import bagel.AbstractGame;
import bagel.Image;
import bagel.Input;
import bagel.Keys;

public class Game extends AbstractGame {
    private final Image backGround;
    private final MovingPlayer player = new MovingPlayer(64,64,"res/player1.png", 120);
    //private MovingPlayer player = new MovingPlayer(48,48,"res/player2.png", 120);
    //private MovingPlayer player = new MovingPlayer(213,220,"res/sami-ullah-taunsvi-hero.png", 120);
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
