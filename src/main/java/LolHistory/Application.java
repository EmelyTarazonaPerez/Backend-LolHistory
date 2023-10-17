package LolHistory;

import LolHistory.bussine.dto.InvocadorDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	static final  String API_KEY = "RGAPI-48b26037-ea85-4fae-8ba7-921ef2d318cb";

	private static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Riot-Token", API_KEY  );
		ResponseEntity<InvocadorDTO> response = restTemplate.exchange(
				"https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/GatitaRosh/lan",
				HttpMethod.GET,
				new HttpEntity<>(headers),
				InvocadorDTO.class);

		System.out.println(response.getBody().getGameName());
	}

}
