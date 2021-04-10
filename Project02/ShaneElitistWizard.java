package Project02;

import static Project02.PeopleType.*;
//this wizard dislikes warriors and takes pride in being a wizard. Will try to avoid losing to other wizards
//and only heals wizards from their nation
/**
 * Creating a new Wizard for Shane's tribe/nation utilizing a self-made, unique
 *         strategy that can be used in our WarringNations game.
 *         Extends People.
 */
public class ShaneElitistWizard extends People {

    /**
     * From the extension of the People java class, we create a new wizard person.
     * @param nation Nation Shane's wizard belongs to.
     * @param tribe Tribe Shane's wizard belongs to.
     * @param lifePoints Number of life points Shane's wizard has.
     */
    public ShaneElitistWizard(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, wizard, lifePoints);
        myDescription = "\tShane Elitist Wizard";
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
                    case warrior: //fight
                        lifePoints = (int)(this.getLifePoints() * .5) + 1;
                        break;
                    case wizard: //fight
                        lifePoints = (int)(this.getLifePoints() * .5) + 2;
                        break;
                    case healer: //fight
                        lifePoints = (int)(this.getLifePoints() * .5) + 6;
                        break;
                    default:
                        lifePoints = 4;
                        break;
                }
            }
            // lower/same health as enemy
            else {
                switch(otherPerson.getType()) { //does more damage at lower health
                    case warrior: // fight
                        lifePoints = (int)(this.getLifePoints() * .6) + 6;
                        break;
                    case wizard: //runs to avoid losing to another wizard
                        lifePoints = 0;
                        break;
                    case healer: // fight
                        lifePoints = (int)(this.getLifePoints() * .6) + 5;
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
                        //only shares health with wizards from their nation
                        case wizard: // heal
                            lifePoints = (int)(otherPerson.getLifePoints() * .7) + 8;
                            break;
                        default:
                            lifePoints = 0;
                            break;
                    }
                }
            }
            // different tribe
            else {
                if (this.getLifePoints() > otherPerson.getLifePoints()) { //if health is greater than the other
                    //only heals wizards
                    if (otherPerson.getType() == wizard) { //nothing
                        lifePoints = (int) (otherPerson.getLifePoints() * .5) + 6;
                    }
                }
            }
        }
        return lifePoints;
    }


}

