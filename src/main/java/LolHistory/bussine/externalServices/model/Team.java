package LolHistory.bussine.externalServices.model;

import lombok.Data;

@Data
public class Team {
    private int teamId = 100;
    private boolean win;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
