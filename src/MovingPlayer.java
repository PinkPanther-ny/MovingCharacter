import bagel.*;
import bagel.util.Point;

public abstract class MovingPlayer {

    public static final double DEFAULT_SPEED = 2;
    public static final double RUNNING_SPEED = DEFAULT_SPEED*2;

    /**
     * Source image that contains all movements,
     * each row contains one whole process of a movement
     * */
    private Image player;

    /** Source image information */
    private final int tileWidth;
    private final int tileHeight;

    /** Number of rows and columns */
    private int tileX;
    private int tileY;

    /** Current processing image */
    private int indexX;
    private int indexY;

    /*  Frame Rate of character */
    private final Timer timer;

    private double speed = DEFAULT_SPEED;
    private Point location;

    MovingPlayer(int tileWidth, int tileHeight, String filePath, int tick){
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        indexX=0;
        indexY=0;
        timer = new Timer(tick);
        location = new Point(500,500);

        try {
            player = new Image(filePath);
            validateImage();
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

    /**
     * Not quite useful, animate the player by drawing every row and column,
     * but good for visualising whole image
     * */
    public void drawAll(){

        player.draw(location.x, location.y,
                new DrawOptions().setSection(indexX*tileWidth, indexY*tileHeight, tileWidth, tileHeight )
        );

        if(timer.isCool()){
            if (++indexX==tileX){
                indexX=0;
                indexY++;
            }
            if(indexY==tileY){
                indexY=0;
            }
        }

    }

    public void drawMoving(){
        drawAll();
    }

    public void update(Input input){
        drawMoving();
    }

    public Timer getTimer() {
        return timer;
    }

    public Image getPlayer() {
        return player;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public int getTileX() {
        return tileX;
    }

    public int getIndexX() {
        return indexX;
    }

    public void setIndexX(int indexX) {
        this.indexX = indexX;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
