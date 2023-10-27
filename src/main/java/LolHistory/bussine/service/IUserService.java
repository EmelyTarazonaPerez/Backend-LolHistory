package LolHistory.bussine.service;

import LolHistory.bussine.externalServices.model.PlayerAccount;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    public ResponseEntity<Object> getChampionMastery(String puuid);

}
