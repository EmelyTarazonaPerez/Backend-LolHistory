package LolHistory.bussine.externalServices;

import LolHistory.bussine.dto.InvocadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;

@Service
public class ConsumerUserService  extends ConsumerRiotService {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<InvocadorDTO> getSummoner(String gameName, String tagLine){
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Riot-Token", super.API_KEY);

        ResponseEntity<InvocadorDTO> response = restTemplate.exchange(
                "https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/" + gameName + "/" + tagLine,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                InvocadorDTO.class);

        return new ResponseEntity<InvocadorDTO>(response.getBody(), HttpStatus.OK);
    }




}
