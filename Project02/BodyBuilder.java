package Project02;

import java.util.Random;

import static Project02.PeopleType.*;

/**
 * Creating a new special npc to interact with people in the world
 *         Will have a unique interaction from other people types.
 * This Body Builder will increase the attack of someone they meet.
 */
public class BodyBuilder extends People {

    /**
     * Constructor for an npc Body Builder
     */
    public BodyBuilder()
    {
        super("Planet Fitness", "Gym Sharks", special, 2, 10, 10);
        setInteractionsLeft(2);
        myDescription = "\tBody Builder";
    }


    /**
     * This method will increase the player's attack by using the dice mechanic. The player will receive
     *      one to twenty points added to their attack statistic.
     * @param people Player who encounters the Body Builder
     */
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

