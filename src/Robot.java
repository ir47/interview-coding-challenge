public class Robot {


    private Position currentPosition;
    private RobotDirection facingDirection;

    public Robot(Position currentPosition, char facingDirection) {
        this.currentPosition = currentPosition;
        setDirection(facingDirection);
    }

    public void command(char command) throws InvalidCommandException {
        switch (command) {
            case 'L' -> turnLeft();
            case 'R' -> turnRight();
            case 'M' -> move();
            default -> throw new InvalidCommandException();
        }
    }

    public void move(){
        switch (facingDirection){
            case NORTH -> this.currentPosition.increaseY();
            case EAST -> this.currentPosition.increaseX();
            case SOUTH -> this.currentPosition.decreaseY();
            case WEST -> this.currentPosition.decreaseX();
        }
    }

    public void turnRight(){
        switch (facingDirection){
            case NORTH -> setDirection('E');
            case EAST -> setDirection('S');
            case SOUTH -> setDirection('W');
            case WEST -> setDirection('N');
        }
    }

    public void turnLeft(){
        switch (facingDirection){
            case NORTH -> setDirection('W');
            case EAST -> setDirection('N');
            case SOUTH -> setDirection('E');
            case WEST -> setDirection('S');
        }
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public RobotDirection getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(RobotDirection facingDirection) {
        this.facingDirection = facingDirection;
    }

    public void displayPosition(){
        System.out.println(this.currentPosition.toString() + " " +facingDirection);
    }

    public void setDirection(char input) {
         this.facingDirection = switch (input) {
            case 'N' -> RobotDirection.NORTH;
            case 'E' -> RobotDirection.EAST;
            case 'S' -> RobotDirection.SOUTH;
            case 'W' -> RobotDirection.WEST;
            default -> null;
        };
    }
}
