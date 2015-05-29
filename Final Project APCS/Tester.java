
/**
 * This class is just for testing mechanics of the other classes.
 * 
 * @author Luke Maiorano 
 * @version 1.0
 */
import java.util.ArrayList;
public class Tester
{
    public static void main(String []args){
        ObjectMap o=new ObjectMap();
        o.addObject(new Object(100,100,50,50));
        Target t=new Target(20,20);
        Follower f=new Follower(500,500,t,o);
        ArrayList<Point> pointList=new ArrayList<Point>();
        pointList.add(new Point(300,100));
        pointList.add(t.getPoint());
        System.out.println(o);
        System.out.println("Is the point X:150, Y:125 in the set of objects? : "+o.isInside(150,125));
        o.addObject(new Object(0,0,100,100));
        o.addObject(new Object(100,100,200,200));
        System.out.println();
        System.out.println("The next is a test with similar condition only with more objects in the map");
        System.out.println();
        System.out.println(o);
        System.out.println("Is the point X:150, Y:125 in the set of objects? : "+o.isInside(150,125));
        System.out.println("What object is colliding with the point X:150, Y:125? : "+o.inObject(150,125));
        System.out.println("Is the point X:300, Y:300 in the set of objects? : "+o.isInside(150,125));
        System.out.println("What Object is closest to X:300, Y:300 in the set of objects? : "+o.getClosestObject(new Point(300,300)));  
        
    }
}
