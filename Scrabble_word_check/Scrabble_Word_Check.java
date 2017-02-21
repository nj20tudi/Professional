import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
/**
 * Write a description of class Scrabble_Word_Check here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scrabble_Word_Check
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Scrabble_Word_Check
     */
    public Scrabble_Word_Check()
    {
    }

    public static void main(String args[]){
        boolean done = false;
        while(done == false){
            System.out.print("Enter word to check: ");
            Scanner scanner = new Scanner(System.in);
            String check = scanner.nextLine().toUpperCase();
            boolean isWord = false;
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"));
                String line;
                while (((line = reader.readLine()) != null)&& (isWord == false))
                {
                    if(line.equals(check))isWord = true;
                }
                reader.close();
            }
            catch (Exception e){}
            if(isWord)System.out.println("Valid");
            else System.out.println("Invalid");
            System.out.println();
            System.out.print("Continue? (yes/no): ");
            String ans = scanner.nextLine().toLowerCase();
            if(ans.equals("no"))done=true;
            System.out.println();
            
        }
        
    }
}
