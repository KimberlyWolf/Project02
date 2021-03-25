package Project02;

import java.util.Random;

import static Project02.PeopleType.*;

public class EricWizardCritsOrRuns extends People {

    public EricWizardCritsOrRuns(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, wizard, lifePoints);
        myDescription = "\tEric Polarizing Wizard";
    }

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        // opposing nation
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        int diceRoll = random.nextInt();
        boolean equalChance = diceRoll%2==0;
        // different nation
        if (!this.getNation().equals((otherPerson.getNation()))) {
            if (equalChance)
                lifePoints = this.getLifePoints();
            // same nation
        } else {
            // shares random health
            if (equalChance)
                lifePoints = (int) random.nextDouble() * this.getLifePoints();
        }
        return lifePoints;
    }


}

