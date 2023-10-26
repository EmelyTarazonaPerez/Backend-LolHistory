package LolHistory.bussine.externalServices.model;

import lombok.Data;

@Data
public class ChampiosMastery {
    private String puuid;
    private int championId;
    private int championLevel;
    private int championPoints;
    private int championPointsSinceLastLevel;
    private int championPointsUntilNextLevel;
    private boolean chestGranted;
    private int tokensEarned;
    private String summonerId;

    public String getPuuid() {
        return puuid;
    }

    public int getChampionId() {
        return championId;
    }
    public int getChampionLevel() {
        return championLevel;
    }

    public int getChampionPoints() {
        return championPoints;
    }

    public int getChampionPointsSinceLastLevel() {
        return championPointsSinceLastLevel;
    }

    public int getChampionPointsUntilNextLevel() {
        return championPointsUntilNextLevel;
    }

    public boolean isChestGranted() {
        return chestGranted;
    }

    public int getTokensEarned() {
        return tokensEarned;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public void setChampionLevel(int championLevel) {
        this.championLevel = championLevel;
    }

    public void setChampionPoints(int championPoints) {
        this.championPoints = championPoints;
    }

    public void setChampionPointsSinceLastLevel(int championPointsSinceLastLevel) {
        this.championPointsSinceLastLevel = championPointsSinceLastLevel;
    }

    public void setChampionPointsUntilNextLevel(int championPointsUntilNextLevel) {
        this.championPointsUntilNextLevel = championPointsUntilNextLevel;
    }

    public void setChestGranted(boolean chestGranted) {
        this.chestGranted = chestGranted;
    }

    public void setTokensEarned(int tokensEarned) {
        this.tokensEarned = tokensEarned;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }
}
