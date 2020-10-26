public enum Direction {
    SOUTH (0),
    WEST (1),
    EAST (2),
    NORTH (3)
    ;
    private final int shortCode;

    Direction(int shortCode) {
        this.shortCode = shortCode;
    }

    public int getDirection() {
        return this.shortCode;
    }
}
