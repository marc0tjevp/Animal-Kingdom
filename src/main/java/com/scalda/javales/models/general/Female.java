package com.scalda.javales.models.general;

import com.scalda.javales.models.utils.OvulatingThread;
import java.util.ArrayList;
import java.util.Random;

public class Female extends Gender {

    // Variables
    private OvulatingThread ovThread;
    private ArrayList<Egg> eggs = new ArrayList<>();
    private ArrayList<Egg> iEggs = new ArrayList<>();

    // Constructor
    public Female() {
        Random r = new Random();
        int i = r.nextInt(10);
        i++;
        i = i * 1000;
        ovThread = new OvulatingThread(this, i);
        ovThread.start();
        r = null;
    }

    // Getters and setters
    public ArrayList<Egg> getEggs() {
        return eggs;
    }

    public OvulatingThread getOvThread() {
        return ovThread;
    }

    public void setOvThread(OvulatingThread ovThread) {
        this.ovThread = ovThread;
    }

    public ArrayList<Egg> getiEggs() {
        return iEggs;
    }

    // Methods
    Random r = new Random();

    public void ovulate() {

        if (this.isPregnant() != true) {
            for (int i = 0; i < (r.nextInt(getGenderOwner().getMaxNumberOfEggs()) + 1); i++) {
                Egg e = new Egg();
                eggs.add(e);
            }
        } else {
        }

    }

    public void menstruate() {
        eggs.clear();
    }

    public boolean isPregnant() {
        if (iEggs.size() != 0) {
            System.out.println("Cant make eggs now!");
            return true;
        }

        return false;
    }

    public void propagate(Animal partner1, Animal partner2) {

        if (partner1.getGender().getClass().equals(partner2.getGender().getClass())) {
        } else {
            ArrayList<Egg> tempEggs = eggs;
            for (Egg e : tempEggs) {
                e.inseminate(partner1, partner2);
                iEggs.add(e);
                System.out.println("This egg is inseminated now");
            }

        }
    }

    public ArrayList<Egg> giveBirth() {
        return iEggs;
    }

    public void clearIEggs() {
        iEggs.clear();
    }

    @Override
    public boolean isFemale() {
        return true;
    }

    @Override
    public void stopOvulation() {
        if (ovThread.isAlive()) {
            ovThread.interrupt();
        } else {
            ovThread = new OvulatingThread(this, 3000);
            ovThread.start();
        }
    }

}
