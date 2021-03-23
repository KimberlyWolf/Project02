package Project02;

import static Project02.PeopleType.warrior;
//this warrior wants to be the best warrior of all. Does not help other warriors by sharing health. Will do more
//damage to warriors.
public class ShaneCompetitiveWarrior extends People {

    public ShaneCompetitiveWarrior(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, warrior, lifePoints);
        myDescription = "\tShane Competitive Warrior";
    }

    public int encounterStrategy(People otherPerson) {
        int lifePoints = 0;
        // opposing nation
        if (!this.getNation().equals((otherPerson.getNation())))
        {
            // greater health than enemy
            if (this.getLifePoints() > otherPerson.getLifePoints())
            {
                switch(otherPerson.getType()) {
                    case warrior: // fight return a positive number
                        lifePoints = (int)(this.getLifePoints() * .5) + 8;
                        break;
                    case wizard: // fight return a positive number
                        lifePoints = (int)(this.getLifePoints() * .6) + 1;
                        break;
                    case healer: // fight return a positive number
                        lifePoints = (int)(this.getLifePoints() * .4) + 2;
                        break;
                    default:
                        lifePoints = 6;
                        break;
                }
            }
            // lower/same health as enemy
            else {
                switch(otherPerson.getType()) {
                    case warrior: //fight return a positive number
                        lifePoints = (int)(this.getLifePoints() * .5) + 6;
                        break;
                    case wizard: //runs bc fears wizards at low health
                        lifePoints = 0;
                        break;
                    case healer: //fight return a positive number
                        lifePoints = (int)(this.getLifePoints() * .4) + 5;
                        break;
                    default:
                        lifePoints = 5;
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
                        //heal
                        case wizard: // dislikes wizards
                            lifePoints = (int)(otherPerson.getLifePoints() * .3);
                            break;
                        case healer: //heal
                            lifePoints = (int)(otherPerson.getLifePoints() * .4) + 1;
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
                        //heal
                        //nothing does not like wizards or other warriors
                        case healer: //nothing
                            lifePoints = (int)(otherPerson.getLifePoints() * .25) + 1;
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

