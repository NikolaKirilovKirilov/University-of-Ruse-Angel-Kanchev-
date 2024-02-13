
import java.awt.*;
import java.util.*;

import javax.swing.*;

import java.io.*;
import java.awt.event.*;

public class Program extends Frame implements MouseListener, ActionListener{

	boolean saved = false;
	
	ArrayList<Rectangle> collection = new ArrayList<>();
	Rectangle rect = new Rectangle();
	
	MenuBar bar = new MenuBar();
	Menu file = new Menu("File");
	
	MenuItem fileNew = new MenuItem("New");
	MenuItem open = new MenuItem("Open");
	MenuItem save = new MenuItem("Save");
	
	Program() {
		super("Paint");
		setSize(1100, 900);
		setBackground(Color.LIGHT_GRAY);
		addWindowListener(new WindowClosingAdapter(true));
		addMouseListener(this);
		setVisible(true);
		
		fileNew.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		
		file.add(fileNew);file.add(open); file.add(save);
		bar.add(file);
		
		setMenuBar(bar);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		for(Rectangle rect : collection)
		{
			g.drawRect(rect.getP1X(), rect.getP1Y(), rect.getP2X() - rect.getP1X(), rect.getP2Y() - rect.getP1Y());
		}
		saved = false;
	}
	
	public static void main(String[] args)
	{
		Program wnd = new Program();
	}
	
	//Mouse events
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int index = 0; boolean found = false;
		if(e.getButton() == MouseEvent.BUTTON3)
		{
			for(Rectangle rect: collection)
			{
				if((e.getX() >= rect.getP1X()-3 && e.getY() >= rect.getP1Y()-3) && 
						(e.getX() <= rect.getP2X()+3 && e.getY() <= rect.getP2Y()+3)) {
					index = collection.indexOf(rect);
					found = true;
				}
				
				if(found) {
				collection.remove(index);
				found = false;
				}
			}
		}
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() == MouseEvent.BUTTON1)
		rect.setPoint1(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() == MouseEvent.BUTTON1)
		{
		rect.setPoint2(e.getX(), e.getY());
		rect.reevaluate();
		collection.add(rect);
		rect = new Rectangle();
		repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == fileNew)
		{
			if(saved)
			{
				collection.clear();
				repaint();
			}
			else
			{
				int response = JOptionPane.showConfirmDialog(null, "Do you want to Save?", "Yes", JOptionPane.YES_NO_OPTION);
				if(response == JOptionPane.YES_OPTION)
				{
					try{
					    FileOutputStream writeData = new FileOutputStream("peopledata.ser");
					    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

					    writeStream.writeObject(collection);
					    writeStream.flush();
					    writeStream.close();

					}catch (IOException e2) {
					    e2.printStackTrace();
					}
					collection.clear();
					repaint();
					saved = true;
				}
				if(response == JOptionPane.NO_OPTION)
				{
					collection.clear();
					repaint();
				}
			}
		}
		if(e.getSource() == open)
		{
			try{
			    FileInputStream readData = new FileInputStream("rectangles.ser");
			    ObjectInputStream readStream = new ObjectInputStream(readData);

			    ArrayList<Rectangle> collection2 = (ArrayList<Rectangle>) readStream.readObject();
			    collection = collection2;
			    readStream.close();
			    repaint();
			}catch (Exception e2) {
			    e2.printStackTrace();
			}
		}
		if(e.getSource() == save)
		{
			try{
			    FileOutputStream writeData = new FileOutputStream("rectangles.ser");
			    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

			    writeStream.writeObject(collection);
			    writeStream.flush();
			    writeStream.close();

			}catch (IOException e2) {
			    e2.printStackTrace();
			}
			saved = true;
		}
	}
}
