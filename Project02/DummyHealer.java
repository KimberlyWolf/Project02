package Project02;

import static Project02.PeopleType.*;

public class DummyHealer extends People {

    public DummyHealer(String nation, String tribe, int lifePoints, int attack, int defense)
    {
        super(nation, tribe, healer, lifePoints, attack, defense);
        myDescription = "\tDummy Healer";
    }

    public int healingStrategy(Project02.People otherPerson) { return 0; }
    public double getEffectiveness(Project02.People otherPerson) { return 1.0; }
    public boolean shouldRunAway(Project02.People otherPerson) { return false; }

}

