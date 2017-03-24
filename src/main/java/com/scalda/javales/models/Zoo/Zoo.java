package com.scalda.javales.models.Zoo;

import com.scalda.javales.models.general.Animal;
import com.scalda.javales.models.general.Egg;
import com.scalda.javales.models.mammals.Human;
import com.scalda.javales.models.utils.ReptileEggHatcherThread;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.UUID;

public class Zoo {

    // Variables
    private static String name = "Animal Kingdom";
    private ArrayList<Cage> cages;
    private static Zoo instance = null;
    private ReptileEggHatcherThread ReptileEggHatcherThread;

    // Constructor
    private Zoo(String name) {
        cages = new ArrayList<>();
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        Zoo.name = name;
    }

    public ArrayList<Cage> getCages() {
        return cages;
    }

    public ArrayList<Animal> clearAnimals() {
        for (Cage c : cages) {
            c.getCagedAnimals().clear();
        }
        return null;
    }

    public Cage getCageOfAnimal(Animal anAnimal) {
        for (Cage c : cages) {
            if (anAnimal.getClass().getSimpleName().equals(c.getCageType())) {
                return c;
            }
        }
        return null;
    }

    public Cage getCageByRace(Class<? extends Animal> class1) {
        for (Cage c : cages) {
            if (c.getCageType().equals(class1.getSimpleName())) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Animal> getAllAnimalsBySpecies(String species) {
        ArrayList<Animal> allAnimalsSpecies = new ArrayList<>();
        for (Cage c : cages) {
            if (species.equals(c.getCageType())) {
                allAnimalsSpecies.addAll(c.getCagedAnimals());
                return allAnimalsSpecies;
            }
        }
        return allAnimalsSpecies;
    }

    public ArrayList<Animal> getAllAnimals() {
        ArrayList<Animal> allAnimals = new ArrayList<>();
        for (Cage c : cages) {
            allAnimals.addAll(c.getCagedAnimals());
        }
        return allAnimals;
    }

    // Methods
    public static Zoo getInstance() {
        if (instance == null) {
            instance = new Zoo(name);
        }
        return instance;
    }

    public boolean addCage(Cage aCage) {
        cages.add(aCage);
        return true;
    }

    public boolean addAnimal(Animal anAnimal) {
        for (Cage c : cages) {
            if (anAnimal.getClass().getSimpleName().equals(c.getCageType())) {
                c.addAnimal(anAnimal);
                return true;
            }
        }
        Cage cage = new Cage(anAnimal.getClass().getSimpleName());
        cage.addAnimal(anAnimal);
        addCage(cage);
        return true;
    }

    public Animal getAnimalByUUID(UUID id) {
        for (Animal a : this.getAllAnimals()) {
            if (id.equals(a.getID())) {
                return a;
            }
        }
        return null;
    }

    public void addEggsOfReptiles(ArrayList<Egg> reptileEggs) {
        if (!reptileEggs.isEmpty()) {
            Cage reptileCage = getCageByRace(reptileEggs.get(0).getEmbryo().getClass());
            ReptileEggHatcherThread = new ReptileEggHatcherThread(reptileCage, reptileEggs);
            ReptileEggHatcherThread.start();
        }
    }
}
