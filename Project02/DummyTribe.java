package Project02;
import java.util.Collection;
import java.util.Collections;
import java.io.StringBufferInputStream;
import java.util.ArrayList;

/**
 * Testing making Tribes and adding members to the tribe. For testing purposes only.
 * Extends the Tribe class
 */
public class DummyTribe extends Tribe
{
    /**
     * Creates a new tribe in our world for a specific nation.
     * @param nation The nation the tribe belongs to.
     * @param tribe The tribe name.
     * @param lifePoints Number of life points the tribe has total.
     * @param numberOfPeoplePerTribe Number of members in the tribe.
     */
    public DummyTribe(String nation, String tribe, int lifePoints, int numberOfPeoplePerTribe)
    {
        super(nation, tribe, lifePoints, numberOfPeoplePerTribe);
        populateTribe();
    }

    /**
     * Overrides the populateTribe() method to add new members of
     *      different classes (Warrior, Wizard, and Healer) to this
     *      tribe.
     */
    @Override
    public void populateTribe() {
        members.add(new DummyWarrior(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe, 10, 10));
        members.add(new DummyWarrior(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe, 10, 10));
        members.add(new DummyWizard(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe, 10, 10));
        members.add(new DummyWizard(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe, 10, 10));
        members.add(new DummyHealer(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe, 10, 10));
        members.add(new DummyHealer(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe, 10, 10));

        for (int i = 0; i < members.size(); i++) {
            livingMembers.add(members.get(i));
        }

        System.out.println(livingMembers);
    };

}
