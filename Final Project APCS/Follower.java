
/**
 * Write a description of class Follower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Follower
{
    private ObjectMap currentMap;
    private Point currentTarget=null;
    private Point finalTarget;
    private Point loc;
    private double m;
    private double b;
    public Follower(int xint,int yint,ObjectMap o)
    {
        loc=new Point(xint,yint);
        currentMap=o;
    }
    
    /**
     * This method changes the main target manually
     */
    public void setTarget(int xx, int yy){finalTarget=new Point(xx,yy);}
    
    /**
     * This method scans whats the next step to getting to the finalTarget by making a new currentTarget
     */
    public void findNextTarget(){
        //needs to be added, uses currentMap to scan the area and decide the best solution.
    }
    
    /**
     * This method takes the currentTarget and loc to create a equation for getting to the currentTarget
     */
    public void findNextDirection(){
        m=(currentTarget.ycord()-loc.ycord())/(currentTarget.xcord()-loc.xcord());
        b=loc.ycord()/(loc.xcord()*m);
    }
    
    /**
     * This method updates the follower, by consectutively calling this it will move to its objective
     */
    public void update(){
        if(currentTarget==null || loc.distance(finalTarget)<5){
            //do nothing due to having no target or are currently at the final destination
        }
        else if(loc.distance(currentTarget)<5){
            findNextTarget();
            findNextDirection();
        }
        else{
            if(currentTarget.xcord()>loc.xcord()){
                loc.xadd(1);
                loc.yset((int)(m*loc.xcord()+b));
            }
            else if(currentTarget.xcord()<loc.xcord()){
                loc.xadd(-1);
                loc.yset((int)(m*loc.xcord()+b));
            }
            else{
                if(currentTarget.ycord()>loc.ycord()){
                    loc.yadd(1);
                }
                else if(currentTarget.ycord()<loc.ycord()){
                    loc.yadd(-1);
                }
            }
        }
    }
    
    /**
     * This method draws the follower to the screen
     */
    public void draw(){
        
    }
}
