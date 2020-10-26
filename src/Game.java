import bagel.AbstractGame;
import bagel.Input;
import bagel.Keys;

public class Game extends AbstractGame {
    private MovingPlayer player = new MovingPlayer(64,64,"res/player1.png", 120);
    //private MovingPlayer player = new MovingPlayer(48,48,"res/player2.png", 120);
    //private MovingPlayer player = new MovingPlayer(213,220,"res/sami-ullah-taunsvi-hero.png", 120);
    public Game() {
        
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
        //player.drawAll();
        player.update(input);
    }

}
