package Project02;
import java.util.Collection;
import java.util.Collections;
import java.io.StringBufferInputStream;
import java.util.ArrayList;

/**
 * An abstract class of a Tribe. It is meant to serve as the "base class"
 *        for a tribe in the WarringNations game. This includes the number
 *        of members in the tribe and their life points, the tribe and nation name,
 *        a list of people who are alive, and more.
 */
public abstract class Tribe
{
    /**
     * Basic attributes for a given tribe, such as the name of the nation and tribe,
     * the number of members, life points the tribe has, a list of members in the tribe,
     * and a list of people who are living from the tribe.
     */
    protected String nationName;
    protected String tribeName;
    protected int tribeLifePoints;
    protected int numberOfPeoplePerTribe;
    protected ArrayList<People> members = new ArrayList<>();
    protected ArrayList<People> livingMembers = new ArrayList<>();

    /**
     * Instantiates a new Tribe for our WarringNations game
     * @param nation Nation name
     * @param tribe Tribe name
     * @param lifePoints Number of life points for the tribe
     * @param peoplePerTribe Number of people in the tribe
     */
    public Tribe(String nation, String tribe, int lifePoints, int peoplePerTribe)
    {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;
        numberOfPeoplePerTribe = peoplePerTribe;
    }

    /**
     * Iterates over a list of members and checks to see if a person
     * at a specific index is alive or dead.
     * @return A list of living members in the tribe
     */
    public ArrayList<People> getLivingTribeMembers()
    {
        livingMembers.clear();
        tribeLifePoints = 0;
        for(int person = 0; person < members.size(); person++)
        {
            if(members.get(person).isPersonAlive())
            {
                livingMembers.add(members.get(person));
                tribeLifePoints += members.get(person).getLifePoints();
                //System.out.println(members.get(person));
            }
            else
            {
                if(!(members.get(person).getDead()))
                {
                    members.get(person).setDead();
                    System.out.println("\t\t" + members.get(person) + " is dead!");
                }
            }
        }
        //System.out.println(livingMembers);
        return livingMembers;
    }


    /**
     * @return The number of people who are alive in the tribe.
     */
    public int getTribeSize()
    {
        return livingMembers.size();
    }

    /**
     * Checks to see if there are any living members in the Tribe
     *      based off of the number of life points remaining in the tribe.
     * @return True if the number of life points is greater than 0
     */
    public Boolean isTribeAlive()
    {
        return (tribeLifePoints > 0);
    }


    /**
     * @return The number of life points the tribe has
     */
    public int getTribeLifePoints()
    {
        return tribeLifePoints;
    }

    /**
     * @return The name of the tribe
     */
    public String getTribeName()
    {
        return tribeName;
    }

    /**
     * @return A String value of the living members remaining in a tribe
     */
    public String toString()
    {
        String result = "\0";

        result = tribeName;
        for(int i = 0; i < members.size(); i++)
        {
            result = result + '\n' + members.get(i).toString();
        }
        result = result + '\n';
        return result;
    }

    /**
     * @return The number of people per tribe
     */
    public int getNumberOfPeoplePerTribe() {
        return numberOfPeoplePerTribe;
    }

    /**
     * An abstract method used to add members to the tribe.
     */
    public abstract void populateTribe();

}
