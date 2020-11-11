import bagel.*;
import bagel.util.Point;

public class WoodCutter extends MovingPlayer{

    private Action action;

    WoodCutter() {
        super(64, 64, "res/pixelArt/1 Woodcutter/WoodcutterAll.png", 120);
        action = Action.IDLE;
    }

    @Override
    public void drawMoving() {
        getPlayer().drawFromTopLeft(getLocation().x, getLocation().y,
                new DrawOptions().setSection(
                        getIndexX()*getTileWidth(),
                        action.getAction()*getTileHeight(),
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

    @Override
    public void update(Input input) {

        if(input.isDown(Keys.D) && input.isDown(Keys.LEFT_SHIFT)){
            action = Action.JUMP;
            setLocation(new Point(getLocation().x + getSpeed()*1.1, getLocation().y));
            drawMoving();
        }else if(input.isDown(Keys.D)){
            action = Action.WALK;
            setLocation(new Point(getLocation().x + getSpeed(), getLocation().y));
            drawMoving();
        }else if(input.isDown(Keys.F) && input.isDown(Keys.LEFT_SHIFT)){
            action = Action.ATTACK3;
            setLocation(new Point(getLocation().x + getSpeed()*0.8, getLocation().y));
            drawMoving();
        }else if(input.isDown(Keys.F)){
            action = Action.RUN;
            setLocation(new Point(getLocation().x + getSpeed()*1.1, getLocation().y));
            drawMoving();
        }else if(input.isDown(Keys.W)){
            action = Action.CLIMB;
            setLocation(new Point(getLocation().x, getLocation().y - getSpeed()*0.5));
            drawMoving();
        }else if(input.isDown(Keys.S)){
            action = Action.CLIMB;
            setLocation(new Point(getLocation().x, getLocation().y + getSpeed()*0.8));
            drawMoving();
        }else if(input.isDown(Keys.A)){
            action = Action.PUSH;
            setLocation(new Point(getLocation().x - getSpeed()*0.7, getLocation().y));
            drawMoving();
        }else if(input.isDown(Keys.C)){
            action = Action.CRAFT;
            drawMoving();
        }else if(input.isDown(Keys.Q)){
            action = Action.DEATH;
            drawMoving();
        }else if(input.isDown(Keys.E)){
            action = Action.HURT;
            drawMoving();
        }else if(input.isDown(MouseButtons.LEFT)){
            action = Action.ATTACK1;
            drawMoving();
        }else if(input.isDown(MouseButtons.RIGHT)){
            action = Action.ATTACK2;
            drawMoving();
        }else if(input.isDown(Keys.SPACE)){
            action = Action.STABLE;
            drawMoving();
        }else {
            action = Action.IDLE;
            drawMoving();
        }
    }
}
