package Project02;

import java.util.Random;

public class Die {

    public Random diceRoller;
    private int diceSides;

    public Die(int sides) {
        long seed = System.currentTimeMillis();
        this.diceRoller = new Random(seed);
        // default to 6 sides
        if (sides == 0) {
            sides = 6;
        }
        this.diceSides = sides;
    }

    public int roll() {
        System.out.println("Let's roll the " + diceSides + " sided die!");
        return diceRoller.nextInt(diceSides)+1; // shift bounds up by 1 to include sides
    }
}
