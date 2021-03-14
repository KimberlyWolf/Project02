package Project02;
import java.util.Collection;
import java.util.Collections;
import java.io.StringBufferInputStream;
import java.util.ArrayList;

public class Tribe
{
    private String nationName;
    private String tribeName;
    private int tribeLifePoints;
    private ArrayList<People> members = new ArrayList<>();
    private ArrayList<People> livingMembers = new ArrayList<>();

    public Tribe(String nation, String tribe, int lifePoints, int numberOfPeoplePerTribe)
    {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;
        for (int i = 0; i < numberOfPeoplePerTribe; i++)
            // This WILL become i%6 == ... once we have the other 3 strategies implemented, but no sooner.
            if (i%3 == 0)
                members.add(new SchaperWarrior(nationName, tribeName,
                        tribeLifePoints/numberOfPeoplePerTribe));
            else if (i%3 == 1)
                members.add(new SchaperWizard(nationName, tribeName,
                        tribeLifePoints /numberOfPeoplePerTribe));
            else
                members.add(new SelfDefenseHealer(nationName, tribeName,
                        tribeLifePoints /numberOfPeoplePerTribe));

        for (int i = 0; i < members.size(); i++)
            livingMembers.addAll(members);
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
    /*
    public void printMembers()
    {
        for(int i = 0; i < 2; i++)
        {
            System.out.println(people.get(i));
        }
    }
*/


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

}
