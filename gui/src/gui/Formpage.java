package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Formpage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formpage window = new Formpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Formpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*
		 * frame = new JFrame(); frame.setBounds(100, 100, 450, 300);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 */
		  // Create main window
	    frame = new JFrame("Flight Booking System");
	    frame.setBounds(100, 100, 674, 428);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    // Create input fields and labels
	    JLabel fromLabel = new JLabel("From:");
	    fromLabel.setBounds(102, 41, 67, 13);
	    JComboBox<String> originField = new JComboBox<>();
	    originField.setBounds(102, 64, 67, 21);
	    originField.addItem("New York");
	    originField.addItem("Chicago");
	    originField.addItem("San Francisco");

	    JLabel destinationLabel = new JLabel("Destination:");
	    destinationLabel.setBounds(244, 41, 74, 13);
	    JComboBox<String> destinationField = new JComboBox<>();
	    destinationField.setBounds(244, 64, 74, 21);
	    destinationField.addItem("London");
	    destinationField.addItem("Paris");
	    destinationField.addItem("Rome");

	    JLabel departureDateLabel = new JLabel("Departure Date:");
	    departureDateLabel.setBounds(391, 41, 107, 13);
	    JTextField departureDateField = new JTextField(10);
	    departureDateField.setBounds(391, 65, 86, 19);

	    // Create search button
		/*
		 * JButton searchButton = new JButton("Search"); searchButton.setSize(100, 100);
		 */

	    // Add input fields and labels to panel
	    JPanel form = new JPanel();
	    form.setLayout(null);
	    form.add(fromLabel);
	    form.add(originField);
	    form.add(destinationLabel);
	    form.add(destinationField);
	    form.add(departureDateLabel);
	    form.add(departureDateField);

	    // Add form and search button to frame
	    frame.getContentPane().add(form);
	    
	    JLabel classLabel = new JLabel("Class:");
	    classLabel.setBounds(102, 96, 67, 13);
	    form.add(classLabel);
	    
	    JComboBox<String> classField = new JComboBox<String>();
	    classField.setBounds(102, 119, 67, 21);
	    form.add(classField);
	    
	    JLabel numPeople = new JLabel("No.of people:");
	    numPeople.setBounds(244, 96, 107, 13);
	    form.add(numPeople);
	    
	    JComboBox<String> numpeopleField = new JComboBox<String>();
	    numpeopleField.setBounds(244, 119, 74, 21);
	    form.add(numpeopleField);
	    
	    JPanel panel = new JPanel();
	    panel.setBorder(UIManager.getBorder("ComboBox.border"));
	    panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(255, 255, 255));
	    panel.setBounds(36, 20, 582, 341);
	    form.add(panel);
	    //frame.add(searchButton);

	    // Display frame
	    frame.setVisible(true);
	}
}
