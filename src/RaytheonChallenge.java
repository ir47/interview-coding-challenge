import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RaytheonChallenge {

    public static void main(String[] args) throws IOException, InvalidCommandException, OutOfPlateauException, InvalidFacingDirection {
        System.out.println("Raytheon Challenge");
        RaytheonChallenge raytheonChallenge = new RaytheonChallenge();
        raytheonChallenge.setup();

    }

    public void setup() throws IOException, InvalidCommandException, OutOfPlateauException, InvalidFacingDirection {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nEnter Plateau top right corner as X Y");

        String[] input = reader.readLine().split(" ");

        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        Position topRight = new Position(x, y);

        Plateau plateau = new Plateau(topRight);

        System.out.println("\nEnter Robot details as X Y Facing Direction(N,S,E,W)");

        input = reader.readLine().split(" ");

        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);

        char direction = Character.toUpperCase(input[2].charAt(0));

        Robot robot = new Robot(new Position(x, y), direction, plateau);

        System.out.println("\nRobot Placed at:");
        robot.displayPosition();

        System.out.println("\nEnter Robot commands(L, R, M)");

        String commands = reader.readLine().replaceAll(" ", "").strip().toUpperCase();


        for (int i = 0; i < commands.length(); i++) {
            robot.command(commands.charAt(i));
        }

        System.out.println("\nRobot Final Position: ");
        robot.displayPosition();
    }
}
