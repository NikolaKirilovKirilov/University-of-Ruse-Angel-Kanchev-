package Program;

import java.awt.*;

public class Program{
	public static void main(String[] args) {
		Frame wnd = new Frame("Paint 2.1");
		wnd.addWindowListener(new WindowClosingAdapter(true));
		wnd.setSize(900, 800);
		wnd.setBackground(Color.GRAY);;
		wnd.setVisible(true);
	}
}
