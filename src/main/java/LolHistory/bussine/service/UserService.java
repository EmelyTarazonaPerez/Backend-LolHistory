package LolHistory.bussine.service;

import LolHistory.bussine.dto.InvocadorDTO;
import LolHistory.bussine.externalServices.ConsumerRiotService;
import LolHistory.bussine.externalServices.ConsumerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private  ConsumerUserService consumerUserService;

    @Autowired
    private ConsumerRiotService consumerRiotService;

    @Override
    public ResponseEntity<InvocadorDTO> getSummoner(String name, String region) {
        consumerRiotService.setPUUID(consumerUserService.getSummoner(name, region).getBody().getPuuid());
        return consumerUserService.getSummoner(name, region);
    }

    @Override
    public ResponseEntity<Object> getChampionMastery(String puuid) {
        return consumerUserService.getChampionMastery(puuid);
    }
}
