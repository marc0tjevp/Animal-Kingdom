/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalda.javales.models.reptiles;

import com.scalda.javales.models.general.Animal;
import com.scalda.javales.models.general.Gender;
import com.scalda.javales.models.interfaces.IReptile;

/**
 *
 * @author MMarco
 */
public abstract class Reptile extends Animal implements IReptile {
    
    //Constructor
    public Reptile(String bodyCovering, String name, String color, double weight, int maxNumberOfEggs, Gender gender) {
        super(bodyCovering, name, color, weight, maxNumberOfEggs, gender);
    }
    
}
