package com.scalda.javales.models.mammals;

import com.scalda.javales.models.general.Animal;
import com.scalda.javales.models.general.Egg;
import com.scalda.javales.models.general.Female;
import com.scalda.javales.models.general.Gender;
import com.scalda.javales.models.interfaces.IMammal;
import com.scalda.javales.models.utils.SuckleDispatcherThread;
import java.util.ArrayList;

public abstract class Mammal extends Animal implements IMammal {

    // Variables
    private ArrayList<Egg> mammalIEggs = new ArrayList<>();

    //Constructor
    public Mammal(String bodyCovering, String name, String color, double weight, int maxNumberOfEggs, Gender gender) {
        super(bodyCovering, name, color, weight, maxNumberOfEggs, gender);
    }

    // Methods
    public void giveLifeBirth() {
        mammalIEggs = giveBirth();
        if (this.isFemale()) {
            if (this.getGender().isPregnant()) {
                for (Egg b : mammalIEggs) {
                    IMammal m = (IMammal) b.getEmbryo();
                    babies.add(m);
                }
                suckle();
                Female f = (Female) getGender();
                f.clearIEggs();
            }
        }
    }

    public static void clearBabies() {
        System.out.println("ALL THE BABIES CLEAREDDDDD");
        babies.clear();
    }

    public abstract String communicate();

    public abstract ArrayList<IMammal> getbabies();

    public void suckle() {
        new SuckleDispatcherThread(this).start();
    }
}
