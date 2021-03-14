package Project02;

public class PlayGame
{
    public PlayGame()
    {
        Settings settings = new Settings(40, 1000, 2,
                5, 6, 3, 1);
        World earth = new World(settings);
        earth.war();
    }
}
