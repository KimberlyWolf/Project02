package Project02;

import java.util.*;

public class World {
    private int worldLifePoints;
    private int numberOfRounds;
    private ArrayList<Nation> allNations = new ArrayList<>();
    private ArrayList<Nation> allLivingNations = new ArrayList<>();
    private Settings settings;

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
        // Some not yet used
        // int numberOfClasses = settings.getNumberOfClasses();
        // int minimumNumberOfPeoplePerClass = settings.getMinimumRequiredPeoplePerClass();
        /*
        allNations.add(new Nation("Wolves", lifePointsPerNation, numberOfTribesPerNation,
                numberOfPeoplePerTribe)); // Kimberly Wolf's Nation
        allNations.add(new Nation("Bogfrogs", lifePointsPerNation, numberOfTribesPerNation,
                numberOfPeoplePerTribe)); // Eric Gorski's Nation
        allNations.add(new Nation("Goblins", lifePointsPerNation, numberOfTribesPerNation,
                numberOfPeoplePerTribe)); // Shane Houghton's Nation
        */
        allNations.add(new EricNation(lifePointsPerNation, numberOfTribesPerNation, numberOfPeoplePerTribe));
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


    // moves the life comparison logic out of encounter strategies
    public void encounterPeaceful(int personOne, int personTwo) {
        int personOneLifePoints = worldCreatedPeople.get(personOne).getLifePoints();
        int personTwoLifePoints = worldCreatedPeople.get(personTwo).getLifePoints();

        int moreHealthyPerson = personOneLifePoints > personTwoLifePoints ? personOne : personTwo;
        int lessHealthyPerson = personOneLifePoints > personTwoLifePoints ? personTwo : personOne;

        // readable references
        String giver = displayPersonInfo(moreHealthyPerson);
        String receiver = displayPersonInfo(lessHealthyPerson);

        // more healthy person shares
        int healthShared = worldCreatedPeople.get(moreHealthyPerson).encounterStrategy(worldCreatedPeople.get(lessHealthyPerson));
        System.out.println(giver + " shares " + healthShared + " with "  + receiver);
        worldCreatedPeople.get(lessHealthyPerson).modifyLifePoints(-healthShared); // negative
    }


    public void encounterHostile(int personOneWorldIndex, int personTwoWorldIndex) {
        // random generator
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        int diceRoll = random.nextInt();

        // attacker is person1 and defender is person2 if dice roll is even
        int attackerIndex = diceRoll%2==0 ? personOneWorldIndex : personTwoWorldIndex;
        int defenderIndex = diceRoll%2==0 ? personTwoWorldIndex : personOneWorldIndex;

        // init vars
        int attackerHealthRisked, defenderHealthRisked;
        int attackerDamageDealt, defenderDamageDealt;
        boolean attackerRanAway = false, defenderRanAway = false;

        // readable references
        String attacker = displayPersonInfo(attackerIndex);
        String defender = displayPersonInfo(defenderIndex);

        System.out.println(attacker + " becomes attacker, and " + defender + " becomes defender.");

        // attacker gets to decide if they want to run away before the encounter begins
        attackerHealthRisked = worldCreatedPeople.get(attackerIndex).encounterStrategy(worldCreatedPeople.get(defenderIndex));
        // if attacker runs away
        if (attackerHealthRisked == 0) {
            attackerRanAway = true;
            attackerDamageDealt = 0;
            defenderDamageDealt = 0;
        } else {
            // otherwise, attacker stays and fights
            defenderHealthRisked = worldCreatedPeople.get(defenderIndex).encounterStrategy(worldCreatedPeople.get(attackerIndex));
            // if defender tries running away, defender risks zero health
            if (defenderHealthRisked == 0){
                defenderRanAway = true;
                attackerDamageDealt = attackerHealthRisked; // attacker doesn't deal full damage if defender runs
                defenderDamageDealt = defenderHealthRisked; // zero when running away
            } else {
                // otherwise, regular combat scenario
                // at most, do 1.5x health risked
                // at worst, do 0.5x health risked
                // (these can be changed)
                attackerDamageDealt = (int) (random.nextDouble()+0.5) * attackerHealthRisked;
                defenderDamageDealt = (int) (random.nextDouble()+0.5) * defenderHealthRisked;
            }
        }
        // deal damage
        // note the defender does not take full damage if running away
        if (defenderRanAway) { attackerDamageDealt = attackerDamageDealt/settings.getRunAwayDamageFactor(); }

        System.out.println(attacker + " deals " + attackerDamageDealt + " to " + defender);
        worldCreatedPeople.get(attackerIndex).modifyLifePoints(-defenderDamageDealt);
        System.out.println(defender + " deals " + defenderDamageDealt +
                " to " + attacker);
        worldCreatedPeople.get(defenderIndex).modifyLifePoints(-attackerDamageDealt);

        // penalties for running away applied after combat
        if (attackerRanAway) {
            // when attacker runs away, they lose one health, and defender gains one health
            System.out.println(attacker + " runs away, losing 1 life.");
            worldCreatedPeople.get(attackerIndex).modifyLifePoints(-1);
            System.out.println("Consequently, " + defender + " gains 1 life.");
            worldCreatedPeople.get(defenderIndex).modifyLifePoints(1);
        } else if (defenderRanAway) {
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
