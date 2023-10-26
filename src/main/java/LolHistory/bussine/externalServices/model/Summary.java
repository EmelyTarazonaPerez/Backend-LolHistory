package LolHistory.bussine.externalServices.model;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class Summary {
    private List<String> championPng;
    private int damage;

    public int getDamage() {
        return damage;
    }
    public List<String> getChampionPng() {
        return championPng;
    }
    public void setChampionPng(List<String> championPng) {
        this.championPng = championPng;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

}
