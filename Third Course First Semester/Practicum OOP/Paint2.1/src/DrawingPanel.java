import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class DrawingPanel extends JPanel {
    private ArrayList<RectangleData> rectangles = new ArrayList<>();
    private RectangleData currentRectangle;

    DrawingPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    if (currentRectangle == null) {
                        currentRectangle = new RectangleData(e.getX(), e.getY(), e.getX(), e.getY());
                    } else {
                        rectangles.add(currentRectangle);
                        currentRectangle = null;
                    }
                } else if (SwingUtilities.isRightMouseButton(e) && !e.isControlDown()) {
                    deleteRectangle(e.getX(), e.getY());
                }
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (currentRectangle != null) {
                    currentRectangle.x2 = e.getX();
                    currentRectangle.y2 = e.getY();
                    repaint();
                }
            }
        });
    }

    private void deleteRectangle(int x, int y) {
        for (int i = rectangles.size() - 1; i >= 0; i--) {
            if (rectangles.get(i).isInside(x, y)) {
                rectangles.remove(i);
                repaint();
                return;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (RectangleData rectangle : rectangles) {
            g.drawRect(rectangle.x1, rectangle.y1, rectangle.x2 - rectangle.x1, rectangle.y2 - rectangle.y1);
        }
        if (currentRectangle != null) {
            g.drawRect(currentRectangle.x1, currentRectangle.y1,
                    currentRectangle.x2 - currentRectangle.x1, currentRectangle.y2 - currentRectangle.y1);
        }
    }

    public ArrayList<RectangleData> getRectangles() {
        return rectangles;
    }
}