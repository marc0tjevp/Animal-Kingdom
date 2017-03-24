/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalda.javales.models.mammals;

import com.scalda.javales.models.general.Gender;

/**
 *
 * @author MMarco
 */
public abstract class Mouse extends Mammal {
    
    //Constructor
    public Mouse(String bodyCovering, String name, String color, double weight, int maxNumberOfEggs, Gender gender) {
        super(bodyCovering, name, color, weight, maxNumberOfEggs, gender);
    }
    
}
