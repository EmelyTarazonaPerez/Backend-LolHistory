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
                participant.setGameId(n.getInfo().getGameId());
                break;
            }
        }
        return participant;
    }


    public HashMap<Integer,Integer> listEquipo () {
        List<Participant> stactsPlayer = getSummaryPlayerHistory();
        HashMap<Integer, Integer> idTeamByIdGame = new HashMap<>();
        for (Participant current: stactsPlayer ) {
            idTeamByIdGame.put(current.getGameId(), current.getTeamId());

        }
        return idTeamByIdGame;

    }

    public List<Participant> ListJugadoresByEquipo(Match n){
        HashMap<Integer,Integer> idEquipos = listEquipo();
        int value = idEquipos.get(n.getInfo().getGameId());
        List<Participant> participants = n.getInfo().getParticipants();
        return participants.stream().filter(i -> i.getTeamId() == value).collect(Collectors.toList());
    }

    public List<Match> recorrerArray (){
        List<Match> dataHistoryGame =  getAllStats();
        assert dataHistoryGame != null;
        List<List<Participant>> equipo =  dataHistoryGame.stream().map(this::ListJugadoresByEquipo).collect(Collectors.toList());
        for ( List<Participant> jugador : equipo ) {
            for ( Match juego : dataHistoryGame ) {
                juego.getInfo().setParticipants(jugador);
            }
        }
        return  dataHistoryGame;
    }


  /*  public HashMap<Integer, Integer> suma() {
       List<List<Participant>>  n = recorrerArray();
       List<Integer> killsTotal = n.stream().map(this::sumaX).collect(Collectors.toList());

       List<Match> partidas = getAllStats();
       HashMap<Integer, Integer> killsTotalByIdGame = new HashMap<>();

       int index = 0;
        for (Match current: partidas) {
                killsTotalByIdGame.put(current.getInfo().getGameId(), killsTotal.get(index));
                index++;
        }
        return killsTotalByIdGame;

    }

    private int sumaX (List<Participant> n){
        int suma = 0;
        for (Participant current: n ) {
            suma = suma + current.getKills();
        }
        System.out.println(suma);
        return suma;
    }

*/
}
