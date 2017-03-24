package com.scalda.javales.models.utils;

import com.scalda.javales.models.Zoo.Cage;
import com.scalda.javales.models.general.Egg;
import java.util.ArrayList;

public class ReptileEggHatcherThread extends Thread {

    // variables
    private Cage reptileCage;
    private ArrayList<Egg> reptileEggs;

    public ReptileEggHatcherThread(Cage reptileCage, ArrayList<Egg> reptileEggs) {

        this.reptileCage = reptileCage;
        this.reptileEggs = reptileEggs;

    }

    public void run() {
        super.run();
        try {
            sleep(10000);

            //reptileCage.addReptileEggs(reptileEggs);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }

}
