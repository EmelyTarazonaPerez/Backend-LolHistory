package LolHistory.bussine.externalServices.model.match;

import java.util.List;

public class PerkStyleDto {

    public String description;

    public List<PerkStyleSelectionDto> selections;
    private int style;

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }
}
