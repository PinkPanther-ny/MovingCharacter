import bagel.*;
import bagel.util.Point;

public abstract class MovingPlayer {

    public static final double DEFAULT_SPEED = 2;
    public static final double RUNNING_SPEED = DEFAULT_SPEED*2;

    private Image player;
    private final int tileWidth;
    private final int tileHeight;

    private int tileX;
    private int tileY;
    private int indexX;
    private int indexY;

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
        }catch (BagelError e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        try {
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

    public void drawAll(){

        player.draw(location.x, location.y, new DrawOptions().setSection(indexX*tileWidth, indexY*tileHeight, tileWidth, tileHeight ) );
        if(timer.isCool()){
            //System.out.printf("%d,%d\n",indexX*tileWidth, indexY*tileHeight);
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
        drawAll();
    }

    public abstract void drawStable();

    public void update(Input input){
        drawMoving();
    }

    public Timer getTimer() {
        return timer;
    }

    public Image getPlayer() {
        return player;
    }

    public void setPlayer(Image player) {
        this.player = player;
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

    public void setTileX(int tileX) {
        this.tileX = tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
    }

    public int getIndexX() {
        return indexX;
    }

    public void setIndexX(int indexX) {
        this.indexX = indexX;
    }

    public int getIndexY() {
        return indexY;
    }

    public void setIndexY(int indexY) {
        this.indexY = indexY;
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
