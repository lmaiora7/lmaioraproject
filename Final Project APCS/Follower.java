
/**
 * This follower class creates a follower that wil actively follow a target. It uses a object map to decide where to
 * go next and how to get there.
 * 
 * @author Luke Maiorano 
 * @version 1.0
 */
public class Follower
{
    private ObjectMap currentMap;//the map in which it uses to decide its path
    private Point currentTarget=null;//the temporary target used to ultimately get to the finalTarget
    private Target finalTarget;
    private Point loc;//current location
    //these both are used to decide the angle of travel
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
    public void setTarget(int xx, int yy){finalTarget=new Target(xx,yy);}
    public void setTarget(Target tt){finalTarget=tt;}
    
    /**
     * This method scans whats the next step to getting to the finalTarget by making a new currentTarget.
     * The method begins by making a rough step by step process of getting to final target, from there it looks for
     * any of the points its marked that it can use to cut corners and arrive more efficiently. If no efficient 
     * travel method is found it will just use the original solution it created. If no possible way of arriving
     * at the final target is possible then it will set finalTarget to null and currentTarget to null as well.
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
        if(currentTarget==null || loc.distance(finalTarget.getPoint())<5){
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
