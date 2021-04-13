package Project02;

import static Project02.PeopleType.*;

public class ShaneGoofyWarrior extends People{
    /**
     * From the extension of the People java class, we create a new warrior person.
     * @param nation Nation Shane's warrior belongs to.
     * @param tribe Tribe Shane's warrior belongs to.
     * @param lifePoints Number of life points Shane's warrior has.
     */
    public ShaneGoofyWarrior(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints, 10, 10);
        myDescription = "\tShane Goofy Warrior";
        // more effective against healers
        this.setEffectiveness(warrior, 1.0);
        this.setEffectiveness(wizard, 1.0);
        this.setEffectiveness(healer, 1.25);
    }

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

    @Override
    // only fight wizards if strong advantage and fight warriors at any advantage
    // is strangely afraid of healers with more health
    public boolean shouldRunAway(People otherPerson) {
        return ((otherPerson.getType() == warrior && otherPerson.getLifePoints() > this.getLifePoints()) ||
                (otherPerson.getType() == wizard && otherPerson.getLifePoints() > 1.5 * this.getLifePoints())
                || (otherPerson.getType() == healer && otherPerson.getLifePoints() > this.getLifePoints()));
    }

    // NOT an npc character, is not used here
    @Override
    public void interact(People people) {

    }

}
