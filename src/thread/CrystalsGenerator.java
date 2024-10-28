package src.thread;

import src.model.Crystal;
import src.model.Planet;
import src.model.Race;
import src.util.CrystalUtil;
import src.util.RandomUtil;

public class CrystalsGenerator extends Thread{
    private final Planet planet;
    private static final int MIN_CRYSTALS_COUNT = 2;
    private static final int MAX_CRYSTALS_COUNT = 5;
    private Night night;
    private final Race race1, race2;

    public CrystalsGenerator(Planet planet, Night night, Race race1, Race race2) {
        this.planet = planet;
        this.night = night;
        this.race1 = race1;
        this.race2 = race2;
    }

    public void run() {
        while(race1.amountOfCrystals() < 500 && race2.amountOfCrystals() < 500){
            try {
                generateNewCrystals();
                waitWholeDay();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void generateNewCrystals() {
        int crystalCounter = RandomUtil.getNext(MIN_CRYSTALS_COUNT, MAX_CRYSTALS_COUNT);
        synchronized (planet.getLock()) {
            for (int i = 0; i < crystalCounter; i++) {
                Crystal currentCrystal = CrystalUtil.getRandomCrystal();
                planet.addCrystal(currentCrystal);
            }
        }
    }

    private void waitWholeDay() throws InterruptedException {
        synchronized (night.getLock()) {
            night.getLock().wait();
        }
    }
}
