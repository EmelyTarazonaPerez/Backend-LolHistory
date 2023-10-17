package LolHistory.bussine.externalServices;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class ConsumerRiotService {
    final  String API_KEY = "RGAPI-48b26037-ea85-4fae-8ba7-921ef2d318cb";
    private String PUUID;

    public void setPUUID(String PUUID) {
        this.PUUID = PUUID;
    }
    public String getPUUID() {
        return PUUID;
    }
}
