package Project02;

public class Sandbox {

    public Sandbox() {
        testDieRollIsWithinBounds();
    }

    public void testDieRollIsWithinBounds() {
        Die die = new Die(6);
        int roll;
        for (int i = 0; i < 12; i++) {
            roll = die.roll();
            System.out.println(roll);
        }
    }
}