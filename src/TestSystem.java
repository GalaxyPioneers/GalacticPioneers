/**
 * Created by Basketlord on 5/20/2015.
 */
import java.awt.*;
import java.applet.*;

public class TestSystem extends Systim
{
    public TestSystem(int px,int py)
    {
        super(px,py);
    }

    public void render(Graphics g, Applet ap)
    {
        g.fillRect(200,200,200,200);
    }
}
