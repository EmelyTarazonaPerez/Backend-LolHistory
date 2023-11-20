package LolHistory.bussine.service.impl;

import LolHistory.bussine.externalServices.ConsumerGameHistory;
import LolHistory.bussine.externalServices.model.match.Match;
import LolHistory.bussine.externalServices.model.match.Participant;
import LolHistory.bussine.externalServices.model.SummaryDamage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameHistoryService {
    @Autowired
    private ConsumerGameHistory consumerGameHistory;

    public Match getGameByTamp (long StartTimestamp){
        return consumerGameHistory.getGameByTamp(StartTimestamp);
    }

    public List<SummaryDamage> getSummaryPlayers (long StartTimestamp) {
        return consumerGameHistory.getStacsPlayers(StartTimestamp);
    }

    public List<Match> getLastGames () {
        List<Match> lastMaths = consumerGameHistory.getLastGames();
        for ( Match match :lastMaths ) {
         match.getInfo().setParticipants(consumerGameHistory.returnPlayer(match));
        }
        return lastMaths;
    }
}
