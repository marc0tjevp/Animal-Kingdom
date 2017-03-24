package com.scalda.javales.models.utils;

import com.scalda.javales.models.Zoo.Zoo;
import com.scalda.javales.models.general.Animal;
import com.scalda.javales.models.interfaces.IMammal;
import com.scalda.javales.models.mammals.Human;
import com.scalda.javales.models.mammals.Mammal;

public class SuckleDispatcherThread extends Thread {

    // Variables
    private Mammal mother;

    public SuckleDispatcherThread(Mammal mammal) {

        this.mother = mammal;

    }

    @Override
    public void run() {
        super.run();
        try {

            sleep(300);

            for (IMammal m : mother.getbabies()) {
                Zoo z = Zoo.getInstance();
                z.addAnimal((Animal) m);

            }
            Mammal.clearBabies();

        } catch (InterruptedException e) {
        }

    }

}
