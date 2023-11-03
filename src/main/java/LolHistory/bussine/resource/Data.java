package LolHistory.bussine.resource;

import LolHistory.bussine.externalServices.ConsumerGameHistory;
import LolHistory.bussine.externalServices.ConsumerUser;
import LolHistory.bussine.externalServices.model.Match;
import LolHistory.bussine.externalServices.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Data {
    @Autowired
    private ConsumerUser consumerUser;
    public HashMap<Integer,Integer> getIdGameAndIdTeam(List<Match> dataHistoryGame){
        List<Participant> playerGames = dataHistoryGame.stream().map(this::playerGame).collect(Collectors.toList());
        HashMap<Integer, Integer> idTeamByIdGame = new HashMap<>();
        for(Participant playerGame: playerGames ) {
            idTeamByIdGame.put(playerGame.getGameId(), playerGame.getTeamId());
        }

        return idTeamByIdGame;
    }

    public Participant playerGame (Match n) {
        List<Participant> participants = n.getInfo().getParticipants();
        Participant participant = null;
        for(Participant current : participants) {
            if (current.getPuuid().equals(consumerUser.getPUUID())) {
                participant = current;
                participant.setGameId(n.getInfo().getGameId());
                break;
            }
        }

        return participant;
    }

    public int addKillTeam (List<Participant> n){
        int suma = 0;
        for (Participant current: n ) {
            suma = suma + current.getKills();
        }
        return suma;
    }

    public int addKillTeam (Match n){
        List<Participant> participants = n.getInfo().getParticipants();
        int suma = 0;
        for (Participant current: participants ) {
            suma = suma + current.getKills();
        }
        return suma;
    }
}
