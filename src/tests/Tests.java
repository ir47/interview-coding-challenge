import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {


    //Create Position

    /**
     * Tests the creation of a position object
     */
    @Test
    public void createPosition() {
        Position position = new Position(10, 10);
        assertTrue(position instanceof Position);
    }


    //Check xcoord

    /**
     * Tests the x-coordinate value of the created position
     */
    @Test
    public void testXCoordinate() {
        Position position = new Position(10, 10);
        assertEquals(10, position.getXCoordinate());
    }


    //check ycoord

    /**
     * Tests the x-coordinate value of the created position
     */
    @Test
    public void testYCoordinate() {
        Position position = new Position(10, 10);
        assertEquals(10, position.getYCoordinate());

    }

    //check increase x

    /**
     * Tests the increasing of the x-coordinate value for a given position object
     */
    @Test
    public void testXIncrease() {
        Position position = new Position(10, 10);
        position.increaseX();
        assertEquals(11, position.getXCoordinate());
    }

    //check increased y

    /**
     * Tests the increasing of the y-coordinate value for a given position object
     */
    @Test
    public void testYIncrease() {
        Position position = new Position(10, 10);
        position.increaseY();
        assertEquals(11, position.getYCoordinate());
    }

    //check decrease x

    /**
     * Tests the decreasing of the x-coordinate value for a given position object
     */
    @Test
    public void testXDecrease() {
        Position position = new Position(10, 10);
        position.decreaseX();
        assertEquals(9, position.getXCoordinate());
    }

    //check decrease y

    /**
     * Tests the decreasing of the y-coordinate value for a given position object
     */
    @Test
    public void testYDecrease() {
        Position position = new Position(10, 10);
        position.decreaseY();
        assertEquals(9, position.getYCoordinate());
    }

    //create robot

    /**
     * Tests the creation of a robot object
     */
    @Test
    public void createRobot() throws InvalidFacingDirection {
        Robot robot = new Robot(new Position(0, 0), 'N', null);
        assertTrue(robot instanceof Robot);
    }

    //create plateau

    /**
     * Tests the creation of a plateau object
     */
    @Test
    public void createPlateau() {
        Plateau plateau = new Plateau(new Position(10, 10));
        assertTrue(plateau instanceof Plateau);
    }

    //check plateau coords

    /**
     * Tests the setting of the plateau object coordinates for the top right corner
     */
    @Test
    public void testPlateauTopRight() {
        Plateau plateau = new Plateau(new Position(9, 10));
        Position p = new Position(9, 10);
        assertEquals(p, plateau.getTopRight());
    }

    /**
     * Tests the setting of the plateau object coordinates for the bottom left corner
     */
    @Test
    public void testPlateauBottomLeft() {
        Plateau plateau = new Plateau(new Position(9, 10));
        Position p = new Position(0, 0);
        assertEquals(p, plateau.getBottomLeft());
    }


    //check robot coords

    /**
     * Tests the setting of the robot object coordinates for the initial robot placement
     */
    @Test
    public void testRobotCoords() throws InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 0), 'N', plateau);
        Position p = new Position(5, 0);
        assertEquals(robot.getCurrentPosition(), p);
    }

    //check robot facing direction

    /**
     * Tests the setting of the robot object facing direction for the initial robot placement
     */
    @Test
    public void testRobotFacingDirection() throws InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 0), 'N', plateau);
        assertEquals(robot.getFacingDirection(), RobotDirection.NORTH);
    }

    //check turning robot left

    /**
     * Tests the left turn functionality of the robot
     */
    @Test
    public void testRobotTurnLeft() throws OutOfPlateauException, InvalidCommandException, InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 0), 'N', plateau);
        robot.command('L');
        assertEquals(robot.getFacingDirection(), RobotDirection.WEST);
    }


    //check turning robot right

    /**
     * Tests the right turn functionality of the robot
     */
    @Test
    public void testRobotTurnRight() throws OutOfPlateauException, InvalidCommandException, InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 0), 'N', plateau);
        robot.command('R');
        assertEquals(robot.getFacingDirection(), RobotDirection.EAST);
    }

    //check moving robot

    /**
     * Tests move command facing north
     */
    @Test
    public void testRobotMoveNorth() throws OutOfPlateauException, InvalidCommandException, InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 0), 'N', plateau);
        robot.command('M');

        Position p = new Position(5, 1);
        assertEquals(robot.getCurrentPosition(), p);
    }

    /**
     * Tests move command facing east
     */
    @Test
    public void testRobotMoveEast() throws OutOfPlateauException, InvalidCommandException, InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 0), 'E', plateau);
        robot.command('M');

        Position p = new Position(6, 0);
        assertEquals(robot.getCurrentPosition(), p);
    }

    /**
     * Tests move command facing south
     */
    @Test
    public void testRobotMoveSouth() throws OutOfPlateauException, InvalidCommandException, InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 2), 'S', plateau);
        robot.command('M');

        Position p = new Position(5, 1);
        assertEquals(robot.getCurrentPosition(), p);
    }


    /**
     * Tests move command facing west
     */
    @Test
    public void testRobotMoveWest() throws OutOfPlateauException, InvalidCommandException, InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 0), 'W', plateau);
        robot.command('M');

        Position p = new Position(4, 0);
        assertEquals(robot.getCurrentPosition(), p);
    }


    //check out of bounds for all 4 directions

    /**
     * Tests moving out of bounds while moving north
     */
    @Test
    public void testOutOfBoundsNorth() throws OutOfPlateauException, InvalidCommandException {
        assertThrows(OutOfPlateauException.class, () -> {
            Plateau plateau = new Plateau(new Position(10, 10));
            Robot robot = new Robot(new Position(0, 10), 'N', plateau);
            robot.command('M');
        });
    }

    /**
     * Tests moving out of bounds while moving east
     */
    @Test
    public void testOutOfBoundsEast() {
        assertThrows(OutOfPlateauException.class, () -> {
            Plateau plateau = new Plateau(new Position(10, 10));
            Robot robot = new Robot(new Position(10, 0), 'E', plateau);
            robot.command('M');
        });
    }

    /**
     * Tests moving out of bounds while moving south
     */
    @Test
    public void testOutOfBoundsSouth() {
        assertThrows(OutOfPlateauException.class, () -> {
            Plateau plateau = new Plateau(new Position(10, 10));
            Robot robot = new Robot(new Position(0, 0), 'S', plateau);
            robot.command('M');
        });
    }

    /**
     * Tests moving out of bounds while moving west
     */
    @Test
    public void testOutOfBoundsWest() {
        assertThrows(OutOfPlateauException.class, () -> {
            Plateau plateau = new Plateau(new Position(10, 10));
            Robot robot = new Robot(new Position(0, 10), 'W', plateau);
            robot.command('M');
        });
    }
    //test invalid command

    /**
     * Tests passing the robot an invalid command
     */
    @Test
    public void testInvalidRobotCommand() {
        assertThrows(InvalidCommandException.class, () -> {
            Plateau plateau = new Plateau(new Position(10, 10));
            Robot robot = new Robot(new Position(0, 10), 'W', plateau);
            robot.command('K');
        });
    }

    //test invalid facing direction

    /**
     * Tests passing the robot an invalid facing direction
     */
    @Test
    public void testInvalidFacingDirection() {
        assertThrows(InvalidFacingDirection.class, () -> {
            Plateau plateau = new Plateau(new Position(10, 10));
            Robot robot = new Robot(new Position(0, 10), 'P', plateau);
        });
    }

}
