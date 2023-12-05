import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program extends Frame{
	List<Double> xCoordinates = new ArrayList<>();
    List<Double> yCoordinates = new ArrayList<>();
	
	Program() {
		super("Lines");
		setSize(600, 400);
		setLocation(200, 100);
		setBackground(Color.LIGHT_GRAY);
		addWindowListener(new WindowClosingAdapter(true));
		setVisible(true);
	}
	
	public void loadCoords() {
		try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] coordinates = line.split("\\s+");
                if (coordinates.length == 2) {
                    double x = Double.parseDouble(coordinates[0]);
                    double y = Double.parseDouble(coordinates[1]);
                    xCoordinates.add(x);
                    yCoordinates.add(y);
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void paint(Graphics g)
	{
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < xCoordinates.size() - 1; i++) {
            double x1 = xCoordinates.get(i);
            double y1 = yCoordinates.get(i);
            double x2 = xCoordinates.get(i + 1);
            double y2 = yCoordinates.get(i + 1);

            int x1Int = (int) x1;
            int y1Int = (int) y1;
            int x2Int = (int) x2;
            int y2Int = (int) y2;

            g2d.drawLine(x1Int, y1Int, x2Int, y2Int);
        }
	}
	
	public static void main(String[] args) {
		Program win = new Program();
		win.loadCoords();
	}
}
