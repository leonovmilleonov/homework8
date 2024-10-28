package src;

import src.model.Planet;
import src.model.Race;
import src.thread.CrystalsGenerator;
import src.thread.Night;
import src.thread.Rocket;

public class Runner {
    public static void main(String[] args) {
        Planet planet = new Planet();
        Race fire = new Race("Fire");
        Race wind = new Race("Wind");

        Night night = new Night(fire, wind);
        Rocket fireRocket = new Rocket(fire, planet, night);
        Rocket windRocket = new Rocket(wind, planet, night);
        CrystalsGenerator generator = new CrystalsGenerator(planet, night, fire, wind);

        generator.start();
        night.start();
        fireRocket.start();
        windRocket.start();

        try {
            generator.join();
            night.join();
            fireRocket.join();
            windRocket.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
