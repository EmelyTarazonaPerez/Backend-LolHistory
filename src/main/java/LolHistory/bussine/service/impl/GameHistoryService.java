package LolHistory.bussine.service.impl;

import LolHistory.bussine.externalServices.ConsumerGameHistory;
import LolHistory.bussine.externalServices.model.Match;
import LolHistory.bussine.externalServices.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class GameHistoryService {
    @Autowired
    ConsumerGameHistory consumerGameHistory;

    public Match[] getAllGameStatistics (){
        return consumerGameHistory.getAllStatics();
    }
    public Stream<List<Participant>> getStatisticsByPlayer (){
        return consumerGameHistory.getStatisticsByPlayer();
    }


}
