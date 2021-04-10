package Project02;

import static Project02.PeopleType.*;
//this warrior is very afraid of wizards, and will avoid them at all costs. Does not even share health with them.
/**
 * Creating a new Warrior for Shane's tribe/nation utilizing a self-made, unique
 *         strategy that can be used in our WarringNations game.
 *         Extends People.
 */
public class ShaneWizFearingWarrior extends People {

    /**
     * From the extension of the People java class, we create a new warrior person.
     * @param nation Nation Shane's warrior belongs to.
     * @param tribe Tribe Shane's warrior belongs to.
     * @param lifePoints Number of life points Shane's warrior has.
     */
    public ShaneWizFearingWarrior(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints);
        myDescription = "\tShane Wizard-Fearing Warrior";
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
                    case warrior: // fight return a positive number
                        lifePoints = (int)(this.getLifePoints() * .5) + 3;
                        break;
                    case wizard: // runs from a wizard
                        break;
                    case healer: // fight return a positive number
                        lifePoints = (int)(this.getLifePoints() * .4) + 5;
                        break;
                    default:
                        lifePoints = 6;
                        break;
                }
            }
            // lower/same health as enemy
            else {
                switch(otherPerson.getType()) {
                    case warrior: //fight return a positive number
                        lifePoints = (int)(this.getLifePoints() * .5) + 3;
                        break;
                    case wizard: //runs bc fears wizards
                        lifePoints = 0;
                        break;
                    case healer: //fight return a positive number
                        lifePoints = (int)(this.getLifePoints() * .4) + 5;
                        break;
                    default:
                        lifePoints = 5;
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
                        case warrior: //heal
                            lifePoints = (int)(otherPerson.getLifePoints() * .7) + 2;
                            break;
                        case wizard: // dislikes wizards
                            lifePoints = (int)(otherPerson.getLifePoints() * .3);
                            break;
                        case healer: //heal
                            lifePoints = (int)(otherPerson.getLifePoints() * .4) + 1;
                            break;
                        default:
                            lifePoints = 0;
                            break;
                    }
                }
            }
            // different tribe
            else {
                // more health than friendly
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    switch (otherPerson.getType()) {
                        case warrior: //heal
                            lifePoints = (int)(otherPerson.getLifePoints() * .35) + 1;
                            break;
                        //nothing does not like wizards
                        case healer: //nothing
                            lifePoints = (int)(otherPerson.getLifePoints() * .25) + 1;
                            break;
                        default:
                            lifePoints = 0;
                            break;
                    }
                }
            }
        }
        return lifePoints;
    }


}

