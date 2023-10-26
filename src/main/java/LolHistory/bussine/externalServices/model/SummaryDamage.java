package LolHistory.bussine.externalServices.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class SummaryDamage {
    private String championPng;
    private int damage;

    public int getDamage() {
        return damage;
    }
    public String getChampionPng() {
        return championPng;
    }
    public void setChampionPng(String championPng) {
        this.championPng = championPng;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

}
