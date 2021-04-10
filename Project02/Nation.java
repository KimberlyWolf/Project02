package Project02;

import java.util.ArrayList;

/**
 * An abstract class of a Nation. It is meant to serve as the "base class"
 *        for a nation in the WarringNations game. This includes the number
 *        of members in the nation, its tribes, the number of total life points,
 *        and much more.
 */
public abstract class Nation
{
    /**
     * Basic attributes for a given nation, such as the name of the nation, the
     *    number of members, tribes, and life points the nation has.
     */
    protected int nationLifePoints;
    protected int numberOfTribes;
    protected int peoplePerTribe;
    protected String nationName;

    /**
     * An ArrayList of Tribes used to keep tract of the number of tribes a nation has.
     */
    protected ArrayList<Tribe> tribes = new ArrayList<>();

    /**
     * An ArrayList of People used to keep tract of the total number of people a nation has.
     */
    protected ArrayList<People> population = new ArrayList<>();

    /**
     * An ArrayList of people used to keep tract of the number of living people a nation has.
     */
    protected ArrayList<People> livingPopulation = new ArrayList<>();


    /**
     * Instantiates a new Nation to be put into our game world.
     * @param name The name of the Nation.
     * @param lifePoints The number of life points the nation has.
     * @param tribeCount The number of tribes in the nation.
     * @param numberOfPeoplePerTribe The number of members in the tribe.
     */
    public Nation(String name, int lifePoints, int tribeCount, int numberOfPeoplePerTribe)
    {
        nationName = name;
        nationLifePoints = lifePoints;
        numberOfTribes = tribeCount;
        peoplePerTribe = numberOfPeoplePerTribe;
    }

    /**
     * An abstract method used to add tribes to the nation.
     */
    public abstract void populateNation();

    /**
     * Used to check the number of members who are alive in the population.
     *        We must traverse over each tribe and check if there are any
     *        living members left in the tribe. Then add those living members
     *        to an ArrayList of people.
     * @return An ArrayList of living members left in the population.
     */
    public ArrayList<People> getNationPopulation()
    {
        nationLifePoints = 0;
        livingPopulation.clear();
        for(int tribe = 0; tribe < tribes.size(); tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                livingPopulation.addAll(tribes.get(tribe).getLivingTribeMembers());
                nationLifePoints += tribes.get(tribe).getTribeLifePoints();
            }
        }
        return livingPopulation;
    }

    /**
     * @return The nation name and the tribes associated with the nation.
     */
    public String toString()
    {
        String result = "\0";
        result = nationName;
        for(int i = 0; i < tribes.size(); i++)
        {
            result = result + '\n' + tribes.get(i).toString();

        }
        result = result + '\n';
        return result;
    }


}
