package Project02;

import static Project02.PeopleType.*;

public class SkeletonPerson extends People {

    public SkeletonPerson(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, wizard, lifePoints, 10, 10);
        myDescription = "\tBare bones of an encounter strategy";
    }

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
        boolean someCondition = true;
        if (someCondition)
            return true;
        else return false;
    }

    @Override
    public void interact(People people) {

    }


}

