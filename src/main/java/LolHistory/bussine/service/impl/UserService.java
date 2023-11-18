package LolHistory.bussine.service.impl;

import LolHistory.bussine.externalServices.ConsumerLeague;
import LolHistory.bussine.externalServices.model.LeagueEntry;
import LolHistory.bussine.externalServices.model.PlayerAccount;
import LolHistory.bussine.externalServices.ConsumerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private ConsumerUser consumerUserService;
    @Autowired
    private ConsumerLeague consumerLeague;

    public PlayerAccount getSummoner(String name) {
        return consumerUserService.getAccount(name);
    }
    public LeagueEntry[] getSummonerLeague (String name){
        LeagueEntry[] dataRanked =  consumerLeague.getSummaryLeague(name);
        for (LeagueEntry current: dataRanked ) {
            double addGames = (double) current.getWins() + current.getLosses();
            double winningP = current.getWins()/ addGames;
            current.setWinningP(winningP);
            current.setTier(current.getTier().toLowerCase());
        }
        return dataRanked;
    }

}
