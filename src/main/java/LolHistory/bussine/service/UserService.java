package LolHistory.bussine.service;

import LolHistory.bussine.externalServices.ConsumerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class UserService {

    @Autowired
    private ConsumerUserService consumerUserService;

    @Autowired
    private RestTemplate restTemplate;


}
