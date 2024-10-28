package src.thread;

import src.model.Race;

public class Night extends Thread {
    private final Object lock = new Object();
    private static final int TIME_INTERVAL = 10;
    private Race race1, race2;

    public Night(Race race1, Race race2){
        this.race1 = race1;
        this.race2 = race2;
    }

    public void run() {
        do {
            synchronized (lock) {
                lock.notifyAll();
                try {
                    lock.wait(TIME_INTERVAL);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } while (race1.amountOfCrystals() < 500 && race2.amountOfCrystals() < 500);
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public Object getLock() {
        return lock;
    }
}
