package Project02;

import static Project02.PeopleType.*;

public class KimWizard2 extends People {

    public KimWizard2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints);
        myDescription = "\tKim Wizard2";
        //Friendlier to own Wizards, but will be more aggressive to opposing Wizards
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
                        lifePoints -= 1;
                        break;
                    case wizard:
                        lifePoints = this.getLifePoints();
                        break;
                    case healer:
                        lifePoints = this.getLifePoints() / 3;
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
                        lifePoints = this.getLifePoints() / 2;
                        break;
                    case healer:
                        lifePoints = this.getLifePoints() / 5;
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
                            lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 5;
                            break;
                        case wizard:
                            lifePoints = (this.getLifePoints() - otherPerson.getLifePoints());
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
            // different tribe
            else {
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    lifePoints = 0; //Will not heal anyone that is not from same tribe!
                }
            }
        }
        return lifePoints;
    }
}

