package LolHistory.presentation;

import LolHistory.bussine.externalServices.model.Match;
import LolHistory.bussine.externalServices.model.Participant;
import LolHistory.bussine.service.impl.GameHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<Match[]> getAllGameStatistics(){
        System.out.println(Arrays.toString(gameHistoryService.getAllGameStatistics()));
        return new ResponseEntity<Match[]>(gameHistoryService.getAllGameStatistics(), HttpStatus.OK);
    }

    @GetMapping("/gameHistory/player")
    public ResponseEntity<Stream<List<Participant>>> getGameHistory(){
        return new ResponseEntity<>(gameHistoryService.getStatisticsByPlayer(), HttpStatus.OK);
    }

}
