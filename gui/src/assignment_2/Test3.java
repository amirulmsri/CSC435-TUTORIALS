package assignment_2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class Test3 extends JFrame {

	 private JSplitPane splitPane;
	  private JPanel sidePanel;
	  private JButton toggleButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test3 frame = new Test3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 438);
		// Create the split pane and side panel
	    splitPane = new JSplitPane();
	    sidePanel = new JPanel();

	    // Add a button to the side panel to toggle its visibility
	    toggleButton = new JButton("Toggle Side Panel");
	    toggleButton.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        // Toggle the visibility of the side panel
	        sidePanel.setVisible(!sidePanel.isVisible());

	        // Adjust the divider location of the split pane
	        splitPane.setDividerLocation(sidePanel.isVisible() ? 0.2 : 0.0);
	      }
	    });
	    sidePanel.add(toggleButton);

	    // Add the side panel to the left side of the split pane
	    splitPane.setLeftComponent(sidePanel);

	    // Add the split pane to the frame
	    add(splitPane);
	}
}
