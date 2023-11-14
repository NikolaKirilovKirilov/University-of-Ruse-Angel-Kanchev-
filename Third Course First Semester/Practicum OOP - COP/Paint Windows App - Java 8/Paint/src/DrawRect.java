import java.awt.*;
import java.awt.event.*;

public class DrawRect {
	
	public int x, y, x1, y1, width = x1 - x, height = y1 - y;
	public void draw(Graphics g)
	{
		g.drawRect(x, y, width, height);
	}
}
