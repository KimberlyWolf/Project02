package Project02;

import static Project02.PeopleType.*;

/**
 * Creating a new Healer for Kim's tribe/nation utilizing a self-made, unique
 *         strategy that can be used in our WarringNations game.
 *         Extends People.
 */
public class KimHealer2 extends People {

    /**
     * From the extension of the People java class, we create a new healer person.
     * @param nation Nation Kim's Healer belongs to.
     * @param tribe Tribe Kim's Healer belongs to.
     * @param lifePoints Number of life points Kim's Healer has.
     */
    public KimHealer2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints);
        myDescription = "\tKim Healer";
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
                switch(otherPerson.getType()) {
                    case warrior:
                        lifePoints = this.getLifePoints() / 8;
                        break;
                    case wizard:
                        lifePoints = this.getLifePoints() / 6;
                        break;
                    case healer:
                        lifePoints = this.getLifePoints() / 4;
                        break;
                    default:
                        lifePoints = 0;
                        break;
                }
            }
            // lower/same health as enemy
            else {
                lifePoints -= 1;
            }
        }
        else
        {
            // same tribe
            if (this.getTribe().equals(otherPerson.getTribe())) {
                // share health only if have more than friend
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    lifePoints = this.getLifePoints() - otherPerson.getLifePoints();
                }
            }
            // different tribe
            else {
                // more health than friendly
                // this will always share enough health to make them equal
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 2;
                }
            }
        }
        return lifePoints;
    }
}