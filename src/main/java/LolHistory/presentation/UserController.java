package LolHistory.presentation;
import LolHistory.bussine.externalServices.model.Invocador;
import LolHistory.bussine.externalServices.model.Match;
import LolHistory.bussine.externalServices.model.Participant;
import LolHistory.bussine.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{gameName}/{tagLine}")
    public ResponseEntity<Invocador> getInvocador (@PathVariable Map<String, String> pathVarsMap){
        String gameName  = pathVarsMap.get("gameName");
        String tagLine = pathVarsMap.get("tagLine");
        return new ResponseEntity<Invocador>( userService.getSummoner(gameName, tagLine).getBody(), HttpStatus.OK);
    }

    @GetMapping("/{puuid}")
    public ResponseEntity<Object> getChampionMastery(@PathVariable String puuid){
        return new ResponseEntity<Object>(userService.getChampionMastery(puuid).getBody(), HttpStatus.OK);
    }



}
