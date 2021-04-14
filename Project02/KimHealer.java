package Project02;

import static Project02.PeopleType.*;

/**
 * Creating a new Healer for Kim's tribe/nation utilizing a self-made, unique
 *         strategy that can be used in our WarringNations game.
 *         Extends People.
 */
public class KimHealer extends People {

    /**
     * From the extension of the People java class, we create a new healer person.
     *      Implements what their default/base attack and defense, as well as their
     *      effectiveness in terms of damaging an opposing player based on other player's
     *      class.
     * @param nation Nation Kim's Healer belongs to.
     * @param tribe Tribe Kim's Healer belongs to.
     * @param lifePoints Number of life points Kim's Healer has.
     */
    public KimHealer(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, healer, lifePoints, 10, 10);
        myDescription = "\tKim Healer";
    }

    /**
     * An individually created strategy that determines how much points this player is
     *      willing to give to heal during a friendly encounter. The number of life points
     *      can vary if the players are from the same tribe or not.
     * @param otherPerson Opposing player from same Nation
     * @return The number of life points this player should give to heal a friendly player
     */
    public int healingStrategy(Project02.People otherPerson) {
        int lifePoints = 0;

        // same tribe
        if (this.getTribe().equals(otherPerson.getTribe())) {
            // share health only if have more than friend
            if (this.getLifePoints() > otherPerson.getLifePoints()) {
                switch (otherPerson.getType()) {
                    case warrior:
                        lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 4;
                        break;
                    case wizard:
                        lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 2;
                        break;
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
                        lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 4;
                        break;
                    case wizard:
                        lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 2;
                        break;
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
    /**
     * Checks whether this player should run away in an encounter or not based on the player's
     *      created strategy.
     * @param otherPerson Opposing Player
     * @return True if the player should run away
     */
    @Override
    public boolean shouldRunAway(People otherPerson) {
        return ((otherPerson.getType() == warrior && otherPerson.getLifePoints() > this.getLifePoints()) ||
                (otherPerson.getType() == wizard && otherPerson.getLifePoints() > this.getLifePoints())
                || (otherPerson.getType() == healer && otherPerson.getLifePoints() > 1.25 * this.getLifePoints()));
    }

    /**
     * This is only used for special characters. Nothing should be added here.
     * @param people Player in world
     */
    // do nothing
    @Override
    public void interact(People people) {

    }


}

