package LolHistory.bussine.service;

import LolHistory.bussine.dto.InvocadorDTO;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    public ResponseEntity<InvocadorDTO> getSummoner(String name, String region);
    public ResponseEntity<Object> getChampionMastery(String puuid);

}
