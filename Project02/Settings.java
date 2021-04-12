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
    private int totalLifePointsPerNation;
    private int numberOfNations;
    private int numberOfTribesPerNation;
    private int numberOfPeoplePerTribe;
    private int numberOfClasses;
    private int minimumRequiredPeoplePerClass;
    private int runAwayDamageFactor;

    /**
     * Instantiates the settings for our game.
     * @param maxRounds Maximum number of rounds
     * @param maxHealthPerPerson Maximum life points a person can have at any time
     * @param totalLifePointsPerNation Maximum number of life points per nation
     * @param numberOfNations Number of nations present in the game
     * @param numberOfTribesPerNation Number of tribes present in the game
     * @param numberOfPeoplePerTribe Number of members in the tribe
     * @param numberOfClasses Number of unique classes for each member
     * @param runAwayDamageFactor How much damage one takes if they "run away" from an encounter
     */
    public Settings(int maxRounds, int maxHealthPerPerson, int totalLifePointsPerNation, int numberOfNations, int numberOfTribesPerNation,
                    int numberOfPeoplePerTribe, int numberOfClasses, int runAwayDamageFactor)
    {
        this.maxRounds = maxRounds;
        this.maxHealthPerPerson = maxHealthPerPerson;
        this.totalLifePointsPerNation = totalLifePointsPerNation;
        this.numberOfNations = numberOfNations;
        this.numberOfTribesPerNation = numberOfTribesPerNation;
        this.numberOfPeoplePerTribe = numberOfPeoplePerTribe;
        this.numberOfClasses = numberOfClasses;
        this.runAwayDamageFactor = runAwayDamageFactor;
    }

    public int getMaxRounds() {
        return this.maxRounds;
    }

    public void setMaxRounds(int maxRounds) {
        this.maxRounds = maxRounds;
    }

    public int getMaxHealthPerPerson() { return this.maxHealthPerPerson; }

    public int getTotalLifePointsPerNation() {
        return this.totalLifePointsPerNation;
    }

    public void setTotalLifePointsPerNation(int points) {
        this.totalLifePointsPerNation = points;
    }

    public int getNumberOfNations() {
        return this.numberOfNations;
    }

    public void setNumberOfNations(int numberOfNations) {
        this.numberOfNations = numberOfNations;
    }

    public int getNumberOfTribesPerNation() {
        return this.numberOfTribesPerNation;
    }

    public void setNumberOfTribesPerNation(int numberOfTribesPerNation) {
        this.numberOfTribesPerNation = numberOfTribesPerNation;
    }

    public int getNumberOfPeoplePerTribe() {
        return this.numberOfPeoplePerTribe;
    }

    public void setNumberOfPeoplePerTribe(int numberOfPeoplePerTribe) {
        this.numberOfPeoplePerTribe = numberOfPeoplePerTribe;
    }

    public int getNumberOfClasses() {
        return this.numberOfClasses;
    }

    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public int getMinimumRequiredPeoplePerClass() {
        return this.minimumRequiredPeoplePerClass;
    }

    public void setMinimumRequiredPeoplePerClass(int requiredClassCount) {
        this.minimumRequiredPeoplePerClass = requiredClassCount;
    }

    public int getRunAwayDamageFactor() { return this.runAwayDamageFactor; }

    public void setRunAwayDamageFactor(int factor) {
        this.runAwayDamageFactor = factor;
    }


}
