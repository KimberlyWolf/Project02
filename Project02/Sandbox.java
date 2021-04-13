package Project02;

public class Sandbox {

    public Sandbox() { //testDieRollIsWithinBounds();
        //testBodyBuilder();
    }

    public void testDieRollIsWithinBounds() {
        Die die = new Die(6);
        int roll;
        for (int i = 0; i < 12; i++) {
            roll = die.roll();
            System.out.println(roll);
        }

    }

    public void testBodyBuilder(){
        ShaneGoofyWarrior s = new ShaneGoofyWarrior("o", "p", 100);
        BodyBuilder b = new BodyBuilder();

        System.out.println(s.getAttack());
        System.out.println(b.interactionsLeft);
        b.interact(s);
        System.out.println(b.interactionsLeft);
        System.out.println(s.getAttack());
    }
}