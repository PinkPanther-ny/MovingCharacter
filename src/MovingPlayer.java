import bagel.*;
import bagel.util.Point;

public class MovingPlayer {

    private static final double DEFAULT_SPEED = 1.5;
    private static final double RUNNING_SPEED = DEFAULT_SPEED*2.2;

    private Image player;
    private final int tileWidth;
    private final int tileHeight;

    private int tileX;
    private int tileY;
    private int indexX;
    private int indexY;

    private final Timer timer;

    private double speed = DEFAULT_SPEED;
    private boolean isMoving = false;
    private Direction direction;
    private Point location;

    MovingPlayer(int tileWidth, int tileHeight, String filePath, int tick){
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        indexX=0;
        indexY=0;
        timer = new Timer(tick);
        location = new Point(500,500);
        direction = Direction.SOUTH;

        try {
            player = new Image(filePath);
        }catch (BagelError e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        try {
            //validateImage();
            tileX = (int)(this.player.getWidth()/tileWidth);
            tileY = (int)(this.player.getHeight()/tileHeight);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    private void validateImage() throws Exception {

        if( this.player.getWidth()%tileWidth!=0 || this.player.getHeight()%tileHeight!=0 ){
            throw new Exception("Invalid Image: Tile width/height invalid.");
        }
    }

    public void drawAll(){

        player.draw(location.x, location.y, new DrawOptions().setSection(indexX*tileWidth, indexY*tileHeight, tileWidth, tileHeight ) );
        if(timer.isCool()){
            System.out.printf("%d,%d\n",indexX*tileWidth, indexY*tileHeight);
            indexX++;
            if (indexX==tileX){
                indexX=0;
                indexY++;
            }
            if(indexY==tileY){
                indexY=0;
            }

        }

    }

    public void drawMoving(){

        player.draw(location.x, location.y, new DrawOptions().setSection(indexX*tileWidth, direction.getDirection()*tileHeight, tileWidth, tileHeight ) );
        if(timer.isCool()){
            indexX++;
            if (indexX==tileX){
                indexX=0;
            }

        }

    }

    public void drawStable(){

        player.draw(location.x, location.y, new DrawOptions().setSection(0, direction.getDirection()*tileHeight, tileWidth, tileHeight ) );

    }

    public void update(Input input){

        if(input.isDown(Keys.D)){
            isMoving = true;
            direction = Direction.EAST;
            location = new Point(location.x+speed, location.y);
        }else if(input.isDown(Keys.A)){
            isMoving = true;
            direction = Direction.WEST;
            location = new Point(location.x-speed, location.y);
        }else if(input.isDown(Keys.W)){
            isMoving = true;
            direction = Direction.NORTH;
            location = new Point(location.x, location.y-speed);
        }else if(input.isDown(Keys.S)){
            isMoving = true;
            direction = Direction.SOUTH;
            location = new Point(location.x, location.y+speed);
        }else {

            isMoving = false;
        }

        if(input.isDown(Keys.LEFT_SHIFT)){
            speed = RUNNING_SPEED;
        }else {
            speed = DEFAULT_SPEED;
        }


        if(isMoving){
            drawMoving();
        }else {
            drawStable();
        }



    }



}
