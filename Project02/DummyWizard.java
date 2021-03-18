package Project02;

import static Project02.PeopleType.*;

public class DummyWizard extends People {

    public DummyWizard(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, wizard, lifePoints);
        myDescription = "\tDummy Wizard";
    }

    public int encounterStrategy(Project02.People otherPerson) { return 0; }


}

