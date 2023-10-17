package LolHistory.presentation;
import LolHistory.bussine.dto.InvocadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class UserController {

    private static final String API_KEY = "RGAPI-3f843f63-40a3-4293-b4d8-7bc2b28966b9";

    public static RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{gameName}/{tagLine}")
    public ResponseEntity<String> getInvocador (@PathVariable Map<String, String> pathVarsMap){
        String gameName  = pathVarsMap.get("gameName");
        String tagLine = pathVarsMap.get("tagLine");
        return new ResponseEntity<String>("aquí el " + gameName + " " + tagLine,  HttpStatus.OK);
    }

    @GetMapping("/prueba")
    public ResponseEntity<InvocadorDTO> getData (){
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Riot-Token",  API_KEY);
        ResponseEntity<InvocadorDTO> response = restTemplate.exchange(
                "https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/GatitaRosh/lan",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                InvocadorDTO.class);

        if(response.getBody() != null){
            return new ResponseEntity<InvocadorDTO>(response.getBody(), HttpStatus.BAD_REQUEST ) ;
        }
        return new ResponseEntity<InvocadorDTO>(response.getBody(), HttpStatus.OK) ;
    }

}
