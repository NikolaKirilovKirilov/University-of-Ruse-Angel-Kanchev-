import java.awt.*;
import java.awt.event.*;

public class Program extends Frame implements MouseListener, MouseMotionListener{

	Program() {
		super("Paint");
		setSize(500, 700);
		setBackground(Color.LIGHT_GRAY);
		addWindowListener(new WindowClosingAdapter(true));
		addMouseListener(this);
		setVisible(true);
	}
	
	public static void Main(String[] args)
	{
		Program wnd = new Program();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
