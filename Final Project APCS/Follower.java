
/**
 * This follower class creates a follower that wil actively follow a target. It uses a object map to decide where to
 * go next and how to get there.
 * 
 * @author Luke Maiorano 
 * @version 1.0
 */
import java.util.ArrayList;
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
        ArrayList<Point> trackPoints=new ArrayList<Point>();
        Point temp=loc;
        Point ir=finalTarget.getPoint();
        int tempm,tempb;
        Object o=null;
        while(temp.distance(finalTarget.getPoint())>5){//it's possible that the value 5, is too specific!
            tempm=(ir.ycord()-temp.ycord())/(ir.xcord()-temp.xcord());
            tempb=temp.ycord()/(temp.xcord()*tempm);
            if(temp.distance(ir)>5 && currentMap.inObject(temp.xcord(),temp.ycord())==null){
                if(ir.xcord()>temp.xcord()){
                    temp.xadd(1);
                    temp.yset((int)(tempm*temp.xcord()+tempb));
                }
                else if(ir.xcord()<temp.xcord()){
                    temp.xadd(-1);
                    temp.yset((int)(tempm*temp.xcord()+tempb));
                }
                else{
                    if(ir.ycord()>temp.ycord()){
                        temp.yadd(1);
                    }
                    else if(ir.ycord()<temp.ycord()){
                        temp.yadd(-1);
                    }
                }
            }
            else{
                o=currentMap.inObject(temp.xcord(),temp.ycord());
                trackPoints.add(o.closestPoint(temp));
                if(/*direct way to final target*/){
                    ir=finalTarget.getPoint();
                }
                else{
                    ir=o.rotate();
                }
            }
        }
    }

    /**
     * This method takes the currentTarget and loc to create a equation for getting to the currentTarget
     */
    public void findNextDirection(){
        m=(currentTarget.ycord()-loc.ycord())/(currentTarget.xcord()-loc.xcord());
        b=loc.ycord()/(loc.xcord()*m);
    }

    /**
     * This method uses the followers current location and the given parameters to figure out if there is a direct
     * path between the two. The collision it checks is the ObjectMap initialized under currentMap.
     */
    private boolean checkCollision(int xx,int yy){
        boolean tf=false;
        int tempx=xx,tempy=yy,tempm=((yy-loc.ycord())/(xx-loc.xcord())),tempb=tempy/(tempm*tempx);
        while(tempx!=loc.xcord()){
            if(tf=true)
                tempx=loc.xcord();
            else if(tempx>loc.xcord()){
                tempx--;
                tempy=tempx*tempm+tempb;
                tf=currentMap.isInside(tempx,tempy);
            }
            else if(tempx<loc.xcord()){
                tempx++;
                tempy=tempx*tempm+tempb;
                tf=currentMap.isInside(tempx,tempy);
            }
        }
        return tf;
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
