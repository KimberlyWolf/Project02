package Project02;

import static Project02.PeopleType.*;

public class KimHealer2 extends People {

    public KimHealer2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints);
        myDescription = "\tKim Healer2";
        //Similar to Healer1, but will only attack if they have more health than enemy!
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
                        lifePoints = this.getLifePoints() / 8;
                        break;
                    case wizard:
                        lifePoints = this.getLifePoints() / 6;
                        break;
                    case healer:
                        lifePoints = this.getLifePoints() / 4;
                        break;
                    default:
                        lifePoints = 0;
                        break;
                }
            }
            // lower/same health as enemy
            else {
                lifePoints -= 1;
            }
        }
        else
        {
            // same tribe
            if (this.getTribe().equals(otherPerson.getTribe())) {
                // share health only if have more than friend
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    lifePoints = this.getLifePoints() - otherPerson.getLifePoints();
                }
            }
            // different tribe
            else {
                // more health than friendly
                // this will always share enough health to make them equal
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 2;
                }
            }
        }
        return lifePoints;
    }
}