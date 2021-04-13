package Project02;

/**
 * Creating a new nation called "Wolves" to be utilized in the
 *      WarringNations game. Extends Nation.
 */
public class KimNation extends Nation
{

    /**
     * Creates a new Nation in our World.
     * @param lifePoints Number of life points this nation has as a total.
     * @param numberOfTribes Number of tribes found in this nation.
     * @param numberOfPeoplePerTribe Number of members per tribe in this nation.
     */
    public KimNation(int lifePoints, int numberOfTribes, int numberOfPeoplePerTribe)
    {
        super("Wolves", lifePoints, numberOfTribes, numberOfPeoplePerTribe);
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
            tribes.add(new KimTribe(nationName, "Tribe" + i, nationLifePoints/numberOfTribes,
                    peoplePerTribe));
        }
    }

}

