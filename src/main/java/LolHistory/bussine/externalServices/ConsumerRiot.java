package LolHistory.bussine.externalServices;

import LolHistory.bussine.externalServices.model.match.Match;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Date;

@Service
@RequiredArgsConstructor
public abstract class ConsumerRiot {
    @Value("${api.key}")
    private String API_KEY;
    @Autowired
    private RestTemplate restTemplate;
    protected final String linkIcon = "http://ddragon.leagueoflegends.com/cdn/13.21.1/img/profileicon/";

    protected HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Riot-Token", API_KEY);

        return headers;
    }

    protected <T> ResponseEntity<T> sendRiotRequest(String url, HttpMethod method, Class<T> typeDto) {
        return restTemplate.exchange(
            url,
            method,
            new HttpEntity<>(getHeader()),
            typeDto
        );
    }

    protected <T> ResponseEntity<T> sendRiotRequest(
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

    protected <T> ResponseEntity<T> sendRiotRequest(String url, HttpMethod method, HttpHeaders headers, Class<T> typeDto) {
        return restTemplate.exchange(
            url,
            method,
            new HttpEntity<>(headers),
            typeDto
        );
    }

    protected <T> ResponseEntity<T> sendRiotRequest(
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

    protected Date timeStampToDate(Match n ){
        Timestamp tms = new Timestamp(n.getInfo().getGameStartTimestamp());
        return new Date(tms.getTime());
    }

}
