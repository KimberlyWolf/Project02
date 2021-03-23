package Project02;

import java.util.ArrayList;

public class EricNation extends Nation
{

    public EricNation(int lifePoints, int numberOfTribes, int numberOfPeoplePerTribe)
    {
        super("Bogfrogs", lifePoints, numberOfTribes, numberOfPeoplePerTribe);
        populateNation();
        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }

    @Override
    public void populateNation() {
        for(int i = 1; i < numberOfTribes + 1; i++)
        {
            tribes.add(new EricTribe(nationName, "Tribe" + i, nationLifePoints/numberOfTribes,
                    peoplePerTribe));
        }
    }

}
