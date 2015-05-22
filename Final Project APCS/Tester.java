
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Tester
{
    public static void main(String []args){
        ObjectMap o=new ObjectMap();
        o.addObject(new Object(100,100,100,50));
        Target t=new Target(20,20);
        Follower f=new Follower(500,500,t,o);
        ArrayList<Point> pointList=new ArrayList<Point>();
        pointList.add(new Point(300,100));
        pointList.add(t.getPoint());
        while(f.getLocation().distance(t.getPoint())>50){
            f.update();
        }
    }
}
