package LolHistory.bussine.service;

import LolHistory.bussine.externalServices.model.Invocador;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    public ResponseEntity<Invocador> getSummoner(String name, String region);
    public ResponseEntity<Object> getChampionMastery(String puuid);

}
