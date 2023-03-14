package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class gui {
  public static void main(String[] args) {
    // Create main window
    JFrame frame = new JFrame("Flight Booking System");
    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create input fields and labels
    JLabel originLabel = new JLabel("Origin:");
    JComboBox<String> originField = new JComboBox<>();
    originField.addItem("New York");
    originField.addItem("Chicago");
    originField.addItem("San Francisco");

    JLabel destinationLabel = new JLabel("Destination:");
    JComboBox<String> destinationField = new JComboBox<>();
    destinationField.addItem("London");
    destinationField.addItem("Paris");
    destinationField.addItem("Rome");

    JLabel departureDateLabel = new JLabel("Departure Date:");
    JTextField departureDateField = new JTextField(10);

    // Create search button
	/*
	 * JButton searchButton = new JButton("Search"); searchButton.setSize(100, 100);
	 */

    // Add input fields and labels to panel
    JPanel form = new JPanel();
    form.setLayout(new FlowLayout());
    form.add(originLabel);
    form.add(originField);
    form.add(destinationLabel);
    form.add(destinationField);
    form.add(departureDateLabel);
    form.add(departureDateField);

    // Add form and search button to frame
    frame.add(form);
    //frame.add(searchButton);

    // Display frame
    frame.setVisible(true);
  }
}