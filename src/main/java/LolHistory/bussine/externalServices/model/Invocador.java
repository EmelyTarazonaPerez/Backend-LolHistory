package LolHistory.bussine.externalServices.model;

import lombok.Data;

@Data
public class Invocador {
    private  String puuid;
    private String gameName;
    private String tagLine;

    public void setGameName(String gameName) {
       this.gameName = gameName;
    }
    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }
    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }
    public String getGameName() { return gameName; }

    public String getTagLine() {
        return tagLine;
    }
    public String getPuuid() {
        return puuid;
    }
}