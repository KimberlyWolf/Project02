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
     * Individual strategies to influence how the game is played. This strategy determines
     *       how this player interacts from people from other nations, their own nation,
     *       and their own tribe.
     * @param otherPerson The opponent player 1 is going against
     * @return Life points to determine if this player runs away, how much to damage to
     *       deal, or how much to heal.
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

    // TODO: document this
    @Override
    // will never run from a wizard, always is looking to beat other wizards
    public boolean shouldRunAway(People otherPerson) {
        return ((otherPerson.getType() == warrior && otherPerson.getLifePoints() > this.getLifePoints())
                || (otherPerson.getType() == healer && otherPerson.getLifePoints() > this.getLifePoints()));
    }

    // NOT an npc, won't be used here
    @Override
    public void interact(People people) {

    }


}

