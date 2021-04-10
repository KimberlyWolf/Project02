package Project02;

import static Project02.PeopleType.healer;
//this healer will fight as well as heal. He is not very powerful when dealing damage.
/**
 * Creating a new Healer for Shane's tribe/nation utilizing a self-made, unique
 *         strategy that can be used in our WarringNations game.
 *         Extends People.
 */
public class ShaneFightingHealer extends People {

    /**
     * From the extension of the People java class, we create a new healer person.
     * @param nation Nation Shane's healer belongs to.
     * @param tribe Tribe Shane's healer belongs to.
     * @param lifePoints Number of life points Shane's healer has.
     */
    public ShaneFightingHealer(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, healer, lifePoints);
        myDescription = "\tShane Healer";
    }

    /**
     * Individual strategies to influence how the game is played. This strategy determines
     *       how this player interacts from people from other nations, their own nation,
     *       and their own tribe.
     * @param otherPerson The opponent player 1 is going against
     * @return Life points to determine if this player runs away, how much to damage to
     *       deal, or how much to heal.
     */
    public int encounterStrategy(People otherPerson) {
        int lifePoints = 0;
        // opposing nation
        if (!this.getNation().equals((otherPerson.getNation())))
        {
            {
                // greater health than enemy
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    switch (otherPerson.getType()) {
                        case warrior: //fight
                        case wizard:
                            lifePoints = (int) (this.getLifePoints() * .25) + 1;
                            break;
                        case healer: //fight
                            lifePoints = (int) (this.getLifePoints() * .25) + 3;
                            break;
                        default:
                            lifePoints = 0;
                            break;
                    }
                }
                // lower/same health as enemy
                else {
                    switch (otherPerson.getType()) { //does more damage at lower health
                        case warrior: // fight
                        case wizard:
                        case healer:
                            lifePoints = (int) (this.getLifePoints() * .25) + 2;
                            break;
                        default:
                            lifePoints = 3;
                            break;
                    }
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
                        case warrior: //heal
                            lifePoints = (int)(otherPerson.getLifePoints() * .7) + 13;
                            break;
                        case wizard: //heal
                            lifePoints = (int)(otherPerson.getLifePoints() * .6) + 12;
                            break;
                        case healer: //heal a lot
                             lifePoints = (int)(otherPerson.getLifePoints() * .8) + 11;
                            break;
                        default:
                            lifePoints = 10;
                            break;
                    }

                }
                else{
                    lifePoints += 5;
                }
            }
            // different tribe
            else {
                // more health than friendly
                    switch (otherPerson.getType()) {
                        case warrior: //heal
                            lifePoints = (int)(otherPerson.getLifePoints() * .5) + 15;
                            break;
                        case wizard: //heal
                            lifePoints = (int)(otherPerson.getLifePoints() * .5) + 13;
                            break;
                        case healer: //heal
                            lifePoints = (int)(otherPerson.getLifePoints() * .5) + 10;
                            break;
                        default:
                            lifePoints = 8;
                            break;
                    }
            }
        }
        return lifePoints;
    }


}

