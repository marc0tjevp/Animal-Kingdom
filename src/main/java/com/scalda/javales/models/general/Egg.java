/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scalda.javales.models.general;

import com.scalda.javales.models.mammals.Human;
import com.scalda.javales.models.mammals.Mammal;
import com.scalda.javales.models.utils.AnimalGeneration;
import java.lang.reflect.InvocationTargetException;

public class Egg {

    //Variables
    private Animal embryo;

    //Constructor
    public Egg() {
    }

    // Getters and setters
    public Animal getEmbryo() {
        return embryo;
    }

    // Methods
    public boolean isInseminated() {
        if (embryo != null) {
            return true;
        }
        return false;
    }

    public void inseminate(Animal parent1, Animal parent2) {
        try {
            Gender randomGender = AnimalGeneration.getRandomGender();

            Animal a = AnimalGeneration.looksLikeParent(parent1, parent2);

            embryo = parent1.getClass()
                    .getConstructor(String.class, String.class, String.class, double.class, Gender.class)
                    .newInstance(a.getBodyCovering(), AnimalGeneration.randomName(randomGender),
                            AnimalGeneration.looksLikeParent(parent1, parent2).getColor(),
                            AnimalGeneration.looksLikeParent(parent1, parent2).getWeight(), randomGender);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
        }
    }

}
