package Project02;

import java.util.Random;

/**
 * Utilizes a random number generator that determines outcomes in the game.
 *      The number of sides on the die is always defaulted to 6, but can be
 *      changed if one sees a need to change it.
 */
public class Die {

    /**
     * Uses a built-in java random number generator to create diceRoller
     */
    public Random diceRoller;

    /**
     * Number of sides a dice has
     */
    private int diceSides;

    /**
     * Instantiates a new random number generator and sets the number of sides of a
     *      die to a given parameter. If no parameter is given, the number of sides
     *      will default to 6.
     * @param sides Sides of a die
     */
    public Die(int sides) {
        long seed = System.currentTimeMillis();
        this.diceRoller = new Random(seed);
        // default to 6 sides
        if (sides == 0) {
            sides = 6;
        }
        this.diceSides = sides;
    }

    /**
     * Rolls a die and returns the random number generated
     * @return The random number plus 1 to fit our bounds
     */
    public int roll() {
        System.out.println("Let's roll the " + diceSides + " sided die!");
        return diceRoller.nextInt(diceSides)+1; // shift bounds up by 1 to include sides
    }
}
