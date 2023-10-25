package LolHistory.bussine.service.dto;

import LolHistory.bussine.externalServices.model.Participant;
import lombok.Getter;

import java.util.List;

public class InfoGameHistory {
    @Getter
    private String date;
    private String gameMode;
    private List<Participant> participants;

    public String getGameMode() {
        return gameMode;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
