package Project02;

import java.util.Random;

import static Project02.PeopleType.*;

/**
 * A npc object that people can encounter in the world. This object will have a unique effect on a person.
 * This mysterious potion will either heal or damage a person. This is determined by dice rolls.
 */
public class MysteriousPotion extends People {


    /**
     * Constructor for the special artifact: Mysterious Potion
     */
    public MysteriousPotion()
    {
        super("", "", special, 2, 0, 0);
        myDescription = "\tmysterious potion";
    }


    /**
     * Using the dice mechanic, this method determines whether the player should receive or lose health.
     * If the dice roll is even, health is given, else, health is lost.
     * @param people Person who encounters the Potion
     */
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

    /**
     * This method will not be used by special characters and artifacts!
     * @param otherPerson Opposing player
     * @return Integer value of how much health is being given
     */
    //npc wont be using these methods
    @Override
    public int healingStrategy(People otherPerson) {
        return 0;
    }

    /**
     * This method will not be used by special characters and artifacts!
     * @param otherPerson Opposing player
     * @return False because special characters never run away.
     */
    @Override
    public boolean shouldRunAway(People otherPerson) {
        return false;
    }


}

