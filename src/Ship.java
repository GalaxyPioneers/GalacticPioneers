import java.util.*;

public abstract class Ship
{
    private int x,y,type;
    public Ship(int pX,int pY,int pType)
    {
        x=pX;
        y=pY;
        type=pType;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getType()
    {
        return type;
    }
    public void setType(int set)
    {
        type = set;
    }
}