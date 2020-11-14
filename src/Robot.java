public class Robot {


    private Position currentPosition;
    private RobotDirection facingDirection;

    public Robot(Position currentPosition, char facingDirection) {
        this.currentPosition = currentPosition;
        setDirection(facingDirection);
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
