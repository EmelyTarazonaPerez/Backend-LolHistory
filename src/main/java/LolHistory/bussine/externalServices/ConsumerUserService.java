package LolHistory.bussine.externalServices;

import LolHistory.bussine.dto.InvocadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import javax.swing.text.html.parser.Entity;

@Service
public class ConsumerUserService  {

    @Autowired
    private RestTemplate restTemplate;
    public void getInvocador(){


    }




}
