import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class RectangleData {
    int x1, y1, x2, y2;

    RectangleData(int x1, int y1, int x2, int y2) {
        this.x1 = Math.min(x1, x2);
        this.y1 = Math.min(y1, y2);
        this.x2 = Math.max(x1, x2);
        this.y2 = Math.max(y1, y2);
    }

    boolean isInside(int x, int y) {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }
}