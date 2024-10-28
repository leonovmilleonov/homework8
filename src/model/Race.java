package src.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Race {
    private final Map<Crystal, Integer> crystals = new EnumMap<>(Crystal.class);
    private final String elementType;

    public Race(String elementType) {
        this.elementType = elementType;
    }

    public void addCrystals(List<Crystal> otherCrystals) {
        otherCrystals.forEach(crystal -> crystals.merge(crystal, 1, Integer::sum));
    }

    public int amountOfCrystals(){
        return crystals.values().stream().mapToInt(x -> x).sum();
    }
}
