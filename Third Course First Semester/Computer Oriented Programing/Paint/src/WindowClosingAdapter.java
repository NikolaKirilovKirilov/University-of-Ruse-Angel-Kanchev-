import java.awt.*;
import java.awt.event.*;

public class WindowClosingAdapter extends WindowAdapter {
	private boolean exitSystem;
	
	public WindowClosingAdapter(boolean exitSystem)
	{
		this.exitSystem = exitSystem;
	}
}
