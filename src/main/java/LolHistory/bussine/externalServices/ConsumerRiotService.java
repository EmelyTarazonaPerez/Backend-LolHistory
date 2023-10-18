package LolHistory.bussine.externalServices;

import LolHistory.bussine.dto.InvocadorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Configuration
@Service
@RequiredArgsConstructor
public abstract class ConsumerRiotService {
    @Value("${api.key}")
    private String API_KEY;
    @Autowired
    private RestTemplate restTemplate;
    private String PUUID;

    public void setPUUID(String PUUID) {
        this.PUUID = PUUID;
    }
    public String getPUUID() {
        return PUUID;
    }

    public HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Riot-Token", API_KEY);

        return headers;
    }

    public <T> ResponseEntity<T> sendRiotRequest(String url, HttpMethod method, Class<T> typeDto) {
        return restTemplate.exchange(
            url,
            method,
            new HttpEntity<>(getHeader()),
            typeDto
        );
    }

    public <T> ResponseEntity<T> sendRiotRequest(
            String url,
            HttpMethod method,
            MultiValueMap<String, String> body,
            Class<T> typeDto
    ) {
        HttpEntity<?> httpEntity = new HttpEntity<Object>(body, getHeader());

        return restTemplate.exchange(
            url,
            method,
            httpEntity,
            typeDto
        );
    }

    public <T> ResponseEntity<T> sendRiotRequest(String url, HttpMethod method, HttpHeaders headers, Class<T> typeDto) {
        return restTemplate.exchange(
            url,
            method,
            new HttpEntity<>(headers),
            typeDto
        );
    }

    public <T> ResponseEntity<T> sendRiotRequest(
            String url,
            HttpMethod method,
            MultiValueMap<String, String> body,
            HttpHeaders headers,
            Class<T> typeDto
    ) {
        HttpEntity<?> httpEntity = new HttpEntity<Object>(body, headers);

        return restTemplate.exchange(
            url,
            method,
            httpEntity,
            typeDto
        );
    }
}
