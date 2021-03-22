package Project02;

import static Project02.PeopleType.*;

public class EricHealerSelfDefense extends People {

    public EricHealerSelfDefense(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, healer, lifePoints);
        myDescription = "\tEric Healer";
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
                    case warrior:
                        // TODO
                        break;
                    case wizard:
                        // TODO
                        break;
                    case healer:
                        // TODO
                        break;
                    default:
                        break;
                }
            }
            // lower/same health as enemy
            else {
                switch(otherPerson.getType()) {
                    case warrior:
                        // TODO
                        break;
                    case wizard:
                        // TODO
                        break;
                    case healer:
                        // TODO
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
                            // TODO
                            break;
                        case wizard:
                            // TODO
                            break;
                        case healer:
                            // TODO
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
                            // TODO
                            break;
                        case wizard:
                            // TODO
                            break;
                        case healer:
                            // TODO
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

