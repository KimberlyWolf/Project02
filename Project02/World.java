package Project02;

import java.util.*;

import static Project02.PeopleType.*;

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
        this.worldLifePoints = settings.getBaseHealthPerPerson() * this.settings.getNumberOfNations()
                * this.settings.getNumberOfTribesPerNation() * this.settings.getNumberOfPeoplePerTribe();
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
    public void createWorld() {
        int baseHealthPerPerson = settings.getBaseHealthPerPerson();
        int numberOfTribesPerNation = settings.getNumberOfTribesPerNation();
        int numberOfPeoplePerTribe = settings.getNumberOfPeoplePerTribe();

        allNations.add(new KimNation(baseHealthPerPerson, numberOfTribesPerNation, numberOfPeoplePerTribe));
        allNations.add(new EricNation(baseHealthPerPerson, numberOfTribesPerNation, numberOfPeoplePerTribe));
        allNations.add(new ShaneNation(baseHealthPerPerson, numberOfTribesPerNation, numberOfPeoplePerTribe));
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
        int personOneHealth = worldCreatedPeople.get(personOne).getLifePoints();
        int personTwoHealth = worldCreatedPeople.get(personTwo).getLifePoints();
        System.out.printf("ENCOUNTER: %s (%d) encounters %s (%d)%n", personOneDescription, personOneHealth,
                personTwoDescription, personTwoHealth);

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
     * This is the encounter for the special characters and artifacts. Because there is a
     *      limited number of times a special character can be interacted with, the number
     *      of interactions are reduced. If the number of interactions left reaches zero,
     *      that special character is considered "dead."
     * @param personRegular Person of the class Warrior, Wizard, or Healer.
     * @param personSpecial Special character or artifact
     */
    private void encounterSpecial(int personRegular, int personSpecial) {
        worldCreatedPeople.get(personSpecial).reduceInteractionsLeft();
        worldCreatedPeople.get(personSpecial).interact(worldCreatedPeople.get(personRegular));

        if (worldCreatedPeople.get(personSpecial).getInteractionsLeft() == 0) {
            worldCreatedPeople.get(personSpecial).setDead();
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
        int moreHealthyPersonLifePoints = worldCreatedPeople.get(moreHealthyPerson).getLifePoints();
        int lessHealthyPersonLifePoints = worldCreatedPeople.get(lessHealthyPerson).getLifePoints();

        // TODO: bug here?
        // if greater than the max, use diff
        if (lessHealthyPersonLifePoints + healthShared > maxHealthAllowed)
            healthShared = maxHealthAllowed - lessHealthyPersonLifePoints;

        // readable references
        String giver = displayPersonInfo(moreHealthyPerson);
        String receiver = displayPersonInfo(lessHealthyPerson);

        // inform players
        System.out.printf("PEACEFUL ENCOUNTER: %s (%d) shares %d with %s (%d)%n", giver, moreHealthyPersonLifePoints, healthShared,
                receiver, lessHealthyPersonLifePoints);
        // apply heal
        worldCreatedPeople.get(moreHealthyPerson).modifyLifePoints(-healthShared); // takes from more healthy
        worldCreatedPeople.get(lessHealthyPerson).modifyLifePoints(healthShared); // to give to less healthy

        if (worldCreatedPeople.get(moreHealthyPerson).getLifePoints() > maxHealthAllowed)
            worldCreatedPeople.get(moreHealthyPerson).setLifePoints(maxHealthAllowed);
        if (worldCreatedPeople.get(lessHealthyPerson).getLifePoints() > maxHealthAllowed)
            worldCreatedPeople.get(lessHealthyPerson).setLifePoints(maxHealthAllowed);

        // Update values after
        moreHealthyPersonLifePoints = worldCreatedPeople.get(moreHealthyPerson).getLifePoints();
        lessHealthyPersonLifePoints = worldCreatedPeople.get(lessHealthyPerson).getLifePoints();

        System.out.printf("%s now has %d health after sharing.%n", giver, moreHealthyPersonLifePoints);
        System.out.printf("%s now has %d health after being shared with.%n", receiver, lessHealthyPersonLifePoints);

    }

    /** Using the dice roll concept, to determine which player is the attacker and defender.
     * Determines how much damage a player receives or deals based off of the created strategies
     * individuals have made.
     * @param personOneWorldIndex Index value of the Offensive/Defensive player
     * @param personTwoWorldIndex Index value of the opponent
     */
    public void encounterHostile(int personOneWorldIndex, int personTwoWorldIndex) {
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
        boolean attackerAlive = true, defenderAlive = true;
        int maxHealth = settings.getMaxHealthPerPerson();

        // readable references
        String attacker = displayPersonInfo(attackerIndex);
        String defender = displayPersonInfo(defenderIndex);
        int attackerLifePoints = worldCreatedPeople.get(attackerIndex).getLifePoints();
        int defenderLifePoints = worldCreatedPeople.get(defenderIndex).getLifePoints();

        // game message
        System.out.printf("HOSTILE ENCOUNTER: %s (%d) becomes attacker and %s (%d) becomes defender%n", attacker, attackerLifePoints,
                defender, defenderLifePoints);

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
        // attacker drives overall encounter and can choose to run
        if (!attackerRunsAway) {
            // otherwise, attacker stays and attacks defender
            // defender can choose to run away
            defenderRunsAway = worldCreatedPeople.get(defenderIndex).shouldRunAway(worldCreatedPeople.get(attackerIndex));

            // if defender tries running away, defender doesnt get to defend against attacker
            int attackerRoll = die.roll();
            System.out.printf("%s rolls a %d%n", attacker, attackerRoll);
            attackerAttackAmount = (int) Math.floor(attackerRoll * attackerAttack * attackerEffectiveness);

            if (defenderRunsAway) {
                // defender takes reduced damage when running away
                System.out.printf("%s (%d) tries to run away.", defender, defenderLifePoints);
                attackerDamageDealt = attackerAttackAmount / settings.getRunAwayDamageFactor();
                System.out.printf("%s (%d) deals %d damage to %s (%d) while running away.%n", attacker,
                        attackerLifePoints, attackerDamageDealt, defender, defenderLifePoints);
                worldCreatedPeople.get(defenderIndex).modifyLifePoints(-attackerDamageDealt);

                // Update health after combat
                defenderLifePoints = worldCreatedPeople.get(defenderIndex).getLifePoints();
                defenderAlive = worldCreatedPeople.get(defenderIndex).isPersonAlive();

            } else {
                // if defender stays and fights, they get to defend, and also attack
                int defenderRoll = die.roll();
                defenderDefenseAmount = (int) Math.floor(defenderRoll * defenderDefense * defenderEffectiveness);
                System.out.printf("%s rolls a %d%n", defender, defenderRoll);
                // attacker attacks first
                if (attackerAttackAmount >= defenderDefenseAmount)
                    attackerDamageDealt = attackerAttackAmount - defenderDefenseAmount;
                else
                    // todo: successfully defended msg?
                    attackerDamageDealt = 0;
                System.out.printf("%s (%d) deals %d damage to %s (%d).%n", attacker, attackerLifePoints, attackerDamageDealt,
                        defender, defenderLifePoints);
                worldCreatedPeople.get(defenderIndex).modifyLifePoints(-attackerDamageDealt);

                // Update health and check if dead after combat
                defenderLifePoints = worldCreatedPeople.get(defenderIndex).getLifePoints();
                if (defenderLifePoints < 0) {
                    worldCreatedPeople.get(defenderIndex).setLifePoints(0);
                }
                defenderAlive = worldCreatedPeople.get(defenderIndex).isPersonAlive();

                // Defender deals damage back
                if (defenderAlive) {
                    defenderAttackAmount = (int) Math.floor(die.roll() * defenderAttack * defenderEffectiveness);
                    attackerDefenseAmount = (int) Math.floor(die.roll() * attackerDefense * attackerEffectiveness);
                    if (defenderAttackAmount >= attackerDefenseAmount)
                        defenderDamageDealt = defenderAttackAmount - attackerDefenseAmount;
                    else
                        defenderDamageDealt = 0;
                    System.out.printf("%s (%d) deals %d damage to %s (%d).%n", defender, defenderLifePoints,
                            defenderDamageDealt, attacker, attackerLifePoints);
                    worldCreatedPeople.get(defenderIndex).modifyLifePoints(-attackerDamageDealt);

                    // Update health and check if dead after combat
                    attackerLifePoints = worldCreatedPeople.get(attackerIndex).getLifePoints();
                    if (attackerLifePoints < 0) {
                        worldCreatedPeople.get(attackerIndex).setLifePoints(0);
                    }
                    attackerAlive = worldCreatedPeople.get(attackerIndex).isPersonAlive();
                }
            }
        }
        // deal damage
        // note the defender does not take full damage if running away
        // TODO: in progress
        if (attackerRunsAway) {
            // when attacker runs away, they lose one health, and defender gains one health
            System.out.printf("%s (%d) runs away, losing 1 life.%n", attacker, attackerLifePoints);
            worldCreatedPeople.get(attackerIndex).modifyLifePoints(-1);

            System.out.printf("Consequently, %s (%d) gains 1 life.%n", defender, defenderLifePoints);
            worldCreatedPeople.get(defenderIndex).modifyLifePoints(1);
            defenderLifePoints = worldCreatedPeople.get(defenderIndex).getLifePoints();
            // apply cap
            if (defenderLifePoints > maxHealth) {
                worldCreatedPeople.get(defenderIndex).setLifePoints(maxHealth);
            }
        } else if (defenderRunsAway && defenderAlive) {
            System.out.printf("%s (%d) runs away, losing 1 life.%n", defender, defenderLifePoints);
            worldCreatedPeople.get(defenderIndex).modifyLifePoints(-1);

            System.out.printf("Consequently, %s (%d) gains 1 life.%n", attacker, attackerLifePoints);
            worldCreatedPeople.get(attackerIndex).modifyLifePoints(1);
            attackerLifePoints = worldCreatedPeople.get(attackerIndex).getLifePoints();
            // apply cap
            if (attackerLifePoints > maxHealth) {
                worldCreatedPeople.get(attackerIndex).setLifePoints(maxHealth);
            }
        }
        attackerLifePoints = worldCreatedPeople.get(attackerIndex).getLifePoints();
        defenderLifePoints = worldCreatedPeople.get(defenderIndex).getLifePoints();
        System.out.printf("POST-ENCOUNTER SUMMARY: %s (%d) \t %s (%d).%n", attacker, attackerLifePoints, defender, defenderLifePoints);
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
