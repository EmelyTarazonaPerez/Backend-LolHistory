package LolHistory.bussine.externalServices;

import LolHistory.bussine.externalServices.model.Invocador;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class ConsumerUserService  extends ConsumerRiotService {
    private String PUUID;

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

    public ResponseEntity<Object> getChampionMastery(String puuid){
        ResponseEntity<Object> response = super.sendRiotRequest(
                "https://la1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-puuid/" + puuid,
                HttpMethod.GET,
                Object.class
        );

        return new ResponseEntity<Object>(response.getBody(), HttpStatus.OK);
    }
    public String getPUUID() {
        return PUUID;
    }
}
