/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalda.javales.models.birds;

import com.scalda.javales.models.general.Egg;
import com.scalda.javales.models.general.Gender;
import java.util.ArrayList;
import java.util.Random;

public class Pinguin extends Bird {
    
    //Variables
    public static int maxNumberOfEggs = 4;
    private static String[] pinguinQuotes = {"Krakaka", "WOMBO COMBO"};
    
    //Constructor
    public Pinguin(String bodyCovering, String name, String color, double weight, Gender gender) {
        super(bodyCovering, name, color, weight, maxNumberOfEggs, gender);
    }

    @Override
    public String communicate() {
        Random r = new Random();

        return pinguinQuotes[r.nextInt(pinguinQuotes.length)];
    }

    @Override
    public String fly() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hatchEgg(ArrayList<Egg> layedEgg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Egg> layEgg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
