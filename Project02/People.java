package Project02;

import Project02.PeopleType;

/**
 * An abstract class of a Person. It is meant to serve as the "base class"
 *        for a person in the WarringNations game. This includes the person's name,
 *        its tribes and nation affiliation, the number of total life points they have,
 *        and much more.
 */
public abstract class People
{
    /**
     * Basic attributes for a given person, such as their name, its tribes and nation
     *          affiliation, the number of total life points they have, their "class,"
     *          description, and whether they are dead or not.
     */
    private String personName;
    private String myNation;
    private String myTribe;
    private PeopleType me;
    protected String myDescription;
    private int myLifePoints;
    private boolean dead;


    /**
     * Instantiates a new Nation to be put into our game world.
     * @param nation The nation name.
     * @param tribe The tribe the person belongs to.
     * @param person The "class" the person is- Warrior, Wizard, or Healer.
     * @param lifePoints The number of life points the person has.
     */
    public People(String nation, String tribe, PeopleType person, int lifePoints)
    {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        myLifePoints = lifePoints;
        dead = false;
    }

    /**
     * Sets dead to True if a player has lost all of their life points.
     */
    public void setDead()
    {
        dead = true;
    }

    /**
     * Returns whether a player is dead or not.
     * @return True if the player is dead.
     */
    public boolean getDead()
    {
        return dead;
    }

    /**
     * Returns whether this person is a Warrior, Wizard, or Healer.
     * @return The "class" of a given person
     */
    public PeopleType getType()
    {
        return me;
    }

    /**
     * Gets the tribe the person is affiliated with.
     * @return The tribe the person belongs to.
     */
    public String getTribe()
    {
        return myTribe;
    }

    /**
     * Gets the nation the person is affiliated with.
     * @return The nation the person belongs to.
     */
    public String getNation()
    {
        return myNation;
    }

    /**
     * Checks to see if a person is dead or alive.
     * @return True if the number of life points is greater than 0.
     */
    public Boolean isPersonAlive()
    {
        return (myLifePoints > 0);
    }

    /**
     * Gets the description of a person.
     * @return The description of a person
     */
    public String getDescription() { return myDescription; }

    /**
     * Gets the number of life points a person currently has.
     * @return Number of current life points
     */
    public int getLifePoints()
    {
        return myLifePoints;
    }

    /**
     * Modifies one's current life points to account for what was lost or
     *        gained during an encounter.
     * @param points Points gained or lost during an encounter.
     */
    public void modifyLifePoints(int points)
    {
        myLifePoints += points;
    }

    /**
     * An abstract method used to determine how the player should react in an encounter.
     * @param otherPerson Person in random encounter.
     * @return Life points to be dealt or received.
     */
    public abstract int encounterStrategy(People otherPerson);

    /**
     * @return The string of the person's nation, tribe, description, and current life points.
     */
    public String toString()
    {
        String result = new String( myNation + "\t" +  myTribe + "\t" + myDescription + "\t" + myLifePoints);
        return result;
    }

}

