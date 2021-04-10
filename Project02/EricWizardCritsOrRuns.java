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
     * @param nation Nation Eric's wizard belongs to.
     * @param tribe Tribe Eric's wizard belongs to.
     * @param lifePoints Number of life points Eric's wizard has.
     */
    public EricWizardCritsOrRuns(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, wizard, lifePoints);
        myDescription = "\tEric Polarizing Wizard";
    }

    /**
     * Individual strategies to influence how the game is played. This strategy determines
     *       how this player interacts from people from other nations, their own nation,
     *       and their own tribe.
     * @param otherPerson The opponent player 1 is going against
     * @return Life points to determine if this player runs away, how much to damage to
     *       deal, or how much to heal.
     */
    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        // opposing nation
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        int diceRoll = random.nextInt();
        boolean equalChance = diceRoll%2==0;
        // different nation
        if (!this.getNation().equals((otherPerson.getNation()))) {
            if (equalChance)
                lifePoints = this.getLifePoints();
            // same nation
        } else {
            // shares random health
            if (equalChance)
                lifePoints = (int) random.nextDouble() * this.getLifePoints();
        }
        return lifePoints;
    }


}

