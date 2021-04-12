package Project02;

public class EricTribe extends Tribe
{
    public EricTribe(String nation, String tribe, int lifePoints, int numberOfPeoplePerTribe)
    {
        super(nation, tribe, lifePoints, numberOfPeoplePerTribe);
        populateTribe();
    }

    @Override
    public void populateTribe() {
        members.add(new EricWarriorOpportunist(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new EricWarriorOpportunist(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new EricWizardCritsOrRuns(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new EricWizardCritsOrRuns(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new EricHealerSelfDefense(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new EricHealerSelfDefense(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));

        for (int i = 0; i < members.size(); i++) {
            livingMembers.add(members.get(i));
        }

        System.out.println(livingMembers);
    }

}
