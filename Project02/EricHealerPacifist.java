package Project02;

import static Project02.PeopleType.*;

public class EricHealerPacifist extends People {

    public EricHealerPacifist(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, healer, lifePoints);
        myDescription = "\tEric Healer";
    }

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        // opposing nation
        if (!this.getNation().equals((otherPerson.getNation())))
        {
            // always runs
            lifePoints -= 1;
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
                        lifePoints = 0;
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
                        lifePoints = 0;
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
                            lifePoints = 0;
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
                            // TODO
                            break;
                        case wizard:
                            // TODO
                            break;
                        case healer:
                            // TODO
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

