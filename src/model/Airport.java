package model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Airport {
    private final int runaways;
    private BlockingQueue<String> freeRunaways = new LinkedBlockingQueue<>();

    public BlockingQueue<String> getFreeRunaways() {
        return freeRunaways;
    }

    public void setFreeRunaways(BlockingQueue<String> freeRunaways) {
        this.freeRunaways = freeRunaways;
    }

    public int getRunaways() {
        return runaways;
    }

    public Airport(int runaways) {
        this.runaways = runaways;
        for (int i = 0; i < runaways; i++){
            freeRunaways.add("Runaway " + (i+1));
        }
    }
}
