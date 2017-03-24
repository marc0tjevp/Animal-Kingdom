package com.scalda.javales.models.utils;

import com.scalda.javales.models.general.Female;

public class OvulatingThread extends Thread {

    // Variables
    private int initialDelay;
    private Female fem;

    public OvulatingThread(Female fem, int i) {

        this.initialDelay = i;
        this.fem = fem;

    }

    public void run() {
        super.run();
        try {
            sleep(initialDelay);
            while (fem.isPregnant() == false) {
                sleep(2500);
                if (fem.isPregnant() != true) {
                    fem.ovulate();
                }

                sleep(1500);

                if (fem.isPregnant() != true) {
                    fem.menstruate();
                }

            }
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }

    }
}
