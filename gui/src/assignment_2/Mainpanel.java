package assignment_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JButton;

public class Mainpanel extends JFrame {

	//private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpanel frame = new Mainpanel();
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
	public Mainpanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1303, 603);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane);
		
		JPanel sidepanel = new JPanel();
	    splitPane.setLeftComponent(sidepanel);
	    sidepanel.setBackground(new Color(255, 0, 0));
	    sidepanel.setForeground(new Color(0, 0, 0));
	    sidepanel.setLayout(new BoxLayout(sidepanel, BoxLayout.Y_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setRightComponent(tabbedPane);
		
		// Set the divider size to 0 to hide the divider
	    splitPane.setDividerSize(0);
	    
	    // Set the split pane's UI to a BasicSplitPaneUI
	    BasicSplitPaneUI splitPaneUI = (BasicSplitPaneUI) splitPane.getUI();
	    
	 // Add a button to the left of the divider to collapse the side panel
	    JButton collapseButton = new JButton("*****");
	    collapseButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          // Set the side panel's size to 0 to collapse it
	      	  splitPane.setDividerLocation(0);
	        }

	      });
	    splitPaneUI.getDivider().add(collapseButton, BorderLayout.WEST);
	    
	    
	    
	    
	      JButton btnNewButton_1 = new JButton(">>");
	      sidepanel.add(btnNewButton_1);
	      
	      JButton btnNewButton = new JButton("<<");
	      sidepanel.add(btnNewButton);
	      
	      
	      
	    
		
	 
	}
}
