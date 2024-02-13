import java.awt.*;
import java.io.Serializable;

public class Rectangle implements Serializable {
	Point point1 = new Point();
	Point point2 = new Point();
	
	public Rectangle()
	{
		point1.x = 0;
		point1.y = 0;
		point2.x = 0;
		point2.y = 0;
	}
	
	public void setPoint1(int x, int y)
	{
		point1.x = x; point1.y = y;
	}
	
	public void setPoint2(int x, int y)
	{
		point2.x = x; point2.y = y;
	}
	
	public void reevaluate()
	{
		int x, y;
		if(point1.x > point2.x)
		{
			x = point2.x;
			point2.x = point1.x;
			point1.x = x;
		}
		
		if(point1.y > point2.y)
		{
			y = point2.y;
			point2.y = point1.y;
			point1.y =y;
		}
	}
	
	public int getP1X()
	{
		return point1.x;
	}
	
	public int getP1Y()
	{
		return point1.y;
	}
	
	public int getP2X()
	{
		return point2.x;
	}
	
	public int getP2Y()
	{
		return point2.y;
	}
}
