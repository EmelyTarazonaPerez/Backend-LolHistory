package LolHistory.bussine.externalServices.model.match;

import lombok.Data;

import java.util.List;

@Data
public class Perks {

    public List<PerkStyleDto> styles;
    public List<PerkStyleDto> getStyle() {
        return styles;
    }
    public void setStyle(List<PerkStyleDto> styles) {
        this.styles = styles;
    }
}
