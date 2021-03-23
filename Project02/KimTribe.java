package Project02;
import java.util.Collection;
import java.util.Collections;
import java.io.StringBufferInputStream;
import java.util.ArrayList;

public class KimTribe extends Tribe
{
    public KimTribe(String nation, String tribe, int lifePoints, int numberOfPeoplePerTribe)
    {
        super(nation, tribe, lifePoints, numberOfPeoplePerTribe);
        populateTribe();
    }

    @Override
    public void populateTribe() {
        members.add(new KimWarrior1(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new KimWarrior2(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new KimWizard1(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new KimWizard2(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new KimHealer1(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new KimHealer2(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));

        for (int i = 0; i < members.size(); i++) {
            livingMembers.add(members.get(i));
        }

        System.out.println(livingMembers);
    }

}