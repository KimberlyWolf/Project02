package Project02;

/**
 * Creating a new tribe for the "Wolves" nation to be utilized
 *      in the WarringNations game. Extends Tribe.
 */
public class KimTribe extends Tribe
{

    /**
     * Creates a new tribe in our world.
     * @param nation The nation the tribe belongs to.
     * @param tribe The tribe name.
     * @param lifePoints Number of life points the tribe has total.
     * @param numberOfPeoplePerTribe Number of members in the tribe.
     */
    public KimTribe(String nation, String tribe, int lifePoints, int numberOfPeoplePerTribe)
    {
        super(nation, tribe, lifePoints, numberOfPeoplePerTribe);
        populateTribe();
    }

    /**
     * Overrides the populateTribe() method to add new members of
     *      different classes (Warrior, Wizard, and Healer) to this
     *      tribe. Prints the living members of the tribe.
     */
    @Override
    public void populateTribe() {
        members.add(new KimWarrior(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new KimWarrior(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new KimWizard(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new KimWizard(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new KimHealer(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new KimHealer(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));

        for (int i = 0; i < members.size(); i++) {
            livingMembers.add(members.get(i));
        }

        System.out.println(livingMembers);
    }

}
