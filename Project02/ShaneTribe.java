package Project02;

public class ShaneTribe extends Tribe
{
    public ShaneTribe(String nation, String tribe, int lifePoints, int numberOfPeoplePerTribe)
    {
        super(nation, tribe, lifePoints, numberOfPeoplePerTribe);
        populateTribe();
    }

    @Override
    public void populateTribe() {
        members.add(new ShaneWizFearingWarrior(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new ShaneCompetitiveWarrior(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new ShaneHealerKillerWizard(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new ShaneElitistWizard(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new ShaneCowardHealer(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));
        members.add(new ShaneFightingHealer(nationName, tribeName, tribeLifePoints/numberOfPeoplePerTribe));

        for (int i = 0; i < members.size(); i++) {
            livingMembers.add(members.get(i));
        }

        System.out.println(livingMembers);
    };

}
