package src.model;

import java.util.ArrayList;
import java.util.List;

public class Planet {
    private final Object lock = new Object();
    private final List<Crystal> crystals = new ArrayList<>();

    public Planet() {
    }

    public void addCrystals(List<Crystal> otherCrystals) {
        crystals.addAll(otherCrystals);
    }

    public void addCrystal(Crystal otherCrystal){
        crystals.add(otherCrystal);
    }

    public Crystal removeCrystal(int index) {
        return crystals.remove(index);
    }

    public List<Crystal> removeAllCrystals() {
        List<Crystal> out = new ArrayList<>(crystals);
        crystals.clear();
        return out;
    }

    public int amountOfCrystals() {
        return crystals.size();
    }

    public boolean isNoCrystals() {
        return crystals.isEmpty();
    }

    public Object getLock() {
        return lock;
    }
}
