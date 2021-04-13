package Project02;

import java.util.Random;

import static Project02.PeopleType.*;

/**
 * A npc object that people can encounter in the world. This object will have a unique effect on a person.
 * This mysterious potion will either heal or damage a person. This is determined by dice rolls.
 */
public class MysteriousPotion extends People {


    public MysteriousPotion(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, special, lifePoints, 0, 0);
        myDescription = "\tmysterious potion";
    }


    @Override
    public void interact(People people) {
        Die die = new Die(20);
        Die twoSidedDie = new Die(2);
        System.out.println( people.myDescription + " makes sure no one is watching and drinks the " + getDescription()+".");
        System.out.println("Will this help or harm " + people.myDescription + "?");
        int evenOrOdd = twoSidedDie.roll();
        int healthPoints;

        if (evenOrOdd % 2 == 0){
            System.out.println("It's even, health is given!");
            healthPoints =  die.roll() * 5;
        }
        else {
            System.out.println("Uh oh, it's odd, health is lost!");
            healthPoints = - die.roll() * 5;

        }

        System.out.println(people.getDescription() + " felt funny and received " + healthPoints + " health.");
        people.modifyLifePoints(healthPoints);

        reduceInteractionsLeft();
    }

    //npc wont be using these methods
    @Override
    public int healingStrategy(People otherPerson) {
        return 0;
    }

    @Override
    public boolean shouldRunAway(People otherPerson) {
        return false;
    }


}

