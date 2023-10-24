package LolHistory.bussine.service.impl;

import LolHistory.bussine.externalServices.ConsumerGameHistory;
import LolHistory.bussine.externalServices.model.Invocador;
import LolHistory.bussine.externalServices.ConsumerUserService;
import LolHistory.bussine.externalServices.model.Match;
import LolHistory.bussine.externalServices.model.Participant;
import LolHistory.bussine.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

}
