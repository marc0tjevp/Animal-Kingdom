/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalda.javales.models.reptiles;

import com.scalda.javales.models.Zoo.Zoo;
import com.scalda.javales.models.general.Egg;
import com.scalda.javales.models.general.Gender;
import java.util.ArrayList;
import java.util.Random;

public class Crocodile extends Reptile {

    // Variables
    private static String[] crocoQuotes = {"Rawrr", "Tic toc Tic toc"};

    public static int maxNumberOfEggs = 35;

    // Constructor
    public Crocodile(String bodyCovering, String name, String color,
            double weight, Gender gender) {
        super(bodyCovering, name, color, weight, maxNumberOfEggs, gender);
    }
    
    // Methods
    public String communicate() {
        Random r = new Random();
        return crocoQuotes[r.nextInt(crocoQuotes.length)];
    }

    public String crawl() {
        return "I can crawl";
    }

    public ArrayList<Egg> layEgg() {
        Zoo z = Zoo.getInstance();
        if (this.isFemale()) {
            z.addEggsOfReptiles(this.giveBirth());
        }
        return null;
    }

}
