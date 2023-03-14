package assignment_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.JTextArea;

public class Mainframe extends JFrame implements MouseListener, ActionListener{
	private static JLabel usernameLbl;
	private static JTextField username;
	private static JLabel pswdLbl;
	private static JPasswordField pswd;
	private static JButton signInBtn;
	private static JLabel success;
	private JLabel logoPanel;
	//JLabel label;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Mainframe frame = new Mainframe();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Mainframe() {
	
		testing1();
		
	
	}

	public void testing1() {
		getContentPane().setBackground(new Color(240,240,240));
		this.setTitle("Qatar Airways");
		this.setSize(920, 600);
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Mainframe.class.getResource("/assignment_2/qatar.png")));
		
		//this.getContentPane().setBackground(new Color(123, 50, 250));
		getContentPane().setLayout(null);
		
		usernameLbl = new JLabel("Username");
		usernameLbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		usernameLbl.setBounds(309, 157, 90, 36);
		getContentPane().add(usernameLbl);
		
		username = new JTextField();
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(309, 191, 286, 27);
		getContentPane().add(username);
		username.setColumns(10);
		
		pswdLbl = new JLabel("Password ");
		pswdLbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pswdLbl.setBounds(309, 240, 107, 13);
		getContentPane().add(pswdLbl);
		
		pswd = new JPasswordField();
		pswd.setHorizontalAlignment(SwingConstants.CENTER);
		pswd.setBounds(309, 263, 286, 27);
		getContentPane().add(pswd);
		pswd.setColumns(10);
		
		signInBtn = new JButton("Sign in");
		//signInBtn.setOpaque(true);
		signInBtn.setBorderPainted(false);
		signInBtn.setBackground(new Color(51, 255, 255));
		signInBtn.setForeground(new Color(255, 255, 255));
		signInBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		signInBtn.setBounds(309, 322, 286, 36);
		signInBtn.addMouseListener(this);
		signInBtn.addActionListener(this);
		getContentPane().add(signInBtn);
		
		success = new JLabel("");
		success.setHorizontalAlignment(SwingConstants.CENTER);
		success.setBounds(309,424,300,25);
		getContentPane().add(success);
		
		JPanel upperpanel = new JPanel();
		upperpanel.setBackground(new Color(255, 0, 0));
		upperpanel.setBounds(0, 0, 906, 72);
		getContentPane().add(upperpanel);
		upperpanel.setLayout(null);
		
		logoPanel = new JLabel(new ImageIcon("C:\\Users\\ASUS\\Pictures\\Screenshots\\Screenshot (195).png"));
		logoPanel.setBounds(-15, 10, 322, 62);
		upperpanel.add(logoPanel);
		
		JPanel lowerpannel = new JPanel();
		lowerpannel.setBackground(new Color(255, 0, 0));
		lowerpannel.setBounds(0, 513, 906, 50);
		lowerpannel.setAlignmentX(BOTTOM_ALIGNMENT);
		getContentPane().add(lowerpannel);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("ComboBox.border"));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(285, 93, 347, 360);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Login to your Account");
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Mainframe.class.getResource("/assignment_2/login.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	}
	
	  @Override public void mouseClicked(MouseEvent e) { // TODO Auto-generated
		  signInBtn.setBackground(new Color(153, 255, 255));
	  
	  }
	  
	  @Override public void mousePressed(MouseEvent e) { // TODO Auto-generated
		  signInBtn.setBackground(new Color(153, 255, 255)); }
	  
	  @Override public void mouseReleased(MouseEvent e) { // TODO Auto-generated
		  signInBtn.setBackground(new Color(51, 255, 255)); } 
	  
	  @Override public void mouseEntered(MouseEvent e) { // TODO Auto-generated
		  signInBtn.setBackground(new Color(102, 255, 255)); }
	  
	  @Override public void mouseExited(MouseEvent e) { // TODO Auto-generated
		  signInBtn.setBackground(new Color(51, 255, 255));
	  
	  }
	 

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String user= username.getText();
		String password = pswd.getText();	
		
		if(user.equalsIgnoreCase("amirul")&&(password.equalsIgnoreCase("12345")))
		   success.setText("Login Successful!");
		else if (user.isEmpty()|| password.isEmpty()) 
			success.setText("Enter a username or password");
		else
		   success.setText("Invalid Login Credentials"); 
		   
		
	}
}
