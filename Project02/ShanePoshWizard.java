package Project02;

import java.util.Random;

import static Project02.PeopleType.*;

/**
 * Creating a new Wizard for Shane's tribe/nation utilizing a self-made, unique
 *         strategy that can be used in our WarringNations game.
 *         Extends People.
 * This wizard is posh and thinks he is better than other wizards.
 */
public class ShanePoshWizard extends People {

    /**
     * From the extension of the People java class, we create a new wizard person.
     *      Implements what their default/base attack and defense, as well as their
     *      effectiveness in terms of damaging an opposing player based on other player's
     *      class.
     * @param nation Nation Shane's wizard belongs to.
     * @param tribe Tribe Shane's wizard belongs to.
     * @param lifePoints Number of life points Shane's wizard has.
     */
    public ShanePoshWizard(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, wizard, lifePoints, 10, 10);
        myDescription = "\tShane Posh Wizard";
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
        // will heal anyone but Wizards
        if((otherPerson.getType() == warrior||otherPerson.getType() == healer) &&
                otherPerson.getLifePoints() < this.getLifePoints()){
            Die die = new Die(2);
            int diceRoll = die.roll();

            // 50% chance of sharing random amount of health
            if (diceRoll%2==0)
                die = new Die(this.getLifePoints());
            diceRoll = die.roll();
            lifePoints = diceRoll;
        }


        return lifePoints;
    }

    /**
     * Checks whether this player should run away in an encounter or not based on the player's
     *      created strategy.
     * @param otherPerson Opposing Player
     * @return True if the player should run away
     */
    @Override
    // will never run from a wizard, always is looking to beat other wizards
    public boolean shouldRunAway(People otherPerson) {
        return ((otherPerson.getType() == warrior && otherPerson.getLifePoints() > this.getLifePoints())
                || (otherPerson.getType() == healer && otherPerson.getLifePoints() > this.getLifePoints()));
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

