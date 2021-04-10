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
        super(nation, tribe, wizard, lifePoints);
        myDescription = "\tBare bones of an encounter strategy";
    }
    /**
     * Individual strategies to influence how the game is played. This strategy determines
     *       how this player interacts from people from other nations, their own nation,
     *       and their own tribe in a peaceful manor.
     * @param otherPerson The opponent player 1 is going against
     * @return Life points to determine if this player runs away, or how much to heal.
     */
    public int encounterStrategyPeaceful(Project02.People otherPerson) {
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

    // return 0 to run away
    public int encounterStrategyHostile(Project02.People otherPerson) {
        // TODO
        // if have advantage
        int lifePointsToRisk = 0;
        if (this.getLifePoints() > otherPerson.getLifePoints()) {
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
            // if at disadvantage
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
        return lifePointsToRisk;
    }

    /**
     * Individual strategies to influence how the game is played. This strategy determines
     *       how this player interacts from people from other nations, their own nation,
     *       and their own tribe.
     * @param otherPerson The opponent player 1 is going against
     * @return Life points to determine if this player runs away, how much to damage to
     *       deal, or how much to heal.
     */
    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        // opposing nation
        if (!this.getNation().equals((otherPerson.getNation())))
        {
            // greater health than enemy
            if (this.getLifePoints() > otherPerson.getLifePoints())
            {
                switch(otherPerson.getType()) {
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
                        lifePoints = 0;
                        break;
                }
            }
            // lower/same health as enemy
            else {
                switch(otherPerson.getType()) {
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
                        lifePoints = 0;
                        break;
                }
            }
        }
        // same nation
        else
        {
            // same tribe
            if (this.getTribe().equals(otherPerson.getTribe())) {
                // share health only if have more than friend
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
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
                            lifePoints = 0;
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
                            // TODO
                            break;
                        case wizard:
                            // TODO
                            break;
                        case healer:
                            // TODO
                            break;
                        default:
                            lifePoints = 0;
                            break;
                    }
                }
            }
        }
        return lifePoints;
    }


}

