package LolHistory.bussine.externalServices.model.match;

import lombok.Data;

import java.util.List;

@Data
public class Perks {

    public Object object;
    public List<Object> styles;
    public List<Object> getStyle() {
        return styles;
    }
    public void setStyle(List<Object> styles) {
        this.styles = styles;
    }
}
