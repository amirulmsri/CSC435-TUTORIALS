package assignment_2;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.geom.RoundRectangle2D;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;




public class Homepage extends JFrame {
 
	private JButton seatButtons[][];
	private JTextField lastNameField;
	private JTextField firstNameField;
	private JTextField passNoField;
	private JTextField emailField;
	private JTextField phonNumField;
	private JTextField countryCodeField;
	private JTextField textField_6;
	private JTextField textField_7;
	CardLayout crd;
	CardLayout cdr2;
	CardLayout cdr3;
	CardLayout cdr4;
	CardLayout cdr5;
	CardLayout cdr6;
	Booking book;
	FlightSummary summary;
	PassengerDet PassDet;
	boolean bookingFlag;
	boolean manageFlag;
	boolean checkFlag;
	JPanel HomePanel;
	JLabel Flightlbl ;
	JPanel Seatpanel;
	JPanel bookingpanel;
	JPanel passDet;
	JPanel FlightSummary;
	JLabel OriginLbl;
	JLabel destinationLbl;
	JLabel destinationLbl_1;
	JLabel OriginLbl_1 ;
	JLabel displayOrigin;
	JLabel displayDestination;
	boolean clicked = false;
	boolean clicked2 = false;
	JLabel departDateLbl1;
	JLabel returnDateLbl1;
	JLabel displayDate;
	JLabel departTime1;
	JLabel arrivalTime1;
	JSpinner spinner;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	JPanel upperPanelCont;
	JPanel lowerPanelCont ;
	JLabel displayDepartTime1;
	boolean resetDesign;
	JPanel FlightSchedule;
	JLabel minisidePanel;
	JPanel FlightSchedule_2;
	JLabel minisidePanel2;
	JPanel FlightSchedule_2_1;
	JLabel minisidePanel3;
	JPanel FlightSchedule_2_2;
	JLabel minisidePanel4;
	private JPanel pricePanel1;
	JLabel pricePanelheader1;
	JLabel pricePanelheader2;
	JLabel pricePanelheader3 ;
	JLabel pricePanelheader4;
	JLabel departDestinationLbl1;
	JLabel departDestinationLbl2;
	boolean showFare1 = false;
	boolean showFare2 = false;
	JPanel farePanelCont;
	JLabel passCtr;
	int valueSpinner1;
	 int selectedIndex;
	 JLabel displayNumPass;
	 JPanel pricePanel2;
	 JLabel displayPrice2 ;
	 JPanel rcptPanel;
	 JPanel bookSumm ;
	 JLabel displayFirstname;
	 JLabel displayLastname;
	 JLabel displayPassNo;
	 JLabel dateDisplay;
	 JLabel timeDisplay;
	 JLabel displayDepartLoc;
	 JLabel displayDestLoc;
	 double departFare;
	 double returnFare;
	 JLabel displayGrandTotal;
	 DecimalFormat df = new DecimalFormat("#.##");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Homepage();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static class RoundedBorder implements Border{
		private int radius;
		// specify the radius of the rounded corner of the border.
		RoundedBorder(int radius){
			this.radius = radius;
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			 g.drawRoundRect(x, y, width-1, height-1, radius, radius);
			 g.setClip(null);
			 //draw a rounded rectangle border with the specified radius.
		}

		@Override
		public Insets getBorderInsets(Component c) {
			// TODO Auto-generated method stub
			return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
			//specifies the padding around the border at the top, left, bottom, and right of the border, respectively.
		}

		@Override
		public boolean isBorderOpaque() {
			// TODO Auto-generated method stub
			return true;
			//indicating whether the border is opaque (true) or transparent (false).
		}
		
	}


	/**
	 * Create the frame.
	 */
	public Homepage() {
		bookingFlag = false;
		manageFlag = false;

		// Create a split pane to hold the sidePanel and main content JSplitPane
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setOneTouchExpandable(true);
		splitPane.setBounds(0, -22, 1527, 981);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 129, 842);
		splitPane.setLeftComponent(panel);
//		sidePanel.add(panel);
		crd = new CardLayout(0,0);
		panel.setLayout(crd);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(null);
		panel.add(panel_2, "name_2011453891726800");
		
	    // Set the divider size to 0 to hide the divider
	    splitPane.setDividerSize(0);
	    splitPane.setDividerLocation(50);
		JLabel lblNewLabel_16 = new JLabel("");
	
		lblNewLabel_16.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/home.png")));
		lblNewLabel_16.setBounds(10, 92, 60, 47);
		panel_2.add(lblNewLabel_16);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crd.next(panel);
				splitPane.setDividerLocation(130);
			}
		});
		lblNewLabel_7.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/menu.png")));
		lblNewLabel_7.setBounds(10, 10, 60, 57);
		panel_2.add(lblNewLabel_7);
		// Create a JPanel for the side panel and add it to the split pane
		JPanel sidePanel = new JPanel();
		sidePanel.setBounds(0, 0, 129, 963);
		sidePanel.setBorder(null);
		sidePanel.setBackground(new Color(255, 255, 255));
		sidePanel.setLayout(null);
		panel.add(sidePanel);
	

		 // Create a JTabbedPane for the main panel and add it to the split pane
	    JTabbedPane tabbedPane = new JTabbedPane();
	    tabbedPane.setBorder(null);
	    splitPane.setRightComponent(tabbedPane);
	   
	    
//	    // Set the divider size to 0 to hide the divider
	    splitPane.setDividerSize(0);
//	    splitPane.setDividerLocation(130);

	    // Add a button to the left of the divider to collapse the side panel
	    JButton btnNewButton_1 = new JButton(">>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Set the side panel's size to 0 to collapse it
		        //System.out.print("1");
//		     // Toggle the visibility of the side panel
//		        sidePanel.setVisible(!sidePanel.isVisible());//(side panel become invisible)
		        crd.next(panel);
		        splitPane.setDividerLocation(50);
//		        // Adjust the divider location of the split pane//using short-hand if else(ternary operator)
//	        splitPane.setDividerLocation(sidePanel.isVisible() ? 130 : 50);//(condition)? true exp: false:
			}
		});
		btnNewButton_1.setBounds(0, 29, 129, 21);
		sidePanel.add(btnNewButton_1);
	   
	    // Add some buttons to the sidePanel
		JButton button1 = new JButton("HOME");
		
		Component verticalStrut = Box.createVerticalStrut(30);
		sidePanel.add(verticalStrut);
		button1.setBounds(0, 60, 129, 21);
		sidePanel.add(button1);
		/*
		 * button1.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { splitPane.setDividerLocation(0); } });
		 */
		sidePanel.add(Box.createVerticalStrut(30));
		JButton button3 = new JButton("BOOKING");
		button3.setBounds(0, 100, 129, 21);
		sidePanel.add(button3);
		sidePanel.add(Box.createVerticalStrut(30));
		sidePanel.add(Box.createVerticalStrut(30));
		
	
		
		
		
		

		//Home panel
		HomePanel = new JPanel();
		HomePanel.setBorder(null);
		HomePanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Home", HomePanel);
		HomePanel.setLayout(null);
		
		lblNewLabel_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedComponent(HomePanel);
			}
		});
		//homebutton mouselistener method
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedComponent(HomePanel);
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, 0, 1391, 66);
		HomePanel.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/upperpanel.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1391, 832);
		HomePanel.add(panel_1);
		panel_1.setLayout(null);
		cdr2 = new CardLayout(0, 0);
		JPanel CardPanel = new JPanel();
		CardPanel.setBackground(new Color(255, 0, 0));
		CardPanel.setBounds(59, 115, 928, 174);
		panel_1.add(CardPanel);
		CardPanel.setLayout(cdr2);
		CardPanel.setVisible(false);
		JPanel BookingPanel = new JPanel();
		CardPanel.add(BookingPanel, "Booking");
		BookingPanel.setLayout(null);
		BookingPanel.setVisible(false);
		
		JLabel closeLbl = new JLabel("");
		closeLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardPanel.setVisible(false);
				bookingpanel.setBackground(new Color(255, 204, 153));
				Flightlbl.setForeground(new Color(255,255,255));
				bookingFlag = false;
			}
		});
		closeLbl.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-close-window-24.png")));
		closeLbl.setBounds(889, 10, 29, 25);
		BookingPanel.add(closeLbl);
		
		JComboBox OrigincomboBox = new JComboBox(new Object[]{"Paris", "London", "New York", "Tokyo"," "});
		OrigincomboBox.setBorder(UIManager.getBorder("ToolTip.border"));
		OrigincomboBox.setBounds(60, 31, 266, 21);
		BookingPanel.add(OrigincomboBox);
		
		JLabel lblNewLabel_5 = new JLabel("From");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_5.setBounds(23, 35, 45, 13);
		BookingPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_17 = new JLabel("To");
		lblNewLabel_17.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_17.setBounds(467, 35, 24, 13);
		BookingPanel.add(lblNewLabel_17);
		
		JComboBox DestinationcomboBox = new JComboBox(new Object[]{"Paris", "London", "New York", "Tokyo"," "});
		DestinationcomboBox.setBorder(UIManager.getBorder("ToolTip.border"));
		DestinationcomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String destination = (String) DestinationcomboBox.getSelectedItem();
				String depature = (String)OrigincomboBox.getSelectedItem();
				//destinationBox.removeItemAt(4);
				if(destination.equalsIgnoreCase(depature)) {
					JOptionPane.showMessageDialog(DestinationcomboBox, "Please choose valid destination!!","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		DestinationcomboBox.setBounds(501, 31, 296, 21);
		BookingPanel.add(DestinationcomboBox);
		
		//set the max date to 31 DEC
		Calendar cal = Calendar.getInstance();
		cal.set(2023, Calendar.DECEMBER, 31);
		Date maxDate = cal.getTime();
		
		JDateChooser DepartdateChooser= new JDateChooser();
		DepartdateChooser.setBorder(UIManager.getBorder("ToolTip.border"));
		DepartdateChooser.setMinSelectableDate(new Date());
		DepartdateChooser.setMaxSelectableDate(maxDate);
		DepartdateChooser.setBounds(82, 76, 73, 25);
		BookingPanel.add(DepartdateChooser);
		
		JLabel lblNewLabel_5_1 = new JLabel("Departure ");
		lblNewLabel_5_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_5_1.setBounds(23, 84, 60, 13);
		BookingPanel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Return");
		lblNewLabel_5_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_5_1_1.setBounds(195, 84, 45, 13);
		BookingPanel.add(lblNewLabel_5_1_1);
		
		JDateChooser ReturndateChooser = new JDateChooser();
		ReturndateChooser.setBorder(UIManager.getBorder("ToolTip.border"));
		ReturndateChooser.setMinSelectableDate(new Date());
		ReturndateChooser.setMaxSelectableDate(maxDate);
		ReturndateChooser.setBounds(235, 76, 73, 25);
		BookingPanel.add(ReturndateChooser);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("Passenger");
		lblNewLabel_5_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_5_1_1_1_1.setBounds(328, 84, 60, 13);
		BookingPanel.add(lblNewLabel_5_1_1_1_1);
		@SuppressWarnings("unchecked")
		String [] options = {"Adult","Children","Infant"};
		JComboBox PassengercomboBox = new JComboBox(options);
		PassengercomboBox.setBorder(UIManager.getBorder("ToolTip.border"));
		PassengercomboBox.setBounds(386, 80, 128, 21);
		BookingPanel.add(PassengercomboBox);	
		
		// Create a spinner for each value in the combo box
        for (String value : options) {
            // Create a spinner with a default value of 0 and a range of 0 to 10
        	
            spinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));

            spinner.setBounds(520, 80, 35, 20);
           // spinner.
            // Set the spinner invisible until it is needed
            spinner.setVisible(false);

            // Add the spinner to the panel
            BookingPanel.add(spinner);
        }
		// Add an action listener to the combo box to show the appropriate spinner when a value is selected
		PassengercomboBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get the selected index of the combo box
		        selectedIndex = PassengercomboBox.getSelectedIndex();

		        // Make all spinners invisible
		        for (int i = 0; i < options.length; i++) {
		        	BookingPanel.getComponent(i + 11).setVisible(false);
		        }

		        // Make the appropriate spinner visible
		        BookingPanel.getComponent(selectedIndex + 11).setVisible(true);
		       
		        	    try {
							spinner.commitEdit();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    	
		    }
		});
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Cabin Class");
		lblNewLabel_5_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_5_1_1_1.setBounds(603, 84, 73, 13);
		BookingPanel.add(lblNewLabel_5_1_1_1);
		
		JComboBox CabClasscomboBox= new JComboBox(new Object[]{"Economy","Bussiness","Bussiness Suit"});
		CabClasscomboBox.setBorder(UIManager.getBorder("ToolTip.border"));
		CabClasscomboBox.setBounds(669, 80, 128, 21);
		BookingPanel.add(CabClasscomboBox);
		
		//String [] options = {"Adult","Children","Infant"};
		
		JLabel BookNowLbl = new JLabel("Book Now");
		BookNowLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//get input values departureBox destinationBox classBox passegerBox
		    	String departure = (String)OrigincomboBox.getSelectedItem();
		    	String destination = (String)DestinationcomboBox.getSelectedItem();
		    	String classType = (String)CabClasscomboBox.getSelectedItem();
//		    	String passengerType = (String)passengerBox.getSelectedItem();
		    	boolean valid = true;
//		    	//validate inputs
		    	if(departure.isEmpty()|| destination.isEmpty()|| classType.isEmpty()) {
		    		JOptionPane.showMessageDialog(BookNowLbl, "Please fill all the inputs!", "Error", JOptionPane.ERROR_MESSAGE);
		    		valid = false;
		    	}
		    	if(DepartdateChooser.getDate() == null || ReturndateChooser.getDate() == null ) {
		    		JOptionPane.showMessageDialog(BookNowLbl, "Please select a date!", "Error", JOptionPane.ERROR_MESSAGE);
		    		valid = false;
		    	}
		    	if(DepartdateChooser.getDate() == ReturndateChooser.getDate()) {
		    		JOptionPane.showMessageDialog(BookNowLbl, "Invalid date!", "Error", JOptionPane.ERROR_MESSAGE);
		    		valid = false;
		    	}
		    	if(departure.equalsIgnoreCase(destination)) {
		    		JOptionPane.showMessageDialog(BookNowLbl, "Invalid Destination!", "Error", JOptionPane.ERROR_MESSAGE);
		    		valid = false;
		    	}
		    
		        if (valid == true) {
		 
//			        //
		        	valueSpinner1 =  (int) ((JSpinner) BookingPanel.getComponent(selectedIndex + 11)).getValue();
			   	    System.out.println(valueSpinner1);

			        book = new Booking(departure,destination,DepartdateChooser.getDate(),ReturndateChooser.getDate(),classType,valueSpinner1);
			        //set texts in seat panel
			    	displayOrigin.setText(book.getorigin().toUpperCase());
			    	displayDestination.setText(book.getDestination().toUpperCase());
			    	displayDate.setText(book.departDateFormatter().toUpperCase());
			    	
//			        //continue to next page
			    	//set texts in Flight Summary panel
			    	OriginLbl.setText(book.getorigin().toUpperCase());
			    	destinationLbl.setText(book.getDestination().toUpperCase());
			    	destinationLbl_1.setText(book.getDestination().toUpperCase());
			    	OriginLbl_1.setText(book.getorigin().toUpperCase());
			    	departDateLbl1.setText(book.departDateFormatter().toUpperCase());
			    	returnDateLbl1.setText(book.returnDateFormatter().toUpperCase());
			    	pricePanelheader1.setText(book.getBookingClass());
			    	pricePanelheader2.setText(book.getBookingClass());
			    	pricePanelheader3.setText(book.getBookingClass());
			    	pricePanelheader4.setText(book.getBookingClass());
			    	passCtr.setText(String.valueOf(book.getnumPass()));
			    	if(valueSpinner1>1) {
			    		displayNumPass.setText("Passengers");
			    	}
		        	tabbedPane.setSelectedComponent(FlightSummary);
		        }
			}
		});
		BookNowLbl.setBackground(new Color(0, 90, 170));
		BookNowLbl.setHorizontalAlignment(SwingConstants.CENTER);
		BookNowLbl.setFont(new Font("Arial", Font.BOLD, 15));
		BookNowLbl.setBounds(340, 126, 119, 25);
		BookNowLbl.setBorder(new RoundedBorder(12));
		BookNowLbl.setOpaque(true);
		BookingPanel.add(BookNowLbl);
	
		
		//Manage Panel
		JPanel Managepanel = new JPanel();
		Managepanel.setLayout(null);
		CardPanel.add(Managepanel, "ManagePanel");
		
		JLabel lblNewLabel_19 = new JLabel("Manage Booking");
		lblNewLabel_19.setForeground(new Color(0, 90, 170));
		lblNewLabel_19.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_19.setBounds(10, 10, 107, 13);
		Managepanel.add(lblNewLabel_19);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 90, 170));
		separator.setBounds(10, 21, 95, 2);
		Managepanel.add(separator);
		
		JTextArea txtrIfYourBooking = new JTextArea();
		txtrIfYourBooking.setText("If your booking was made through TripleAairlines.com, you may retrieve it here to changes your itinerary. If your booking was made through a travel agent, please contact your travel agency.");
		txtrIfYourBooking.setFont(new Font("Arial", Font.PLAIN, 10));
		txtrIfYourBooking.setBackground(SystemColor.menu);
		txtrIfYourBooking.setBounds(10, 36, 896, 23);
		Managepanel.add(txtrIfYourBooking);
		
		JLabel lblNewLabel_20 = new JLabel("Booking Reference Number");
		lblNewLabel_20.setBounds(10, 77, 174, 13);
		Managepanel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_20_1 = new JLabel("Last Name");
		lblNewLabel_20_1.setBounds(360, 77, 135, 13);
		Managepanel.add(lblNewLabel_20_1);
		
		textField_8 = new JTextField();
		textField_8.setBounds(10, 100, 157, 19);
		Managepanel.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(360, 100, 96, 19);
		Managepanel.add(textField_9);
		
		JLabel BookNowLbl_1 = new JLabel("Manage Now");
		BookNowLbl_1.setOpaque(true);
		BookNowLbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		BookNowLbl_1.setFont(new Font("Arial", Font.BOLD, 15));
		BookNowLbl_1.setBorder(new RoundedBorder(12));
		BookNowLbl_1.setBackground(new Color(0, 90, 170));
		BookNowLbl_1.setBounds(692, 94, 141, 25);
		Managepanel.add(BookNowLbl_1);
		
		JLabel close1Lbl = new JLabel("");
		close1Lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardPanel.setVisible(false);
			}
		});
		close1Lbl.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-close-window-24.png")));
		close1Lbl.setBounds(889, 10, 29, 25);
		Managepanel.add(close1Lbl);
		
		//Check-in Panel
		JPanel checkinPanel = new JPanel();
		CardPanel.add(checkinPanel, "Check-in");
		checkinPanel.setLayout(null);
		
		JLabel close1Lbl_1 = new JLabel("");
		close1Lbl_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardPanel.setVisible(false);
			}
		});
		close1Lbl_1.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-close-window-24.png")));
		close1Lbl_1.setBounds(876, 10, 29, 25);
		checkinPanel.add(close1Lbl_1);
		
		JLabel lblNewLabel_21 = new JLabel("Web check-in available from 48 hours and up to 90 minutes before departure.");
		lblNewLabel_21.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_21.setBounds(10, 10, 419, 13);
		checkinPanel.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Booking Reference Number");
		lblNewLabel_22.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_22.setBounds(10, 47, 145, 13);
		checkinPanel.add(lblNewLabel_22);
		
		textField_10 = new JTextField();
		textField_10.setBounds(10, 70, 145, 19);
		checkinPanel.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_22_1 = new JLabel("Last Name");
		lblNewLabel_22_1.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_22_1.setBounds(349, 47, 80, 13);
		checkinPanel.add(lblNewLabel_22_1);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(349, 70, 145, 19);
		checkinPanel.add(textField_11);
		
		JLabel BookNowLbl_1_1 = new JLabel("Check-In");
		BookNowLbl_1_1.setOpaque(true);
		BookNowLbl_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		BookNowLbl_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		BookNowLbl_1_1.setBorder(new RoundedBorder(12));
		BookNowLbl_1_1.setBackground(new Color(0, 90, 170));
		BookNowLbl_1_1.setBounds(715, 66, 119, 25);
		checkinPanel.add(BookNowLbl_1_1);
		CardPanel.setVisible(false);
		
		JPanel managePanel = new JPanel();
		managePanel.setBackground(new Color(255, 204, 153));
		managePanel.setBounds(161, 67, 112, 48);
		panel_1.add(managePanel,"ManagePanel");
		managePanel.setLayout(null);
		
		JLabel ManageLbl = new JLabel("Manage");
		ManageLbl.setBounds(52, 0, 60, 50);
		managePanel.add(ManageLbl);
		ManageLbl.setForeground(Color.WHITE);
		ManageLbl.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel ManageIcon = new JLabel("");
		ManageIcon.setBounds(10, 0, 40, 50);
		managePanel.add(ManageIcon);
		ManageIcon.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/logbook.png")));
		
		bookingpanel = new JPanel();
		bookingpanel.setBackground(new Color(255, 204, 153));
		bookingpanel.setBounds(59, 67, 103, 48);
		panel_1.add(bookingpanel);
		bookingpanel.setLayout(null);
	
		Flightlbl = new JLabel("Flight");
		Flightlbl.setBounds(49, 0, 54, 49);
		bookingpanel.add(Flightlbl);
		Flightlbl.setForeground(new Color(255, 255, 255));
		Flightlbl.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setBounds(10, 0, 49, 49);
		bookingpanel.add(lblNewLabel_18);
		lblNewLabel_18.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/airplane-take-off.png")));
		
		JPanel CheckinPanel = new JPanel();
		CheckinPanel.setLayout(null);
		CheckinPanel.setBackground(new Color(255, 204, 153));
		CheckinPanel.setBounds(274, 67, 120, 48);
		panel_1.add(CheckinPanel);
		
		JLabel CheckinIcon = new JLabel("");
		CheckinIcon.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-suitcase-64.png")));
		CheckinIcon.setBounds(10, 0, 49, 49);
		CheckinPanel.add(CheckinIcon);
		
		JLabel CheckinLbl = new JLabel("Check-in");
		CheckinLbl.setForeground(Color.WHITE);
		CheckinLbl.setFont(new Font("Arial", Font.PLAIN, 15));
		CheckinLbl.setBounds(49, 0, 71, 49);
		CheckinPanel.add(CheckinLbl);
		
		JLabel navBar = new JLabel("");
		navBar.setOpaque(true);
		navBar.setBackground(new Color(255, 204, 153));
		navBar.setBounds(0, 65, 1392, 50);
		panel_1.add(navBar);
		
		cdr3 = new CardLayout(0,0);
		JPanel CardHome = new JPanel();
		CardHome.setBackground(new Color(255, 255, 255));
		CardHome.setBounds(0, 115, 1300, 456);
		panel_1.add(CardHome);
		CardHome.setLayout(cdr3);
		
		JPanel ads1Panel = new JPanel();
		CardHome.add(ads1Panel, "ads1");
		ads1Panel.setLayout(null);
		
		JLabel prevads1 = new JLabel("");
		prevads1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cdr3.previous(CardHome);
			}
		});
		prevads1.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/leftarrow.png")));
		prevads1.setBounds(10, 229, 37, 37);
		ads1Panel.add(prevads1);
		
		JLabel nextads1 = new JLabel("");
		nextads1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cdr3.next(CardHome);
			}
		});
		nextads1.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-chevron-left-48.png")));
		nextads1.setBounds(1253, 229, 37, 37);
		ads1Panel.add(nextads1);
		
		JLabel ads1 = new JLabel("");
		ads1.setBounds(0, 0, 1300, 488);
		ads1.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/ABA-Bank-1920x720.jpg")));
		ads1Panel.add(ads1);
		
		JPanel ads2Panel = new JPanel();
		CardHome.add(ads2Panel, "name_1944843170631000");
		ads2Panel.setLayout(null);
		
		JLabel nextads2 = new JLabel("");
		nextads2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cdr3.next(CardHome);
			}
		});
		nextads2.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-chevron-left-48.png")));
		nextads2.setBounds(1253, 229, 37, 37);
		ads2Panel.add(nextads2);
		
		JLabel prevads2 = new JLabel("");
		prevads2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cdr3.previous(CardHome);
			}
		});
		prevads2.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/leftarrow.png")));
		prevads2.setBounds(10, 229, 37, 37);
		ads2Panel.add(prevads2);
		
		JLabel ads2 = new JLabel("");
		ads2.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/AK_CNY2023_281222_my_web_en (1).jpg")));
		ads2.setBounds(0, 0, 1300, 456);
		ads2Panel.add(ads2);
		
		JPanel ads3Panel = new JPanel();
		CardHome.add(ads3Panel, "name_1944889653845600");
		ads3Panel.setLayout(null);
		
		JLabel prevads3 = new JLabel("");
		prevads3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cdr3.previous(CardHome);
			}
		});
		prevads3.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/leftarrow.png")));
		prevads3.setBounds(10, 229, 37, 37);
		ads3Panel.add(prevads3);
		
		JLabel nextads3 = new JLabel("");
		nextads3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cdr3.next(CardHome);
			}
		});
		nextads3.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-chevron-left-48.png")));
		nextads3.setBounds(1253, 229, 37, 37);
		ads3Panel.add(nextads3);
		
		JLabel ads3 = new JLabel("");
		ads3.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/Hero_Banner-AAX-Web-EN-NYS (1).png")));
		ads3.setBounds(0, 0, 1300, 456);
		ads3Panel.add(ads3);
		
		JLabel lblNewLabel_32 = new JLabel("");
		lblNewLabel_32.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/Travel-Requirements (1).png")));
		lblNewLabel_32.setBounds(20, 581, 614, 224);
		panel_1.add(lblNewLabel_32);
		
		JLabel lblNewLabel_32_1 = new JLabel("");
		lblNewLabel_32_1.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/Flight Schedule_v3.png")));
		lblNewLabel_32_1.setBounds(677, 581, 614, 224);
		panel_1.add(lblNewLabel_32_1);
		

		//mouseListener for bookingPanel,managePanel&CheckinPanel
		bookingpanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!bookingFlag) {
					bookingpanel.setBackground(new Color(255,255,255));
					Flightlbl.setForeground(new Color(0, 90, 170));
				}
				
//				bookingFlag = false;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!bookingFlag) {
					bookingpanel.setBackground(new Color(255, 204, 153));
					Flightlbl.setForeground(new Color(255,255,255));
					bookingFlag = false;
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				cdr2.show(CardPanel, "Booking"); 
				CardPanel.setVisible(true);
				bookingpanel.setBackground(new Color(255,255,255));
				Flightlbl.setForeground(new Color(0, 90, 170));
				bookingFlag = true;
			}
		});
		managePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				managePanel.setBackground(new Color(255,255,255));
				ManageLbl.setForeground(new Color(0, 90, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				managePanel.setBackground(new Color(255, 204, 153));
				ManageLbl.setForeground(new Color(255,255,255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				cdr2.show(CardPanel,"ManagePanel");
				CardPanel.setVisible(true);
				managePanel.setBackground(new Color(255,255,255));
				ManageLbl.setForeground(new Color(0, 90, 170));
			}
		});
		CheckinPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				CheckinPanel.setBackground(new Color(255,255,255));
				CheckinLbl.setForeground(new Color(0, 90, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				CheckinPanel.setBackground(new Color(255, 204, 153));
				CheckinLbl.setForeground(new Color(255,255,255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				cdr2.show(CardPanel,"Check-in");
				CardPanel.setVisible(true);
				CheckinPanel.setBackground(new Color(255,255,255));
				CheckinLbl.setForeground(new Color(0, 90, 170));
			}
		});
		

	    
	    //Seat Panel
		Seatpanel = new JPanel();
		Seatpanel.setBackground(new Color(128, 128, 255));
		Seatpanel.setBorder(null);
		tabbedPane.addTab("Seat ", null, Seatpanel, null);
		Seatpanel.setLayout(null);
		
		JLabel lblNewLabel_36_1 = new JLabel("36 SEATS");
		lblNewLabel_36_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_36_1.setBounds(369, 632, 107, 27);
		Seatpanel.add(lblNewLabel_36_1);
		
		JLabel lblNewLabel_36 = new JLabel("6 SEATS");
		lblNewLabel_36.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_36.setBounds(49, 630, 136, 27);
		Seatpanel.add(lblNewLabel_36);
		
		JLabel displayPass = new JLabel("New label");
		displayPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		displayPass.setForeground(new Color(255, 12, 12));
		displayPass.setBounds(380, 338, 74, 44);
		Seatpanel.add(displayPass);
		
		JLabel displayTime = new JLabel("New label");
		displayTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		displayTime.setForeground(new Color(255, 12, 12));
		displayTime.setBounds(227, 338, 55, 44);
		Seatpanel.add(displayTime);
		
		displayDate = new JLabel("");
		displayDate.setForeground(new Color(255, 12, 12));
		displayDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		displayDate.setBounds(37, 338, 148, 44);
		Seatpanel.add(displayDate);
		
		displayDestination = new JLabel("");
		displayDestination.setHorizontalAlignment(SwingConstants.CENTER);
		displayDestination.setForeground(new Color(255, 12, 12));
		displayDestination.setFont(new Font("Tahoma", Font.BOLD, 15));
		displayDestination.setBounds(293, 217, 120, 44);
		Seatpanel.add(displayDestination);

		displayOrigin = new JLabel("");
		displayOrigin.setHorizontalAlignment(SwingConstants.CENTER);
		displayOrigin.setForeground(new Color(255, 12, 12));
		displayOrigin.setFont(new Font("Tahoma", Font.BOLD, 15));
		displayOrigin.setBounds(37, 217, 120, 44);
		Seatpanel.add(displayOrigin);
		
//        System.out.print(book.getDestination());
    	
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/black-plane (1).png")));
		lblNewLabel_15.setBounds(199, 170, 55, 70);
		Seatpanel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/upperpanel.png")));
		lblNewLabel_6.setBounds(0, 0, 1502, 95);
		Seatpanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7_1 = new JLabel("From");
		lblNewLabel_7_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7_1.setBounds(78, 188, 61, 33);
		Seatpanel.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("To");
		lblNewLabel_7_1_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7_1_1.setBounds(339, 188, 43, 33);
		Seatpanel.add(lblNewLabel_7_1_1);
		
		JLabel lblNewLabel_7_1_2 = new JLabel("DATE");
		lblNewLabel_7_1_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_7_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7_1_2.setBounds(49, 303, 120, 33);
		Seatpanel.add(lblNewLabel_7_1_2);
		
		JLabel lblNewLabel_7_1_2_1 = new JLabel("TIME");
		lblNewLabel_7_1_2_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_7_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7_1_2_1.setBounds(227, 303, 68, 33);
		Seatpanel.add(lblNewLabel_7_1_2_1);
		
		JLabel lblNewLabel_7_1_2_1_1 = new JLabel("PASSENGER");
		lblNewLabel_7_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_2_1_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_7_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7_1_2_1_1.setBounds(356, 303, 120, 33);
		Seatpanel.add(lblNewLabel_7_1_2_1_1);
		
		JButton btnNewButton = new JButton("BOOK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			tabbedPane.setSelectedComponent(passDet);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(205, 12, 12));
		btnNewButton.setBorder(new RoundedBorder(10));
		btnNewButton.setBounds(78, 475, 91, 33);
		btnNewButton.setBorderPainted(false);
		Seatpanel.add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBorderPainted(false);
		btnCancel.setBackground(new Color(205, 12, 12));
		btnCancel.setBounds(339, 475, 91, 33);
		Seatpanel.add(btnCancel);
		
		JButton btnUpdateSeatData = new JButton("UPDATE SEAT DATA");
		btnUpdateSeatData.setForeground(Color.WHITE);
		btnUpdateSeatData.setBorderPainted(false);
		btnUpdateSeatData.setBackground(new Color(205, 12, 12));
		btnUpdateSeatData.setBounds(149, 673, 220, 33);
		Seatpanel.add(btnUpdateSeatData);
		
		JLabel lblNewLabel_7_1_2_2 = new JLabel("AVAILABLE ");
		lblNewLabel_7_1_2_2.setForeground(Color.GRAY);
		lblNewLabel_7_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7_1_2_2.setBounds(49, 598, 120, 33);
		Seatpanel.add(lblNewLabel_7_1_2_2);
		
		JLabel lblNewLabel_7_1_2_2_1 = new JLabel("BOOKED");
		lblNewLabel_7_1_2_2_1.setForeground(Color.GRAY);
		lblNewLabel_7_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7_1_2_2_1.setBounds(380, 598, 85, 33);
		Seatpanel.add(lblNewLabel_7_1_2_2_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(593, 194, 691, 575);
		Seatpanel.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(37, 0, 236, 179);
		panel_6.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 3, 10, 10));
		createButt(3,3, panel_3, seatButtons,'A',128,128,128,false);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(417, 0, 236, 179);
		panel_6.add(panel_3_1);
		panel_3_1.setLayout(new GridLayout(3, 3, 10, 10));
		createButt(3,3, panel_3_1, seatButtons,'B',128,128,128,false);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBounds(37, 360, 236, 179);
		panel_6.add(panel_3_2);
		panel_3_2.setLayout(new GridLayout(3, 3, 10, 10));
		createButt(3,3, panel_3_2, seatButtons,'C',128,128,128,false);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setBounds(417, 360, 236, 179);
		panel_6.add(panel_3_3);
		panel_3_3.setLayout(new GridLayout(3, 3, 10, 10));
		createButt(3,3, panel_3_3, seatButtons,'D',128,128,128,false);
		
		JPanel panel_3_4 = new JPanel();
		panel_3_4.setBounds(37, 225, 236, 61);
		panel_6.add(panel_3_4);
		panel_3_4.setLayout(new GridLayout(1, 3, 10, 10));
		createButt(1,3, panel_3_4, seatButtons,'E',52,251,152,true);
		
		JPanel panel_3_4_1 = new JPanel();
		panel_3_4_1.setBounds(417, 225, 236, 61);
		panel_6.add(panel_3_4_1);
		panel_3_4_1.setLayout(new GridLayout(1, 3, 10, 10));
		createButt(1,3, panel_3_4_1, seatButtons,'F',52,251,152,true);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBorderPainted(false);
		btnBack.setBackground(new Color(205, 12, 12));
		btnBack.setBounds(10, 804, 91, 33);
		Seatpanel.add(btnBack);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.setForeground(Color.WHITE);
		btnNext.setBorderPainted(false);
		btnNext.setBackground(new Color(205, 12, 12));
		btnNext.setBounds(1294, 804, 91, 33);
		Seatpanel.add(btnNext);
		
		JLabel lblNewLabel_14_7 = new JLabel("DEPART");
		lblNewLabel_14_7.setForeground(Color.WHITE);
		lblNewLabel_14_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14_7.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_14_7.setOpaque(true);
		lblNewLabel_14_7.setBackground(new Color(205, 12, 12));
		lblNewLabel_14_7.setBounds(34, 118, 442, 51);
		Seatpanel.add(lblNewLabel_14_7);
		
		JLabel lblNewLabel_14_7_1 = new JLabel("BOOKING");
		lblNewLabel_14_7_1.setForeground(Color.WHITE);
		lblNewLabel_14_7_1.setOpaque(true);
		lblNewLabel_14_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14_7_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_14_7_1.setBackground(new Color(205, 12, 12));
		lblNewLabel_14_7_1.setBounds(34, 403, 442, 51);
		Seatpanel.add(lblNewLabel_14_7_1);
		
		JLabel lblNewLabel_14_7_1_1 = new JLabel("SUMMARY ");
		lblNewLabel_14_7_1_1.setForeground(Color.WHITE);
		lblNewLabel_14_7_1_1.setOpaque(true);
		lblNewLabel_14_7_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14_7_1_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_14_7_1_1.setBackground(new Color(205, 12, 12));
		lblNewLabel_14_7_1_1.setBounds(34, 537, 442, 51);
		Seatpanel.add(lblNewLabel_14_7_1_1);
		
		JLabel lblNewLabel_14_6 = new JLabel("");
		lblNewLabel_14_6.setOpaque(true);
		lblNewLabel_14_6.setBackground(Color.WHITE);
		lblNewLabel_14_6.setBounds(34, 170, 442, 599);
		Seatpanel.add(lblNewLabel_14_6);
		
		JLabel lblNewLabel_14_7_2 = new JLabel("SELECT SEAT");
		lblNewLabel_14_7_2.setOpaque(true);
		lblNewLabel_14_7_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14_7_2.setForeground(Color.WHITE);
		lblNewLabel_14_7_2.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_14_7_2.setBackground(new Color(205, 12, 12));
		lblNewLabel_14_7_2.setBounds(576, 118, 729, 51);
		Seatpanel.add(lblNewLabel_14_7_2);
		
		JLabel lblNewLabel_14_6_1 = new JLabel("");
		lblNewLabel_14_6_1.setOpaque(true);
		lblNewLabel_14_6_1.setBackground(Color.WHITE);
		lblNewLabel_14_6_1.setBounds(576, 170, 729, 599);
		Seatpanel.add(lblNewLabel_14_6_1);
		
		passDet = new JPanel();
		passDet.setBackground(new Color(128, 128, 255));
		passDet.setBorder(null);
		tabbedPane.addTab("Passenger Details", null, passDet, null);
		passDet.setLayout(null);
		
		JPanel passDetpanel = new JPanel();
		passDetpanel.setBackground(new Color(128, 128, 255));
		passDetpanel.setBounds(0, 0, 1391, 952);
		passDet.add(passDetpanel);
		passDetpanel.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/upperpanel.png")));
		lblNewLabel_12.setBounds(0, 0, 1502, 94);
		passDetpanel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Passenger Details");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_13.setBounds(56, 137, 194, 25);
		passDetpanel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_13_1 = new JLabel("First & Middle Name (as per passport):");
		lblNewLabel_13_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13_1.setBounds(56, 269, 305, 25);
		passDetpanel.add(lblNewLabel_13_1);
		
		JLabel lblNewLabel_13_1_1 = new JLabel("Last/Family  Name (as per passport):");
		lblNewLabel_13_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13_1_1.setBounds(56, 344, 375, 25);
		passDetpanel.add(lblNewLabel_13_1_1);
		
		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(56, 379, 419, 30);
		passDetpanel.add(lastNameField);
		
		JLabel lblNewLabel_13_1_1_1 = new JLabel("Passport No.");
		lblNewLabel_13_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13_1_1_1.setBounds(56, 419, 118, 25);
		passDetpanel.add(lblNewLabel_13_1_1_1);
		
		firstNameField = new JTextField();
		firstNameField.setColumns(10);
		firstNameField.setBounds(56, 304, 419, 30);
		passDetpanel.add(firstNameField);
		
		passNoField = new JTextField();
		passNoField.setColumns(10);
		passNoField.setBounds(56, 454, 419, 30);
		passDetpanel.add(passNoField);
		
		JLabel lblNewLabel_13_1_2 = new JLabel("Title:");
		lblNewLabel_13_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13_1_2.setBounds(56, 194, 305, 25);
		passDetpanel.add(lblNewLabel_13_1_2);
		
		JComboBox TitlecomboBox = new JComboBox(new Object [] {"Mr","Mrs","Ms","Miss",});
		TitlecomboBox.setBounds(56, 229, 419, 30);
		passDetpanel.add(TitlecomboBox);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setOpaque(true);
		lblNewLabel_14.setBackground(new Color(205, 12, 12));
		lblNewLabel_14.setBounds(32, 123, 1332, 51);
		passDetpanel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_13_2 = new JLabel("Emergency Contact Informations ");
		lblNewLabel_13_2.setForeground(Color.WHITE);
		lblNewLabel_13_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_13_2.setBounds(56, 543, 418, 25);
		passDetpanel.add(lblNewLabel_13_2);
		
		JLabel lblNewLabel_14_1 = new JLabel("");
		lblNewLabel_14_1.setOpaque(true);
		lblNewLabel_14_1.setBackground(new Color(205, 12, 12));
		lblNewLabel_14_1.setBounds(32, 530, 1332, 51);
		passDetpanel.add(lblNewLabel_14_1);
		
		JLabel lblNewLabel_13_1_2_1 = new JLabel("Email:");
		lblNewLabel_13_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13_1_2_1.setBounds(633, 344, 305, 25);
		passDetpanel.add(lblNewLabel_13_1_2_1);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(633, 379, 419, 30);
		passDetpanel.add(emailField);
		
		JLabel lblNewLabel_13_1_2_1_1 = new JLabel("Phone Number:");
		lblNewLabel_13_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13_1_2_1_1.setBounds(633, 269, 305, 25);
		passDetpanel.add(lblNewLabel_13_1_2_1_1);
		
		phonNumField = new JTextField();
		phonNumField.setColumns(10);
		phonNumField.setBounds(633, 304, 419, 30);
		passDetpanel.add(phonNumField);
		
		JLabel lblNewLabel_13_1_2_1_1_1 = new JLabel("Country Code:");
		lblNewLabel_13_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13_1_2_1_1_1.setBounds(633, 419, 305, 25);
		passDetpanel.add(lblNewLabel_13_1_2_1_1_1);
		
		countryCodeField = new JTextField();
		countryCodeField.setColumns(10);
		countryCodeField.setBounds(633, 454, 419, 30);
		passDetpanel.add(countryCodeField);
		
		JLabel lblNewLabel_13_1_2_2 = new JLabel("Full Name:");
		lblNewLabel_13_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13_1_2_2.setBounds(56, 601, 305, 25);
		passDetpanel.add(lblNewLabel_13_1_2_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(56, 632, 419, 30);
		passDetpanel.add(textField_6);
		
		JLabel lblNewLabel_13_1_2_1_1_2 = new JLabel("Phone Number:");
		lblNewLabel_13_1_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13_1_2_1_1_2.setBounds(633, 601, 305, 25);
		passDetpanel.add(lblNewLabel_13_1_2_1_1_2);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(633, 632, 419, 30);
		passDetpanel.add(textField_7);
		
		JButton btnNewButton_2 = new JButton("SUBMIT");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PassDet = new PassengerDet(	firstNameField.getText(),lastNameField.getText(),passNoField.getText(),phonNumField.getText(),emailField.getText(),
						countryCodeField.getText()); 
				displayFirstname.setText(firstNameField.getText());
				displayLastname.setText(lastNameField.getText());
				displayPassNo.setText(passNoField.getText());
			    dateDisplay.setText(book.departDateFormatter());
			    timeDisplay.setText(summary.getdepartTime());
			    displayDepartLoc.setText(book.getorigin());
			    displayDestLoc.setText(book.getDestination());
			    df.setRoundingMode(RoundingMode.HALF_UP);
			    double TotalCharge = summary.TotalCharge();
				String roundedNumber1 = df.format(TotalCharge);
			    displayGrandTotal.setText(roundedNumber1);
				tabbedPane.setSelectedComponent(bookSumm);
			}
		});
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(new Color(0,90,170));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(473, 708, 166, 44);
		passDetpanel.add(btnNewButton_2);
		
		JLabel lblNewLabel_14_2 = new JLabel("");
		lblNewLabel_14_2.setOpaque(true);
		lblNewLabel_14_2.setBackground(new Color(248,248,248));
		lblNewLabel_14_2.setBounds(32, 172, 1332, 626);
		passDetpanel.add(lblNewLabel_14_2);
		
		bookSumm = new JPanel();
		bookSumm.setBorder(null);
		bookSumm.setLayout(null);
		bookSumm.setBackground(new Color(128, 128, 255));
		tabbedPane.addTab("Booking Summary", null, bookSumm, null);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(594, 401, 217, 2);
		bookSumm.add(separator_1_2);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(594, 323, 382, 2);
		bookSumm.add(separator_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(597, 223, 285, 2);
		bookSumm.add(separator_1);
		
		displayGrandTotal = new JLabel("");
		displayGrandTotal.setForeground(new Color (205,12,12));
		displayGrandTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		displayGrandTotal.setBounds(741, 493, 141, 39);
		bookSumm.add(displayGrandTotal);
		
		JLabel lblNewLabel_30 = new JLabel("GRAND TOTAL:");
		lblNewLabel_30.setForeground(new Color(128, 128, 128));
		lblNewLabel_30.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_30.setBounds(597, 493, 141, 39);
		bookSumm.add(lblNewLabel_30);
		
		JLabel lblNewLabel_38 = new JLabel("");
		lblNewLabel_38.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-right-arrow-64.png")));
		lblNewLabel_38.setBounds(682, 213, 64, 64);
		bookSumm.add(lblNewLabel_38);
		
		JLabel seatDisplay = new JLabel("E1-1");
		seatDisplay.setFont(new Font("Tahoma", Font.BOLD, 12));
		seatDisplay.setForeground(new Color(205, 12, 12));
		seatDisplay.setBounds(741, 413, 94, 13);
		bookSumm.add(seatDisplay);
		
		JLabel flightDisplay = new JLabel("TA145");
		flightDisplay.setFont(new Font("Tahoma", Font.BOLD, 12));
		flightDisplay.setForeground(new Color(205, 12, 12));
		flightDisplay.setBounds(597, 417, 94, 13);
		bookSumm.add(flightDisplay);
		
		JLabel gateDisplay = new JLabel("Gate 8");
		gateDisplay.setFont(new Font("Tahoma", Font.BOLD, 12));
		gateDisplay.setForeground(new Color(205, 12, 12));
		gateDisplay.setBounds(903, 336, 94, 13);
		bookSumm.add(gateDisplay);
		
		timeDisplay = new JLabel("New label");
		timeDisplay.setFont(new Font("Tahoma", Font.BOLD, 12));
		timeDisplay.setForeground(new Color(205, 12, 12));
		timeDisplay.setBounds(741, 336, 94, 13);
		bookSumm.add(timeDisplay);
		
		dateDisplay = new JLabel("New label");
		dateDisplay.setFont(new Font("Tahoma", Font.BOLD, 12));
		dateDisplay.setForeground(new Color(205, 12, 12));
		dateDisplay.setBounds(597, 336, 134, 13);
		bookSumm.add(dateDisplay);
		
		displayPassNo = new JLabel("New label");
		displayPassNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		displayPassNo.setForeground(new Color(205,12,12));
		displayPassNo.setBounds(259, 409, 194, 21);
		bookSumm.add(displayPassNo);
		
		displayLastname = new JLabel("New label");
		displayLastname.setFont(new Font("Tahoma", Font.BOLD, 13));
		displayLastname.setForeground(new Color(205,12,12));
		displayLastname.setBounds(245, 342, 194, 21);
		bookSumm.add(displayLastname);
		
		displayFirstname = new JLabel("New label");
		displayFirstname.setFont(new Font("Tahoma", Font.BOLD, 13));
		displayFirstname.setForeground(new Color(205, 12, 12));
		displayFirstname.setBounds(245, 271, 194, 21);
		bookSumm.add(displayFirstname);
		
		JLabel lblNewLabel_9_1 = new JLabel("Brace for Impact");
		lblNewLabel_9_1.setForeground(Color.WHITE);
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_9_1.setBounds(1205, 41, 149, 25);
		bookSumm.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/upperpanel.png")));
		lblNewLabel_8_1.setBounds(0, 0, 1502, 95);
		bookSumm.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_10_2 = new JLabel("BOOKING SUMMARY ");
		lblNewLabel_10_2.setForeground(Color.WHITE);
		lblNewLabel_10_2.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_10_2.setBounds(46, 133, 235, 25);
		bookSumm.add(lblNewLabel_10_2);
		
		JLabel lblNewLabel_10_1_4 = new JLabel("FIRST NAME");
		lblNewLabel_10_1_4.setForeground(Color.GRAY);
		lblNewLabel_10_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10_1_4.setBounds(123, 271, 127, 25);
		bookSumm.add(lblNewLabel_10_1_4);
		
		JLabel lblNewLabel_10_1_4_1 = new JLabel("LAST NAME");
		lblNewLabel_10_1_4_1.setForeground(Color.GRAY);
		lblNewLabel_10_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10_1_4_1.setBounds(123, 342, 127, 25);
		bookSumm.add(lblNewLabel_10_1_4_1);
		
		JLabel lblNewLabel_10_1_4_1_1 = new JLabel("PASSPORT NO.");
		lblNewLabel_10_1_4_1_1.setForeground(Color.GRAY);
		lblNewLabel_10_1_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10_1_4_1_1.setBounds(123, 409, 127, 25);
		bookSumm.add(lblNewLabel_10_1_4_1_1);
		
		JLabel lblNewLabel_10_1_4_2 = new JLabel("FROM");
		lblNewLabel_10_1_4_2.setForeground(Color.GRAY);
		lblNewLabel_10_1_4_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_10_1_4_2.setBounds(597, 200, 127, 25);
		bookSumm.add(lblNewLabel_10_1_4_2);
		
		JLabel lblNewLabel_10_1_4_2_1 = new JLabel("TO");
		lblNewLabel_10_1_4_2_1.setForeground(Color.GRAY);
		lblNewLabel_10_1_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_10_1_4_2_1.setBounds(781, 200, 30, 25);
		bookSumm.add(lblNewLabel_10_1_4_2_1);
		
		JLabel lblNewLabel_10_1_4_2_2 = new JLabel("DATE");
		lblNewLabel_10_1_4_2_2.setForeground(Color.GRAY);
		lblNewLabel_10_1_4_2_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_10_1_4_2_2.setBounds(597, 301, 73, 25);
		bookSumm.add(lblNewLabel_10_1_4_2_2);
		
		JLabel lblNewLabel_10_1_4_2_2_1 = new JLabel("TIME");
		lblNewLabel_10_1_4_2_2_1.setForeground(Color.GRAY);
		lblNewLabel_10_1_4_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_10_1_4_2_2_1.setBounds(741, 301, 73, 25);
		bookSumm.add(lblNewLabel_10_1_4_2_2_1);
		
		JLabel lblNewLabel_10_1_4_2_2_1_1 = new JLabel("GATE");
		lblNewLabel_10_1_4_2_2_1_1.setForeground(Color.GRAY);
		lblNewLabel_10_1_4_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_10_1_4_2_2_1_1.setBounds(903, 301, 73, 25);
		bookSumm.add(lblNewLabel_10_1_4_2_2_1_1);
		
		JLabel lblNewLabel_10_1_4_2_2_1_1_1 = new JLabel("FLIGHT ");
		lblNewLabel_10_1_4_2_2_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_10_1_4_2_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_10_1_4_2_2_1_1_1.setBounds(597, 381, 73, 25);
		bookSumm.add(lblNewLabel_10_1_4_2_2_1_1_1);
		
		JLabel lblNewLabel_10_1_4_2_2_1_1_1_1 = new JLabel("SEAT");
		lblNewLabel_10_1_4_2_2_1_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_10_1_4_2_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_10_1_4_2_2_1_1_1_1.setBounds(741, 381, 73, 25);
		bookSumm.add(lblNewLabel_10_1_4_2_2_1_1_1_1);
		
		displayDepartLoc = new JLabel("BKK");
		displayDepartLoc.setForeground(new Color(205, 12, 12));
		displayDepartLoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		displayDepartLoc.setBounds(597, 235, 149, 25);
		bookSumm.add(displayDepartLoc);
		
		displayDestLoc = new JLabel("KUL");
		displayDestLoc.setForeground(new Color(205, 12, 12));
		displayDestLoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		displayDestLoc.setBounds(781, 235, 179, 25);
		bookSumm.add(displayDestLoc);
		
		JLabel lblNewLabel_14_4 = new JLabel("");
		lblNewLabel_14_4.setOpaque(true);
		lblNewLabel_14_4.setBackground(Color.WHITE);
		lblNewLabel_14_4.setBounds(32, 168, 1165, 448);
		bookSumm.add(lblNewLabel_14_4);
		
		JLabel lblNewLabel_14_5 = new JLabel("");
		lblNewLabel_14_5.setOpaque(true);
		lblNewLabel_14_5.setBackground(new Color(205, 12, 12));
		lblNewLabel_14_5.setBounds(32, 121, 1165, 51);
		bookSumm.add(lblNewLabel_14_5);
		// Create a JDatePicker and set some properties
	  
		
		//Receipt panel
		rcptPanel = new JPanel();
		rcptPanel.setBorder(null);
		tabbedPane.addTab("Receipt", rcptPanel);
		rcptPanel.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Brace for Impact");
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_9.setBounds(1205, 41, 149, 25);
		rcptPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/upperpanel.png")));
		lblNewLabel_8.setBounds(0, 0, 1502, 95);
		rcptPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("BOOKING SUMMARY ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_10.setBounds(22, 105, 235, 25);
		rcptPanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("PASSENGER & TICKET INFORMATION");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10_1.setBounds(123, 198, 308, 25);
		rcptPanel.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_10_1_1 = new JLabel("FLIGHT DETAILS");
		lblNewLabel_10_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10_1_1.setBounds(123, 331, 142, 25);
		rcptPanel.add(lblNewLabel_10_1_1);
		
		JLabel lblNewLabel_10_1_2 = new JLabel("FARE INFORMATION");
		lblNewLabel_10_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10_1_2.setBounds(123, 461, 308, 25);
		rcptPanel.add(lblNewLabel_10_1_2);
		
		JLabel lblNewLabel_10_1_3 = new JLabel("BOOKING DATE:");
		lblNewLabel_10_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10_1_3.setBounds(708, 198, 308, 25);
		rcptPanel.add(lblNewLabel_10_1_3);
		
		JLabel lblNewLabel_10_1_2_1 = new JLabel("GRAND TOTAL(MYR): RM");
		lblNewLabel_10_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10_1_2_1.setBounds(708, 602, 308, 25);
		rcptPanel.add(lblNewLabel_10_1_2_1);
		
		JLabel lblNewLabel_11 = new JLabel("NAME:");
		lblNewLabel_11.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(123, 233, 57, 25);
		rcptPanel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_11_1 = new JLabel("TICKET NUMBER:");
		lblNewLabel_11_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_11_1.setBounds(123, 268, 100, 25);
		rcptPanel.add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_11_1_1 = new JLabel("CLASS:");
		lblNewLabel_11_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_11_1_1.setBounds(579, 233, 100, 25);
		rcptPanel.add(lblNewLabel_11_1_1);
		
		JLabel lblNewLabel_11_1_1_1 = new JLabel("SEAT NUMBER:");
		lblNewLabel_11_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_11_1_1_1.setBounds(579, 268, 100, 25);
		rcptPanel.add(lblNewLabel_11_1_1_1);
		
		JLabel lblNewLabel_11_1_1_1_1 = new JLabel("FLIGHT NUMBER:");
		lblNewLabel_11_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_11_1_1_1_1.setBounds(123, 366, 100, 25);
		rcptPanel.add(lblNewLabel_11_1_1_1_1);
		
		JLabel lblNewLabel_11_1_1_1_1_1 = new JLabel("FROM:");
		lblNewLabel_11_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_11_1_1_1_1_1.setBounds(123, 398, 100, 25);
		rcptPanel.add(lblNewLabel_11_1_1_1_1_1);
		
		JLabel lblNewLabel_37 = new JLabel("New label");
		lblNewLabel_37.setBounds(173, 240, 221, 13);
		rcptPanel.add(lblNewLabel_37);
		
		FlightSummary = new JPanel();
		FlightSummary.setBackground(new Color(128, 128, 255));
		tabbedPane.addTab("New tab", null, FlightSummary, null);
		FlightSummary.setLayout(null);
		
		JPanel RightPanel = new JPanel();
		RightPanel.setBounds(813, 104, 378, 676);
		FlightSummary.add(RightPanel);
		RightPanel.setLayout(null);
		
		JPanel TripSummary = new JPanel();
		TripSummary.setBounds(0, 0, 378, 108);
		RightPanel.add(TripSummary);
		TripSummary.setLayout(null);
		
		JLabel TripSumLbl = new JLabel("  Trip Summary ");
		TripSumLbl.setForeground(new Color(255, 255, 255));
		TripSumLbl.setBackground(new Color(128, 128, 128));
		TripSumLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		TripSumLbl.setOpaque(true);
		TripSumLbl.setBounds(0, 0, 378, 35);
		TripSummary.add(TripSumLbl);
		
		JLabel totalpassLbl = new JLabel("Total Passenger");
		totalpassLbl.setForeground(new Color(30, 65, 155));
		totalpassLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		totalpassLbl.setBounds(10, 31, 126, 26);
		TripSummary.add(totalpassLbl);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/person-male.png")));
		lblNewLabel_3.setBounds(20, 59, 51, 35);
		TripSummary.add(lblNewLabel_3);
		
		passCtr = new JLabel("");
		passCtr.setForeground(new Color(0, 0, 0));
		passCtr.setBounds(81, 59, 40, 35);
		TripSummary.add(passCtr);
		
		displayNumPass = new JLabel("PASSENGER");
		displayNumPass.setBounds(103, 59, 111, 39);
		TripSummary.add(displayNumPass);
		
		upperPanelCont = new JPanel();
		cdr4 = new CardLayout(0,0);
		upperPanelCont.setBounds(0, 107, 378, 200);
		RightPanel.add(upperPanelCont);
		upperPanelCont.setLayout(cdr4);
		
		JPanel TripSummary1 = new JPanel();
		upperPanelCont.add(TripSummary1, "Trip1");
		TripSummary1.setLayout(null);
		
		JLabel lblFareSelection = new JLabel("  Fare Selection");
		lblFareSelection.setOpaque(true);
		lblFareSelection.setForeground(Color.WHITE);
		lblFareSelection.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFareSelection.setBackground(Color.GRAY);
		lblFareSelection.setBounds(0, 0, 378, 35);
		TripSummary1.add(lblFareSelection);
		
		JLabel lblNewLabel_1 = new JLabel("Depart");
		lblNewLabel_1.setForeground(new Color(30, 65, 155));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(26, 51, 45, 13);
		TripSummary1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/button.png")));
		lblNewLabel_2.setBounds(52, 103, 273, 55);
		TripSummary1.add(lblNewLabel_2);
		
		departDateLbl1 = new JLabel("");
		departDateLbl1.setBounds(158, 80, 104, 13);
		TripSummary1.add(departDateLbl1);
		
		JPanel TripSummary2 = new JPanel();
		TripSummary2.setLayout(null);
		upperPanelCont.add(TripSummary2, "Trip2");
		
		JLabel lblFareSelection_2_1 = new JLabel("  Fare Selection");
		lblFareSelection_2_1.setOpaque(true);
		lblFareSelection_2_1.setForeground(Color.WHITE);
		lblFareSelection_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFareSelection_2_1.setBackground(Color.GRAY);
		lblFareSelection_2_1.setBounds(0, 0, 378, 35);
		TripSummary2.add(lblFareSelection_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Depart");
		lblNewLabel_1_2_1.setForeground(new Color(30, 65, 155));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_1.setBounds(26, 51, 45, 13);
		TripSummary2.add(lblNewLabel_1_2_1);
		
		JLabel departDateLbl2 = new JLabel("new label");
		departDateLbl2.setFont(new Font("Tahoma", Font.BOLD, 13));
		departDateLbl2.setBounds(26, 74, 194, 19);
		TripSummary2.add(departDateLbl2);
		
		displayDepartTime1 = new JLabel("New label");
		displayDepartTime1.setBounds(26, 103, 106, 26);
		TripSummary2.add(displayDepartTime1);
		
		JLabel displayArriveTime1 = new JLabel("New label");
		displayArriveTime1.setBounds(26, 125, 106, 26);
		TripSummary2.add(displayArriveTime1);
		
		JLabel trashbinIcon1 = new JLabel("");
		trashbinIcon1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cdr4.previous(upperPanelCont);
				resetDesign = true;
				FlightSchedule.setBackground(new Color (240,240,240));
				FlightSchedule.setBorder(new LineBorder(new Color(192, 192, 192)));
				minisidePanel.setBackground(new Color(192, 192, 192));
				//pricePanel1.setBackground(new Color(255,255,255));
				pricePanelheader1.setBackground(new Color(192, 192, 192));
				FlightSchedule_2.setBackground(new Color (240,240,240));
				FlightSchedule_2.setBorder(new LineBorder(new Color(192, 192, 192)));
				minisidePanel2.setBackground(new Color(192, 192, 192));
				pricePanel1.setBorder(new LineBorder(new Color(192,192,192)));
				pricePanelheader2.setBackground(new Color(192, 192, 192));
				departDestinationLbl1.setText("New Label");
				clicked = false;
				showFare1 = false;
				cdr6.first(farePanelCont);
			}
		});
		trashbinIcon1.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-delete-trash-24.png")));
		trashbinIcon1.setBounds(333, 45, 24, 24);
		TripSummary2.add(trashbinIcon1);
		
		JLabel departOriginLbl1 = new JLabel("New label");
		departOriginLbl1.setBounds(175, 110, 128, 13);
		TripSummary2.add(departOriginLbl1);
		
		departDestinationLbl1 = new JLabel("New label");
		departDestinationLbl1.setBounds(175, 132, 128, 13);
		TripSummary2.add(departDestinationLbl1);
		
		JLabel totalDurationLbl1 = new JLabel("Total duration:");
		totalDurationLbl1.setBounds(26, 161, 84, 13);
		TripSummary2.add(totalDurationLbl1);
		
		JLabel displayDuration1 = new JLabel("New label");
		displayDuration1.setBounds(114, 161, 66, 13);
		TripSummary2.add(displayDuration1);
		
		JLabel classTypeLbl1 = new JLabel("Class type:");
		classTypeLbl1.setBounds(175, 161, 76, 13);
		TripSummary2.add(classTypeLbl1);
		
		JLabel displayClass1 = new JLabel("New label");
		displayClass1.setBounds(238, 161, 106, 13);
		TripSummary2.add(displayClass1);
		
		lowerPanelCont = new JPanel();
		cdr5 = new CardLayout(0,0);
		lowerPanelCont.setBounds(0, 317, 378, 199);
		RightPanel.add(lowerPanelCont);
		lowerPanelCont.setLayout(cdr5);
		
		JPanel TripSummary3 = new JPanel();
		lowerPanelCont.add(TripSummary3, "Trip3");
		TripSummary3.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/button.png")));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(52, 103, 270, 55);
		TripSummary3.add(lblNewLabel_2_2);
		
		JLabel lblFareSelection_1 = new JLabel("  Fare Selection");
		lblFareSelection_1.setOpaque(true);
		lblFareSelection_1.setForeground(Color.WHITE);
		lblFareSelection_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFareSelection_1.setBackground(Color.GRAY);
		lblFareSelection_1.setBounds(0, 0, 378, 35);
		TripSummary3.add(lblFareSelection_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(54, 75, 286, 79);
		TripSummary3.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Return");
		lblNewLabel_1_1.setBounds(33, 52, 45, 13);
		TripSummary3.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(30, 65, 155));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		returnDateLbl1 = new JLabel("");
		returnDateLbl1.setBounds(164, 76, 129, 13);
		TripSummary3.add(returnDateLbl1);
		
		JPanel TripSummary4 = new JPanel();
		TripSummary4.setLayout(null);
		lowerPanelCont.add(TripSummary4, "Trip4");
		
		JLabel lblFareSelection_1_1 = new JLabel("  Fare Selection");
		lblFareSelection_1_1.setOpaque(true);
		lblFareSelection_1_1.setForeground(Color.WHITE);
		lblFareSelection_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFareSelection_1_1.setBackground(Color.GRAY);
		lblFareSelection_1_1.setBounds(0, 0, 378, 35);
		TripSummary4.add(lblFareSelection_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Return");
		lblNewLabel_1_1_1.setForeground(new Color(30, 65, 155));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(33, 52, 45, 13);
		TripSummary4.add(lblNewLabel_1_1_1);
		
		JLabel departDateLbl2_1 = new JLabel("new label");
		departDateLbl2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		departDateLbl2_1.setBounds(33, 75, 194, 19);
		TripSummary4.add(departDateLbl2_1);
		
		JLabel displayDepartTime2 = new JLabel("New label");
		displayDepartTime2.setBounds(33, 104, 106, 26);
		TripSummary4.add(displayDepartTime2);
		
		JLabel displayArriveTime2 = new JLabel("New label");
		displayArriveTime2.setBounds(33, 127, 106, 26);
		TripSummary4.add(displayArriveTime2);
		
		JLabel trashbinIcon2 = new JLabel("");
		trashbinIcon2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cdr5.previous(lowerPanelCont);
				resetDesign = true;
				FlightSchedule_2_1.setBackground(new Color (240,240,240));
				FlightSchedule_2_1.setBorder(new LineBorder(new Color(192, 192, 192)));
				pricePanelheader3.setBackground(new Color(192, 192, 192));
				minisidePanel3.setBackground(new Color(192, 192, 192));
				FlightSchedule_2_2.setBackground(new Color (240,240,240));
				FlightSchedule_2_2.setBorder(new LineBorder(new Color(192, 192, 192)));
				minisidePanel4.setBackground(new Color(192, 192, 192));
				pricePanelheader4.setBackground(new Color(192, 192, 192));
				departDestinationLbl2.setText("New Label");
				clicked2 = false;
				showFare2 = false;
				cdr6.first(farePanelCont);
			}
		});
		trashbinIcon2.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-delete-trash-24.png")));
		trashbinIcon2.setBounds(333, 45, 24, 24);
		TripSummary4.add(trashbinIcon2);
		
		JLabel departOriginLbl2 = new JLabel("New label");
		departOriginLbl2.setBounds(174, 111, 128, 13);
		TripSummary4.add(departOriginLbl2);
		
		departDestinationLbl2 = new JLabel("New label");
		departDestinationLbl2.setBounds(174, 134, 128, 13);
		TripSummary4.add(departDestinationLbl2);
		
		JLabel totalDurationLbl2 = new JLabel("Total duration:");
		totalDurationLbl2.setBounds(26, 161, 84, 13);
		TripSummary4.add(totalDurationLbl2);
		
		JLabel displayDuration2 = new JLabel("New label");
		displayDuration2.setBounds(114, 161, 66, 13);
		TripSummary4.add(displayDuration2);
		
		JLabel classTypeLbl2 = new JLabel("Class type:");
		classTypeLbl2.setBounds(175, 161, 76, 13);
		TripSummary4.add(classTypeLbl2);
		
		JLabel displayClass2 = new JLabel("New label");
		displayClass2.setBounds(238, 161, 106, 13);
		TripSummary4.add(displayClass2);
		
		cdr6 = new CardLayout(0,0);
		farePanelCont = new JPanel();
		farePanelCont.setBounds(0, 526, 378, 148);
		RightPanel.add(farePanelCont);
		farePanelCont.setLayout(cdr6);
		
		JPanel TripSummary_1_1 = new JPanel();
		farePanelCont.add(TripSummary_1_1, "name_98885226645500");
		TripSummary_1_1.setLayout(null);
		
		JLabel lblFareSummary = new JLabel("  Fare Summary ");
		lblFareSummary.setOpaque(true);
		lblFareSummary.setForeground(Color.WHITE);
		lblFareSummary.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFareSummary.setBackground(Color.GRAY);
		lblFareSummary.setBounds(0, 0, 378, 35);
		TripSummary_1_1.add(lblFareSummary);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("");
		lblNewLabel_2_2_1.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/button.png")));
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setBounds(51, 69, 270, 55);
		TripSummary_1_1.add(lblNewLabel_2_2_1);
		
		JPanel TripSummary_1_1_1 = new JPanel();
		TripSummary_1_1_1.setLayout(null);
		farePanelCont.add(TripSummary_1_1_1, "name_99025518222800");
		
		JLabel lblFareSummary_1 = new JLabel("  Fare Summary ");
		lblFareSummary_1.setOpaque(true);
		lblFareSummary_1.setForeground(Color.WHITE);
		lblFareSummary_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFareSummary_1.setBackground(Color.GRAY);
		lblFareSummary_1.setBounds(0, 0, 378, 35);
		TripSummary_1_1_1.add(lblFareSummary_1);
		
		JLabel lblNewLabel_26 = new JLabel("Air Fare");
		lblNewLabel_26.setBounds(10, 45, 45, 13);
		TripSummary_1_1_1.add(lblNewLabel_26);
		
		JLabel displayFare = new JLabel("New label");
		displayFare.setBounds(181, 45, 126, 13);
		TripSummary_1_1_1.add(displayFare);
		
		JLabel lblNewLabel_33 = new JLabel("Taxes, Fee and");
		lblNewLabel_33.setBounds(10, 78, 100, 13);
		TripSummary_1_1_1.add(lblNewLabel_33);
		
		JLabel lblNewLabel_34 = new JLabel("Charges");
		lblNewLabel_34.setBounds(10, 90, 74, 13);
		TripSummary_1_1_1.add(lblNewLabel_34);
		
		JLabel displayTaxes = new JLabel("New label");
		displayTaxes.setBounds(181, 78, 126, 13);
		TripSummary_1_1_1.add(displayTaxes);
		
		JLabel lblNewLabel_35 = new JLabel("Total");
		lblNewLabel_35.setBounds(10, 125, 45, 13);
		TripSummary_1_1_1.add(lblNewLabel_35);
		
		JLabel dsplayTotalFare = new JLabel("New label");
		dsplayTotalFare.setBounds(181, 125, 126, 13);
		TripSummary_1_1_1.add(dsplayTotalFare);
		
		JPanel DepartPanel = new JPanel();
		DepartPanel.setBounds(52, 102, 724, 678);
		FlightSummary.add(DepartPanel);
		DepartPanel.setLayout(null);
		
		JPanel DepartHeader = new JPanel();
		DepartHeader.setBorder(new LineBorder(new Color(192, 192, 192)));
		DepartHeader.setBounds(0, 0, 724, 79);
		DepartPanel.add(DepartHeader);
		DepartHeader.setLayout(null);
		
		JLabel DepartLbl = new JLabel("Depart");
		DepartLbl.setForeground(new Color(128, 128, 128));
		DepartLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		DepartLbl.setBounds(10, 0, 87, 44);
		DepartHeader.add(DepartLbl);
		
		OriginLbl = new JLabel("");
		OriginLbl.setForeground(new Color(0, 0, 0));
		OriginLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		OriginLbl.setHorizontalAlignment(SwingConstants.CENTER);
		OriginLbl.setBounds(10, 45, 131, 24);
		DepartHeader.add(OriginLbl);
		
		destinationLbl = new JLabel("");
		destinationLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		destinationLbl.setHorizontalAlignment(SwingConstants.CENTER);
		destinationLbl.setBounds(291, 45, 131, 24);
		DepartHeader.add(destinationLbl);
		
		JLabel lblNewLabel_23_2 = new JLabel("To");
		lblNewLabel_23_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_23_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23_2.setBounds(179, 45, 87, 24);
		DepartHeader.add(lblNewLabel_23_2);
		
		JLabel lblNewLabel_24 = new JLabel("");
		lblNewLabel_24.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-airplane-take-off-26.png")));
		lblNewLabel_24.setBounds(85, 10, 51, 34);
		DepartHeader.add(lblNewLabel_24);
		
		FlightSchedule = new JPanel();
		FlightSchedule.setBorder(new LineBorder(new Color(192, 192, 192)));
		FlightSchedule.setBounds(0, 89, 724, 109);
		DepartPanel.add(FlightSchedule);
		FlightSchedule.setLayout(null);
		
		minisidePanel = new JLabel("");
		minisidePanel.setBackground(new Color(192, 192, 192));
		minisidePanel.setOpaque(true);
		minisidePanel.setBounds(0, 0, 10, 109);
		FlightSchedule.add(minisidePanel);
	
		departTime1 = new JLabel("01:10");
		departTime1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		departTime1.setBounds(20, 10, 89, 65);
		FlightSchedule.add(departTime1);
		
		JLabel lblNewLabel_27 = new JLabel("");
		lblNewLabel_27.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-right-arrow-64.png")));
		lblNewLabel_27.setBounds(133, 26, 78, 49);
		FlightSchedule.add(lblNewLabel_27);
		
		arrivalTime1 = new JLabel("09:10");
		arrivalTime1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		arrivalTime1.setBounds(235, 10, 89, 65);
		FlightSchedule.add(arrivalTime1);
		
		JLabel lblNewLabel_28 = new JLabel("Direct ");
		lblNewLabel_28.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_28.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_28.setBounds(133, 20, 62, 13);
		FlightSchedule.add(lblNewLabel_28);
		
		JLabel duration1 = new JLabel("11h 10m");
		duration1.setHorizontalAlignment(SwingConstants.CENTER);
		duration1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		duration1.setBounds(119, 62, 106, 13);
		FlightSchedule.add(duration1);
		
		JLabel lblNewLabel_29 = new JLabel("");
		lblNewLabel_29.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/img_flightFin_qantas.png")));
		lblNewLabel_29.setBounds(357, 36, 32, 20);
		FlightSchedule.add(lblNewLabel_29);
		
		JLabel airplane1 = new JLabel("Triple Airlines TA145");
		airplane1.setBounds(399, 44, 129, 13);
		FlightSchedule.add(airplane1);
		
		pricePanel1 = new JPanel();
		pricePanel1.setBorder(new LineBorder(new Color(192, 192, 192)));
		pricePanel1.setBounds(566, 0, 158, 99);
		FlightSchedule.add(pricePanel1);
		pricePanel1.setLayout(null);
		
		pricePanelheader1 = new JLabel("New label");
		pricePanelheader1.setHorizontalAlignment(SwingConstants.CENTER);
		pricePanelheader1.setOpaque(true);
		pricePanelheader1.setBackground(new Color(192, 192, 192));
		pricePanelheader1.setBounds(0, 0, 157, 32);
		pricePanel1.add(pricePanelheader1);
		
		JLabel displayPrice1 = new JLabel("662.54");
		displayPrice1.setHorizontalAlignment(SwingConstants.CENTER);
		displayPrice1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		displayPrice1.setBounds(41, 55, 74, 32);
		pricePanel1.add(displayPrice1);
		
		JLabel lblNewLabel_31 = new JLabel("From");
		lblNewLabel_31.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_31.setBounds(54, 42, 45, 13);
		pricePanel1.add(lblNewLabel_31);
		
		
		
		
		
		JPanel ReturnHeader = new JPanel();
		ReturnHeader.setBorder(new LineBorder(new Color(192, 192, 192)));
		ReturnHeader.setLayout(null);
		ReturnHeader.setBounds(0, 327, 724, 79);
		DepartPanel.add(ReturnHeader);
		
		JLabel RetrunLbl = new JLabel("Return");
		RetrunLbl.setForeground(Color.GRAY);
		RetrunLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		RetrunLbl.setBounds(10, 0, 87, 44);
		ReturnHeader.add(RetrunLbl);
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-airplane-landing-26.png")));
		lblNewLabel_23.setBounds(92, 10, 44, 34);
		ReturnHeader.add(lblNewLabel_23);
		
		OriginLbl_1 = new JLabel("");
		OriginLbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		OriginLbl_1.setForeground(Color.BLACK);
		OriginLbl_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		OriginLbl_1.setBounds(291, 45, 131, 24);
		ReturnHeader.add(OriginLbl_1);
		
		destinationLbl_1 = new JLabel("");
		destinationLbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		destinationLbl_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		destinationLbl_1.setBounds(10, 45, 131, 24);
		ReturnHeader.add(destinationLbl_1);
		
		JLabel lblNewLabel_23_2_1 = new JLabel("To");
		lblNewLabel_23_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23_2_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_23_2_1.setBounds(179, 45, 87, 24);
		ReturnHeader.add(lblNewLabel_23_2_1);
		
		FlightSchedule_2 = new JPanel();
		FlightSchedule_2.setLayout(null);
		FlightSchedule_2.setBorder(new LineBorder(new Color(192, 192, 192)));
		FlightSchedule_2.setBounds(0, 208, 724, 109);
		DepartPanel.add(FlightSchedule_2);
		
		minisidePanel2 = new JLabel("");
		minisidePanel2.setOpaque(true);
		minisidePanel2.setBackground(Color.LIGHT_GRAY);
		minisidePanel2.setBounds(0, 0, 10, 109);
		FlightSchedule_2.add(minisidePanel2);
		
		JLabel departTime2 = new JLabel("07:30");
		departTime2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		departTime2.setBounds(20, 10, 89, 65);
		FlightSchedule_2.add(departTime2);
		
		JLabel lblNewLabel_27_1 = new JLabel("");
		lblNewLabel_27_1.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-right-arrow-64.png")));
		lblNewLabel_27_1.setBounds(133, 26, 78, 49);
		FlightSchedule_2.add(lblNewLabel_27_1);
		
		JLabel arrivalTime2 = new JLabel("16:05");
		arrivalTime2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		arrivalTime2.setBounds(235, 10, 89, 65);
		FlightSchedule_2.add(arrivalTime2);
		
		
		JLabel duration2 = new JLabel("14h 35m");
		duration2.setHorizontalAlignment(SwingConstants.CENTER);
		duration2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		duration2.setBounds(119, 68, 106, 13);
		FlightSchedule_2.add(duration2);
		
		pricePanel2 = new JPanel();
		pricePanel2.setLayout(null);
		pricePanel2.setBorder(new LineBorder(new Color(192, 192, 192)));
		pricePanel2.setBounds(566, 0, 158, 99);
		FlightSchedule_2.add(pricePanel2);
		
		displayPrice2 = new JLabel("759.18");
		displayPrice2.setHorizontalAlignment(SwingConstants.CENTER);
		displayPrice2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		displayPrice2.setBounds(41, 55, 74, 32);
		pricePanel2.add(displayPrice2);
		
		
	
		
		JLabel lblNewLabel_28_2 = new JLabel("1 stop");
		lblNewLabel_28_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_28_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_28_2.setBounds(133, 21, 67, 13);
		FlightSchedule_2.add(lblNewLabel_28_2);
		
		JLabel lblNewLabel_29_1 = new JLabel("");
		lblNewLabel_29_1.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/img_flightFin_qantas.png")));
		lblNewLabel_29_1.setBounds(356, 22, 32, 20);
		FlightSchedule_2.add(lblNewLabel_29_1);
		
		JLabel airplane2 = new JLabel("Triple Airlines TA129");
		airplane2.setBounds(398, 29, 169, 13);
		FlightSchedule_2.add(airplane2);
		
		JLabel lblNewLabel_29_1_1 = new JLabel("");
		lblNewLabel_29_1_1.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/img_flightFin_mab.png")));
		lblNewLabel_29_1_1.setBounds(356, 61, 32, 20);
		FlightSchedule_2.add(lblNewLabel_29_1_1);
		
		JLabel lblNewLabel_30_1_1 = new JLabel("Malaysia Airlines MH365");
		lblNewLabel_30_1_1.setBounds(398, 69, 199, 13);
		FlightSchedule_2.add(lblNewLabel_30_1_1);
		
		
		
		pricePanelheader2 = new JLabel("New label");
		pricePanelheader2.setOpaque(true);
		pricePanelheader2.setHorizontalAlignment(SwingConstants.CENTER);
		pricePanelheader2.setBackground(Color.LIGHT_GRAY);
		pricePanelheader2.setBounds(0, 0, 157, 32);
		pricePanel2.add(pricePanelheader2);
		
		
		
		JLabel lblNewLabel_31_1 = new JLabel("From");
		lblNewLabel_31_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_31_1.setBounds(54, 42, 45, 13);
		pricePanel2.add(lblNewLabel_31_1);
		
		FlightSchedule_2_1 = new JPanel();
		FlightSchedule_2_1.setLayout(null);
		FlightSchedule_2_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		FlightSchedule_2_1.setBounds(0, 416, 724, 109);
		DepartPanel.add(FlightSchedule_2_1);
		
		minisidePanel3 = new JLabel("");
		minisidePanel3.setOpaque(true);
		minisidePanel3.setBackground(Color.LIGHT_GRAY);
		minisidePanel3.setBounds(0, 0, 10, 109);
		FlightSchedule_2_1.add(minisidePanel3);
		
		JLabel departTime3 = new JLabel("03:20");
		departTime3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		departTime3.setBounds(20, 10, 89, 65);
		FlightSchedule_2_1.add(departTime3);
		
		JLabel lblNewLabel_27_1_1 = new JLabel("");
		lblNewLabel_27_1_1.setBounds(138, 26, 78, 49);
		FlightSchedule_2_1.add(lblNewLabel_27_1_1);
		
		JLabel arrivalTime3 = new JLabel("11:45");
		arrivalTime3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		arrivalTime3.setBounds(235, 10, 89, 65);
		FlightSchedule_2_1.add(arrivalTime3);
		
		JLabel duration3 = new JLabel("11h 25m");
		duration3.setHorizontalAlignment(SwingConstants.CENTER);
		duration3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		duration3.setBounds(119, 68, 106, 13);
		FlightSchedule_2_1.add(duration3);
		
		
		JLabel lblNewLabel_28_2_1 = new JLabel("Direct ");
		lblNewLabel_28_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_28_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_28_2_1.setBounds(138, 10, 62, 13);
		FlightSchedule_2_1.add(lblNewLabel_28_2_1);
		
		JLabel lblNewLabel_27_1_3 = new JLabel("");
		lblNewLabel_27_1_3.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-right-arrow-64.png")));
		lblNewLabel_27_1_3.setBounds(133, 26, 78, 49);
		FlightSchedule_2_1.add(lblNewLabel_27_1_3);
		
		JLabel lblNewLabel_29_1_1_1 = new JLabel("");
		lblNewLabel_29_1_1_1.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/img_flightFin_mab.png")));
		lblNewLabel_29_1_1_1.setBounds(367, 37, 32, 20);
		FlightSchedule_2_1.add(lblNewLabel_29_1_1_1);
		
		JLabel lblNewLabel_30_1_1_1 = new JLabel("Malaysia Airlines MH307");
		lblNewLabel_30_1_1_1.setBounds(405, 44, 159, 13);
		FlightSchedule_2_1.add(lblNewLabel_30_1_1_1);
		
		JPanel pricePanel3 = new JPanel();
		pricePanel3.setLayout(null);
		pricePanel3.setBorder(new LineBorder(new Color(192, 192, 192)));
		pricePanel3.setBounds(566, 0, 158, 99);
		FlightSchedule_2_1.add(pricePanel3);
		
		pricePanelheader3 = new JLabel("New label");
		pricePanelheader3.setOpaque(true);
		pricePanelheader3.setHorizontalAlignment(SwingConstants.CENTER);
		pricePanelheader3.setBackground(Color.LIGHT_GRAY);
		pricePanelheader3.setBounds(0, 0, 157, 32);
		pricePanel3.add(pricePanelheader3);
		
		JLabel displayPrice3 = new JLabel("712.85");
		displayPrice3.setHorizontalAlignment(SwingConstants.CENTER);
		displayPrice3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		displayPrice3.setBounds(41, 55, 74, 32);
		pricePanel3.add(displayPrice3);
		
		JLabel lblNewLabel_31_2 = new JLabel("From");
		lblNewLabel_31_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_31_2.setBounds(54, 42, 45, 13);
		pricePanel3.add(lblNewLabel_31_2);
		
		FlightSchedule_2_2 = new JPanel();
	
		FlightSchedule_2_2.setLayout(null);
		FlightSchedule_2_2.setBorder(new LineBorder(new Color(192, 192, 192)));
		FlightSchedule_2_2.setBounds(0, 535, 724, 109);
		DepartPanel.add(FlightSchedule_2_2);
		
		minisidePanel4 = new JLabel("");
		minisidePanel4.setOpaque(true);
		minisidePanel4.setBackground(Color.LIGHT_GRAY);
		minisidePanel4.setBounds(0, 0, 10, 109);
		FlightSchedule_2_2.add(minisidePanel4);
		
		JLabel departTime4 = new JLabel("04:35");
		departTime4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		departTime4.setBounds(20, 10, 89, 65);
		FlightSchedule_2_2.add(departTime4);
		
		JLabel lblNewLabel_27_1_2 = new JLabel("");
		lblNewLabel_27_1_2.setBounds(133, 26, 78, 49);
		FlightSchedule_2_2.add(lblNewLabel_27_1_2);
		
		JLabel arrivalTime4 = new JLabel("15:15");
		arrivalTime4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		arrivalTime4.setBounds(235, 10, 89, 65);
		FlightSchedule_2_2.add(arrivalTime4);
		
		JLabel duration4 = new JLabel("14h 40m");
		duration4.setHorizontalAlignment(SwingConstants.CENTER);
		duration4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		duration4.setBounds(119, 68, 106, 13);
		FlightSchedule_2_2.add(duration4);
		
		
		
		JLabel lblNewLabel_28_2_2 = new JLabel("1 stop");
		lblNewLabel_28_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_28_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_28_2_2.setBounds(138, 10, 62, 13);
		FlightSchedule_2_2.add(lblNewLabel_28_2_2);
		
		JLabel lblNewLabel_27_1_1_1 = new JLabel("");
		lblNewLabel_27_1_1_1.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/icons8-right-arrow-64.png")));
		lblNewLabel_27_1_1_1.setBounds(133, 26, 78, 49);
		FlightSchedule_2_2.add(lblNewLabel_27_1_1_1);
		
		JLabel lblNewLabel_29_1_2 = new JLabel("");
		lblNewLabel_29_1_2.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/img_flightFin_qantas.png")));
		lblNewLabel_29_1_2.setBounds(373, 26, 32, 20);
		FlightSchedule_2_2.add(lblNewLabel_29_1_2);
		
		JLabel lblNewLabel_30_1_2 = new JLabel("Triple Airlines TA129");
		lblNewLabel_30_1_2.setBounds(415, 33, 152, 13);
		FlightSchedule_2_2.add(lblNewLabel_30_1_2);
		
		JLabel lblNewLabel_29_1_1_2 = new JLabel("");
		lblNewLabel_29_1_1_2.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/img_flightFin_mab.png")));
		lblNewLabel_29_1_1_2.setBounds(373, 55, 32, 20);
		FlightSchedule_2_2.add(lblNewLabel_29_1_1_2);
		
		JLabel lblNewLabel_30_1_1_1_1 = new JLabel("Malaysia Airlines MH027");
		lblNewLabel_30_1_1_1_1.setBounds(415, 62, 152, 13);
		FlightSchedule_2_2.add(lblNewLabel_30_1_1_1_1);
		
		JPanel pricePanel4 = new JPanel();
		pricePanel4.setLayout(null);
		pricePanel4.setBorder(new LineBorder(new Color(192, 192, 192)));
		pricePanel4.setBounds(566, 0, 158, 99);
		FlightSchedule_2_2.add(pricePanel4);
		
		pricePanelheader4 = new JLabel("New label");
		pricePanelheader4.setOpaque(true);
		pricePanelheader4.setHorizontalAlignment(SwingConstants.CENTER);
		pricePanelheader4.setBackground(Color.LIGHT_GRAY);
		pricePanelheader4.setBounds(0, 0, 157, 32);
		pricePanel4.add(pricePanelheader4);
		
		JLabel displayPrice4 = new JLabel("829.25");
		displayPrice4.setHorizontalAlignment(SwingConstants.CENTER);
		displayPrice4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		displayPrice4.setBounds(41, 55, 74, 32);
		pricePanel4.add(displayPrice4);
		
		JLabel lblNewLabel_31_2_1 = new JLabel("From");
		lblNewLabel_31_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_31_2_1.setBounds(54, 42, 45, 13);
		pricePanel4.add(lblNewLabel_31_2_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/upperpanel.png")));
		lblNewLabel.setBounds(0, 0, 1389, 92);
		FlightSummary.add(lblNewLabel);
		
		JLabel lblNewLabel_25 = new JLabel("");
		lblNewLabel_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayTime.setText(summary.getdepartTime());
				displayPass.setText(Integer.toString(book.getnumPass()));
				tabbedPane.setSelectedComponent(Seatpanel);
			}
			
		});
		lblNewLabel_25.setBounds(837, 790, 330, 57);
		FlightSummary.add(lblNewLabel_25);
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_25.setIcon(new ImageIcon(Homepage.class.getResource("/assignment_2/redbutton (1).png")));
		
		//FlightScedule1
		FlightSchedule.addMouseListener(new MouseAdapter() {
			String departTime = departTime1.getText();
			String arrivalTime = arrivalTime1.getText();
		
			@Override
			public void mouseEntered(MouseEvent e) {
				FlightSchedule.setBorder(new LineBorder(new Color(205,12,12)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				FlightSchedule.setBorder(new LineBorder(new Color(192, 192, 192)));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//nested if: first one for trash bin icon//when trash bin was clicked change the design of the panel to normal
				//add flag variable to outer control statement// add flag variable to trash bin icon
				//second for changing the design of the panel
				//also change the clicked value at trash bin icon to allow the mouseclicked at this section
				departFare =Double.parseDouble(displayPrice1.getText());
				
				
				if(!clicked) {
					summary = new FlightSummary(departTime,arrivalTime);
					FlightSchedule.setBackground(new Color (192, 192, 192));
					minisidePanel.setBackground(new Color(159,96,53));
					pricePanelheader1.setBackground(new Color(159,96,53));
					departDateLbl2.setText(book.departDateFormatter());
					displayDepartTime1.setText(summary.getdepartTime());
					displayArriveTime1.setText(summary.getarriveTime());
					departOriginLbl1.setText(book.getorigin().toUpperCase());
					departDestinationLbl1.setText(book.getDestination().toUpperCase());
					displayDuration1.setText(duration1.getText());
					displayClass1.setText(book.getBookingClass());
					System.out.print(book.getBookingClass());
				
					clicked = true;
					cdr4.next(upperPanelCont);
					showFare1 = true;
				}
				if(showFare1 && showFare2 )
				{
					summary.setdepartFare(departFare);
					summary.setreturnFare(returnFare);
					displayTaxes.setText(Double.toString(summary.getTaxes()));
					double totalFare = summary.getdepartFare()+summary.getreturnFare();
					df.setRoundingMode(RoundingMode.HALF_UP);
					String roundedNumber = df.format(totalFare);
					displayFare.setText(roundedNumber);
					double TotalCharge = summary.TotalCharge();
					String roundedNumber1 = df.format(TotalCharge);
					dsplayTotalFare.setText(roundedNumber1);
					
					
				}
						 
			}
		});
		
        //FlightScedule2
		FlightSchedule_2.addMouseListener(new MouseAdapter() {
			String departTime = departTime2.getText();
			String arrivalTime = arrivalTime2.getText();

			@Override
			public void mouseEntered(MouseEvent e) {
				FlightSchedule_2.setBorder(new LineBorder(new Color(205,12,12)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				FlightSchedule_2.setBorder(new LineBorder(new Color(192, 192, 192)));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				departFare =Double.parseDouble(displayPrice2.getText());
				if(!clicked) {
					summary = new FlightSummary(departTime,arrivalTime);
					FlightSchedule_2.setBackground(new Color (192, 192, 192));
					minisidePanel2.setBackground(new Color(159,96,53));
					pricePanelheader2.setBackground(new Color(159,96,53));
					departDateLbl2.setText(book.departDateFormatter());
					displayDepartTime1.setText(summary.getdepartTime());
					departDestinationLbl1.setText(book.getDestination().toUpperCase());
					displayArriveTime1.setText(summary.getarriveTime());
					displayDuration1.setText(duration2.getText());
					clicked = true;
					cdr4.next(upperPanelCont);
					showFare1 = true;
				}
				if(showFare1 && showFare2 )
				{
					summary.setdepartFare(departFare);
					summary.setreturnFare(returnFare);
					displayTaxes.setText(Double.toString(summary.getTaxes()));
					double totalFare = summary.getdepartFare()+summary.getreturnFare();
					df.setRoundingMode(RoundingMode.HALF_UP);
					String roundedNumber = df.format(totalFare);
					displayFare.setText(roundedNumber);
					double TotalCharge = summary.TotalCharge();
					String roundedNumber1 = df.format(TotalCharge);
					dsplayTotalFare.setText(roundedNumber1);
					cdr6.last(farePanelCont);
					
				}
//				else {
//					cdr6.previous(farePanelCont);
//			}
				 
			}
		});
		 //FlightScedule3
		FlightSchedule_2_1.addMouseListener(new MouseAdapter() {
			String departTime = departTime3.getText();
			String arrivalTime = arrivalTime3.getText();
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				FlightSchedule_2_1.setBorder(new LineBorder(new Color(205,12,12)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				FlightSchedule_2_1.setBorder(new LineBorder(new Color(192, 192, 192)));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				returnFare =Double.parseDouble(displayPrice3.getText());
				if(!clicked2) {
					summary = new FlightSummary(departTime, arrivalTime);
					FlightSchedule_2_1.setBackground(new Color (192, 192, 192));
					minisidePanel3.setBackground(new Color(159,96,53));
					pricePanelheader3.setBackground(new Color(159,96,53));
					clicked2 = true;
					departDateLbl2_1.setText(book.returnDateFormatter());
					displayDepartTime2.setText(summary.getdepartTime());
					displayArriveTime2.setText(summary.getarriveTime());
					departOriginLbl2.setText(book.getDestination().toUpperCase());
					departDestinationLbl2.setText(book.getorigin().toUpperCase());
					displayDuration2.setText(duration3.getText());
					displayClass2.setText(book.getBookingClass());
					cdr5.next(lowerPanelCont);
					 showFare2 = true;
				}
				if(showFare1 && showFare2 )
				{
					summary.setdepartFare(departFare);
					summary.setreturnFare(returnFare);
					displayTaxes.setText(Double.toString(summary.getTaxes()));
					double totalFare = summary.getdepartFare()+summary.getreturnFare();
					df.setRoundingMode(RoundingMode.HALF_UP);
					String roundedNumber = df.format(totalFare);
					displayFare.setText(roundedNumber);
					double TotalCharge = summary.TotalCharge();
					String roundedNumber1 = df.format(TotalCharge);
					dsplayTotalFare.setText(roundedNumber1);
					cdr6.last(farePanelCont);
				}

			}
		});
		//FlightScedule4
		FlightSchedule_2_2.addMouseListener(new MouseAdapter() {
			String departTime = departTime4.getText();
			String arrivalTime = arrivalTime4.getText();
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				FlightSchedule_2_2.setBorder(new LineBorder(new Color(205,12,12)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				FlightSchedule_2_2.setBorder(new LineBorder(new Color(192, 192, 192)));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				returnFare =Double.parseDouble(displayPrice4.getText());
				if(!clicked2) {
					summary = new FlightSummary(departTime, arrivalTime);
					FlightSchedule_2_2.setBackground(new Color (192, 192, 192));
					minisidePanel4.setBackground(new Color(159,96,53));
					pricePanelheader4.setBackground(new Color(159,96,53));
					clicked2 = true;
					departDateLbl2_1.setText(book.returnDateFormatter());
					displayDepartTime2.setText(summary.getdepartTime());
					displayArriveTime2.setText(summary.getarriveTime());
					departOriginLbl2.setText(book.getDestination().toUpperCase());
					departDestinationLbl2.setText(book.getorigin().toUpperCase());
					displayDuration2.setText(duration4.getText());
					displayClass2.setText(book.getBookingClass());
					cdr5.next(lowerPanelCont);
					 showFare2 = true; 
				}
				if(showFare1 && showFare2 )
				{
					summary.setdepartFare(departFare);
					summary.setreturnFare(returnFare);
					displayTaxes.setText(Double.toString(summary.getTaxes()));
					double totalFare = summary.getdepartFare()+summary.getreturnFare();
					df.setRoundingMode(RoundingMode.HALF_UP);
					String roundedNumber = df.format(totalFare);
					displayFare.setText(roundedNumber);
					double TotalCharge = summary.TotalCharge();
					String roundedNumber1 = df.format(TotalCharge);
					dsplayTotalFare.setText(roundedNumber1);
					cdr6.last(farePanelCont);
				}
//				else {
//					cdr6.previous(farePanelCont);
//			}
				 
			}
		});
		
		JViewport viewport = new JViewport();
		viewport.setView(splitPane);
		//viewport.setPreferredSize(new Dimension(200, 200));
		viewport.setAutoscrolls(true);
		
		splitPane.addMouseWheelListener(new MouseWheelListener() {
			    public void mouseWheelMoved(MouseWheelEvent e) {
			    	//int unitsToScroll = e.getUnitsToScroll() * 2;
			        if (e.getPreciseWheelRotation() <0) {
			            //Scrolling up, move the panel up
			        	splitPane.setLocation(splitPane.getX(), splitPane.getY() + -e.getWheelRotation()*8);
			        	
			        } else {
			            //Scrolling down, move the panel down
			        	splitPane.setLocation(splitPane.getX(), splitPane.getY() + -e.getWheelRotation()*8);
			        	
			        }
			    }
			});
	
		

		
		
		JFrame frame = new JFrame();

		
		frame.setTitle("TripleA Airlines ");
		frame.setBounds(100, 100, 1452, 924);
//		frame.setUndecorated(rootPaneCheckingEnabled);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(splitPane);
		// Display the frame
		//frame.pack();
		frame.setVisible(true);

	}
	//method to create buttons
			public void createButt(int row,int col, JPanel x,JButton seatButtons[][],char S, int a,int b,int c, boolean enable) {
				seatButtons = new JButton[row][col];
				for (int i = 0; i < row; i++) {
				      for (int j = 0; j < col; j++) {
				        String seatNumber = S+((i + 1) + "-" + (j + 1));
				        seatButtons[i][j] = new JButton(seatNumber);
				        seatButtons[i][j].setBounds(col, col, 50, 33);
				        seatButtons[i][j].setBackground(new Color(a,b,c));
				        seatButtons[i][j].setEnabled(enable);
				        x.add(seatButtons[i][j]);
				      }
				    }
			}
}


