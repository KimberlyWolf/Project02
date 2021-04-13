package Project02;

import java.util.Random;

import static Project02.PeopleType.*;

/**
 * Creating a new special npc to interact with people in the world
 *         Will have a unique interaction from other people types.
 * This Black Smith will increase the defense of someone they meet.
 */
public class BodyBuilder extends People {

    /**
     * Constructor for an npc Black Smith
     */
    public BodyBuilder()
    {
        super("Planet Fitness", "Gym Sharks", special, 100, 10, 10);
        setInteractionsLeft(2);
        myDescription = "\tBody Builder";
    }


    // NOT an npc, won't be used here
    @Override
    public void interact(People people) {
        Die die = new Die(20);
        System.out.println("The Body Builder teaches " + people.myDescription + " how to bulk and get swole.");
        int diceRoll = die.roll();
        people.setAttack(getAttack() + diceRoll);
        System.out.println(people.getDescription() + "'s attack rose by " + diceRoll);
        System.out.println("The two people part ways.");
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

