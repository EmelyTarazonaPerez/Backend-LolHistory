package LolHistory.bussine.service.impl;

import LolHistory.bussine.externalServices.model.Invocador;
import LolHistory.bussine.externalServices.ConsumerRiotService;
import LolHistory.bussine.externalServices.ConsumerUserService;
import LolHistory.bussine.externalServices.model.Match;
import LolHistory.bussine.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private  ConsumerUserService consumerUserService;
    @Override
    public ResponseEntity<Invocador> getSummoner(String name, String region) {
        return consumerUserService.getSummoner(name, region);
    }

    @Override
    public ResponseEntity<Object> getChampionMastery(String puuid) {
        return consumerUserService.getChampionMastery(puuid);
    }


    public ResponseEntity<Match> getInfoGameByMatch(){
        return consumerUserService.getInfoGameByMatch();
    }
}
