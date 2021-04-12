package Project02;

import java.util.*;

import static Project02.PeopleType.*;

public class World {
    private int worldLifePoints;
    private int numberOfRounds;
    private ArrayList<Nation> allNations = new ArrayList<>();
    private ArrayList<Nation> allLivingNations = new ArrayList<>();
    private Project02.Settings settings;

    Random generator;
    ArrayList<People> worldCreatedPeople = new ArrayList<>();
    public World(Settings settings)
    {
        // seed for psuedo-random number generator
        this.settings = settings;
        this.worldLifePoints = settings.getTotalLifePointsPerNation() * this.settings.getNumberOfNations();
        this.numberOfRounds = this.settings.getMaxRounds();
        Date seed = new Date();
        generator = new Random(seed.getTime());
        createWorld();
        // this isnt adding anything
        worldCreatedPeople.addAll(getWorldCreatedPopulation());
        System.out.println(worldCreatedPeople);
    }

    public void war()
        {
            ArrayList<Integer> worldSurvivingPeople = new ArrayList<>();

            for(int round = 1; round <= numberOfRounds+1; round++)
            {
                if (round > numberOfRounds) {
                    System.out.println("Stalemate! You're ALL losers!");
                    break;
                }
                Set<String> survivingNations = new HashSet<>();
                System.out.println("Round number: " + round);
                worldSurvivingPeople.clear();
                worldSurvivingPeople.addAll(getWorldSurvivingPeople());
                survivingNations.addAll(getSurvivingNations());
                //
                if ((worldSurvivingPeople.size() >= 2) && (survivingNations.size() > 1) && (round < numberOfRounds+1)) {
                    playOneRound(worldSurvivingPeople);
                }
                else {
                    System.out.print("Game is over! Winning Nation is: ");
                    if (survivingNations.size() == 0) {
                        System.out.println("All Nations Destroyed.");
                    }
                    else {
                        System.out.println(survivingNations);
                        System.out.println("The survivors are: ");
                        for (Integer i = 0; i < worldSurvivingPeople.size(); i++) {
                            System.out.println(worldCreatedPeople.get(worldSurvivingPeople.get(i)));
                        }
                    }
                    break;
                }
            }

    }



    public void createWorld()
    {
        int lifePointsPerNation = settings.getTotalLifePointsPerNation();
        int numberOfTribesPerNation = settings.getNumberOfTribesPerNation();
        int numberOfPeoplePerTribe = settings.getNumberOfPeoplePerTribe();

        //allNations.add(new KimNation(lifePointsPerNation, numberOfTribesPerNation, numberOfPeoplePerTribe));
        allNations.add(new EricNation(lifePointsPerNation, numberOfTribesPerNation, numberOfPeoplePerTribe));
        //allNations.add(new ShaneNation(lifePointsPerNation, numberOfTribesPerNation, numberOfPeoplePerTribe));
        allNations.add(new DummyNation(lifePointsPerNation, numberOfTribesPerNation, numberOfPeoplePerTribe));
    }


    public ArrayList<People> getWorldCreatedPopulation()
    {
        ArrayList<People> livingPeople = new ArrayList<>();
        // add all living people from allNations to livingPeople
        for(int nation = 0; nation < allNations.size(); nation++)
            livingPeople.addAll(allNations.get(nation).getNationPopulation());
        //System.out.println(livingPeople);
        return livingPeople;
    }


    public ArrayList<Integer> getWorldSurvivingPeople()
    {
        ArrayList<Integer> survivors = new ArrayList<>();
        for (int i = 0; i < worldCreatedPeople.size(); i++)
        {
            if(worldCreatedPeople.get(i).isPersonAlive())
            {
                survivors.add(i);
            }
        }
        return survivors;
    }


    public Set<String> getSurvivingNations()
    {
        Set<String> survivingNations = new HashSet<>();

        for (int i = 0; i < worldCreatedPeople.size(); i++)
        {
            if(worldCreatedPeople.get(i).isPersonAlive())
            {
                survivingNations.add(worldCreatedPeople.get(i).getNation());
            }
        }
        return survivingNations;
    }


    public void encounter(int personOne, int personTwo) {
        // Decide if either is special
        // TODO: random factor
        PeopleType personOneType = worldCreatedPeople.get(personOne).getType();
        PeopleType personTwoType = worldCreatedPeople.get(personTwo).getType();
        if (personOneType == special && personTwoType == special) {
            // do nothing if both special
            return;
        } else if (personOneType == special) {
            encounterSpecial(personTwo, personOne);
            return;
        } else if (personTwoType == special) {
            encounterSpecial(personOne, personTwo);
            return;
        }

        // Announces encounter
        String personOneDescription = displayPersonInfo(personOne);
        String personTwoDescription = displayPersonInfo(personTwo);
        System.out.println("Encounter: " + personOneDescription + " encounters " + personTwoDescription);

        // Determine friendly or hostile encounter based on same nation or not
        String personOneNation = worldCreatedPeople.get(personOne).getNation();
        String personTwoNation = worldCreatedPeople.get(personTwo).getNation();
        if (personOneNation.equals(personTwoNation))
        {
            encounterPeaceful(personOne, personTwo);
        } else
        {
            encounterHostile(personOne, personTwo);
        }
    }

    private void encounterSpecial(int personRegular, int personSpecial) {
        worldCreatedPeople.get(personSpecial).reduceInteractionsLeft();
        worldCreatedPeople.get(personSpecial).interact(worldCreatedPeople.get(personRegular));

        if (worldCreatedPeople.get(personSpecial).getInteractionsLeft() == 0) {
            worldCreatedPeople.get(personSpecial).setDead();
        }

    }


    // moves the life comparison logic out of encounter strategies
    public void encounterPeaceful(int personOne, int personTwo) {
        int personOneLifePoints = worldCreatedPeople.get(personOne).getLifePoints();
        int personTwoLifePoints = worldCreatedPeople.get(personTwo).getLifePoints();

        // decide who is healthier
        int moreHealthyPerson = personOneLifePoints > personTwoLifePoints ? personOne : personTwo;
        int lessHealthyPerson = personOneLifePoints > personTwoLifePoints ? personTwo : personOne;

        // more healthy person shares using friendly strategies
        int healthShared = worldCreatedPeople.get(moreHealthyPerson).healingStrategy(worldCreatedPeople.get(lessHealthyPerson));

        // stop any person from exceeding maxhealth
        int maxHealthAllowed = settings.getMaxHealthPerPerson();
        int lessHealthyPersonLifePoints = worldCreatedPeople.get(lessHealthyPerson).getLifePoints();

        // if greater than the max, use diff
        if (lessHealthyPersonLifePoints + healthShared > maxHealthAllowed)
            healthShared = maxHealthAllowed - lessHealthyPersonLifePoints;

        // readable references
        String giver = displayPersonInfo(moreHealthyPerson);
        String receiver = displayPersonInfo(lessHealthyPerson);

        // inform players
        System.out.println(giver + " shares " + healthShared + " with "  + receiver);
        // apply heal
        worldCreatedPeople.get(moreHealthyPerson).modifyLifePoints(-healthShared); // takes from more healthy
        worldCreatedPeople.get(lessHealthyPerson).modifyLifePoints(healthShared); // to give to less healthy

    }


    public void encounterHostile(int personOneWorldIndex, int personTwoWorldIndex) {
        // random generator
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        //int diceRoll = random.nextInt();

        // Create a 10-sided die
        Die die = new Die(10);
        int diceRoll = die.roll();

        // attacker is person1 and defender is person2 if dice roll is even
        int attackerIndex = diceRoll%2==0 ? personOneWorldIndex : personTwoWorldIndex;
        int defenderIndex = diceRoll%2==0 ? personTwoWorldIndex : personOneWorldIndex;

        // init vars
        int attackerDamageDealt, defenderDamageDealt;
        int attackerAttack, defenderDefense, defenderAttack, attackerDefense,
            attackerAttackAmount, defenderDefenseAmount, defenderAttackAmount, attackerDefenseAmount;
        double attackerEffectiveness, defenderEffectiveness;
        boolean attackerRunsAway = false, defenderRunsAway = false;

        // readable references
        String attacker = displayPersonInfo(attackerIndex);
        String defender = displayPersonInfo(defenderIndex);

        // game message
        System.out.println(attacker + " becomes attacker, and " + defender + " becomes defender.");

        // can move this code in later to prevent unnecessary code executing every time
        // attacker stats
        attackerAttack = worldCreatedPeople.get(attackerIndex).getAttack();
        attackerDefense = worldCreatedPeople.get(attackerIndex).getDefense();
        attackerEffectiveness = worldCreatedPeople.get(attackerIndex).getEffectiveness(worldCreatedPeople.get(defenderIndex));

        // defender stats
        defenderAttack = worldCreatedPeople.get(defenderIndex).getAttack();
        defenderDefense = worldCreatedPeople.get(defenderIndex).getDefense();
        defenderEffectiveness = worldCreatedPeople.get(defenderIndex).getEffectiveness(worldCreatedPeople.get(attackerIndex));

        attackerRunsAway = worldCreatedPeople.get(attackerIndex).shouldRunAway(worldCreatedPeople.get(defenderIndex));
        // attacker drives overall encounter
        if (attackerRunsAway) {
            // if attacker decides to run
            // neither does damage to one another
            attackerDamageDealt = 0;
            defenderDamageDealt = 0;
        } else {
            // otherwise, attacker stays and attacks defender
            // defender can choose to run away
            defenderRunsAway = worldCreatedPeople.get(defenderIndex).shouldRunAway(worldCreatedPeople.get(attackerIndex));

            // if defender tries running away, defender doesnt get to defend against attacker
            attackerAttackAmount = (int) Math.floor(die.roll() * attackerAttack * attackerEffectiveness);
            if (defenderRunsAway) {
                // defender takes reduced damage when running away
                attackerDamageDealt = attackerAttackAmount/settings.getRunAwayDamageFactor();
                // defender deals no damage when running away
                defenderDamageDealt = 0; // zero when running away

            } else {
                // if defender stays and fights, they get to defend, and also attack
                attackerAttackAmount = (int) Math.floor(die.roll()*attackerAttack*attackerEffectiveness);
                defenderDefenseAmount = (int) Math.floor(die.roll()*defenderDefense*defenderEffectiveness);
                attackerDamageDealt = attackerAttackAmount - defenderDefenseAmount;

                defenderAttackAmount = (int) Math.floor(die.roll()*defenderAttack*defenderEffectiveness);
                attackerDefenseAmount = (int) Math.floor(die.roll()*attackerDefense*attackerEffectiveness);
                defenderDamageDealt = defenderAttackAmount - attackerDefenseAmount;
            }
        }
        // deal damage
        // note the defender does not take full damage if running away
        System.out.println(attacker + " deals " + attackerDamageDealt + " to " + defender);
        worldCreatedPeople.get(attackerIndex).modifyLifePoints(-defenderDamageDealt);
        System.out.println(defender + " deals " + defenderDamageDealt +
                " to " + attacker);
        worldCreatedPeople.get(defenderIndex).modifyLifePoints(-attackerDamageDealt);

        // penalties for running away applied after combat
        if (attackerRunsAway) {
            // when attacker runs away, they lose one health, and defender gains one health
            System.out.println(attacker + " runs away, losing 1 life.");
            worldCreatedPeople.get(attackerIndex).modifyLifePoints(-1);
            System.out.println("Consequently, " + defender + " gains 1 life.");
            worldCreatedPeople.get(defenderIndex).modifyLifePoints(1);
        } else if (defenderRunsAway) {
            System.out.println(defender + " runs away, losing 1 life.");
            worldCreatedPeople.get(defenderIndex).modifyLifePoints(-1);
            System.out.println("Consequently, " + attacker + " gains 1 life.");
            worldCreatedPeople.get(attackerIndex).modifyLifePoints(1);
        }

        // aging not mentioned in client requirements and has been removed
    }


    public void playOneRound(ArrayList<Integer> combatants)
    {
        // modified this to specify what number this is on the command line
        System.out.println("Total no. combatants: " + combatants.size());

        int numberOfCombatants;
        Collections.shuffle(combatants);
        numberOfCombatants = combatants.size() - 1;
        int combatantIndex = 0;

        while(combatantIndex < numberOfCombatants)
        {
            encounter(combatants.get(combatantIndex), combatants.get(combatantIndex+1));
            combatantIndex = combatantIndex + 2;
        }
    }


    public String displayPersonInfo(int person) {

        return worldCreatedPeople.get(person).getDescription() + " from " + worldCreatedPeople.get(person).getTribe() +
                " of " + worldCreatedPeople.get(person).getNation();

    }

}
