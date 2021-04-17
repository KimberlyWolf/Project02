package Project02;

import java.util.Random;

import static Project02.PeopleType.*;

/**
 * Creating a new special npc to interact with people in the world
 *         Will have a unique interaction from other people types.
 * This Black Smith will increase the defense of someone they meet.
 */
public class BlackSmith extends People {

    /**
     * Constructor for an npc Black Smith
     */
    public BlackSmith()
    {
        super("Asgard", "Black Smith Guild", special, 2, 10, 10);
        myDescription = "\tBlack Smith";

    }

    /**
     * This method will increase the player's defense by using the dice mechanic. The player will receive
     *      one to twenty points added to their defense statistic.
     * @param people Player who encounters the Black Smith
     */
    @Override
    public void interact(People people) {
        Die die = new Die(20);
        System.out.println("The humble blacksmith clads " + people.myDescription + " in the finest armor.");
        int diceRoll = die.roll();
        people.setDefense(getDefense() + diceRoll);
        System.out.println(people.getDescription() + "'s defense rose by " + diceRoll);
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

