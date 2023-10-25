package LolHistory.bussine.externalServices.model;

import lombok.Data;

@Data
public class Match {

    private AllInfo info;
    public AllInfo getInfo() {
        return info;
    }
    public void setInfo(AllInfo info) {
        this.info = info;
    }
}
