package Project02;

import static Project02.PeopleType.*;
/**
 * Creates a template for making strategies. Used to Testing purposed only!
 *     Extends People.
 */
public class SkeletonPerson extends People {
    /**
     * From the extension of the People java class, we create a new healer person.
     * @param nation Nation template belongs to.
     * @param tribe Tribe template belongs to.
     * @param lifePoints Number of life points template has.
     */
    public SkeletonPerson(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, wizard, lifePoints, 10, 10);
        myDescription = "\tBare bones of an encounter strategy";
        // TODO: set effectiveness
    }
    /**
     * Individual strategies to influence how the game is played. This strategy determines
     *       how this player interacts from people from other nations, their own nation,
     *       and their own tribe in a peaceful manor.
     * @param otherPerson The opponent player 1 is going against
     * @return Life points to determine if this player runs away, or how much to heal.
     */
    public int healingStrategy(Project02.People otherPerson) {
        int lifePointsToShare = 0;
        String thisPersonTribe = this.getTribe();
        boolean sameTribe = this.getTribe().equals(otherPerson.getTribe());
        if (sameTribe) {
            switch (otherPerson.getType()) {
                case warrior:
                    // TODO
                    break;
                case wizard:
                    // TODO
                    break;
                case healer:
                    // TODO
                    break;
                default:
                    break;
            }
        } else {
            switch (otherPerson.getType()) {
                case warrior:
                    // TODO
                    break;
                case wizard:
                    // TODO
                    break;
                case healer:
                    // TODO
                    break;
                default:
                    break;
            }
        }
        return lifePointsToShare;
    }

    @Override
    public boolean shouldRunAway(People otherPerson) {
        return false;
    }

    @Override
    public void interact(People otherPerson) {

    }
}

