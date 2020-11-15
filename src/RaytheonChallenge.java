import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RaytheonChallenge {

    public static void main(String[] args) throws IOException, InvalidCommandException {
        System.out.println("Raytheon Challenge");
        RaytheonChallenge raytheonChallenge = new RaytheonChallenge();
        raytheonChallenge.setup();

    }

    public void setup() throws IOException, InvalidCommandException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        Position topRight = new Position(x,y);

        Plateau plateau = new Plateau(topRight);

        input = reader.readLine().split(" ");

        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);

        char direction = Character.toUpperCase(input[2].charAt(0));

        Robot robot = new Robot(new Position(x,y),direction);
        robot.displayPosition();

        String commands = reader.readLine().strip().toUpperCase();

        for (int i = 0; i < commands.length(); i++) {
            robot.command(commands.charAt(i));
        }

        robot.displayPosition();
    }
}
