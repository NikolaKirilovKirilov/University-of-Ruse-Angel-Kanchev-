import java.awt.*;
import java.awt.event.*;

public class Paint {
	public static void main(String[] args)
	{
		Frame wnd = new Frame("Paint 2.0");
		wnd.addWindowListener(new WindowClosingAdapter(true));
		wnd.setSize(600, 500);
		wnd.setVisible(true);
	}
}
