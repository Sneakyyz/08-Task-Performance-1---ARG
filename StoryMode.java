import java.util.Scanner;
import java.util.InputMismatchException;

public class StoryMode implements GameMode {
    private Scanner scanner;

    public StoryMode(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void startGame() {
        System.out.println("\nYou wake up in your apartment and hear strange noises outside. You peek through the window and see zombies roaming the streets.");
        System.out.println("What do you do?");
        System.out.println("1. Investigate the hallway.");
        System.out.println("2. Stay inside and barricade the door.");
        System.out.print("Enter your choice: ");
        
        int choice = getChoice();
        
        if (choice == 1) {
            investigateHallway();
        } else if (choice == 2) {
            barricadeDoor();
        }
    }

    private void investigateHallway() {
        System.out.println("\nYou open the door, and a zombie lunges at you! Do you:");
        System.out.println("1. Fight the zombie with a broom.");
        System.out.println("2. Run back inside and lock the door.");
        System.out.print("Enter your choice: ");
        
        int choice = getChoice();
        
        if (choice == 1) {
            gameOver("You fought bravely but were overpowered.");
        } else if (choice == 2) {
            System.out.println("You ran back to your apartment, but the door was broken down.");
            gameOver("You were caught by the zombies.");
        }
    }

    private void barricadeDoor() {
        System.out.println("\nYou barricade yourself inside your apartment.");
        System.out.println("Do you:");
        System.out.println("1. Wait for help.");
        System.out.println("2. Try to escape through the window.");
        System.out.print("Enter your choice: ");
        
        int choice = getChoice();
        
        if (choice == 1) {
            gameOver("You waited too long, and the zombies broke in.");
        } else if (choice == 2) {
            escapeThroughWindow();
        }
    }

    private void escapeThroughWindow() {
        System.out.println("\nYou climb out the window, but the ground is swarming with zombies.");
        System.out.println("Do you:");
        System.out.println("1. Try to fight your way through.");
        System.out.println("2. Hide in a nearby alley.");
        System.out.print("Enter your choice: ");
        
        int choice = getChoice();
        
        if (choice == 1) {
            gameOver("You were overwhelmed by the zombies.");
        } else if (choice == 2) {
            System.out.println("You managed to hide, but now you must wait until the danger passes.");
            System.out.println("You survived another day!");
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