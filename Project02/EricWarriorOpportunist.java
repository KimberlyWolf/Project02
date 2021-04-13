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

    // TODO: update this
    /**
     * Individual strategies to influence how the game is played. This strategy determines
     *       how this player interacts from people from other nations, their own nation,
     *       and their own tribe.
     * @param otherPerson The opponent player 1 is going against
     * @return Life points to determine if this player runs away, how much to damage to
     *       deal, or how much to heal.
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

    // TODO: document this
    @Override
    // only fight warriors if strong advantage and fight wizards at any advantage
    // fights healers even at disadvantage
    public boolean shouldRunAway(People otherPerson) {
        return ((otherPerson.getType() == warrior && otherPerson.getLifePoints() > 1.5 * this.getLifePoints()) ||
                (otherPerson.getType() == wizard && otherPerson.getLifePoints() > this.getLifePoints()));
    }

    // NOT an npc character, is not used here
    @Override
    public void interact(People people) {

    }


}

