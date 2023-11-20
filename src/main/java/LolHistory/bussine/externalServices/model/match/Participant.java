package LolHistory.bussine.externalServices.model.match;

import lombok.Data;
import lombok.Getter;

@Data
public class Participant {

    private int assists;
    public Challenges challenges;
    private int deaths;
    private int kills;
    public Perks perks;
    private String puuid;
    private int summoner1Id;
    private int summoner2Id;
    public String iconSummoner1Id;
    public String iconSummoner2Id;
    private String summonerName;
    private int teamId;
    private int totalDamageDealtToChampions;
    private String championName;
    private String iconChampion;
    private boolean win;
    private int gameId;

    public void setSummoner1Id(int summoner1Id) { this.summoner1Id = summoner1Id; }
    public void setSummoner2Id(int summoner2Id) { this.summoner2Id = summoner2Id; }
    public int getSummoner1Id() { return summoner1Id; }
    public int getSummoner2Id() { return summoner2Id; }
    public String getIconoChampion() {
        return iconChampion;
    }
    public void setIconoChampion(String iconoChampion) {
        this.iconChampion = iconoChampion;
    }
    public int getGameId() { return gameId; }
    public void setGameId(int killTotal) { this.gameId = killTotal;}
    public int getAssists() {
        return assists;
    }
    public void setAssists(int assists) {
        this.assists = assists;
    }
    public String getChampionName() {
        return championName;
    }
    public void setChampionName(String championName) {
        this.championName = championName;
    }
    public int getDeaths() {
        return deaths;
    }
    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
    public int getKills() {
        return kills;
    }
    public void setKills(int kills) {
        this.kills = kills;
    }
    public String getPuuid() {
        return puuid;
    }
    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }
    public String getSummonerName() {
        return summonerName;
    }
    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }
    public int getTeamId() {
        return teamId;
    }
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
    public int getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }
    public void setTotalDamageDealtToChampions(int totalDamageDealtToChampions) { this.totalDamageDealtToChampions = totalDamageDealtToChampions; }
    public boolean isWin() {
        return win;
    }
    public void setWin(boolean win) {
        this.win = win;
    }



}
