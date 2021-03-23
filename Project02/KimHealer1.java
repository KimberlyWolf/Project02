package Project02;

import static Project02.PeopleType.*;

public class KimHealer1 extends People {

    public KimHealer1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints);
        myDescription = "\tKim Healer1";
        //This healer is going to be a pacifist!! No attacking, just healing :)
    }


    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        // opposing nation
        if (!this.getNation().equals((otherPerson.getNation())))
        {
            lifePoints -= 1; //Always runs away!!
        }


        // same nation
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

