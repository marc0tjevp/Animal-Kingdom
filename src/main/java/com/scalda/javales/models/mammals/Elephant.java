/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalda.javales.models.mammals;

import com.scalda.javales.models.general.Gender;

public abstract class Elephant extends Mammal {
        
    //Constructor
    public Elephant(String bodyCovering, String name, String color, double weight, int maxNumberOfEggs, Gender gender) {
        super(bodyCovering, name, color, weight, maxNumberOfEggs, gender);
    }
    
    
    
}
