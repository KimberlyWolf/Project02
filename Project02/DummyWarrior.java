package Project02;

import static Project02.PeopleType.*;

public class DummyWarrior extends People {

    public DummyWarrior(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints);
        myDescription = "\tDummy Warrior";
    }

    public int encounterStrategy(Project02.People otherPerson) { return 0; }


}

