package com.scalda.javales.models.mammals;

import com.scalda.javales.models.general.Gender;
import com.scalda.javales.models.interfaces.IMammal;
import java.util.ArrayList;
import java.util.Random;

public class Human extends Mammal {

// Variables
    public int chanceToGetCaught = 30;
    public int chanceToGetStd = 20;
    private boolean usesBirthControl;
    public String lastName;
    public String insertion;
    private Human partner;
    public boolean sexualTransmitedDisease;
    private static String[] humanQuotes = {"Are we human?", "Kawaii Desu", "Peace man",
        "You can't command me to speak", "I'm not your dog...", "I want to change the world!",
        "I ain't no hollabackgurll!", "Can virtual humans pee?", "Is this the real life?", "Yo, sup?",
        "Or is this just fantasy"};
    public static int maxNumberOfEggs = 2;

    //Constructor
    public Human(String bodyCovering, String name, String color, double weight, Gender gender) {
        super(bodyCovering, name, color, weight, maxNumberOfEggs, gender);
    }

    // Getters & Setters
    public int getChanceToGetCaught() {
        return chanceToGetCaught;
    }

    public void setchanceToGetCaught(int chanceToGetStd) {
        this.chanceToGetStd = chanceToGetStd;
    }

    public int getChanceToGetStd() {
        return chanceToGetStd;
    }

    public void setChanceToGetStd(int chanceToGetStd) {
        this.chanceToGetStd = chanceToGetStd;
    }

    public boolean getsexualTransmitedDisease() {
        return sexualTransmitedDisease;
    }

    public void setsexualTransmitedDisease(boolean sexualTransmitedDisease) {
        this.sexualTransmitedDisease = sexualTransmitedDisease;
    }

    public Human getPartner() {
        return partner;
    }

    public String getPartnerName() {
        if (partner == null) {
            return "None";
        } else {
            return partner.getName();
        }
    }

    public void setPartner(Human partner) {
        this.partner = partner;
    }

    public String getLastName() {
        if (lastName == null) {
            return "None";
        } else {
            return lastName;
        }
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInsertion() {
        return insertion;
    }

    public void setInsertion(String insertion) {
        this.insertion = insertion;
    }

    public void setUsesBirthControl(boolean usesBirthControl) {
        this.usesBirthControl = usesBirthControl;
    }

    public ArrayList<IMammal> getbabies() {
        return babies;
    }

    // Methods
    public void makeLove(Human partner) {
        if (this.getClass().getSimpleName().equals(partner.getClass().getSimpleName())) {
            if (this.getPartner() == null || partner.getPartner() == null) {
                adulteryLove(partner);
            } else if (this.getPartner().equals(partner)) {
                marriageLove();
                System.out.println("sex with partner");
            } else {
                adulteryLove(partner);
            }
        } else {
        }
    }

    private void marriageLove() {
        if (this.usesBirthControl == false && this.getPartner().usesBirthControl == false) {
            this.propagate(this.getPartner());
        } else {
            System.out.println("Safe sex with partner");
        }
    }

    private void adulteryLove(Human lover) {
        Random r = new Random();
        if (this.usesBirthControl == false && lover.usesBirthControl == false) {
            this.propagate(lover);

            if (r.nextInt(100) > this.chanceToGetStd) {
                this.setsexualTransmitedDisease(true);
                System.out.println("You've got an STD");
            } else {
                this.setChanceToGetStd(this.chanceToGetStd + 2);
            }
            if (r.nextInt(100) > lover.chanceToGetStd) {
                lover.setsexualTransmitedDisease(true);
                System.out.println("u got aids");
            } else {
                lover.setChanceToGetStd(lover.chanceToGetStd + 2);
            }
        }
        if (r.nextInt(100) > this.chanceToGetCaught) {
            System.out.println("Cheater got caught");
            if (this.getPartner() != null) {
                this.divorce();
            }
        } else {
            this.setchanceToGetCaught(chanceToGetCaught + 5);
        }
        if (r.nextInt(100) > lover.chanceToGetCaught) {
            System.out.println("lover Got caught");
            if (lover.getPartner() != null) {
                lover.divorce();
            }
        } else {
            lover.setchanceToGetCaught(chanceToGetCaught + 5);
        }
    }

    public boolean Mary(Human partner) {
        if (!isMarried() && !partner.isMarried()) {
            setPartner(partner);
            partner.setPartner(this);
            partner.setsexualTransmitedDisease(false);
            this.setsexualTransmitedDisease(false);
            return true;
        } else {
            return false;
        }
    }

    public boolean isMarried() {
        return this.partner != null;
    }

    public void divorce() {
        partner.setPartner(null);
        setPartner(null);
    }

    public boolean isUsesBirthControl() {
        return usesBirthControl;
    }

    @Override
    public String communicate() {
        Random r = new Random();
        return humanQuotes[r.nextInt(humanQuotes.length)];
    }
}
