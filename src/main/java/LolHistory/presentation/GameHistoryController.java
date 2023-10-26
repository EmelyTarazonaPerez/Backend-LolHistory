package LolHistory.presentation;

import LolHistory.bussine.externalServices.model.Match;
import LolHistory.bussine.externalServices.model.Participant;
import LolHistory.bussine.service.impl.GameHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class GameHistoryController {

    @Autowired
    GameHistoryService gameHistoryService;
    @GetMapping("/moreInfoGameHistory")
    public ResponseEntity<List<Match>> getAllGameStatistics(){
        return new ResponseEntity<>(gameHistoryService.getAllGameStatistics(), HttpStatus.OK);
    }

    @GetMapping("/gameHistory/player")
    public ResponseEntity<List<Participant>> getStatsByPlayer(){
        return new ResponseEntity<>(gameHistoryService.getListStatsByPlayer(), HttpStatus.OK);
    }

    @GetMapping("/getInfoGame/{StartTimestamp}")
    public ResponseEntity<Match> getGameByTamp(@PathVariable long StartTimestamp ){
        return new ResponseEntity<>(gameHistoryService.getGameByTamp(StartTimestamp), HttpStatus.OK);
    }

}
