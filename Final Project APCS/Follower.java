
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
    private ArrayList<Point> tracer;
    private int tracerInc;
    private boolean targetChange=true;
    private Point loc;//current location
    //these both are used to decide the angle of travel
    private double m;
    private double b;
    public Follower(int xint,int yint,ObjectMap o)
    {
        loc=new Point(xint,yint);
        currentMap=o;
    }
    public Follower(int xint,int yint,Target tt,ObjectMap o)
    {
        loc=new Point(xint,yint);
        finalTarget=tt;
        currentMap=o;
    }
    public Point getLocation(){return loc;}
    public void setTracerTemporary(ArrayList<Point> p){tracer=p;}//for testing purposes only
    /**
     * This method changes the main target manually
     */
    public void setTarget(int xx, int yy){finalTarget=new Target(xx,yy);targetChange=true;}
    public void setTarget(Target tt){finalTarget=tt;targetChange=true;}
    /**
     * This method scans whats the next step to getting to the finalTarget by making a new currentTarget.
     * The method begins by making a rough step by step process of getting to final target, from there it looks for
     * any of the points its marked that it can use to cut corners and arrive more efficiently. If no efficient 
     * travel method is found it will just use the original solution it created. If no possible way of arriving
     * at the final target is possible then it will set finalTarget to null and currentTarget to null as well.
     * 
     * UPDATE this now creates a arrayList that stores the set of point for it to follow
     */
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>THIS METHOD DOES NOT WORK AS INTENDED, or at all I think<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    private void findNextTarget(){
        ArrayList<Point> trackPoints=new ArrayList<Point>();
        Point temp=loc;
        Point ir=finalTarget.getPoint();
        double tempm,tempb;
        Object o=null;
        while(temp.distance(finalTarget.getPoint())>10){//it's possible that the value 5, is too specific!
            tempm=(ir.ycord()-temp.ycord())/(ir.xcord()-temp.xcord());
            tempb=temp.ycord()/(temp.xcord()*tempm);
            if(temp.distance(ir)>5 && currentMap.isInside(temp.xcord(),temp.ycord())==false){
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
                if(currentMap.isInside(temp.xcord(),temp.ycord())){
                    o=currentMap.inObject(temp.xcord(),temp.ycord());
                }
                if(o==null){
                    currentMap.getClosestObject(temp);
                }
                trackPoints.add(o.closest(temp));
                if(ir!=o.closest(temp)){
                    ir=o.closest(temp);
                }
                if(checkCollisionTarget(temp.xcord(),temp.ycord())==false){
                    ir=finalTarget.getPoint();
                }
                else if(o.rotate(ir).distance(finalTarget.getPoint())<ir.distance(finalTarget.getPoint())){
                    ir=o.rotate(ir);
                }
                else{
                    ir=finalTarget.getPoint();
                }
            }
        }
        tracer=trackPoints;
    }

    /**
     * This method will use the list of target to follow and find the next one on the list and return the next target in order to get
     * to the final target, findNextTarget() must run before this one.
     */
    private Point nextTarget(){
        int result=-1;
        for(int c=tracer.size()-1;c>=0;c--){
            if(result==-1 && checkCollisionFollower(tracer.get(c).xcord(),tracer.get(c).ycord())==false){
                result=c;
            }
        }
        return tracer.get(result);
    }

    /**
     * This method takes the currentTarget and loc to create a equation for getting to the currentTarget
     */
    private void findNextDirection(){
        m=(currentTarget.ycord()-loc.ycord())/(currentTarget.xcord()-loc.xcord());
        b=loc.ycord()/(loc.xcord()*m);
    }

    /**
     * This method uses the followers current location and the given parameters to figure out if there is a direct
     * path between the two. The collision it checks is the ObjectMap initialized under currentMap.
     */
    private boolean checkCollisionFollower(int xx,int yy){
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
     * This method uses the finalTarget's current location and the given parameters to figure out if there is a direct
     * path between the two. The collision it checks is the ObjectMap initialized under currentMap.
     */
    private boolean checkCollisionTarget(int xx,int yy){
        boolean tf=false;
        int tempx=xx,tempy=yy,tempm=((yy-finalTarget.getPoint().ycord())/(xx-finalTarget.getPoint().xcord())),tempb=tempy/(tempm*tempx);
        while(tempx!=finalTarget.getPoint().xcord()){
            if(tf=true)
                tempx=finalTarget.getPoint().xcord();
            else if(tempx>finalTarget.getPoint().xcord()){
                tempx--;
                tempy=tempx*tempm+tempb;
                tf=currentMap.isInside(tempx,tempy);
            }
            else if(tempx<finalTarget.getPoint().xcord()){
                tempx++;
                tempy=tempx*tempm+tempb;
                tf=currentMap.isInside(tempx,tempy);
            }
        }
        return tf;
    }

    /**
     * This method updates the follower, by consectutively calling this it will move to its objective by itself
     */
    public void update(){
        if(targetChange==true){
            findNextTarget();
            tracerInc=0;
            targetChange=false;
        }
        else{
            if(currentTarget==null || loc.distance(finalTarget.getPoint())<5){
                //do nothing due to having no target or are currently at the final destination
            }
            else if(loc.distance(currentTarget)<5){
                currentTarget=nextTarget();
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
    }
    
    public String toString(){
        return "X-Cord: "+loc.xcord()+" | Y-Cord: "+loc.ycord();
    }

    /**
     * This method draws the follower to the screen
     */
    public void draw(){

    }
}
