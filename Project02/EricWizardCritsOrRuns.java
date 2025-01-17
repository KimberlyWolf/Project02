package Project02;

import java.util.Random;

import static Project02.PeopleType.*;

/**
 * Creating a new Wizard for Eric's tribe/nation utilizing a self-made, unique
 *         strategy that can be used in our WarringNations game.
 *         Extends People.
 */
public class EricWizardCritsOrRuns extends People {

    /**
     * From the extension of the People java class, we create a new wizard person.
     *      Implements what their default/base attack and defense, as well as their
     *      effectiveness in terms of damaging an opposing player based on other player's
     *      class.
     * @param nation Nation Eric's wizard belongs to.
     * @param tribe Tribe Eric's wizard belongs to.
     * @param lifePoints Number of life points Eric's wizard has.
     */
    public EricWizardCritsOrRuns(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, wizard, lifePoints, 10, 10);
        myDescription = "\tEric Polarizing Wizard";
        // critically effective if does not run away
        this.setEffectiveness(warrior, 1.5);
        this.setEffectiveness(wizard, 1.5);
        this.setEffectiveness(healer, 1.5);
    }

    /**
     * An individually created strategy that determines how much points this player is
     *      willing to give to heal during a friendly encounter. The number of life points
     *      can vary if the players are from the same tribe or not.
     * @param otherPerson Opposing player from same Nation
     * @return The number of life points this player should give to heal a friendly player
     */
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

    /**
     * Checks whether this player should run away in an encounter or not based on the player's
     *      created strategy.
     * @param otherPerson Opposing Player
     * @return True if the player should run away
     */
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

    /**
     * This is only used for special characters. Nothing should be added here.
     * @param people Player in world
     */
    // NOT an npc, won't be used here
    @Override
    public void interact(People people) {

    }


}

