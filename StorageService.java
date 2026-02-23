// Use Case-5: Game Result Storage
// This class is responsible for persisting final game result after game ends
// Results are stored in a file so that game history is not lost after exit
import java.io.*;
class StorageService {
    // Saves final outcome of game
    // Each record contains player name, number of attempts and the result
    public static void saveResult(String player,int attempts,boolean win){
        //Try-with-resources ensures that the writer is closed automatically after the operation completes
        try(BufferedWriter writer=new BufferedWriter(new FileWriter( "game_results.txt",true))){
            writer.write("Player:"+player+ " , Attempts: "+attempts+" ,Result: "+(win?"WIN":"LOOSE"));
            writer.newLine();
        }
        catch(IOException e){
            System.out.println("Unable to save the result.");
        }
    }
}
