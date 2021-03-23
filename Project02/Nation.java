package Project02;

import java.util.ArrayList;

/*
What has changed: No nationCount (and any code pertaining to it), Update Tribe size
No isNationAlive();
 */
public abstract class Nation
{
    protected int nationLifePoints;
    protected int numberOfTribes;
    protected int peoplePerTribe;
    protected String nationName;
    protected ArrayList<Tribe> tribes = new ArrayList<>();
    protected ArrayList<People> population = new ArrayList<>();
    protected ArrayList<People> livingPopulation = new ArrayList<>();


    public Nation(String name, int lifePoints, int tribeCount, int numberOfPeoplePerTribe)
    {
        nationName = name;
        nationLifePoints = lifePoints;
        numberOfTribes = tribeCount;
        peoplePerTribe = numberOfPeoplePerTribe;
    }

    public abstract void populateNation();

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
