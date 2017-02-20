import java.util.ArrayList;
import java.util.Scanner; 
import javax.swing.JOptionPane; 
/**
 * Write a description of class Logic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Logic
{
    ArrayList<String> Players = new ArrayList<>();
    int scores[];
    /**
     * Constructor for objects of class Logic
     */
    public Logic()
    {
        String players = JOptionPane.showInputDialog("Please enter number of players (max 10): ");
        int p = Integer.parseInt(players);
        if(p > 10)p=10;
        scores = new int[p];
        for(int i = 0; i < p; i++){
            String temp = JOptionPane.showInputDialog("Please enter name of player " + (i+1) + ": ");
            Players.add(temp);
        }

        String score = JOptionPane.showInputDialog("Please enter starting score: ");
        int s = Integer.parseInt(score);
        for(int i = 0; i < scores.length; i++){
            scores[i] = s;
        }
    }

    public void plus(int player)
    {
        String a = JOptionPane.showInputDialog("Increase by: ");
        int add = Integer.parseInt(a);
        scores[player] = scores[player] + add;
    }

    public void minus(int player)
    {
        String a = JOptionPane.showInputDialog("Decrease by: ");
        int sub = Integer.parseInt(a);
        scores[player] = scores[player] - sub;
    }

}
