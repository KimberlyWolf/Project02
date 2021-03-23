package Project02;

import static Project02.PeopleType.*;

public class KimWarrior1 extends People {

    public KimWarrior1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints);
        myDescription = "\tKim Warrior1";
        //Greedy Warrior -Does not like to share health at ALL
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
                        lifePoints = this.getLifePoints() / 4;
                        break;
                    case wizard:
                        lifePoints = this.getLifePoints() / 2;
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
                        lifePoints = this.getLifePoints() / 2;
                        break;
                    case wizard:
                        lifePoints = this.getLifePoints();
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
        if (this.getLifePoints() > otherPerson.getLifePoints()) {
            lifePoints = 0; //They will NEVER share their health with anyone!
        }
        }
        return lifePoints;
    }
}

