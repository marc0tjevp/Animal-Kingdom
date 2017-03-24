package com.scalda.javales.models.Zoo;

import com.scalda.javales.models.general.Animal;
import java.util.ArrayList;

public class Cage {

    // Variables
    public ArrayList<Animal> animals;
    private String type;

    // Constructor
    public Cage(String type) {
        this.animals = new ArrayList<>();
        this.type = type;
    }

    // Getters and setters
    public String getCageType() {
        return type;
    }

    public ArrayList<Animal> getCagedAnimals() {
        return animals;
    }

    // Methods
    public Animal selectAnimal(int index) {
        return animals.get(index);
    }

    public boolean addAnimal(Animal anAnimal) {
        animals.add(anAnimal);
        return true;
    }

    public ArrayList<Animal> getAnimal() {
        return animals;
    }
    
}
