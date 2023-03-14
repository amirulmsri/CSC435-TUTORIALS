package assignment_2;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class Main {
  public static void main(String[] args) {
	  JPanel contentPanel = new JPanel();
	  contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

	  //add some components to the content panel
	  for(int i=0;i<100;i++) {
	      JLabel label = new JLabel("This is label number " + i);
	      contentPanel.add(label);
	  }

	  JViewport viewport = new JViewport();
	  viewport.setView(contentPanel);
	  viewport.setPreferredSize(new Dimension(200, 200));
	  viewport.setAutoscrolls(true);

	  //JPanel scrollablePanel = new JPanel();

	//Add content to the panel

	  contentPanel.addMouseWheelListener(new MouseWheelListener() {
	    public void mouseWheelMoved(MouseWheelEvent e) {
	        if (e.getPreciseWheelRotation() <0) {
	            //Scrolling up, move the panel up
	        	contentPanel.setLocation(contentPanel.getX(), contentPanel.getY() + -e.getWheelRotation());
	        	
	        } else {
	            //Scrolling down, move the panel down
	        	contentPanel.setLocation(contentPanel.getX(), contentPanel.getY() + -e.getWheelRotation());
	        	System.out.print("down");
	        }
	    }
	});
		 
	  JFrame frame = new JFrame();
	  frame.add(viewport);
	  frame.setSize(300,300);
	  frame.setVisible(true);
  }
  
}
