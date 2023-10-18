package LolHistory.bussine.externalServices;

import LolHistory.bussine.dto.InvocadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;

@Service
public class ConsumerUserService  extends ConsumerRiotService {
    public ResponseEntity<InvocadorDTO> getSummoner(String gameName, String tagLine){
        ResponseEntity<InvocadorDTO> response = super.sendRiotRequest(
                "https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/" + gameName + "/" + tagLine,
                HttpMethod.GET,
                InvocadorDTO.class
        );

        return new ResponseEntity<InvocadorDTO>(response.getBody(), HttpStatus.OK);
    }

    public ResponseEntity<Object> getChampionMastery(String puuid){
        ResponseEntity<Object> response = super.sendRiotRequest(
                "https://la1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-puuid/" + puuid,
                HttpMethod.GET,
                Object.class
        );

        return new ResponseEntity<Object>(response.getBody(), HttpStatus.OK);
    }
}
