package Project02;

import static Project02.PeopleType.*;
import java.util.HashMap;

/**
 * An abstract class of a Person. It is meant to serve as the "base class"
 *        for a person in the WarringNations game. This includes the person's name,
 *        its tribes and nation affiliation, the number of total life points they have,
 *        and much more.
 */
public abstract class People
{
    /**
     * Basic attributes for a given person, such as their name, tribe, nation affiliation, stats, class, description,
     * and if they're dead or not.
     */
    private String personName;
    private String myNation;
    private String myTribe;
    private PeopleType me;
    protected String myDescription;
    private int myLifePoints;
    private int attack;
    private int defense;
    private boolean dead;
    protected HashMap<PeopleType, Double> effectiveness;
    protected int interactionsLeft;

    /**
     * Instantiates a new Nation to be put into our game world.
     * @param nation The nation name.
     * @param tribe The tribe the person belongs to.
     * @param person The "class" the person is- Warrior, Wizard, or Healer.
     * @param lifePoints The number of life points the person has.
     * @param baseAttack The base attack stat of the person for hostile encounters.
     * @param baseDefense The base defense stat of the person for hostile encounters.
     */
    public People(String nation, String tribe, PeopleType person, int lifePoints, int baseAttack, int baseDefense)
    {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        dead = false;

        // stats
        myLifePoints = lifePoints;
        attack = baseAttack;
        defense = baseDefense;

        // effectiveness
        effectiveness = new HashMap<PeopleType, Double>();
        effectiveness.put(warrior, 1.0);
        effectiveness.put(wizard, 1.0);
        effectiveness.put(healer, 1.0);
    }
    // World methods for including/excluding a person from next round
    /** Sets dead to 'true' to exclude from survivors at end of each round. */
    public void setDead()
    {
        dead = true;
    }
    /** Returns living/dead status of a person. */
    public boolean getDead()
    {
        return dead;
    }
    /** Returns if this person's life points are greater than zero */
    public Boolean isPersonAlive()
    {
        return (myLifePoints > 0);
    }

    // World methods for general info
    /** Returns this player's "class" (warrior, wizard, healer, special) */
    public PeopleType getType()
    {
        return me;
    }

    /** Returns this player's Nation affiliation */
    public String getNation()
    {
        return myNation;
    }

    /** Returns this player's tribe affiliation */
    public String getTribe()
    {
        return myTribe;
    }

    // Stat changes
    /** Returns this person's life points */
    public int getLifePoints()
    {
        return myLifePoints;
    }
    /** Adds a given integer to this person's life points. Add a negative integer to deal damage */
    public void modifyLifePoints(int points)
    {
        myLifePoints += points;
    }

    /** Returns this person's attack stat */
    public int getAttack()  { return attack; }
    /** Set this person's attack stat to a given integer */
    public void setAttack(int desiredAttack) { attack = desiredAttack; }

    /** Returns this person's defense stat */
    public int getDefense()  { return defense; }
    /** Set this person's defense stat to a given integer */
    public void setDefense(int desiredDefense) { defense = desiredDefense; }

    /** Returns this person's effectiveness against a given person's class */
    public double getEffectiveness(People otherPerson) {
        return this.effectiveness.get(otherPerson.getType());
    }
    /** Updates the effectiveness in the effectiveness HashMap. Removes the old effectiveness if already present */
    public void setEffectiveness(PeopleType personType, double newEffectiveness) {
        effectiveness.remove(personType); // It reformatted this to this but not sure if this is correct now
        effectiveness.put(personType, newEffectiveness);
    }

    /** Determines and returns how much health, if any, this person should share with another person */
    public abstract int healingStrategy(People otherPerson);
    /** Returns whether this person should run away from a hostile encounter against a given person */
    public abstract boolean shouldRunAway(People otherPerson);

    // For special characters only
    /** Returns how many remaining interactions a special character has before being removed */
    public int getInteractionsLeft() { return interactionsLeft; }
    /** Reduces how many remaining interactions a special character has by one */
    public void reduceInteractionsLeft() { this.interactionsLeft--; }
    /** Performs behavior for special encounters by NPCs or random world events */
    public abstract void interact(People people);

    // For printing
    /** Returns description of this person */
    public String getDescription() { return myDescription; }
    /** @return The string of the person's nation, tribe, description, and current life points. */
    public String toString()
    {
        return new String( myNation + "\t" +  myTribe + "\t" + myDescription + "\t" + myLifePoints);
    }


}

