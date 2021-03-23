package Project02;

public class ShaneNation extends Nation
{

    public ShaneNation(int lifePoints, int numberOfTribes, int numberOfPeoplePerTribe)
    {
        super("Goblins", lifePoints, numberOfTribes, numberOfPeoplePerTribe);
        populateNation();
        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }

    @Override
    public void populateNation() {
        for(int i = 1; i < numberOfTribes + 1; i++)
        {
            tribes.add(new ShaneTribe(nationName, "Tribe" + i, nationLifePoints/numberOfTribes,
                    peoplePerTribe));
        }
    }

}
