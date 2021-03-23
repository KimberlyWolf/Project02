package Project02;

import static Project02.PeopleType.*;

public class KimWizard1 extends People {

    public KimWizard1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints);
        myDescription = "\tKim Wizard1";
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
                        lifePoints = this.getLifePoints()/4;
                        break;
                    case wizard:
                        lifePoints = this.getLifePoints()/2;
                        break;
                    case healer:
                        lifePoints = this.getLifePoints();
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
                        lifePoints -= 1;
                        break;
                    case wizard:
                        lifePoints = this.getLifePoints()/2;
                        break;
                    case healer:
                        lifePoints = this.getLifePoints();
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
                            lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 4;
                            break;
                        case wizard:
                            lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 2;
                            break;
                        case healer:
                            lifePoints = (this.getLifePoints() - otherPerson.getLifePoints());
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
                            lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 8;
                            break;
                        case wizard:
                            lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 4;
                            break;
                        case healer:
                            lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 2;
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

