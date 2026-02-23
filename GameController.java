// Handles game lifecycle decisions
// This class is responsible for deciding whether game should restart or exit based on user choice
import java.util.*;
class GameController {
    // Asks player if they want to restart the game after completion
    // Returns true if game should restart
    // Returns false if application should exit
    public static boolean restartGame(Scanner sc){
        System.out.print("Do you want to play again?(Yes/No)");
        return sc.nextLine().equalsIgnoreCase("yes");
    }
}
