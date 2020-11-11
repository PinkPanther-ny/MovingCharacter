import bagel.AbstractGame;
import bagel.Image;
import bagel.Input;
import bagel.Keys;

public class Game extends AbstractGame {
    private final Image backGround;
    private final MovingPlayer player = new WoodCutter();
    public Game() {
        backGround = new Image("res/bg.png");
    }

    

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) {

        Game game = new Game();
        game.run();
    }

    @Override
    public void update(Input input) {

        backGround.drawFromTopLeft(0,0);
        //player.drawAll();
        player.update(input);
    }

}
