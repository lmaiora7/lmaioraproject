
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester
{
    public static void main(String []args){
        ObjectMap o=new ObjectMap();
        o.addObject(new Object(100,100,100,50));
        Target t=new Target(20,20);
        Follower f=new Follower(200,200,t,o);
    }
}
