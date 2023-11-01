package LolHistory.bussine.externalServices.model;

import lombok.Data;

import java.util.Date;

@Data
public class Participant {

    private int assists;
    private int championId;
    private String championName;
    private int deaths;
    private int kills;
    private String puuid;
    private String summonerName;
    private int teamId;
    private int totalDamageDealtToChampions;
    private boolean win;
    private Date date;
    private String gameMode;
    private String pictureChamp;
    private int gameId;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int killTotal) {
        this.gameId = killTotal;
    }

    public String getPictureChamp() { return pictureChamp; }
    public void setPictureChamp(String pictureChamp) { this.pictureChamp = pictureChamp; }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }


    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
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

    public void setTotalDamageDealtToChampions(int totalDamageDealtToChampions) {
        this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }



}
