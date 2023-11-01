package LolHistory.bussine.service.impl;

import LolHistory.bussine.externalServices.ConsumerGameHistory;
import LolHistory.bussine.externalServices.ConsumerUser;
import LolHistory.bussine.externalServices.model.Match;
import LolHistory.bussine.externalServices.model.Participant;
import LolHistory.bussine.externalServices.model.SummaryDamage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameHistoryService {
    @Autowired
    private ConsumerGameHistory consumerGameHistory;

    public List<Match> getAllGameStatistics (){
        return consumerGameHistory.getAllStats();
    }

    public Match getGameByTamp (long StartTimestamp){
        return consumerGameHistory.getGameByTamp(StartTimestamp);
    }

    public List<SummaryDamage> getSummaryPlayers (long StartTimestamp) {
        return consumerGameHistory.getStacsPlayers(StartTimestamp);
    }

    public List<Participant> getSummaryPlayerHistory(){
        return consumerGameHistory.getSummaryPlayerHistory();
    }

    public HashMap<Integer,Integer> listEquipo() {
        return consumerGameHistory.listEquipo();
    }

    public List<List<Participant>>  listJugadoresByEquipo() {
        return consumerGameHistory.recorrerArray();
    }
/*
    public List<Participant[]> suma() {
        return consumerGameHistory.suma();
    }

*/

}
