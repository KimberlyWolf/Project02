package Project02;

import static Project02.PeopleType.*;

public class EricHealerPacifist extends People {

    public EricHealerPacifist(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, healer, lifePoints);
        myDescription = "\tEric Pacifist Healer";
    }

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        // opposing nation
        if (!this.getNation().equals((otherPerson.getNation())))
        {
            // always runs
            return lifePoints;
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
                            lifePoints = (this.getLifePoints() - otherPerson.getLifePoints())/2;
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

