
import java.awt.*;
import javax.swing.*;

/**
 * Class Runner - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class Runner extends JApplet
{
    private int x;
    public void init()
    {
        // this is a workaround for a security conflict with some browsers
        // including some versions of Netscape & Internet Explorer which do 
        // not allow access to the AWT system event queue which JApplets do 
        // on startup to check access. May not be necessary with your browser. 
        JRootPane rootPane = this.getRootPane();    
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);
    
        // provide any initialisation necessary for your JApplet
    }
    public void start()
    {
        
    }
    public void stop()
    {
        
    }
    public void paint(Graphics g)
    {
        // simple text displayed on applet
        g.setColor(Color.white);
        g.fillRect(0, 0, 200, 100);
        g.setColor(Color.black);
        g.drawString("Sample Applet", 20, 20);
        g.setColor(Color.blue);
        g.drawString("created by BlueJ", 20, 40);
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
}
