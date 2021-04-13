package Project02;

import static Project02.PeopleType.*;

/**
 * Creating a new Healer for Shane's tribe/nation utilizing a self-made, unique
 *         strategy that can be used in our WarringNations game.
 *         Extends People.
 * This healer runs from fights where people have more health than him unless its another healer.
 */
public class ShaneCowardHealer extends People {

    /**
     * From the extension of the People java class, we create a new healer person.
     * @param nation Nation Shane's healer belongs to.
     * @param tribe Tribe Shane's healer belongs to.
     * @param lifePoints Number of life points Shane's healer has.
     */
    public ShaneCowardHealer(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, healer, lifePoints, 10, 10);
        myDescription = "\tShane Coward Healer";
    }

    public int healingStrategy(Project02.People otherPerson) {
        int lifePoints = 0;

        // same tribe
        if (this.getTribe().equals(otherPerson.getTribe())) {
            // share health only if have more than friend
            if (this.getLifePoints() > otherPerson.getLifePoints()) {
                switch (otherPerson.getType()) {
                    case warrior:
                    case wizard:
                    case healer:
                        lifePoints = this.getLifePoints() - otherPerson.getLifePoints();
                        break;
                    default:
                        break;
                }
            }
        }
        // different tribe
        else {
            // more health than friendly
            if (this.getLifePoints() > otherPerson.getLifePoints()) {
                switch (otherPerson.getType()) {
                    case warrior:
                    case wizard:
                    case healer:
                        lifePoints = this.getLifePoints() - otherPerson.getLifePoints();
                        break;
                    default:
                        break;
                }
            }
        }

        return lifePoints;
    }


    @Override
    public boolean shouldRunAway(People otherPerson) {

        return otherPerson.getLifePoints() > this.getLifePoints() && otherPerson.getType()!= healer;
    }

    // do nothing
    @Override
    public void interact(People people) {

    }


}

