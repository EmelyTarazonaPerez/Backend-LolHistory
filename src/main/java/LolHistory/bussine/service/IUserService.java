package LolHistory.bussine.service;

import org.springframework.http.ResponseEntity;

public interface IUserService {
    public ResponseEntity<Object> getChampionMastery(String puuid);

}
