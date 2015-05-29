
/**
 * Write a description of class Object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Object
{
    private Point loc= new Point(0,0);
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

    public boolean pointInside(Point p){
        boolean tf=false;
        if((p.xcord()>=loc.xcord()&&p.xcord()<=loc.xcord()+length)&&(p.ycord()>=loc.ycord()&&p.ycord()<=loc.ycord()+height)){
            tf=true;
        }
        return tf;
    }

    public Point closest(Point p){
        Point result=pt1;
        if(p.distance(pt2)<p.distance(result))
            result=pt2;
        else if(p.distance(pt3)<p.distance(result))
            result=pt3;
        else if(p.distance(pt4)<p.distance(result))
            result=pt4;
        return result;
    }
    
    public Point rotate(Point p){
        Point result;
        if(p==pt1)
            result=pt2;
        else if(p==pt2)
            result=pt4;
        else if(p==pt3)
            result=pt1;
        else if(p==pt4)
            result=pt3;
        else
            result=null;
        return result;
    }

    public int getx(){return loc.xcord();}

    public int gety(){return loc.ycord();}

    public int getLength(){return length;}

    public int getHeight(){return height;}

    public void draw(){

    }
    
    public String toString(){
        return "[Object is at X:"+loc.xcord()+"|Y:"+loc.ycord()+" and its Length:"+length+"|Height:"+height+"]";
    }
}
