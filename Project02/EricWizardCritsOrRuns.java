package Project02;

import java.util.Random;

import static Project02.PeopleType.*;

public class EricWizardCritsOrRuns extends People {

    public EricWizardCritsOrRuns(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, wizard, lifePoints, 10, 10);
        myDescription = "\tEric Polarizing Wizard";
        // critically effective if does not run away
        this.setEffectiveness(warrior, 1.5);
        this.setEffectiveness(wizard, 1.5);
        this.setEffectiveness(healer, 1.5);
    }

    public int healingStrategy(Project02.People otherPerson) {
        int lifePoints = 0;

        // make 2-sided die
        Die die = new Die(2);
        int diceRoll = die.roll();

        // 50% chance of sharing random amount of health
        if (diceRoll%2==0)
            die = new Die(this.getLifePoints());
            diceRoll = die.roll();
            lifePoints = diceRoll;

        return lifePoints;
    }

    @Override
    // Whether runs away is based on opponent's health and random chance
    public boolean shouldRunAway(People otherPerson) {
        // Create a 50 sided die
        Die die = new Die(50);
        int diceRoll = die.roll();

        // Use opponent's health and dice roll to determine if should run
        int otherHealth = otherPerson.getLifePoints();
        if (diceRoll+50 >= otherHealth)
            return false;
        else return true;
    }

    @Override
    public void interact(People people) {

    }


}

