/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalda.javales.models.general;

import java.util.ArrayList;

public class Male extends Gender {

    public boolean isPregnant() {
        return false;
    }

    public void propagate(Animal partner1, Animal partner2) {
        //Males do nothing...
    }

    public ArrayList<Egg> giveBirth() {
        return null;
    }

    public boolean isFemale() {
        return false;
    }

    @Override
    public void stopOvulation() {
    }

}
