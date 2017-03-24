/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalda.javales.models.birds;

import com.scalda.javales.models.Zoo.Zoo;
import com.scalda.javales.models.general.Animal;
import com.scalda.javales.models.general.Egg;
import com.scalda.javales.models.general.Female;
import com.scalda.javales.models.general.Gender;
import java.util.ArrayList;
import java.util.Random;

public class Parrot extends Bird {

    // Variables
    private static String[] parrotQuotes = {"Krakaka", "KoppieKrauw",
        "Ja ik leef nog"};
    public static int parrotEggs = 7;

    // Constructor
    public Parrot(String bodyCovering, String name, String color,
            double weight, Gender gender) {
        super(bodyCovering, name, color, weight, parrotEggs, gender);
    }

    // Methods
    public String communicate() {
        Random r = new Random();

        return parrotQuotes[r.nextInt(parrotQuotes.length)];
    }

    public String fly() {
        return "I can fly";
    }

    public ArrayList<Egg> layEgg() {
        return this.giveBirth();
    }

    public void hatchEgg(ArrayList<Egg> layedEgg) {
        if (this.isFemale()) {
            if (this.getGender().isPregnant()) {
                for (Egg b : layedEgg) {
                    Animal a = b.getEmbryo();
                    Zoo z = Zoo.getInstance();
                    z.addAnimal(a);
                }
                Female f = (Female) getGender();
                f.clearIEggs();
            }
        }
    }

}
