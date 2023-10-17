package LolHistory;

import LolHistory.bussine.dto.InvocadorDTO;
import LolHistory.bussine.externalServices.ConsumerUserService;
import LolHistory.bussine.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@Service
@RequiredArgsConstructor
public class Application {

	private static final String API_KEY = "RGAPI-3f843f63-40a3-4293-b4d8-7bc2b28966b9";

	@Autowired
	public static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Riot-Token",  API_KEY);
		ResponseEntity<Object> response = restTemplate.exchange(
				"https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/GatitaRosh/lan",
				HttpMethod.GET,
				new HttpEntity<>(headers),
				Object.class);

		System.out.println(response.getBody());

		}




}
