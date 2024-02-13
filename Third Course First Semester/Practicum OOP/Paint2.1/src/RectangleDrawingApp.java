import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class RectangleDrawingApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rectangle Drawing App");
        DrawingPanel drawingPanel = new DrawingPanel();

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem openItem = new JMenuItem("Open");

        saveItem.addActionListener(e -> saveToFile(drawingPanel.getRectangles()));
        openItem.addActionListener(e -> openFromFile(drawingPanel));

        fileMenu.add(saveItem);
        fileMenu.add(openItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.add(drawingPanel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void saveToFile(ArrayList<RectangleData> rectangles) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("rectangles.dat"))) {
            oos.writeObject(rectangles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void openFromFile(DrawingPanel drawingPanel) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("rectangles.dat"))) {
            ArrayList<RectangleData> rectangles = (ArrayList<RectangleData>) ois.readObject();
            drawingPanel.getRectangles().addAll(rectangles);
            drawingPanel.repaint();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}