package package1;
import java.io.File;
import java.io.IOException;

public class FH1 {

    public static void main(String[] args) {
        
        try {
            File myobj = new File("F1.txt");
            
            if (myobj.createNewFile()) {
                System.out.println("File created: " + myobj.getName());
            } else {
                System.out.println("File already exists: " + myobj.getName());
            }
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}