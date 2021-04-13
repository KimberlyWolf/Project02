package Project02;

import static Project02.PeopleType.*;

/**
 * Creating a new Healer for Eric's tribe/nation utilizing a self-made, unique
 *         strategy that can be used in our WarringNations game.
 *         Extends People.
 */
public class EricHealerSelfDefense extends People {

    /**
     * From the extension of the People java class, we create a new healer person.
     *      Implements what their default/base attack and defense, as well as their
     *      effectiveness in terms of damaging an opposing player based on other player's
     *      class.
     * @param nation Nation Eric's healer belongs to.
     * @param tribe Tribe Eric's healer belongs to.
     * @param lifePoints Number of life points Eric's healer has.
     */
    public EricHealerSelfDefense(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, healer, lifePoints, 10, 10);
        myDescription = "\tEric Self-Defense Healer";
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
    /**
     * Checks whether this player should run away in an encounter or not based on the player's
     *      created strategy.
     * @param otherPerson Opposing Player
     * @return True if the player should run away
     */
    @Override
    public boolean shouldRunAway(People otherPerson) {
        return false;
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

