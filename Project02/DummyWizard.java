package Project02;

import static Project02.PeopleType.*;

public class DummyWizard extends People {

    public DummyWizard(String nation, String tribe, int lifePoints, int attack, int defense)
    {
        super(nation, tribe, wizard, lifePoints, attack, defense);
        myDescription = "\tDummy Wizard";
    }

    public int healingStrategy(Project02.People otherPerson) { return 0; }
    public double getEffectiveness(Project02.People otherPerson) { return 1.0; }
    public boolean shouldRunAway(Project02.People otherPerson) { return false; }

    @Override
    public void interact(People people) {

    }
}

