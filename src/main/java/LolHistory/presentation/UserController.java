package LolHistory.presentation;
import LolHistory.bussine.dto.InvocadorDTO;
import LolHistory.bussine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{gameName}/{tagLine}")
    public ResponseEntity<InvocadorDTO> getInvocador (@PathVariable Map<String, String> pathVarsMap){
        String gameName  = pathVarsMap.get("gameName");
        String tagLine = pathVarsMap.get("tagLine");
        return new ResponseEntity<InvocadorDTO>( userService.getSummoner(gameName, tagLine).getBody(), HttpStatus.OK);
    }

    @GetMapping("/{puuid}")
    public ResponseEntity<Object> getChampionMastery(@PathVariable String puuid){
        return new ResponseEntity<Object>(userService.getChampionMastery(puuid).getBody(), HttpStatus.OK);
    }
}
