package LolHistory.bussine.externalServices;

import LolHistory.bussine.externalServices.model.Invocador;
import LolHistory.bussine.externalServices.model.Match;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerUserService  extends ConsumerRiotService {
    private String PUUID;

    /**
     * @param gameName
     * @param tagLine
     * @return basic player information is returned --> PUUID, gameName tagLine
     */
    public ResponseEntity<Invocador> getSummoner(String gameName, String tagLine){
        ResponseEntity<Invocador> response = super.sendRiotRequest(
                "https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/" + gameName + "/" + tagLine,
                HttpMethod.GET,
                Invocador.class
        );
        Invocador invocador = response.getBody();
        PUUID = invocador != null ? invocador.getPuuid() : null;
        return new ResponseEntity<Invocador>(invocador, HttpStatus.OK);
    }

    /**
     *
     * @param puuid
     * @return the champions with the highest mastery are returned in descending order
     */
    public ResponseEntity<Object> getChampionMastery(String puuid){
        ResponseEntity<Object> response = super.sendRiotRequest(
                "https://la1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-puuid/" + puuid,
                HttpMethod.GET,
                Object.class
        );

        return new ResponseEntity<Object>(response.getBody(), HttpStatus.OK);
    }

    /**
     * @return The code of each game is returned
     */
    public ResponseEntity<String> getMatchesByPuuid(){
        ResponseEntity<String> response = super.sendRiotRequest(
                "https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/"+ PUUID +"/ids?start=0&count=20",
                HttpMethod.GET,
                String.class);

        return new ResponseEntity<String>(response.getBody(), HttpStatus.OK);
    }

    public ResponseEntity<Match> getInfoGameByMatch (){

        System.out.println(getMatchesByPuuid().getBody().length());

        ResponseEntity<Match> response = super.sendRiotRequest(
                "https://americas.api.riotgames.com/lol/match/v5/matches/LA1_1446766436",
                HttpMethod.GET,
                Match.class);

        Match match = response.getBody();

        return new ResponseEntity<Match>(response.getBody(), HttpStatus.OK);
    }

}
