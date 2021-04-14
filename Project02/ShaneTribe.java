package Project02;

/**
 * Creating a new tribe for the "Nilbog" nation to be utilized
 *      in the WarringNations game. Extends Tribe.
 */
public class ShaneTribe extends Tribe
{
    /**
     * Creates a new tribe in our world.
     * @param nation The nation the tribe belongs to.
     * @param tribe The tribe name.
     * @param baseHealthPerPerson Number of life points the tribe has total.
     * @param numberOfPeoplePerTribe Number of members in the tribe.
     */
    public ShaneTribe(String nation, String tribe, int baseHealthPerPerson, int numberOfPeoplePerTribe)
    {
        super(nation, tribe, baseHealthPerPerson, numberOfPeoplePerTribe);
        populateTribe();
    }

    /**
     * Overrides the populateTribe() method to add new members of
     *      different classes (Warrior, Wizard, and Healer) to this
     *      tribe. Prints the living members of the tribe.
     */
    @Override
    public void populateTribe() {
        members.add(new ShaneGoofyWarrior(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new ShaneGoofyWarrior(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new ShanePoshWizard(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new ShanePoshWizard(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new ShaneCowardHealer(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new ShaneCowardHealer(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));

        for (int i = 0; i < members.size(); i++) {
            livingMembers.add(members.get(i));
        }

        System.out.println(livingMembers);
    }

}
