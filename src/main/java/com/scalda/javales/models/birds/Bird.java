/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalda.javales.models.birds;

import com.scalda.javales.models.general.Animal;
import com.scalda.javales.models.general.Egg;
import com.scalda.javales.models.general.Gender;
import com.scalda.javales.models.interfaces.IBird;
import java.util.ArrayList;

public abstract class Bird extends Animal implements IBird {

    /// Constructor
    public Bird(String bodyCovering, String name, String color, double weight,
            int maxNumberOfEggs, Gender gender) {
        super(bodyCovering, name, color, weight, maxNumberOfEggs, gender);
    }

    // Methods
    public abstract String communicate();

    public abstract ArrayList<Egg> layEgg();

    public abstract void hatchEgg(ArrayList<Egg> layedEgg);

}
