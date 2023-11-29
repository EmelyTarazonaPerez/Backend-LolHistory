package LolHistory.bussine.externalServices;

import LolHistory.bussine.externalServices.model.account.PlayerAccount;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsumerUser extends ConsumerRiot {
    private String PUUID;
    public Optional<PlayerAccount> getAccount (String gameName){
        PlayerAccount playerAccount = sentRequestApi(gameName);
        setPUUID(playerAccount.getPuuid());
        playerAccount.setLinkIcono(super.linkIcon + playerAccount.getProfileIconId() + ".png");
        return Optional.of(playerAccount);
    }
    public PlayerAccount sentRequestApi (String gameName){
        return super.sendRiotRequest(
                "https://la1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + gameName,
                HttpMethod.GET,
                PlayerAccount.class
        ).getBody();
    }
    public String getPUUID() {
        return PUUID;
    }
    public void setPUUID(String PUUID){
        this.PUUID = PUUID;
    }
}
