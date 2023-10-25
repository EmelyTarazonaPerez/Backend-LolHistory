package LolHistory.bussine.externalServices.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class InfoByParticipant {
    private long gameEndTimestamp;
    private String gameMode;
    private long gameStartTimestamp;
    private Participant participants;
}
