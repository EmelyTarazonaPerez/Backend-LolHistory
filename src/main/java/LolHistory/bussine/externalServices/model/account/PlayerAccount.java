package LolHistory.bussine.externalServices.model.account;

import lombok.Data;

@Data
public class PlayerAccount {
    private String id;
    private String puuid;
    private String name;
    private int profileIconId;
    private int summonerLevel;
    private String linkIcono;
    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }
    public int getProfileIconId() {
        return profileIconId;
    }
    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }
    public int getSummonerLevel() {
        return summonerLevel;
    }
    public void setSummonerLevel(int summonerLevel) {
        this.summonerLevel = summonerLevel;
    }
    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }
    public String getPuuid() {
        return puuid;
    }
    public String getLinkIcono() {
        return linkIcono;
    }
    public void setLinkIcono(String linkIcono) {
        this.linkIcono = linkIcono;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
