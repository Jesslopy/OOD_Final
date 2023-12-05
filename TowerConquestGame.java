import java.util.Scanner;

public class TowerConquestGame {
    private GameState gameState;

    public TowerConquestGame() {
        gameState = new GameState();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to Tower Conquest!");
        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting game...");
                break;
            }

            // Process other commands here
        }
    }

    public static void main(String[] args) {
        TowerConquestGame game = new TowerConquestGame();
        game.startGame();
    }
}