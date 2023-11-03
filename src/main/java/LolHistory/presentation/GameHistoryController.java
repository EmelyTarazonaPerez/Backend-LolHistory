package LolHistory.presentation;

import LolHistory.bussine.externalServices.model.Match;
import LolHistory.bussine.externalServices.model.Participant;
import LolHistory.bussine.externalServices.model.SummaryDamage;
import LolHistory.bussine.service.impl.GameHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class GameHistoryController {

    @Autowired
    GameHistoryService gameHistoryService;

    @GetMapping("/get-macth-whit-date/{StartTimestamp}")
    public ResponseEntity<Match> getGameByDate(@PathVariable long StartTimestamp ){
        return new ResponseEntity<>(gameHistoryService.getGameByTamp(StartTimestamp), HttpStatus.OK);
    }

    @GetMapping("/summary-damage/{StartTimestamp}")
    public ResponseEntity<List<SummaryDamage>> getSummaryPlayers (@PathVariable long StartTimestamp ){
        return new ResponseEntity<>(gameHistoryService.getSummaryPlayers(StartTimestamp), HttpStatus.OK);
    }

    @GetMapping("/last-matches")
    public ResponseEntity<List<Match>> getLastMatches() {
        return new ResponseEntity<>(gameHistoryService.getLastGames(), HttpStatus.OK);
    }

}
