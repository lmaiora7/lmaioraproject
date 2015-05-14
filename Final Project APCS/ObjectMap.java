import java.util.*;
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
}
