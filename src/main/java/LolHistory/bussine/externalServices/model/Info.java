package LolHistory.bussine.externalServices.model;

import java.util.List;

public class Info {
    private long gameEndTimestamp;
    private String gameMode;
    private long gameStartTimestamp;
    private List<Participant> participants;

    public void setGameStartTimestamp(long gameStartTimestamp) {
        this.gameStartTimestamp = gameStartTimestamp;
    }

    public List<Participant> getParticipants() {
        return participants;
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
