import java.util.ArrayList;
import java.util.Scanner; 
import javax.swing.JOptionPane; 
/**
 * The logic for the Monopoly Scoreboard
 * 
 * @author Nicholas Tudino 
 * @version 2.0
 */
public class Logic
{
    String Players[];
    int scores[];
    /**
     * Constructor for objects of class Logic
     * 
     * Prompts user for number of players, their names, and the starting amount
     */
    public Logic()
    {
        String players = JOptionPane.showInputDialog("Please enter number of players (max 8): ");
        int p = Integer.parseInt(players);
        if(p > 8)p=8;
        scores = new int[p+1];
        Players = new String[p+1];
        for(int i = 0; i < p; i++){
            String temp = JOptionPane.showInputDialog("Please enter name of player " + (i+1) + ": ");
            Players[i] = temp;
        }
        Players[p] = "Free Parking";

        String score = JOptionPane.showInputDialog("Please enter starting amount (1500 is standard): ");
        int s = Integer.parseInt(score);
        for(int i = 0; i < scores.length-1; i++){
            scores[i] = s;
        }
        scores[scores.length-1] = 0;
    }

    /**
     * Increases a player's score by an amount input by the user
     * 
     * @param player - the player whose score is being increased
     */
    public void plus(int player)
    {
        String a = JOptionPane.showInputDialog("Increase by: ");
        int add = Integer.parseInt(a);
        scores[player] = scores[player] + add;
    }
    
    /**
     * Decreases a player's score by an amount input by the user
     * 
     * @param player - the player whose score is being decreased
     */
    public void minus(int player)
    {
        String a = JOptionPane.showInputDialog("Decrease by: ");
        int sub = Integer.parseInt(a);
        scores[player] = scores[player] - sub;
    }

    /**
     * Transfers an amount input by the user from one user's score to the other's
     */
    public void transfer(){
        String r = (String) JOptionPane.showInputDialog(null, "Choose Player Receiving Money",
                "Money Transfer", JOptionPane.QUESTION_MESSAGE, null, 
                Players, // Array of players
                Players[0]); // Initial choice

        String g = (String) JOptionPane.showInputDialog(null, "Choose Player Losing Money",
                "Money Transfer", JOptionPane.QUESTION_MESSAGE, null, 
                Players, // Array of players
                Players[0]); // Initial choice
        int rec=0;
        int giv=0;
        for(int i = 0; i < Players.length; i++){
            if(Players[i].equals(r)) rec = i;
            if(Players[i].equals(g)) giv = i;
        }
        
        String amount = JOptionPane.showInputDialog("Please enter amount being transfered: ");
        int amt = Integer.parseInt(amount);
        
        scores[rec] = scores[rec] + amt;
        scores[giv] = scores[giv] - amt;
    }

}
