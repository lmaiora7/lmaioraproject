
/**
 * Write a description of class Object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Object
{
    private Point loc;
    private int length;
    private int height;
    private Point pt1,pt2,pt3,pt4; //These points are for the follower to track and help them find a path
    public Object(int xx,int yy,int len,int hei)
    {
        loc.xset(xx);
        loc.yset(yy);
        length=len;
        height=hei;
        //  1_____2
        //  |_____|
        //  3     4
        pt1=new Point(xx-5,yy-5);
        pt2=new Point(xx+length+5,yy-5);
        pt3=new Point(xx-5,yy+height+5);
        pt4=new Point(xx+length+5,yy+height+5);
    }
    
    public void draw(){
        
    }
}
