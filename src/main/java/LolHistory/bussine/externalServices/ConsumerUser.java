package LolHistory.bussine.externalServices;

import LolHistory.bussine.externalServices.model.PlayerAccount;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class ConsumerUser extends ConsumerRiot {
    private String PUUID;
    public PlayerAccount getAccount (String gameName){
        PlayerAccount playerAccount = sentRequestApi(gameName);
        setPUUID(playerAccount.getPuuid());
        playerAccount.setLinkIcono(super.linkIcon + playerAccount.getProfileIconId() + ".png");
        return playerAccount;
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
