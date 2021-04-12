package Project02;

import static Project02.PeopleType.*;

public class DummyWarrior extends People {

    public DummyWarrior(String nation, String tribe, int lifePoints, int attack, int defense)
    {
        super(nation, tribe, warrior, lifePoints, attack, defense);
        myDescription = "\tDummy Warrior";
    }

    public int healingStrategy(Project02.People otherPerson) { return 0; }
    @Override
    public double getEffectiveness(Project02.People otherPerson) { return 1.0; }
    @Override
    public boolean shouldRunAway(Project02.People otherPerson) { return false; }

    @Override
    public void interact(People people) {

    }
}

