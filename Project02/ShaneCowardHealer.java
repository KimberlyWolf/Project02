package Project02;

import static Project02.PeopleType.*;
// this healer is a coward and an idiot. He will run away from all fights except when fighting a healer.
// He heals other tribe members more over his own tribe.
/**
 * Creating a new Healer for Shane's tribe/nation utilizing a self-made, unique
 *         strategy that can be used in our WarringNations game.
 *         Extends People.
 */
public class ShaneCowardHealer extends People {

    /**
     * From the extension of the People java class, we create a new healer person.
     * @param nation Nation Shane's healer belongs to.
     * @param tribe Tribe Shane's healer belongs to.
     * @param lifePoints Number of life points Shane's healer has.
     */
    public ShaneCowardHealer(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, healer, lifePoints);
        myDescription = "\tShane Coward Healer";
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
        if (this.getLifePoints() > otherPerson.getLifePoints()) {
            if (otherPerson.getType() == healer) { //fight
                lifePoints = (int) (this.getLifePoints() * .25) + 3;
            }
        }
        // same nation
        else
        {
            // same tribe
            if (this.getTribe().equals(otherPerson.getTribe())) {
                // share health only if have more than friend
                if (this.getLifePoints() < otherPerson.getLifePoints()) { //heals if the other person has more health
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
                // this will always share enough health to make them equal
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    switch (otherPerson.getType()) {
                        case warrior:
                            lifePoints = this.getLifePoints() - otherPerson.getLifePoints() + 1;
                            break;
                        case wizard:
                            lifePoints = this.getLifePoints() - otherPerson.getLifePoints() + 2;
                            break;
                        case healer:
                            lifePoints = this.getLifePoints() - otherPerson.getLifePoints() + 3;
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

