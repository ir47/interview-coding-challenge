public class Robot {


    private Position currentPosition;
    private RobotDirection facingDirection;
    private final Plateau plateau;

    public Robot(Position currentPosition, char facingDirection, Plateau plateau) throws InvalidFacingDirection {
        this.currentPosition = currentPosition;
        this.plateau = plateau;
        setDirection(facingDirection);

    }

    public void command(char command) throws InvalidCommandException, OutOfPlateauException, InvalidFacingDirection {
        switch (command) {
            case 'L' -> turnLeft();
            case 'R' -> turnRight();
            case 'M' -> move();
            default -> throw new InvalidCommandException();
        }
    }

    public void move() throws OutOfPlateauException {
        switch (facingDirection) {
            case NORTH -> this.currentPosition.increaseY();
            case EAST -> this.currentPosition.increaseX();
            case SOUTH -> this.currentPosition.decreaseY();
            case WEST -> this.currentPosition.decreaseX();
        }
        checkPosition();
    }

    private void checkPosition() throws OutOfPlateauException {
        switch (facingDirection) {
            case NORTH -> {
                if (currentPosition.yOutOfBounds(plateau.getTopRight())) throw new OutOfPlateauException();
            }
            case EAST -> {
                if (currentPosition.xOutOfBounds(plateau.getBottomRight())) throw new OutOfPlateauException();
            }
            case SOUTH -> {
                if (currentPosition.getYCoordinate() < 0) throw new OutOfPlateauException();
            }
            case WEST -> {
                if (currentPosition.getXCoordinate() < 0) throw new OutOfPlateauException();
            }
        }
    }

    public void turnRight() throws InvalidFacingDirection {
        switch (facingDirection) {
            case NORTH -> setDirection('E');
            case EAST -> setDirection('S');
            case SOUTH -> setDirection('W');
            case WEST -> setDirection('N');
        }
    }

    public void turnLeft() throws InvalidFacingDirection {
        switch (facingDirection) {
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

    public void displayPosition() {
        System.out.println(this.currentPosition.toString() + " " + facingDirection);
    }

    public void setDirection(char input) throws InvalidFacingDirection {
        this.facingDirection = switch (input) {
            case 'N' -> RobotDirection.NORTH;
            case 'E' -> RobotDirection.EAST;
            case 'S' -> RobotDirection.SOUTH;
            case 'W' -> RobotDirection.WEST;
            default -> throw new InvalidFacingDirection();
        };
    }
}
