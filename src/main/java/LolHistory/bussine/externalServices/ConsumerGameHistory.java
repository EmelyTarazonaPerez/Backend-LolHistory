package LolHistory.bussine.externalServices;

import LolHistory.bussine.externalServices.model.Match;
import LolHistory.bussine.externalServices.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ConsumerGameHistory extends ConsumerRiotService  {
    @Autowired
    ConsumerUserService consumerUserService;
    private String[] getMatchesByPlayer(){
        System.out.println(consumerUserService.getPUUID());
        ResponseEntity<String[]> response = super.sendRiotRequest(
                "https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/"+ consumerUserService.getPUUID() +"/ids?start=0&count=5",
                HttpMethod.GET,
                String[].class);
        return response.getBody();
    }

    public Match[] getAllStatics(){
        String[] matchesID = getMatchesByPlayer();
        Match[] arrayMatches = new  Match[matchesID.length];
        for (int i = 0; i < matchesID.length; i++) {
            ResponseEntity<Match>  response = super.sendRiotRequest(
                    "https://americas.api.riotgames.com/lol/match/v5/matches/" + matchesID[i],
                    HttpMethod.GET,
                    Match.class);

            arrayMatches[i] = response.getBody();
        }
        return arrayMatches;
    }
    public Stream<List<Participant>> getStatisticsByPlayer(){
        Match[] dataHistoryGame = getAllStatics();
        assert dataHistoryGame != null;
        return Arrays.stream(dataHistoryGame).map(n -> n.getInfo()
                .getParticipants()
                .stream()
                .filter(x -> Objects.equals(x.getPuuid(), consumerUserService.getPUUID()))
                .collect(Collectors.toList()));
    }

}
