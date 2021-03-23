package Project02;
import java.util.Collection;
import java.util.Collections;
import java.io.StringBufferInputStream;
import java.util.ArrayList;

public class DummyTribe extends Tribe
{
    public DummyTribe(String nation, String tribe, int lifePoints, int numberOfPeoplePerTribe)
    {
        super(nation, tribe, lifePoints, numberOfPeoplePerTribe);
        populateTribe();
    }

    @Override
    public void populateTribe() {
        members.add(new DummyWarrior(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new DummyWarrior(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new DummyWizard(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new DummyWizard(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new DummyHealer(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new DummyHealer(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));

        for (int i = 0; i < members.size(); i++) {
            livingMembers.add(members.get(i));
        }

        System.out.println(livingMembers);
    };

}
