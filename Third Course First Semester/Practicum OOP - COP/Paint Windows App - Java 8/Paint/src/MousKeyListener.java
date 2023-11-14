
import java.awt.event.*;
import java.awt.Point;

public class MousKeyListener{
	public Point registerMouseClick(MouseEvent event)
	{
		if(event.isShiftDown() == true)
		{
			Point pressCords = new Point(event.getX(), event.getY());
			return pressCords;
		}
		else if (event.isShiftDown() == false)
		{
			Point releaseCords = new Point(event.getX(), event.getY());
			return releaseCords;
		}
		else
		{
			Point empty = new Point();
			return empty;
		}
	}
}
