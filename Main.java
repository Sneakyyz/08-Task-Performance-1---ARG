public class Main {
    public static void main(String[] args) {
        Player player = new PlayerImpl();
        TextGame game = new TextGame(player);
        
        game.displayMenu();
        
        game.startPlaying();
    }
}