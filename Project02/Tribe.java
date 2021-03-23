package Project02;
import java.util.Collection;
import java.util.Collections;
import java.io.StringBufferInputStream;
import java.util.ArrayList;

public abstract class Tribe
{
    protected String nationName;
    protected String tribeName;
    protected int tribeLifePoints;
    protected int numberOfPeoplePerTribe;
    protected ArrayList<People> members = new ArrayList<>();
    protected ArrayList<People> livingMembers = new ArrayList<>();

    public Tribe(String nation, String tribe, int lifePoints, int peoplePerTribe)
    {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;
        numberOfPeoplePerTribe = peoplePerTribe;
    }

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


    public int getTribeSize()
    {
        return livingMembers.size();
    }

    public Boolean isTribeAlive()
    {
        return (tribeLifePoints > 0);
    }


    public int getTribeLifePoints()
    {
        return tribeLifePoints;
    }

    public String getTribeName()
    {
        return tribeName;
    }

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

    public int getNumberOfPeoplePerTribe() {
        return numberOfPeoplePerTribe;
    }

    public abstract void populateTribe();

}
