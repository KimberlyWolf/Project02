package Project02;

import java.util.Random;

import static Project02.PeopleType.*;

public class EricWizardChaote extends People {

    public EricWizardChaote(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, wizard, lifePoints);
        myDescription = "\tEric Unpredictable Wizard";
    }

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        // everything it does is "random" (based on chance)
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        lifePoints = (int) random.nextDouble();
        return lifePoints;
    }


}
