package com.scalda.javales.models.utils;

import com.scalda.javales.models.general.Animal;
import com.scalda.javales.models.general.Female;
import com.scalda.javales.models.general.Gender;
import com.scalda.javales.models.general.Male;
import java.util.Random;

public class AnimalGeneration {

    public static Random r = new Random();

    public static Gender getRandomGender() {
        r.nextBoolean();
        if (r.nextBoolean()) {
            return new Male();
        } else {
            return new Female();
        }
    }

    public static Animal looksLikeParent(Animal parent1, Animal parent2) {
        if (r.nextBoolean()) {
            return parent1;
        } else {
            return parent2;
        }

    }

    private static String[] manimalNames = {"Kees", "Henk", "Sjaak",
        "Marco", "Poseidon", "Taurus", "Zeus", "Kronos", "Gino", "Maxim",
        "Rens", "", "Sonic", "James", "Dave", "Sjaak", "Eddie",
        "Tyrone", "Mario", "Yannick", "Sanik", "Jeroen"};

    private static String[] femanimalNames = {"Evy", "Chikorita", "Jamie",
        "Anna", "Tanja", "Rianne", "Roxanne", "Annabel", "Lieve",
        "Naomi", "Sharon", "Esther", "Kim", "Damaris", "Marie", "Rikkie",
        "Julia", "Ruth", "Helene"};

    public static String randomName(Gender g) {
        if (g.isFemale()) {
            return femanimalNames[r.nextInt(femanimalNames.length)];
        } else {
            return manimalNames[r.nextInt(manimalNames.length)];
        }
    }
}
