package Project02;

import static Project02.PeopleType.*;

public class SkeletonPerson extends People {

    public SkeletonPerson(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, wizard, lifePoints);
        myDescription = "\tBare bones of an encounter strategy";
    }

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

