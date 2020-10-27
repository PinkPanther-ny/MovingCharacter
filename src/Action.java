public enum Action {
    STABLE  (0),
    ATTACK1 (1),
    ATTACK2 (2),
    ATTACK3 (3),
    HURT    (4),
    CLIMB   (5),
    DEATH   (6),
    JUMP    (7),
    PUSH    (8),
    RUN     (9),
    WALK    (10),
    IDLE    (11),
    CRAFT   (12)
    ;
    private final int shortCode;

    Action(int shortCode) {
        this.shortCode = shortCode;
    }

    public int getAction() {
        return this.shortCode;
    }
}
