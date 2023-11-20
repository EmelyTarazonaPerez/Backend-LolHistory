package LolHistory.bussine.externalServices.model.match;

import java.util.List;

public class Info {
    private long gameEndTimestamp;
    private int gameId;
    private String gameMode;
    private long gameStartTimestamp;
    private List<Participant> participants;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getKillsTeam() {
        return killsTeam;
    }

    public void setKillsTeam(int killsTeam) {
        this.killsTeam = killsTeam;
    }

    private int killsTeam;

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setGameStartTimestamp(long gameStartTimestamp) {
        this.gameStartTimestamp = gameStartTimestamp;
    }


    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public long getGameEndTimestamp() {
        return gameEndTimestamp;
    }

    public void setGameEndTimestamp(long gameEndTimestamp) {
        this.gameEndTimestamp = gameEndTimestamp;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public long getGameStartTimestamp() {
        return gameStartTimestamp;
    }

    public void setGameStartTimetamp(long gameStartTimestamp) {
        this.gameStartTimestamp = gameStartTimestamp;
    }

}
