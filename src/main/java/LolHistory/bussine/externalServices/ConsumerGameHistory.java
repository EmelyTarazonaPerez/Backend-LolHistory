package LolHistory.bussine.externalServices;

import LolHistory.bussine.externalServices.model.Match;
import LolHistory.bussine.externalServices.model.Participant;
import LolHistory.bussine.externalServices.model.SummaryDamage;
import LolHistory.bussine.resource.Data;
import jdk.nashorn.internal.objects.annotations.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ConsumerGameHistory extends ConsumerRiot {

    @Autowired
    private ConsumerUser consumerUser;
    @Autowired
    private Data data;
    private String[] getMatchesByPlayer(){
        ResponseEntity<String[]> response = sendRiotRequest(
                "https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/"+ consumerUser.getPUUID() +"/ids?start=0&count=5",
                HttpMethod.GET,
                String[].class);
        return response.getBody();
    }

    private List<Match> getLastGames ( ) {
        String[] list = getMatchesByPlayer();
        List<Match> returnList = new ArrayList<>();
        for(String string : list) {
            ResponseEntity<Match> response = super.sendRiotRequest(
                    "https://americas.api.riotgames.com/lol/match/v5/matches/" + string,
                    HttpMethod.GET,
                    Match.class);
            returnList.add(response.getBody());
        }
        return returnList;
    }

    public Match getGameByTamp(long StartTimestamp){
        List<Match> listGames = getLastGames();
        Match checkGame = null;
        for(Match current: listGames) {
            long Timestamp = current.getInfo().getGameStartTimestamp();
            if(Timestamp == StartTimestamp){
                checkGame = current;
                break;
            }
        }
        return checkGame;
    }

    public List<SummaryDamage> getStacsPlayers(long StartTimestamp){
        List<Participant> participants = getGameByTamp(StartTimestamp).getInfo().getParticipants();
        List<SummaryDamage> listSummary = new ArrayList<>();
        for(Participant current:  participants) {
            SummaryDamage summaryDamage = new SummaryDamage();
            summaryDamage.setChampionPng("ihttp://ddragon.leagueoflegends.com/cdn/13.21.1/img/champion/"+current.getChampionName()+".png");
            summaryDamage.setDamage(current.getTotalDamageDealtToChampions());
            listSummary.add(summaryDamage);
        }
        return listSummary;
    }

    public List<Match> historyGame() {
        List<Match> lastGames = getLastGames();
        List<List<Participant>> team =  lastGames.stream()
                .map((data) -> {
                    return participantsSameTeam(data, lastGames);
                })
                .collect(Collectors.toList());

        int index = 0;
        for (Match match : lastGames) {
            match.getInfo().setParticipants(team.get(index));
            match.getInfo().setKillsTeam(data.addKillTeam(team.get(index)));
            index++;
        }
        return  lastGames;
    }

    public List<Participant> participantsSameTeam (Match match, List<Match> matches) {
        HashMap<Integer, Integer> idTeam = data.getIdGameAndIdTeam(matches);
        int value = idTeam.get(match.getInfo().getGameId());
        return match.getInfo().getParticipants().stream()
                .filter(i -> i.getTeamId() == value)
                .collect(Collectors.toList());


    }

}
