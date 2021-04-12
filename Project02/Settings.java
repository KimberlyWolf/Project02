package Project02;

public class Settings {

    private int maxRounds;
    private int maxHealthPerPerson;
    private int totalLifePointsPerNation;
    private int numberOfNations;
    private int numberOfTribesPerNation;
    private int numberOfPeoplePerTribe;
    private int numberOfClasses;
    private int minimumRequiredPeoplePerClass;
    private int runAwayDamageFactor;

    public Settings(int maxRounds, int maxHealthPerPerson, int totalLifePointsPerNation, int numberOfNations, int numberOfTribesPerNation,
                    int numberOfPeoplePerTribe, int numberOfClasses, int minimumRequiredPeoplePerClass, int
                            runAwayDamageFactor)
    {
        this.maxRounds = maxRounds;
        this.maxHealthPerPerson = maxHealthPerPerson;
        this.totalLifePointsPerNation = totalLifePointsPerNation;
        this.numberOfNations = numberOfNations;
        this.numberOfTribesPerNation = numberOfTribesPerNation;
        this.numberOfPeoplePerTribe = numberOfPeoplePerTribe;
        this.numberOfClasses = numberOfClasses;
        this.minimumRequiredPeoplePerClass = minimumRequiredPeoplePerClass;
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
