package LolHistory.bussine.externalServices;

import LolHistory.bussine.externalServices.model.Match;
import LolHistory.bussine.externalServices.model.Participant;
import LolHistory.bussine.externalServices.model.SummaryDamage;
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
    private String[] getMatchesByPlayer(){
        System.out.println("sadnjasd " + consumerUser.getPUUID());
        ResponseEntity<String[]> response = sendRiotRequest(
                "https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/"+ consumerUser.getPUUID() +"/ids?start=0&count=5",
                HttpMethod.GET,
                String[].class);
        return response.getBody();
    }

    private List<Match> loopResponse ( ) {
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

    public List<Match> getAllStats(){;
        List<Match> gameHistory = loopResponse();
        return gameHistory;

    }

    public Match getGameByTamp(long StartTimestamp){
        List<Match> listGames = loopResponse();
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

    public List<Participant> getSummaryPlayerHistory(){
        List<Match> dataHistoryGame = getAllStats();
        suma(dataHistoryGame);
        assert dataHistoryGame != null;
        return dataHistoryGame.stream().map(this::statsPlayer).collect(Collectors.toList());
    }

    private Participant statsPlayer (Match n) {
        List<Participant> participants = n.getInfo().getParticipants();
        Participant participant = null;
        for (Participant current : participants) {
            if (current.getPuuid().equals(consumerUser.getPUUID())) {
                participant = current;
                participant.setPictureChamp("ihttp://ddragon.leagueoflegends.com/cdn/13.21.1/img/champion/" +current.getChampionName()+ ".png");
                participant.setDate(super.timeStampToDate(n));
                participant.setGameMode(n.getInfo().getGameMode());
                break;
            }
        }
        return participant;
    }

    private boolean suma(List<Match> n) {
        n.stream().map(x -> {
            List<Participant> participant = x.getInfo().getParticipants();
            int suma = 0;
            for (Participant current : participant){
                    suma =+ current.getKills();
                System.out.println(suma);
                }
            return suma;
        }).collect(Collectors.toList());;
        return false;
    }

    


}
