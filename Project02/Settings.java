package Project02;

/**
 * This class is the inner workings of the WarringNations game. It keeps track of
 * all the specifics of the game such as the number of rounds that can be played,
 * the number of members per tribe and nation, the total number of life points, and
 * much more.
 */
public class Settings {

    /**
     * Private variables that serve as the backbone of the settings class.
     * These variables set up the game in such a way that allows for variability
     * between each game. Variables include total number of life points per nation,
     * max number of rounds, number of nations, number of tribes per nation,
     * number of people per tribe, and more.
     */
    private int maxRounds;
    private int maxHealthPerPerson;
    private int baseHealthPerPerson;
    private int numberOfNations;
    private int numberOfTribesPerNation;
    private int numberOfPeoplePerTribe;
    private int numberOfClasses;
    private int runAwayDamageFactor;

    /**
     * Instantiates the settings for our game.
     * @param maxRounds Maximum number of rounds
     * @param baseHealthPerPerson Base number of life points per person
     * @param numberOfNations Number of nations present in the game
     * @param numberOfTribesPerNation Number of tribes present in the game
     * @param numberOfPeoplePerTribe Number of members in the tribe
     * @param numberOfClasses Number of unique classes for each member
     * @param runAwayDamageFactor How much damage one takes if they "run away" from an encounter
     */
    public Settings(int maxRounds, int baseHealthPerPerson, int maxHealthPerPerson, int numberOfNations, int numberOfTribesPerNation,
                    int numberOfPeoplePerTribe, int numberOfClasses, int runAwayDamageFactor)
    {
        this.maxRounds = maxRounds;
        this.baseHealthPerPerson = baseHealthPerPerson;
        this.maxHealthPerPerson = maxHealthPerPerson;
        this.numberOfNations = numberOfNations;
        this.numberOfTribesPerNation = numberOfTribesPerNation;
        this.numberOfPeoplePerTribe = numberOfPeoplePerTribe;
        this.numberOfClasses = numberOfClasses;
        this.runAwayDamageFactor = runAwayDamageFactor;
    }

    /**
     * @return Current highest round the game can go to
     */
    public int getMaxRounds() {
        return this.maxRounds;
    }

    /**
     * Sets the maximum number of rounds to the parameter maxRounds.
     * @param maxRounds Number of rounds we want the game to go to
     */
    public void setMaxRounds(int maxRounds) {
        this.maxRounds = maxRounds;
    }

    /**
     * @return Total number of life points per each nation
     */
    public int getBaseHealthPerPerson() {
        return this.baseHealthPerPerson;
    }

    /**
     * Sets the number of life points per nation to the parameter points.
     * @param points Number of points we want each nation to have
     */
    public void setBaseHealthPerPerson(int points) {
        this.baseHealthPerPerson = points;
    }

    /**
     * @return The maximum health a person can have at any time.
     */
    public int getMaxHealthPerPerson() { return this.maxHealthPerPerson; }

    /**
     * @return Total number of nations
     */
    public int getNumberOfNations() {
        return this.numberOfNations;
    }

    /**
     * Sets the number of nations to the parameter numberOfNations.
     * @param numberOfNations Number of nations in the game
     */
    public void setNumberOfNations(int numberOfNations) {
        this.numberOfNations = numberOfNations;
    }

    /**
     * @return Total number of tribes per each nation
     */
    public int getNumberOfTribesPerNation() {
        return this.numberOfTribesPerNation;
    }

    /**
     * Sets the number of tribes per nation to the parameter numberOfTribesPerNation.
     * @param numberOfTribesPerNation Number of tribes we want each nation to have
     */
    public void setNumberOfTribesPerNation(int numberOfTribesPerNation) {
        this.numberOfTribesPerNation = numberOfTribesPerNation;
    }

    /**
     * @return Total number of people per each tribe
     */
    public int getNumberOfPeoplePerTribe() {
        return this.numberOfPeoplePerTribe;
    }

    /**
     * Sets the number of people per tribe to the parameter numberOfPeoplePerTribe.
     * @param numberOfPeoplePerTribe Number of people we want each tribe to have
     */
    public void setNumberOfPeoplePerTribe(int numberOfPeoplePerTribe) {
        this.numberOfPeoplePerTribe = numberOfPeoplePerTribe;
    }

    /**
     * @return The number of unique classes
     */
    public int getNumberOfClasses() {
        return this.numberOfClasses;
    }

    /**
     * Sets the number of unique classes to the parameter numberOfClasses.
     * @param numberOfClasses How many of each class we want each nation to have
     */
    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    /**
     * @return The number of damage a player takes if they run away
     */
    public int getRunAwayDamageFactor() { return this.runAwayDamageFactor; }

    /**
     * Sets the number of points a player loses in they run away to the parameter factor.
     * @param factor Number of points we want the player to lose if they run away
     */
    public void setRunAwayDamageFactor(int factor) {
        this.runAwayDamageFactor = factor;
    }

}
