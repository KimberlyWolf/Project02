package Project02;

public class Settings {

    private int maxRounds;
    private int totalLifePointsPerNation;
    private int numberOfNations;
    private int numberOfTribesPerNation;
    private int numberOfPeoplePerTribe;
    private int numberOfClasses;
    private int minimumRequiredPeoplePerClass;

    public Settings(int maxRounds, int totalLifePointsPerNation, int numberOfNations, int numberOfTribesPerNation,
                    int numberOfPeoplePerTribe, int numberOfClasses, int minimumRequiredPeoplePerClass)
    {
        this.maxRounds = maxRounds;
        this.totalLifePointsPerNation = totalLifePointsPerNation;
        this.numberOfNations = numberOfNations;
        this.numberOfTribesPerNation = numberOfTribesPerNation;
        this.numberOfPeoplePerTribe = numberOfPeoplePerTribe;
        this.numberOfClasses = numberOfClasses;
        this.minimumRequiredPeoplePerClass = minimumRequiredPeoplePerClass;
    }

    public int getMaxRounds() {
        return this.maxRounds;
    }

    public void setMaxRounds(int maxRounds) {
        this.maxRounds = maxRounds;
    }

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
}
