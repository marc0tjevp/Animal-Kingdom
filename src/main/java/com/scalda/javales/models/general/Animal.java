package com.scalda.javales.models.general;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Animal {

    //Variables
    private final UUID ID;
    protected String bodyCovering;
    protected String name;
    protected String color;
    protected double weight;
    protected int maxNumberOfEggs;
    protected Gender gender;

    //Constructor
    public Animal(String bodyCovering, String name, String color, double weight,
            int maxNumberOfEggs, Gender gender) {
        this.ID = java.util.UUID.randomUUID();
        this.bodyCovering = bodyCovering;
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.maxNumberOfEggs = maxNumberOfEggs;
        this.gender = gender;
        this.gender.setGenderOwner(this);
    }

    //Getters and Setters
    public UUID getID() {
        return ID;
    }

    public String getBodyCovering() {
        return bodyCovering;
    }

    public void setBodyCovering(String bodyCovering) {
        this.bodyCovering = bodyCovering;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMaxNumberOfEggs() {
        return maxNumberOfEggs;
    }

    public void setMaxNumberOfEggs(int maxNumberOfEggs) {
        this.maxNumberOfEggs = maxNumberOfEggs;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    //Methods
    public abstract String communicate();

    public boolean propagate(Animal partner) {
        if (this.getName().equals(partner.getName())) {

            return false;
        } else if (this.getClass().equals(partner.getClass())) {

            this.getGender().propagate(this, partner);
            partner.getGender().propagate(this, partner);

            System.out.println("Propagated");
            
            return true;
        } else {
            return false;
        }
    }

    public boolean isPregnant() {
        return getGender().isPregnant();
    }

    public boolean isFemale() {
        return getGender().isFemale();
    }

    public ArrayList<Egg> giveBirth() {
        return this.getGender().giveBirth();
    }
}
