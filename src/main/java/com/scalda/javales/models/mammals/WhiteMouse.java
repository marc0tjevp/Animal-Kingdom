/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalda.javales.models.mammals;

import com.scalda.javales.models.general.Egg;
import com.scalda.javales.models.general.Gender;
import com.scalda.javales.models.interfaces.IMammal;
import java.util.ArrayList;
import java.util.Random;

public class WhiteMouse extends Mouse {

    // Variables
    private ArrayList<Egg> mammalIEggs = new ArrayList<>();
    private static String[] whiteQuotes = {"Squeek", "I actually hate cheese",
        "White MasterRace"};
    public static int maxNumberOfEggs = 4;

    // Constructor
    public WhiteMouse(String bodyCovering, String name, String color,
            double weight, Gender gender) {
        super(bodyCovering, name, color, weight, maxNumberOfEggs, gender);
    }

    // Getters and Setters
    public ArrayList<IMammal> getbabies() {
        return babies;
    }

    // Methods
    public String communicate() {
        Random r = new Random();

        return whiteQuotes[r.nextInt(whiteQuotes.length)];
    }

}
