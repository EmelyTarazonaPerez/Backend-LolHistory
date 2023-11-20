package LolHistory.bussine.externalServices.model.match;

import lombok.Data;

@Data
public class Match {
    private Info info;
    public Info getInfo() { return info; }
    public void setInfo(Info info) {
        this.info = info;
    }
}
