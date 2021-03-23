package Project02;
import java.util.Collection;
import java.util.Collections;
import java.io.StringBufferInputStream;
import java.util.ArrayList;

public class EricTribe extends Tribe
{
    public EricTribe(String nation, String tribe, int lifePoints, int numberOfPeoplePerTribe)
    {
        super(nation, tribe, lifePoints, numberOfPeoplePerTribe);
        populateTribe();
    }

    @Override
    public void populateTribe() {
        members.add(new EricWarrior(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new EricWarrior(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new EricWizard(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new EricWizard(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new EricHealerSelfDefense(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new EricHealerPacifist(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));

        for (int i = 0; i < members.size(); i++) {
            livingMembers.add(members.get(i));
        }

        System.out.println(livingMembers);
    };

}
