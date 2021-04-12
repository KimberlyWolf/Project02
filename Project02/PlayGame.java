package Project02;

/**
 * Creates a game of WarringNations to be played.
 */
public class PlayGame
{
    /**
     * Creates a game utilizing the setting class and creating a
     *      new game world with the given settings.
     */
    public PlayGame()
    {
        Settings settings = new Settings(100, 100, 1000, 3,
                5, 6, 3, 1,
                3);
        World earth = new World(settings);

        // run game
        earth.war();
    }
}
