package LolHistory.bussine.service.impl;

import LolHistory.bussine.externalServices.model.Match;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class DataService {
    public Date timeStampToDate(Match n ){
        Timestamp tms = new Timestamp(n.getInfo().getGameStartTimestamp());
        return new Date(tms.getTime());
    }
}
