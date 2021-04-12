package Project02;

import static Project02.PeopleType.*;

public class EricHealerSelfDefense extends People {

    public EricHealerSelfDefense(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, healer, lifePoints, 10, 10);
        myDescription = "\tEric Self-Defense Healer";
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
        return false;
    }


}

