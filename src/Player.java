import bagel.DrawOptions;
import bagel.Input;
import bagel.Keys;
import bagel.util.Point;

public class Player extends MovingPlayer{
    private Direction direction;

    Player() {
        super(64,64,"res/player.png", 120);
        direction = Direction.SOUTH;
    }

    @Override
    public void drawMoving(){

        getPlayer().drawFromTopLeft(getLocation().x, getLocation().y,
                new DrawOptions().setSection(
                        getIndexX()*getTileWidth(),
                        direction.getDirection()*getTileHeight(),
                        getTileWidth(),
                        getTileHeight()
                )
        );

        if(getTimer().isCool()){
            setIndexX(getIndexX()+1);
            if (getIndexX()==getTileX()){
                setIndexX(0);
            }

        }

    }

    public void drawStable(){
        getPlayer().drawFromTopLeft(getLocation().x, getLocation().y,
                new DrawOptions().setSection(
                        0,
                        direction.getDirection()*getTileHeight(),
                        getTileWidth(),
                        getTileHeight()
                )
        );

    }

    @Override
    public void update(Input input){

        if(input.isDown(Keys.D)){
            direction = Direction.EAST;
            setLocation(new Point(getLocation().x + getSpeed(), getLocation().y));
            drawMoving();
        }else if(input.isDown(Keys.A)){
            direction = Direction.WEST;
            setLocation(new Point(getLocation().x - getSpeed(), getLocation().y));
            drawMoving();
        }else if(input.isDown(Keys.W)){
            direction = Direction.NORTH;
            setLocation(new Point(getLocation().x, getLocation().y - getSpeed()));
            drawMoving();
        }else if(input.isDown(Keys.S)){
            direction = Direction.SOUTH;
            setLocation(new Point(getLocation().x, getLocation().y + getSpeed()));
            drawMoving();
        }else {

            drawStable();
        }

        if(input.isDown(Keys.LEFT_SHIFT)){
            setSpeed(RUNNING_SPEED);
        }else {
            setSpeed(DEFAULT_SPEED);
        }


    }

}
