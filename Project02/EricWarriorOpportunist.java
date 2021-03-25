package Project02;

import static Project02.PeopleType.*;

public class EricWarriorOpportunist extends People {

    public EricWarriorOpportunist(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints);
        myDescription = "\tEric Opportunist Warrior";
    }

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        // opposing nation
        if (!this.getNation().equals((otherPerson.getNation())))
        {
            // greater health than enemy
            if (this.getLifePoints() > otherPerson.getLifePoints())
            {
                switch(otherPerson.getType()) {
                    // do as much damage as possible to heavy damage dealing
                    // and healers that can potentially heal heavy damage dealing
                    // classes
                    case warrior:
                    case healer:
                        lifePoints = this.getLifePoints();
                        break;
                    // do bare minimum needed to kill non-threatening classes
                    case wizard:
                        lifePoints = otherPerson.getLifePoints();
                        break;
                    default:
                        break;
                }
            }
            // lower/same health as enemy
            else {
                switch(otherPerson.getType()) {
                    // run from warriors if they have a significant advantage
                    // otherwise hit as hard as can
                    case warrior:
                        if (otherPerson.getLifePoints() > 1.5*this.getLifePoints())
                            break;
                        else
                            lifePoints = this.getLifePoints();
                        break;
                    // hit healer and wizard hard as can even at disadvantage
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
                // always share enough with own tribe to bring their health up to yours
                if (this.getLifePoints() > otherPerson.getLifePoints())
                    lifePoints = (this.getLifePoints() - otherPerson.getLifePoints())/2;
            }
            // different tribe
            else {
                // more health than friendly
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    if (this.getLifePoints() > 1.5*otherPerson.getLifePoints())
                        lifePoints = (this.getLifePoints() - otherPerson.getLifePoints())/2;
                }
            }
        }
        return lifePoints;
    }


}

