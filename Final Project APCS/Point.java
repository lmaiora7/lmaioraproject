
/**
 * Write a description of class Point here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Point
{
    private int y;
    private int x;
    public Point(int xx, int yy)
    {
        x=xx;
        y=yy;
    }
    public int xcord(){return x;}
    public int ycord(){return y;}
    public void xset(int xx){x=xx;}
    public void yset(int yy){y=yy;}
    public void xadd(int xx){x+=xx;}
    public void yadd(int yy){y+=yy;}
    public int distance(Point p){
        return (int)Math.sqrt((x-p.xcord())+(y-p.ycord()));
    }
    
}
