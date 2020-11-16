/**
 * Robot Class which holds the specific robot attributes and functions
 */

public class Robot {

    //Robots current position stored in a Position object
    private Position currentPosition;

    //Robots current facing direction
    private RobotDirection facingDirection;

    //Plateau which the robot is currently exploring
    private final Plateau plateau;


    /**
     * Constructor for robot class
     *
     * @param currentPosition takes in the starting position object of the robot
     * @param facingDirection takes in the starting facing direction of the robot as a char value
     * @param plateau         takes in the Plateau object of the plateau the robot is to explore
     * @throws InvalidFacingDirection can throw InvalidFacingDirection if invalid facing direction is passed in
     */
    public Robot(Position currentPosition, char facingDirection, Plateau plateau) throws InvalidFacingDirection {
        this.currentPosition = currentPosition;
        this.plateau = plateau;
        setDirection(facingDirection);

    }

    /**
     * Function to read the incoming command for the robot and complete the correct corresponding action
     *
     * @param command takes in the command the robot is to complete
     * @throws InvalidCommandException can throw InvalidCommandException if an invalid command is passed in
     * @throws OutOfPlateauException   can throw OutOfPlateauException if the bounds of the plateau are exceeded
     * @throws InvalidFacingDirection  can throw InvalidFacingDirection if an invalid facing direction is passed in
     */
    public void command(char command) throws InvalidCommandException, OutOfPlateauException, InvalidFacingDirection {
        switch (command) {
            case 'L' -> turnLeft();
            case 'R' -> turnRight();
            case 'M' -> move();
            default -> throw new InvalidCommandException();
        }
    }

    /**
     * Move function for the robot, moves the robot 1 point in its currently facing direction
     *
     * @throws OutOfPlateauException can throw OutOfPlateauException if the bounds of the plateau are exceeded
     */
    public void move() throws OutOfPlateauException {
        switch (facingDirection) {
            case NORTH -> this.currentPosition.increaseY();
            case EAST -> this.currentPosition.increaseX();
            case SOUTH -> this.currentPosition.decreaseY();
            case WEST -> this.currentPosition.decreaseX();
        }
        checkPosition();
    }

    /**
     * Checks the current position of the robot, to check if the bounds of the plateau have been exceeded
     *
     * @throws OutOfPlateauException can throw OutOfPlateauException if the bounds of the plateau are exceeded
     */
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

    /**
     * Sets the new facing direction for the robot after a right turn command
     *
     * @throws InvalidFacingDirection can throw InvalidFacingDirection if an invalid facing direction is passed in
     */
    public void turnRight() throws InvalidFacingDirection {
        switch (facingDirection) {
            case NORTH -> setDirection('E');
            case EAST -> setDirection('S');
            case SOUTH -> setDirection('W');
            case WEST -> setDirection('N');
        }
    }

    /**
     * Sets the new facing direction for the robot after a left turn command
     *
     * @throws InvalidFacingDirection can throw InvalidFacingDirection if an invalid facing direction is passed in
     */
    public void turnLeft() throws InvalidFacingDirection {
        switch (facingDirection) {
            case NORTH -> setDirection('W');
            case EAST -> setDirection('N');
            case SOUTH -> setDirection('E');
            case WEST -> setDirection('S');
        }
    }

    /**
     * Gets the current robot position object
     *
     * @return returns the current position object for the robot
     */
    public Position getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Gets the current facing direction for the robot
     *
     * @return returns the current robots facing direction
     */
    public RobotDirection getFacingDirection() {
        return facingDirection;
    }


    /**
     * Displays the current coordinate points and facing direction for the robot
     */
    public void displayPosition() {
        System.out.println(this.currentPosition.toString() + " " + facingDirection);
    }

    /**
     * Sets the robots current facing direction based on the initial input
     *
     * @param input takes in the initial facing diection of the robot
     * @throws InvalidFacingDirection can throw InvalidFacingDirection if an invalid facing direction is passed in
     */
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
