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

import java.util.List;

@RestController
public class GameHistoryController {

    @Autowired
    GameHistoryService gameHistoryService;
    @GetMapping("/moreInfoGameHistory")
    public ResponseEntity<List<Match>> getGamesHistory(){
        return new ResponseEntity<>(gameHistoryService.getAllGameStatistics(), HttpStatus.OK);
    }
    @GetMapping("/gameHistory/player")
    public ResponseEntity<List<Participant>> getSummaryPlayerHistory(){
        return new ResponseEntity<>(gameHistoryService.getSummaryPlayerHistory(), HttpStatus.OK);
    }

    @GetMapping("/getInfoGame/{StartTimestamp}")
    public ResponseEntity<Match> getGameByDate(@PathVariable long StartTimestamp ){
        return new ResponseEntity<>(gameHistoryService.getGameByTamp(StartTimestamp), HttpStatus.OK);
    }

    @GetMapping("/infoSummaryStatcPlayer/{StartTimestamp}")
    public ResponseEntity<List<SummaryDamage>> getSummaryPlayers (@PathVariable long StartTimestamp ){
        return new ResponseEntity<>(gameHistoryService.getSummaryPlayers(StartTimestamp), HttpStatus.OK);
    }
}
