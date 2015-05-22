
/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Target
{
    private Point loc= new Point(0,0);
    public Target(int xx,int yy)
    {
        loc.xset(xx);
        loc.yset(yy);
    }
    public Target(Point tt){loc=tt;}
    public Point getPoint(){
        return loc;
    }
    public void draw(){
        
    }
}
