package Project02;

public class PlayGame
{
    public PlayGame()
    {
        Settings settings = new Settings(100, 1000, 3,
                5, 6, 3, 1,
                3);
        World earth = new World(settings);
        earth.war();
    }
}
