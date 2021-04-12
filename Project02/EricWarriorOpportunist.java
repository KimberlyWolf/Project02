package Project02;

import static Project02.PeopleType.*;

public class EricWarriorOpportunist extends People {

    public EricWarriorOpportunist(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints, 10, 10);
        myDescription = "\tEric Opportunist Warrior";
        // more effective against healers
        this.setEffectiveness(warrior, 1.0);
        this.setEffectiveness(wizard, 1.0);
        this.setEffectiveness(healer, 1.25);
    }

    public int healingStrategy(Project02.People otherPerson) {
        int lifePoints = 0;

        // same tribe
        if (this.getTribe().equals(otherPerson.getTribe())) {
            // always share enough with own tribe to bring their health up to yours
            if (this.getLifePoints() > otherPerson.getLifePoints())
                lifePoints = (this.getLifePoints() - otherPerson.getLifePoints())/2;
        }
        // different tribe
        else {
            // more health than friendly
            if (this.getLifePoints() > otherPerson.getLifePoints()) {
                if (this.getLifePoints() > 1.5*otherPerson.getLifePoints())
                    lifePoints = (this.getLifePoints() - otherPerson.getLifePoints())/2;
            }
        }

        return lifePoints;
    }

    @Override
    // only fight warriors if strong advantage and fight wizards at any advantage
    // fights healers even at disadvantage
    public boolean shouldRunAway(People otherPerson) {
        return ((otherPerson.getType() == warrior && otherPerson.getLifePoints() > 1.5 * this.getLifePoints()) ||
                (otherPerson.getType() == wizard && otherPerson.getLifePoints() > this.getLifePoints()));
    }

    @Override
    public void interact(People otherPerson) {

    }


}

