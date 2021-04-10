package Project02;

import static Project02.PeopleType.*;

/**
 * Creating a new Healer for Eric's tribe/nation utilizing a self-made, unique
 *         strategy that can be used in our WarringNations game.
 *         Extends People.
 */
public class EricHealerSelfDefense extends People {

    /**
     * From the extension of the People java class, we create a new healer person.
     * @param nation Nation Eric's Healer belongs to.
     * @param tribe Tribe Eric's Healer belongs to.
     * @param lifePoints Number of life points Eric's Healer has.
     */
    public EricHealerSelfDefense(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, healer, lifePoints);
        myDescription = "\tEric Self-Defense Healer";
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
                    case wizard:
                        lifePoints = this.getLifePoints();
                        break;
                    case healer:
                    default:
                        break;
                }
            }
            // lower/same health as enemy
            else {
                switch(otherPerson.getType()) {
                    case warrior:
                    case wizard:
                    case healer:
                        lifePoints = this.getLifePoints();
                        break;
                    default:
                        break;
                }
            }
        }
        // same nation
        else
        {
            // same tribe
            if (this.getTribe().equals(otherPerson.getTribe())) {
                // share health only if have more than friend
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    switch (otherPerson.getType()) {
                        case warrior:
                        case wizard:
                        case healer:
                            lifePoints = this.getLifePoints() - otherPerson.getLifePoints();
                            break;
                        default:
                            break;
                    }
                }
            }
            // different tribe
            else {
                // more health than friendly
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    switch (otherPerson.getType()) {
                        case warrior:
                        case wizard:
                        case healer:
                            lifePoints = this.getLifePoints() - otherPerson.getLifePoints();
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return lifePoints;
    }


}

