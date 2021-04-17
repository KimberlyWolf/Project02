package Project02;

import java.util.Random;

import static Project02.PeopleType.*;

/**
 * A npc character that people can encounter in the world. This object will have a unique effect on a person.
 *  This npc will instantly kill anyone unfortunate enough to encounter it.
 */
public class GrimReaper extends People {

    /**
     * Constructor for the special character: Grim Reaper
     */
    public GrimReaper()
    {
        super("Underworld", "the other side", special, 2, 0, 0);
        myDescription = "\tGrim Reaper";
    }


    /**
     * For those who are unfortunate to encounter the Grim reaper, all of the player's life points
     *      are removed, killing them instantly.
     * @param people Person who encounters the Grim Reaper
     */
    @Override
    public void interact(People people) {
        people.modifyLifePoints(-getLifePoints());
        System.out.println(people.getDescription() + " met their untimely end at the hands of the Grim Reaper.");
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

