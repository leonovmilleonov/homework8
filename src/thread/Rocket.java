package src.thread;

import src.model.Crystal;
import src.model.Planet;
import src.model.Race;
import src.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Rocket extends Thread{
    private static final int MIN_CRYSTALS_COUNT = 2;
    private static final int MAX_CRYSTALS_COUNT = 5;
    private final Race race;
    private final Planet planet;
    private final Night night;

    public Rocket(Race race, Planet planet, Night night) {
        this.race = race;
        this.planet = planet;
        this.night = night;
    }

    public void run(){
        try{
            while(race.amountOfCrystals() < 500){
                List<Crystal> list = collectCrystalsFromPlanet();
                race.addCrystals(list);
                waitWholeDay();
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    private List<Crystal> collectCrystalsFromPlanet(){
        int crystalsCount = RandomUtil.getNext(MIN_CRYSTALS_COUNT, MAX_CRYSTALS_COUNT);
        List<Crystal> result = new ArrayList<>(MAX_CRYSTALS_COUNT);
        synchronized(planet.getLock()){
            if(planet.amountOfCrystals() <= crystalsCount){
                result.addAll(planet.removeAllCrystals());
            } else if(!planet.isNoCrystals()){
                for(int i = 0; i < crystalsCount; i++){
                    Crystal currentCrystal = planet.removeCrystal(RandomUtil.getNext(planet.amountOfCrystals()));
                    result.add(currentCrystal);
                }
            }
        }
        return result;
    }

    private void waitWholeDay() throws InterruptedException {
        synchronized (night.getLock()){
            night.getLock().wait();
        }
    }
}
