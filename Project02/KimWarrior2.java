package Project02;

import static Project02.PeopleType.*;

/**
 * Creating a new Warrior for Kim's tribe/nation utilizing a self-made, unique
 *         strategy that can be used in our WarringNations game.
 *         Extends People.
 */
public class KimWarrior2 extends People {

    /**
     * From the extension of the People java class, we create a new warrior person.
     * @param nation Nation Kim's warrior belongs to.
     * @param tribe Tribe Kim's warrior belongs to.
     * @param lifePoints Number of life points Kim's warrior has.
     */
    public KimWarrior2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints);
        myDescription = "\tKim Warrior";
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
        if (!this.getNation().equals((otherPerson.getNation())))
        {
            // greater health than enemy
            if (this.getLifePoints() > otherPerson.getLifePoints())
            {
                lifePoints = this.getLifePoints();
            }
            // lower/same health as enemy
            else {
                lifePoints = this.getLifePoints() / 2;
            }
        }
        // same nation
        else
        {
            // same tribe
            if (this.getTribe().equals(otherPerson.getTribe())) {
                // share health only if have more than friend
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 2;
                }
            }
            // different tribe
            else {
                // more health than friendly
                // this will always share enough health to make them equal
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 4;
                }
            }
        }
        return lifePoints;
    }

}

