package LolHistory.bussine.externalServices;

import LolHistory.bussine.externalServices.model.account.LeagueEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class ConsumerLeague extends ConsumerRiot {

    @Autowired
    ConsumerUser consumerUser;
    public LeagueEntry[] getSummaryLeague (String name) {
        String id = consumerUser.getAccount(name).get().getId();
        return sendRiotRequest(
                "https://la1.api.riotgames.com/lol/league/v4/entries/by-summoner/" + id,
                HttpMethod.GET,
                LeagueEntry[].class
                ).getBody();
    }





}
