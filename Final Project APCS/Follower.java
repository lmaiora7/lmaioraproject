
/**
 * Write a description of class Follower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Follower
{
    private Point currentTarget;
    private ObjectMap currentMap;
    private Point loc;
    public Follower(int xint,int yint,ObjectMap o)
    {
        loc=new Point(xint,yint);
        currentMap=o;
    }
    
    public void setTarget(int xx, int yy){currentTarget=new Point(xx,yy);}
    
    /**
     * This method updates the follower, by consectutively calling this it will move to its objective
     */
    public void update(){
        
    }
}
