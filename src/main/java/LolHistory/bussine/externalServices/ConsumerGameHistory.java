package LolHistory.bussine.externalServices;

import LolHistory.bussine.externalServices.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ConsumerGameHistory extends ConsumerRiotService  {
    @Autowired
    ConsumerUserService consumerUserService;
    private String[] getMatchesByPlayer(){
        ResponseEntity<String[]> response = super.sendRiotRequest(
                "https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/"+ consumerUserService.getPUUID() +"/ids?start=0&count=5",
                HttpMethod.GET,
                String[].class);
        return response.getBody();
    }

    private List<Match> loopResponse ( ) {
        String[] list = getMatchesByPlayer();
        List<Match> returnList = new ArrayList<>();
        for (String string : list) {
            ResponseEntity<Match> response = super.sendRiotRequest(
                    "https://americas.api.riotgames.com/lol/match/v5/matches/" + string,
                    HttpMethod.GET,
                    Match.class);
            returnList.add(response.getBody());
        }
        return returnList;
    }

    public List<Match> getAllStats(){;
        return loopResponse();
    }


}
