import java.awt.*;
import javax.swing.JFrame;

public class Program extends JFrame {

	Program() {
		super("Bouncing Ball");
		setSize(600,400);
		setLocation(200, 100);
		setBackground(Color.LIGHT_GRAY);
		addWindowListener(new WindowClosingAdapter(true));
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Program wnd = new Program();
	}
	
}
