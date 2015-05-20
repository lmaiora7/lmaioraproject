import java.util.ArrayList;
/**
 * Write a description of class ObjectMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObjectMap
{
    private ArrayList<Object> objectList;
    
    public ObjectMap()
    {
        objectList=new ArrayList<Object>();
    }
    
    public void addObject(Object o){
        objectList.add(o);
    }
    
    public boolean isInside(int xx,int yy){
        boolean tf=false;
        for(int c=0;c<objectList.size();c++){
            Object o=objectList.get(c);
            if((xx>o.getx()&&xx<o.getx()+o.getLength())&&(yy>o.gety()&&yy<o.gety()+o.getHeight())){
                tf=true;
            }
        }
        return tf;
    }
    
    public Object inObject(int xx,int yy){
        Object result=null;
        for(int c=0;c<objectList.size();c++){
            Object o=objectList.get(c);
            if((xx>o.getx()&&xx<o.getx()+o.getLength())&&(yy>o.gety()&&yy<o.gety()+o.getHeight())){
                result=o;
            }
        }
        return result;
    }
    
    public void draw(){
        for(int c=0;c<objectList.size();c++){
            objectList.get(c).draw();
        }
    }
}
