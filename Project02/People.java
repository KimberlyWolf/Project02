package Project02;

import Project02.PeopleType;

import java.util.HashMap;

public abstract class People
{
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

    public People(String nation, String tribe, PeopleType person, int lifePoints, int baseAttack, int baseDefense)
    {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        myLifePoints = lifePoints;
        dead = false;
        attack = baseAttack;
        defense = baseDefense;
        effectiveness = new HashMap<PeopleType, Double>();
    }

    public void setDead()
    {
        dead = true;
    }

    public boolean getDead()
    {
        return dead;
    }

    public PeopleType getType()
    {
        return me;
    }

    public String getTribe()
    {
        return myTribe;
    }

    public String getNation()
    {
        return myNation;
    }

    public Boolean isPersonAlive()
    {
        return (myLifePoints > 0);
    }

    public String getDescription() { return myDescription; }

    public int getLifePoints()
    {
        return myLifePoints;
    }

    public void modifyLifePoints(int points)
    {
        myLifePoints += points;
    }

    public int getAttack()  { return attack; }
    public void setAttack(int desiredAttack) { attack = desiredAttack; }

    public int getDefense()  { return defense; }
    public void setDefense(int desiredDefense) { defense = desiredDefense; }

    public double getEffectiveness(People otherPerson) {
        return this.effectiveness.get(otherPerson.getType());
    }

    public void setEffectiveness(PeopleType personType, double newEffectiveness) {
        if (effectiveness.containsKey(personType)) {
            effectiveness.remove(personType);
            effectiveness.put(personType, newEffectiveness);
        }
    }

    public abstract int healingStrategy(People otherPerson);

    public abstract boolean shouldRunAway(People otherPerson);

    public String toString()
    {
        String result = new String( myNation + "\t" +  myTribe + "\t" + myDescription + "\t" + myLifePoints);
        return result;
    }

}

