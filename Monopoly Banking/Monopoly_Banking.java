import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.applet.Applet;
/**
 * Class Monopoly_Banking - a Java applet used to replace the standard method of banking in Monopoly
 * 
 * @author Nicholas Tudino
 * @version 2.0
 */
public class Monopoly_Banking extends Applet implements MouseListener, 
MouseWheelListener, ActionListener, MouseMotionListener
{
    // instance variables - replace the example below with your own
    private int x;
    public BufferedImage plus_minus;
    public BufferedImage transfer;
    public Logic l;
    int txmin;
    int txmax;
    int tymin;
    int tymax;
    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first 
     * time that the start method is called.
     */
    public void init()
    {
        // this is a workaround for a security conflict with some browsers
        // including some versions of Netscape & Internet Explorer which do 
        // not allow access to the AWT system event queue which JApplets do 
        // on startup to check access. May not be necessary with your browser. 
        
        try{
            plus_minus = ImageIO.read(new File
                ("plus-minus.jpg")); 
            transfer = ImageIO.read(new File   
                ("download.jfif"));
        }
        catch(IOException e){
            showStatus("Background not found in file");
        }
        l = new Logic();
        // provide any initialisation necessary for your JApplet
        addMouseWheelListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    /**
     * Called by the browser or applet viewer to inform this JApplet that it 
     * should start its execution. It is called after the init method and 
     * each time the JApplet is revisited in a Web page. 
     */
    public void start()
    {
        
    }

    /** 
     * Called by the browser or applet viewer to inform this JApplet that
     * it should stop its execution. It is called when the Web page that
     * contains this JApplet has been replaced by another page, and also
     * just before the JApplet is to be destroyed. 
     */
    public void stop()
    {
        // provide any code that needs to be run when page
        // is replaced by another page or before JApplet is destroyed 
    }

    /**
     * Paint method for applet.
     * 
     * @param  g   the Graphics object for this applet
     */
    public void paint(Graphics g)
    {
        Font courierBold20 = new Font("MS Reference Sans Serif", Font.BOLD, 20);
        g.setColor(Color.white);
        g.fillRect(0, 0, 200, 100);
        g.setColor(Color.black);
        g.setFont(courierBold20);
        int loc = 50;
        
        for(int i = 0; i < l.Players.length-1; i++){
            g.drawImage(plus_minus, 20, loc-23, this);
            g.drawString(l.Players[i] + ": $" + l.scores[i], 110, loc+5);
            loc = loc + 50;
        }
        g.drawString("Free Parking: $" + l.scores[l.scores.length-1], 20, loc+5);
        g.drawImage(transfer, 20, loc+20, this);
        txmin = 20;
        txmax = 260;
        tymin = loc+20;
        tymax = loc + 95;
    }

    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * is being reclaimed and that it should destroy any resources that it
     * has allocated. The stop method will always be called before destroy. 
     */
    public void destroy()
    {
        // provide code to be run when JApplet is about to be destroyed.
    }

    /**
     * Returns information about this applet. 
     * An applet should override this method to return a String containing 
     * information about the author, version, and copyright of the JApplet.
     *
     * @return a String representation of information about this JApplet
     */
    public String getAppletInfo()
    {
        // provide information about the applet
        return "Title:   \nAuthor:   \nA simple applet example description. ";
    }

    /**
     * Returns parameter information about this JApplet. 
     * Returns information about the parameters than are understood by this JApplet.
     * An applet should override this method to return an array of Strings 
     * describing these parameters. 
     * Each element of the array should be a set of three Strings containing 
     * the name, the type, and a description.
     *
     * @return a String[] representation of parameter information about this JApplet
     */
    public String[][] getParameterInfo()
    {
        // provide parameter information about the applet
        String paramInfo[][] = {
                {"firstParameter",    "1-10",    "description of first parameter"},
                {"status", "boolean", "description of second parameter"},
                {"images",   "url",     "description of third parameter"}
            };
        return paramInfo;
    }
    
    public void mouseClicked(MouseEvent e){
        int x=e.getX();
        int y=e.getY();
        showStatus("(" + x + ", " + y + ")");
        //addition button
        if(x>22 && x<53){
            //player 1
            if(y>28 && y<65)l.plus(0);
            //player 2
            if(l.scores.length > 1) if(y>80 && y<111)l.plus(1);
            //player 3
            if(l.scores.length > 2)if(y>129 && y<160)l.plus(2);
            //player 4
            if(l.scores.length > 3)if(y>179 && y<213)l.plus(3);
            //player 5
            if(l.scores.length > 4)if(y>228 && y<262)l.plus(4);
            //player 6
            if(l.scores.length > 5)if(y>279 && y<316)l.plus(5);
            //player 7
            if(l.scores.length > 6)if(y>326 && y<362)l.plus(6);
            //player 8
            if(l.scores.length > 7)if(y>381 && y<410)l.plus(7);
            //player 9
            if(l.scores.length > 8)if(y>430 && y<461)l.plus(8);
            //player 10
            if(l.scores.length > 9)if(y>478 && y<516)l.plus(9);
        }
        //subtraction button
        if(x>62 && x<95){
            //player 1
            if(y>28 && y<65)l.minus(0);
            //player 2
            if(l.scores.length > 1) if(y>80 && y<111)l.minus(1);
            //player 3
            if(l.scores.length > 2)if(y>129 && y<160)l.minus(2);
            //player 4
            if(l.scores.length > 3)if(y>179 && y<213)l.minus(3);
            //player 5
            if(l.scores.length > 4)if(y>228 && y<262)l.minus(4);
            //player 6
            if(l.scores.length > 5)if(y>279 && y<316)l.minus(5);
            //player 7
            if(l.scores.length > 6)if(y>326 && y<362)l.minus(6);
            //player 8
            if(l.scores.length > 7)if(y>381 && y<410)l.minus(7);
            //player 9
            if(l.scores.length > 8)if(y>430 && y<461)l.minus(8);
            //player 10
            if(l.scores.length > 9)if(y>478 && y<516)l.minus(9);
        }
        
        if(x > txmin && x<txmax){
            if(y>tymin && y<tymax){
                l.transfer();
            }
        }
        repaint();
    }
    
    public void mouseEntered(MouseEvent e){} 

    public void mouseExited(MouseEvent e){} 

    public void mousePressed(MouseEvent e){} 

    public void mouseReleased(MouseEvent e){} 

    public void mouseMoved(MouseEvent e){}
    
    public void mouseDragged(MouseEvent e ){} 

    public void actionPerformed(ActionEvent e){}

    public void mouseWheelMoved(MouseWheelEvent e){}
}
