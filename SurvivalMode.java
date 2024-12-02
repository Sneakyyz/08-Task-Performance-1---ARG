import java.util.Scanner;
import java.util.InputMismatchException;

public class SurvivalMode implements GameMode {
    private Scanner scanner;

    public SurvivalMode(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void startGame() {
        System.out.println("\nYou wake up in a cabin. Zombies roam the world outside.");
        System.out.println("What do you do?");
        System.out.println("1. Look for weapons.");
        System.out.println("2. Barricade the cabin.");
        System.out.print("Enter your choice: ");
        
        int choice = getChoice();
        
        if (choice == 1) {
            searchForWeapons();
        } else if (choice == 2) {
            barricadeCabin();
        }
    }

    private void searchForWeapons() {
        System.out.println("\nYou find a shotgun, but zombies burst in!");
        System.out.println("Do you:");
        System.out.println("1. Fight.");
        System.out.println("2. Escape out the back.");
        System.out.print("Enter your choice: ");
        
        int choice = getChoice();
        
        if (choice == 1) {
            fightZombies();
        } else if (choice == 2) {
            escapeCabin();
        }
    }
    
    private void barricadeCabin() {
        System.out.println("\nYou barricade the cabin, but zombies break through the windows.");
        System.out.println("Do you:");
        System.out.println("1. Fight the zombies.");
        System.out.println("2. Escape out the back.");
        System.out.print("Enter your choice: ");
        int choice = getChoice();
        
        if (choice == 1) {
            fightZombies();
        } else if (choice == 2) {
            escapeCabin();
        }
    }

    private void fightZombies() {
        System.out.println("\nYou shoot the zombies, but they keep coming.");
        System.out.println("Do you:");
        System.out.println("1. Fight more.");
        System.out.println("2. Find a way out.");
        System.out.print("Enter your choice: ");
        int choice = getChoice();
        
        if (choice == 1) {
            gameOver("You fought bravely, but the zombies overwhelmed you!");
        } else if (choice == 2) {
            escapeCabin();
        }
    }

    private void escapeCabin() {
        System.out.println("\nYou run into the woods and find a vehicle.");
        System.out.println("Do you:");
        System.out.println("1. Drive.");
        System.out.println("2. Keep running.");
        System.out.print("Enter your choice: ");
        int choice = getChoice();
        
        if (choice == 1) {
            driveCar();
        } else if (choice == 2) {
            gameOver("You ran for hours but got caught by zombies.");
        }
    }

    private void driveCar() {
        System.out.println("\nYou manage to outrun some zombies, but the road is blocked.");
        System.out.println("Do you:");
        System.out.println("1. Try to move the vehicle.");
        System.out.println("2. Explore the area on foot.");
        System.out.print("Enter your choice: ");
        int choice = getChoice();
        
        if (choice == 1) {
            gameOver("The noise attracted more zombies.");
        } else if (choice == 2) {
            findSurvivors();
        }
    }

    private void findSurvivors() {
        System.out.println("\nYou find a camp of survivors who offer shelter.");
        System.out.println("Do you:");
        System.out.println("1. Stay with them.");
        System.out.println("2. Go alone.");
        System.out.print("Enter your choice: ");
        int choice = getChoice();
        
        if (choice == 1) {
            System.out.println("\nYou survive the apocalypse with the survivors.");
            System.out.println("Congratulations!");
        } else if (choice == 2) {
            gameOver("You decided to go solo and the zombies caught up.");
        }
    }

    private void gameOver(String message) {
        System.out.println("\n" + message);
        System.out.println("You Died.");
        System.out.println("Game Over.");
    }

    private int getChoice() {
        int choice = -1;
        boolean valid = false;
        
        while (!valid) {
            try {
                choice = scanner.nextInt();
                valid = choice == 1 || choice == 2;
                if (!valid) {
                    System.out.println("\nInvalid choice! Please choose 1 or 2.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("\nInvalid input. Please enter a number.");
            }
        }
        return choice;
    }
}