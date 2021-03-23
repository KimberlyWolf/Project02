package Project02;

import java.util.ArrayList;

public class KimNation extends Nation
{

    public KimNation(int lifePoints, int numberOfTribes, int numberOfPeoplePerTribe)
    {
        super("Wolves", lifePoints, numberOfTribes, numberOfPeoplePerTribe);
        populateNation();
        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }

    @Override
    public void populateNation() {
        for(int i = 1; i < numberOfTribes + 1; i++)
        {
            tribes.add(new KimTribe(nationName, "Tribe" + i, nationLifePoints/numberOfTribes,
                    peoplePerTribe));
        }
    }

}
