package com.scalda.javales.controllers;

import com.scalda.javales.models.Zoo.Zoo;
import com.scalda.javales.models.birds.Bird;
import com.scalda.javales.models.birds.Parrot;
import com.scalda.javales.models.birds.Pinguin;
import com.scalda.javales.models.general.Animal;
import com.scalda.javales.models.general.Female;
import com.scalda.javales.models.general.Gender;
import com.scalda.javales.models.general.Male;
import com.scalda.javales.models.mammals.AfricanElephant;
import com.scalda.javales.models.mammals.AsianElephant;
import com.scalda.javales.models.mammals.GrayMouse;
import com.scalda.javales.models.mammals.Human;
import com.scalda.javales.models.mammals.Mammal;
import com.scalda.javales.models.mammals.WhiteMouse;
import com.scalda.javales.models.reptiles.Crocodile;
import com.scalda.javales.models.reptiles.Snake;
import com.scalda.javales.models.utils.SpringHelper;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("mainController")
public class TestController {

    private Gender gender;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String Home(ModelMap map, @RequestParam(name = "species",
            required = false, defaultValue = "All") String species)
            throws InterruptedException {

        Zoo z = Zoo.getInstance();

        map.put("z", z);
        map.put("z", z.getAllAnimals());
        map.put("species", species);
        map.put("table", z.getAllAnimalsBySpecies(species));

        if (species.equals("All")) {
            z.getAllAnimals();
            map.put("table", z.getAllAnimals());
        } else {
            z.getAllAnimalsBySpecies(species);
            map.put("table", z.getAllAnimalsBySpecies(species));
        }

        map.put("getName", z.getName());

        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String Add(ModelMap modeladd, @RequestParam String name, @RequestParam String bodycovering,
            @RequestParam String color, @RequestParam double weight, @RequestParam String gender, @RequestParam String species, @RequestParam String lastName) {

        Zoo z = Zoo.getInstance();

        if (gender.equals("male")) {
            this.gender = new Male();
        } else {
            this.gender = new Female();
        }

        //Check species
        if (species.equals("Human")) {
            Human a6 = new Human(bodycovering, name, color, weight, this.gender);
            modeladd.put("a6", a6);
            z.addAnimal(a6);
            a6.setLastName(lastName);
        }
        if (species.equals("Pinguin")) {
            Pinguin a6 = new Pinguin(bodycovering, name, color, weight, this.gender);
            modeladd.put("a6", a6);
            z.addAnimal(a6);
        }
        if (species.equals("Parrot")) {
            Parrot a6 = new Parrot(bodycovering, name, color, weight, this.gender);
            modeladd.put("a6", a6);
            z.addAnimal(a6);
        }
        if (species.equals("AfricanElephant")) {
            AfricanElephant a6 = new AfricanElephant(bodycovering, name, color, weight, this.gender);
            modeladd.put("a6", a6);
            z.addAnimal(a6);
        }
        if (species.equals("AsianElephant")) {
            AsianElephant a6 = new AsianElephant(bodycovering, name, color, weight, this.gender);
            modeladd.put("a6", a6);
            z.addAnimal(a6);
        }
        if (species.equals("GrayMouse")) {
            GrayMouse a6 = new GrayMouse(bodycovering, name, color, weight, this.gender);
            modeladd.put("a6", a6);
            z.addAnimal(a6);
        }
        if (species.equals("WhiteMouse")) {
            WhiteMouse a6 = new WhiteMouse(bodycovering, name, color, weight, this.gender);
            modeladd.put("a6", a6);
            z.addAnimal(a6);
        }
        if (species.equals("Crocodile")) {
            Crocodile a6 = new Crocodile(bodycovering, name, color, weight, this.gender);
            modeladd.put("a6", a6);
            z.addAnimal(a6);
        }
        if (species.equals("Snake")) {
            Snake a6 = new Snake(bodycovering, name, color, weight, this.gender);
            modeladd.put("a6", a6);
            z.addAnimal(a6);
        }

        return "redirect:/home?species=All";
    }

    @RequestMapping(value = "/fill", method = RequestMethod.GET)
    public String Fill(ModelMap modelfill) {

        Zoo z = Zoo.getInstance();

        Human a1 = new Human("Skin", "Marco", "Blank", 55.5, new Male());
        Human a2 = new Human("Skin", "Lisa", "Black", 53.2, new Female());
        Parrot b1 = new Parrot("Feather", "Krakaka", "Blue", 12.1, new Male());
        Parrot b2 = new Parrot("Feather", "JeMoeder", "White", 14.4, new Female());
        Pinguin c1 = new Pinguin("Feather", "Pingu", "Black & White", 30.1, new Male());
        Pinguin c2 = new Pinguin("Feather", "Dikke Vogel", "Black & White", 27.1, new Female());
        AfricanElephant d1 = new AfricanElephant("Skin", "Dumbo", "Gray", 300.1, new Male());
        AfricanElephant d2 = new AfricanElephant("Skin", "Ollie", "Gray", 430.1, new Female());
        AsianElephant e1 = new AsianElephant("Skin", "Wang Chang", "Yellow", 500.2, new Female());
        AsianElephant e2 = new AsianElephant("Skin", "Wang Chong Ching", "Yellow", 520.9, new Male());
        GrayMouse f1 = new GrayMouse("Hair", "Pinky", "Gray Duh?", 2.1, new Male());
        GrayMouse f2 = new GrayMouse("Hair", "The Brain", "Also Gray", 4.4, new Female());

        z.addAnimal(a1);
        z.addAnimal(a2);
        z.addAnimal(b1);
        z.addAnimal(b2);
        z.addAnimal(c1);
        z.addAnimal(c2);
        z.addAnimal(d1);
        z.addAnimal(d2);
        z.addAnimal(e1);
        z.addAnimal(e2);
        z.addAnimal(f1);
        z.addAnimal(f2);

        return "redirect:/home?species";
    }

    @RequestMapping(value = "/kill", method = RequestMethod.GET)
    public String Clear(ModelMap modelclear) {

        Zoo z = Zoo.getInstance();

        z.clearAnimals();
        z.getCages().clear();

        return "redirect:/home?species=All";
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String Change(ModelMap modelchange, HttpServletRequest request) {

        Zoo z = Zoo.getInstance();

        String newName = request.getParameter("newName");

        z.setName(newName);

        modelchange.put("newName", newName);

        return "redirect:/home?species=All";
    }

    @RequestMapping(value = "/humans", method = RequestMethod.GET)
    public String Humans(ModelMap map, @RequestParam(name = "species",
            required = false, defaultValue = "Human") String species)
            throws InterruptedException {

        Zoo z = Zoo.getInstance();
        map.put("z", z);

        map.put("z", z.getAllAnimals());
        map.put("species", species);
        map.put("tableHuman", z.getAllAnimalsBySpecies(species));

        if (species.equals("All")) {
            z.getAllAnimals();
            map.put("tableHuman", z.getAllAnimals());
        } else {
            z.getAllAnimalsBySpecies(species);
            map.put("tableHuman", z.getAllAnimalsBySpecies(species));
        }

        map.put("getName", z.getName());

        return "humans";

    }

    @RequestMapping(value = "/propagate", method = RequestMethod.GET)
    public String AnimalPropagate(ModelMap map, @RequestParam(name = "species",
            required = false, defaultValue = "Parrot") String species)
            throws InterruptedException {

        Zoo z = Zoo.getInstance();
        map.put("z", z);

        map.put("z", z.getAllAnimals());
        map.put("species", species);
        map.put("table", z.getAllAnimalsBySpecies(species));
        map.put("getName", z.getName());

        return "propagate";

    }

    @RequestMapping(value = "/cages", method = RequestMethod.GET)
    public String Cages(ModelMap map)
            throws InterruptedException {

        Zoo z = Zoo.getInstance();
        map.put("z", z);

        map.put("getCages", z.getCages());
        map.put("getName", z.getName());

        return "cages";

    }

    @RequestMapping(value = "/prop", method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<Animal> Propagate(HttpServletRequest request) throws IOException {

        String ajaxString = SpringHelper.getAjaxStringFromRequest(request);

        String a = SpringHelper.getParameterFromAjaxString(ajaxString, "selection1");
        String b = SpringHelper.getParameterFromAjaxString(ajaxString, "selection2");

        Animal male = Zoo.getInstance().getAnimalByUUID(UUID.fromString(a));
        Animal female = Zoo.getInstance().getAnimalByUUID(UUID.fromString(b));

        male.propagate(female);

        return null;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String Edit(ModelMap modeladd, @RequestParam String name, @RequestParam String bodycovering,
            @RequestParam String color, @RequestParam double weight, @RequestParam String lastName,
            @RequestParam boolean bcontrol, @RequestParam UUID thisAnimal) {

        Human Animal = (Human) Zoo.getInstance().getAnimalByUUID(thisAnimal);

        Animal.setName(name);
        Animal.setBodyCovering(bodycovering);
        Animal.setColor(color);
        Animal.setWeight(weight);
        Animal.setLastName(lastName);
        Animal.setUsesBirthControl(bcontrol);

        return "redirect:/humans";
    }

    @RequestMapping(value = "/divorce", method = RequestMethod.GET)
    public String Divorce(ModelMap modeladd, @RequestParam UUID thisAnimal) {

        Human Animal = (Human) Zoo.getInstance().getAnimalByUUID(thisAnimal);

        if (Animal.getPartner() != null) {
            Animal.divorce();
        }

        return "redirect:/humans";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String Delete(ModelMap modeldelete, @RequestParam UUID thisAnimal) throws Throwable {

        Animal Animal = Zoo.getInstance().getAnimalByUUID(thisAnimal);

        return "redirect:/humans";
    }

    @RequestMapping(value = "/mary", method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<Animal> Mary(HttpServletRequest request) throws IOException {

        String ajaxString = SpringHelper.getAjaxStringFromRequest(request);

        String a = SpringHelper.getParameterFromAjaxString(ajaxString, "selection1m");
        String b = SpringHelper.getParameterFromAjaxString(ajaxString, "selection2m");

        Human male = (Human) Zoo.getInstance().getAnimalByUUID(UUID.fromString(a));
        Human female = (Human) Zoo.getInstance().getAnimalByUUID(UUID.fromString(b));

        male.Mary(female);

        return null;
    }

    @RequestMapping(value = "/makelove", method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<Animal> MakeLove(HttpServletRequest request) throws IOException {

        String ajaxString = SpringHelper.getAjaxStringFromRequest(request);

        String a = SpringHelper.getParameterFromAjaxString(ajaxString, "selection1ml");
        String b = SpringHelper.getParameterFromAjaxString(ajaxString, "selection2ml");

        Human male = (Human) Zoo.getInstance().getAnimalByUUID(UUID.fromString(a));
        Human female = (Human) Zoo.getInstance().getAnimalByUUID(UUID.fromString(b));

        male.makeLove(female);

        return null;
    }

    @RequestMapping(value = "/giveBirth", method = RequestMethod.GET)
    public String giveBirth(ModelMap modelgivebirth, @RequestParam UUID thisAnimal) throws InterruptedException {

        Mammal Animal = (Mammal) Zoo.getInstance().getAnimalByUUID(thisAnimal);

        Animal.giveLifeBirth();
        sleep(3000);

        return "redirect:/humans";
    }

    @RequestMapping(value = "/layEggs", method = RequestMethod.GET)
    public String layEggs(ModelMap modelgivebirth, @RequestParam UUID thisAnimal) throws InterruptedException {

        Bird Animal = (Bird) Zoo.getInstance().getAnimalByUUID(thisAnimal);
        Animal.hatchEgg(Animal.layEgg());

        sleep(3000);

        return "redirect:/propagate";
    }

    @RequestMapping(value = "/thread", method = RequestMethod.GET)
    public String Thread(ModelMap modelgivebirth, @RequestParam UUID thisAnimal) throws InterruptedException {

        Mammal Animal = (Mammal) Zoo.getInstance().getAnimalByUUID(thisAnimal);

        Animal.getGender().stopOvulation();

        return "redirect:/humans";
    }
}
