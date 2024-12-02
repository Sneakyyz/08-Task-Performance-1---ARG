import java.util.Scanner;
public class TextGame implements Game {
    private Player player;
    private GameMode gameMode;
    private Scanner scanner;

    public TextGame(Player player) {
        this.player = player;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        player.enterName(name);
        
        int mode = 0;
        while (mode != 1 && mode != 2) {
            System.out.println("\nPress 1 or 2 to select your game mode.");
            System.out.println("1 - Story");
            System.out.println("2 - Survival");
            System.out.print("Enter your choice: ");
            
            if (scanner.hasNextInt()) {
                mode = scanner.nextInt();
                scanner.nextLine();
                
                if (mode != 1 && mode != 2) {
                    System.out.println("\nError: Invalid number! Please enter 1 or 2.");
                }
            } else {
                scanner.nextLine();
                System.out.println("\nError: Invalid input! Please enter a number (1 or 2).");
            }
        }
        selectMode(mode);
    }

    @Override
    public void selectMode(int mode) {
        if (mode == 1) {
            gameMode = new StoryMode(scanner);
            System.out.println("\nYou have selected Story mode.");
        } else if (mode == 2) {
            gameMode = new SurvivalMode(scanner);
            System.out.println("\nYou have selected Survival mode.");
        }
        System.out.println("Press P to start playing, " + player.getName() + ".");
    }

    @Override
    public void startPlaying() {
        String input = scanner.nextLine();
        
        while (!input.equalsIgnoreCase("P")) {
            System.out.println("Error: Invalid input. Please press P to start playing.");
            input = scanner.nextLine();
        }
        gameMode.startGame();
    }
}