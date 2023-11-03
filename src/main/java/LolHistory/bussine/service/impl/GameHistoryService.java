package LolHistory.bussine.service.impl;

import LolHistory.bussine.externalServices.ConsumerGameHistory;
import LolHistory.bussine.externalServices.model.Match;
import LolHistory.bussine.externalServices.model.Participant;
import LolHistory.bussine.externalServices.model.SummaryDamage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

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

    public List<Match> listJugadoresByEquipo() {
        return consumerGameHistory.historyGame();
    }

    public List<Match> lastMatches() {
        return consumerGameHistory.getAllStats();
    }

    /*
    public HashMap<Integer, Integer> suma() {
        return consumerGameHistory.suma();
    }

     */



}
