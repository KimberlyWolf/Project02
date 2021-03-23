package Project02;

import static Project02.PeopleType.*;

public class KimWarrior2 extends People {

    public KimWarrior2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints);
        myDescription = "\tKim Warrior2";
        //Wants to go out "in a blaze of glory" --> Fight hard, give health when others need it
    }


    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        // opposing nation
        if (!this.getNation().equals((otherPerson.getNation())))
        {
            // greater health than enemy
            if (this.getLifePoints() > otherPerson.getLifePoints())
            {
                lifePoints = this.getLifePoints();
            }
            // lower/same health as enemy
            else {
                lifePoints = this.getLifePoints() / 2;
            }
        }
        // same nation
        else
        {
            // same tribe
            if (this.getTribe().equals(otherPerson.getTribe())) {
                // share health only if have more than friend
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 2;
                }
            }
            // different tribe
            else {
                // more health than friendly
                // this will always share enough health to make them equal
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 4;
                }
            }
        }
        return lifePoints;
    }

}

