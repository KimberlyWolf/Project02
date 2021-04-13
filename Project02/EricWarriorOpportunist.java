package Project02;

import static Project02.PeopleType.*;

/**
 * Creating a new Warrior for Eric's tribe/nation utilizing a self-made, unique
 *         strategy that can be used in our WarringNations game.
 *         Extends People.
 */
public class EricWarriorOpportunist extends People {

    /**
     * From the extension of the People java class, we create a new warrior person.
     *      Implements what their default/base attack and defense, as well as their
     *      effectiveness in terms of damaging an opposing player based on other player's
     *      class.
     * @param nation Nation Eric's warrior belongs to.
     * @param tribe Tribe Eric's warrior belongs to.
     * @param lifePoints Number of life points Eric's warrior has.
     */
    public EricWarriorOpportunist(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints, 10, 10);
        myDescription = "\tEric Opportunist Warrior";
        // more effective against healers
        this.setEffectiveness(warrior, 1.0);
        this.setEffectiveness(wizard, 1.0);
        this.setEffectiveness(healer, 1.25);
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


    /**
     * Checks whether this player should run away in an encounter or not based on the player's
     *      created strategy.
     * @param otherPerson Opposing Player
     * @return True if the player should run away
     */
    @Override
    // only fight warriors if strong advantage and fight wizards at any advantage
    // fights healers even at disadvantage
    public boolean shouldRunAway(People otherPerson) {
        return ((otherPerson.getType() == warrior && otherPerson.getLifePoints() > 1.5 * this.getLifePoints()) ||
                (otherPerson.getType() == wizard && otherPerson.getLifePoints() > this.getLifePoints()));
    }

    /**
     * This is only used for special characters. Nothing should be added here.
     * @param people Player in world
     */
    // NOT an npc character, is not used here
    @Override
    public void interact(People people) {

    }


}

