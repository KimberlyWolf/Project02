package Project02;

import java.util.Random;

import static Project02.PeopleType.*;

/**
 * A npc character that people can encounter in the world. This object will have a unique effect on a person.
 *  This npc will instantly kill anyone unfortunate enough to encounter it.
 */
public class GrimReaper extends People {

    /**
     * From the extension of the People java class, we create a new wizard person.
     * @param nation Nation Shane's wizard belongs to.
     * @param tribe Tribe Shane's wizard belongs to.
     * @param lifePoints Number of life points Shane's wizard has.
     */
    public GrimReaper(String nation, String tribe, int lifePoints)
    {
        super("Underworld", "the other side", special, lifePoints, 0, 0);
        myDescription = "\tGrim Reaper";
    }



    @Override
    public void interact(People people) {
        people.modifyLifePoints(-getLifePoints());
        System.out.println( people.getDescription() + " met their untimely end at the hands of the Grim Reaper.");
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

