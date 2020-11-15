
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {


//    @BeforeAll
//    public void setup() throws OutOfPlateauException, IOException, InvalidCommandException {
//        RaytheonChallenge challenge = new RaytheonChallenge();
//        challenge.setup();
//    }


    //Create Position

    @Test
    public void createPosition() {
        Position position = new Position(10,10);
        assertTrue(position instanceof Position);
    }


    //Check xcoord

    @Test
    public void testXCoordinate() {
        Position position = new Position(10,10);
        assertEquals(10,position.getXCoordinate());
    }


    //check ycoord

    @Test
    public void testYCoordinate() {
        Position position = new Position(10,10);
        assertEquals(10,position.getYCoordinate());

    }

    //check increase x

    @Test
    public void testXIncrease() {
        Position position = new Position(10,10);
        position.increaseX();
        assertEquals(11,position.getXCoordinate());
    }

    //check increased y

    @Test
    public void testYIncrease() {
        Position position = new Position(10,10);
        position.increaseY();
        assertEquals(11,position.getYCoordinate());
    }

    //check decrease x

    @Test
    public void testXDecrease() {
        Position position = new Position(10,10);
        position.decreaseX();
        assertEquals(9,position.getXCoordinate());
    }

    //check decrease y

    @Test
    public void testYDecrease() {
        Position position = new Position(10,10);
        position.decreaseY();
        assertEquals(9,position.getYCoordinate());
    }

    //create robot
    @Test
    public void createRobot() throws InvalidFacingDirection {
        Robot robot = new Robot(new Position(0,0), 'N',null);
        assertTrue(robot instanceof Robot);
    }

    //create plateau
    @Test
    public void createPlateau() {
        Plateau plateau = new Plateau(new Position(10,10));
        assertTrue(plateau instanceof Plateau);
    }
    //check plateau coords
    @Test
    public void testPlateauTopRight() {
        Plateau plateau = new Plateau(new Position(9,10));
        Position p = new Position(9,10);
        assertEquals(p, plateau.getTopRight());
    }

    @Test
    public void testPlateauBottomLeft() {
        Plateau plateau = new Plateau(new Position(9,10));
        Position p = new Position(0,0);
        assertEquals(p, plateau.getBottomLeft());
    }


//    @BeforeAll
//    static void testDetails() {
//        Plateau plateau = new Plateau(new Position(9,10));
//        Robot robot = new Robot(new Position(0,0), 'N',null);
//    }

    //check robot coords
    @Test
    public void testRobotCoords() throws InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 0), 'N', plateau);
        Position p = new Position(5,0);
        assertEquals(robot.getCurrentPosition(),p);
    }
    //check robot facing direction
    @Test
    public void testRobotFacingDirection() throws InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 0), 'N', plateau);
        assertEquals(robot.getFacingDirection(),RobotDirection.NORTH);
    }
    //check turning robot left
    @Test
    public void testRobotTurnLeft() throws OutOfPlateauException, InvalidCommandException, InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 0), 'N', plateau);
        robot.command('L');
        assertEquals(robot.getFacingDirection(),RobotDirection.WEST);
    }


    //check turning robot right
    @Test
    public void testRobotTurnRight() throws OutOfPlateauException, InvalidCommandException, InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 0), 'N', plateau);
        robot.command('R');
        assertEquals(robot.getFacingDirection(),RobotDirection.EAST);
    }
    //check moving robot
    @Test
    public void testRobotMoveNorth() throws OutOfPlateauException, InvalidCommandException, InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 0), 'N', plateau);
        robot.command('M');

        Position p = new Position(5,1);
        assertEquals(robot.getCurrentPosition(),p);
    }

    @Test
    public void testRobotMoveEast() throws OutOfPlateauException, InvalidCommandException, InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 0), 'E', plateau);
        robot.command('M');

        Position p = new Position(6,0);
        assertEquals(robot.getCurrentPosition(),p);
    }

    @Test
    public void testRobotMoveSouth() throws OutOfPlateauException, InvalidCommandException, InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 2), 'S', plateau);
        robot.command('M');

        Position p = new Position(5,1);
        assertEquals(robot.getCurrentPosition(),p);
    }


    @Test
    public void testRobotMoveWest() throws OutOfPlateauException, InvalidCommandException, InvalidFacingDirection {
        Plateau plateau = new Plateau(new Position(9, 10));
        Robot robot = new Robot(new Position(5, 0), 'W', plateau);
        robot.command('M');

        Position p = new Position(4,0);
        assertEquals(robot.getCurrentPosition(),p);
    }


    //check out of bounds for all 4 directions
    @Test
    public void testOutOfBoundsNorth() throws OutOfPlateauException, InvalidCommandException {
        assertThrows(OutOfPlateauException.class, () -> {
            Plateau plateau = new Plateau(new Position(10, 10));
            Robot robot = new Robot(new Position(0, 10), 'N', plateau);
            robot.command('M');
        });
    }

    @Test
    public void testOutOfBoundsEast() {
        assertThrows(OutOfPlateauException.class, () -> {
            Plateau plateau = new Plateau(new Position(10, 10));
            Robot robot = new Robot(new Position(10, 0), 'E', plateau);
            robot.command('M');
        });
    }

    @Test
    public void testOutOfBoundsSouth() {
        assertThrows(OutOfPlateauException.class, () -> {
            Plateau plateau = new Plateau(new Position(10, 10));
            Robot robot = new Robot(new Position(0, 0), 'S', plateau);
            robot.command('M');
        });
    }

    @Test
    public void testOutOfBoundsWest() {
        assertThrows(OutOfPlateauException.class, () -> {
            Plateau plateau = new Plateau(new Position(10, 10));
            Robot robot = new Robot(new Position(0, 10), 'W', plateau);
            robot.command('M');
        });
    }
    //test invalid command

    @Test
    public void testInvalidRobotCommand() {
        assertThrows(InvalidCommandException.class, () -> {
            Plateau plateau = new Plateau(new Position(10, 10));
            Robot robot = new Robot(new Position(0, 10), 'W', plateau);
            robot.command('K');
        });
    }

    //test invalid coords

//    @Test
//    public void testInvalidCoordinates() {
//        assertThrows(AssertionFailedError.class, () -> {
//            Plateau plateau = new Plateau(new Position(10, 10));
//            Robot robot = new Robot(new Position(Integer.parseInt("hello there"), 10), 'W', plateau);
//        });
//    }

    //test non number coords

    @Test
    public void testNonNumberCoordinates() {

    }

    //test invalid facing direction

    @Test
    public void testInvalidFacingDirection() {
        assertThrows(InvalidFacingDirection.class, () -> {
            Plateau plateau = new Plateau(new Position(10, 10));
            Robot robot = new Robot(new Position(0, 10), 'P', plateau);
        });
    }

}
