/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalda.javales.models.general;

import java.util.ArrayList;

public abstract class Gender {

    //Variables
    private Animal genderOwner;

    public abstract boolean isPregnant();

    public abstract void propagate(Animal partner1, Animal partner2);

    public abstract ArrayList<Egg> giveBirth();

    public abstract boolean isFemale();
    
    public abstract void stopOvulation();

    public void setGenderOwner(Animal owner) {
        genderOwner = owner;
    }

    public Animal getGenderOwner() {
        return genderOwner;
    }

}
