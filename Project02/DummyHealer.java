package Project02;

import static Project02.PeopleType.*;

public class DummyHealer extends People {

    public DummyHealer(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, healer, lifePoints);
        myDescription = "\tDummy Healer";
    }

    public int encounterStrategy(Project02.People otherPerson) { return 0; }


}

