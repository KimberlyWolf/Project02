package Project02;

import java.util.ArrayList;

public class DummyNation extends Nation
{

    public DummyNation(int lifePoints, int numberOfTribes, int numberOfPeoplePerTribe)
    {
        super("Dummies", lifePoints, numberOfTribes, numberOfPeoplePerTribe);
        populateNation();
        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }

    @Override
    public void populateNation() {
        for(int i = 1; i < numberOfTribes + 1; i++)
        {
            tribes.add(new DummyTribe(nationName, "Tribe" + i, nationLifePoints/numberOfTribes,
                    peoplePerTribe));
        }
    }

}
