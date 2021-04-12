package Project02;

import java.util.*;

/**
 * This class acts as the "creation" of our game. Using the values from
 * settings, as well as additional checks for total life points in the world,
 * a list of nations (alive and dead), and the total number of rounds, we can
 * create a world for nations and tribes to battle one another.
 */
public class World {
    /**
     * Private variables that serve as the backbone of the World class.
     * These variables set up the game in such a way that allows for variability
     * between each game. Variables include total number of life points in the game,
     * the number of rounds, a list of of nations-- both alive and dead-- and a
     * settings implementation.
     */
    private int worldLifePoints;
    private int numberOfRounds;
    private ArrayList<Nation> allNations = new ArrayList<>();
    private ArrayList<Nation> allLivingNations = new ArrayList<>();
    private Project02.Settings settings;

    Random generator;
    /**
     * An ArrayList of type people used to signify the total population,
     * or each person in the world.
     */
    ArrayList<People> worldCreatedPeople = new ArrayList<>();


    /**
     * Instantiates a new World so we can play our WarringNations game
     * @param settings Setting attribute to make sure the game is running accordingly
     */
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

    /**
     * Iterates over a list of surviving people and determines if the game should continue
     * or end. These will result in a stalemate or an output of the winning nation and the
     * surviving members of that nation.
     */
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


    /**
     * Utilizes the settings class to build a new world with new nations.
     */
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


    /**
     * Iterates over a list of nations and checks to see if they are alive or dead
     * @return A list of living people
     */
    public ArrayList<People> getWorldCreatedPopulation()
    {
        ArrayList<People> livingPeople = new ArrayList<>();
        // add all living people from allNations to livingPeople
        for(int nation = 0; nation < allNations.size(); nation++)
            livingPeople.addAll(allNations.get(nation).getNationPopulation());
        //System.out.println(livingPeople);
        return livingPeople;
    }


    /**
     * @return A list of the number of surviving people
     */
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


    /**
     * @return The name(s) of the surviving nation(s)
     */
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


    /**
     * Determines whether there is a peaceful or friendly encounter between two people.
     * @param personOne Offensive/Defensive player in the encounter
     * @param personTwo Opponent in the encounter
     */
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


    /**
     * Determines how much (or if any) life points should be shared between players.
     * @param personOne Offensive player in the encounter
     * @param personTwo Innocent bystander from the same nation or tribe
     */
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


    /** Using the dice roll concept, to determine which player is the attacker and defender.
     * Determines how much damage a player receives or deals based off of the created strategies
     * individuals have made.
     * @param personOneWorldIndex Index value of the Offensive/Defensive player
     * @param personTwoWorldIndex Index value of the opponent
     */
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


    /**
     * Randomly selects two people from the created world to engage in an encounter.
     * @param combatants List of the number of people in combat
     */
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


    /**
     * @param person Index of a person in the World
     * @return The description of the person and what tribe and nation they are from.
     */
    public String displayPersonInfo(int person) {

        return worldCreatedPeople.get(person).getDescription() + " from " + worldCreatedPeople.get(person).getTribe() +
                " of " + worldCreatedPeople.get(person).getNation();

    }

}
