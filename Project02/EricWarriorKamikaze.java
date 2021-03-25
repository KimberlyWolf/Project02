package Project02;

import static Project02.PeopleType.*;

public class EricWarriorKamikaze extends People {

    public EricWarriorKamikaze(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints);
        myDescription = "\tEric Kamikaze Warrior";
    }

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        // opposing nation
        if (!this.getNation().equals((otherPerson.getNation())))
        {
            // always do as much as possible to enemy regardless of
            // conditions
            lifePoints = this.getLifePoints();
        }
        // preserve own health by not healing friendlies so can deal
        // maximum damage to enemies
        return lifePoints;
    }


}

