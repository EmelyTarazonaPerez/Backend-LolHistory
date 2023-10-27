package LolHistory.bussine.service.impl;

import LolHistory.bussine.externalServices.model.PlayerAccount;
import LolHistory.bussine.externalServices.ConsumerUserService;
import LolHistory.bussine.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private  ConsumerUserService consumerUserService;
    public PlayerAccount getSummoner(String name) {
        return consumerUserService.getAccount(name);
    }


}
