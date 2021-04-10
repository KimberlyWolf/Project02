package Project02;

import static Project02.PeopleType.*;

/**
 * Testing Wizard character. Only meant for testing purposes.
 * Extends type People.
 */
public class DummyWizard extends People {

    /**
     * From the extension of the People java class, we create a new healer person.
     * @param nation Nation Dummy belongs to.
     * @param tribe Tribe Dummy belongs to.
     * @param lifePoints Number of life points Dummy has.
     */
    public DummyWizard(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, wizard, lifePoints);
        myDescription = "\tDummy Wizard";
    }

    /**
     * Individual strategies to influence how the game is played. This strategy determines
     *       how this player interacts from people from other nations, their own nation,
     *       and their own tribe.
     * @param otherPerson The opponent player 1 is going against
     * @return Life points to determine if this player runs away, how much to damage to
     *       deal, or how much to heal.
     */
    public int encounterStrategy(Project02.People otherPerson) { return 0; }


}

