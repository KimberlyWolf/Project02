package Project02;

import java.util.ArrayList;
/**
 * Testing the Nation class. Only meant for testing purposes.
 * Extends Nation.
 */
public class DummyNation extends Nation
{

    /**
     * Creates a new Nation in our World.
     * @param baseHealthPerPerson Number of life points this nation has as a total.
     * @param numberOfTribes Number of tribes found in this nation.
     * @param numberOfPeoplePerTribe Number of members per tribe in this nation.
     */
    public DummyNation(int baseHealthPerPerson, int numberOfTribes, int numberOfPeoplePerTribe)
    {
        super("Dummies", baseHealthPerPerson, numberOfTribes, numberOfPeoplePerTribe);
        populateNation();
        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }

    /**
     * Overrides the populateNation() method to add new tribes to this nation.
     */
    @Override
    public void populateNation() {
        for(int i = 1; i < numberOfTribes + 1; i++)
        {
            tribes.add(new DummyTribe(nationName, "Tribe" + i, nationLifePoints/numberOfTribes/peoplePerTribe,
                    peoplePerTribe));
        }
    }

}
