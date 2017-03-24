package com.scalda.javales.models.interfaces;

import java.util.ArrayList;

import com.scalda.javales.models.general.Egg;

// An interface is like a blueprint of methods whom are generally added but specified inside classes
public interface IBird extends IEggLayer {

	// tells an animal whether it can fly or not
	public String fly();

	// passes along
	public void hatchEgg(ArrayList<Egg> layedEgg);

}
