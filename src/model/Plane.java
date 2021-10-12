package model;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Plane implements Runnable{
    private String name;
    private final Airport airport;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Plane(String name, Airport airport) {
        this.name = name;
        this.airport = airport;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " preparing for flight");
            long randomTime = (long) (Math.random()*1000);
            TimeUnit.MILLISECONDS.sleep(randomTime);
            System.out.println(name + " is ready for flight");
            String runaway = airport.getFreeRunaways().take();
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println(name + " began to enter " + runaway);
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println(runaway + " accepted " + name);
            TimeUnit.MILLISECONDS.sleep(1500);
            System.out.println(name + " took off.");
            System.out.println(runaway + " is free.");
            airport.getFreeRunaways().add(runaway);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}