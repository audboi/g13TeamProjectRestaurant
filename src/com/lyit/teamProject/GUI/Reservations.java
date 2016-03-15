package com.lyit.teamProject.GUI;

//Authors: Adrian Mulligan, Sean Porter, Dawid Swiecicki, Marty Boyle
//Letterkenny Institute of Technology

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.lyit.teamProject.restaurant.Bookings;
import com.lyit.teamProject.restaurant.Customers;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JComboBox;
import java.awt.ScrollPane;
import java.awt.List;
import java.awt.Choice;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Window.Type;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Reservations {
	
	private JComboBox numGuestCBox;
	private JComboBox eventTypeCBox;
	private JComboBox dietRequestCBox;
	private JComboBox allergyCBox;
	private JComboBox otherReqCBox;
	private JButton reserveNowBtn;
	private JDateChooser chooseDate;
	private Customers handler;
	private JFrame frmReserveYourTable;
	private Bookings reservation;
	private JTextField dateTextField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservations window = new Reservations(null);
					window.frmReserveYourTable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param loginCustomer 
	 */
	public Reservations(Customers loginCustomer) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReserveYourTable = new JFrame();
		frmReserveYourTable.setResizable(false);
		frmReserveYourTable.setType(Type.POPUP);
		frmReserveYourTable.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\chef.png"));
		frmReserveYourTable.setTitle("Reserve your table now at the Famous G13 Restaurant");
		frmReserveYourTable.getContentPane().setBackground(new Color(204, 102, 0));
		frmReserveYourTable.setBounds(100, 100, 681, 498);
		frmReserveYourTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReserveYourTable.getContentPane().setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().getDayPanel().setBorder(null);
		calendar.setBounds(12, 70, 255, 184);
		calendar.getDayChooser().setYear(2016);
		calendar.getDayChooser().setWeekOfYearVisible(false);
		calendar.getDayChooser().setForeground(new Color(0, 0, 0));
		calendar.getDayChooser().setDecorationBackgroundVisible(false);
		calendar.getYearChooser().getSpinner().setBackground(new Color(255, 255, 255));
		calendar.getMonthChooser().setBackground(new Color(255, 255, 255));
		calendar.getMonthChooser().getComboBox().setBackground(new Color(255, 255, 255));
		calendar.getMonthChooser().getComboBox().setForeground(new Color(0, 0, 0));
		calendar.getDayChooser().setBackground(new Color(255, 255, 255));
		calendar.getDayChooser().setWeekdayForeground(new Color(255, 255, 255));
		calendar.getDayChooser().setDecorationBackgroundColor(new Color(255, 255, 255));
		calendar.getDayChooser().setBorder(UIManager.getBorder("DesktopIcon.border"));
		calendar.getDayChooser().setAlwaysFireDayProperty(false);
		calendar.getDayChooser().getDayPanel().setForeground(new Color(255, 255, 255));
		calendar.setTodayButtonText("Today");
		calendar.setDecorationBordersVisible(true);
		calendar.setDecorationBackgroundColor(new Color(51, 102, 51));
		calendar.setBackground(new Color(255, 255, 255));
		calendar.getYearChooser().getSpinner().setForeground(new Color(102, 51, 102));
		calendar.getDayChooser().getDayPanel().setBackground(new Color(51, 51, 51));
		frmReserveYourTable.getContentPane().add(calendar);
		calendar.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]
				{calendar.getMonthChooser(), calendar.getMonthChooser().getSpinner(),
						calendar.getMonthChooser().getComboBox(), calendar.getYearChooser(),
						calendar.getYearChooser().getSpinner(), calendar.getDayChooser(),
						calendar.getDayChooser().getDayPanel()}));
		
		JLabel lblNoOfGuests = new JLabel("Number of Guests:");
		lblNoOfGuests.setBounds(302, 73, 134, 14);
		lblNoOfGuests.setForeground(new Color(255, 255, 255));
		lblNoOfGuests.setBackground(new Color(255, 255, 255));
		frmReserveYourTable.getContentPane().add(lblNoOfGuests);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 102, 0));
		panel_2.setBounds(437, 69, 220, 143);
		frmReserveYourTable.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox numGuestCBox = new JComboBox();
		numGuestCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		numGuestCBox.setBounds(0, 0, 220, 20);
		panel_2.add(numGuestCBox);
		numGuestCBox.setBackground(new Color(255, 255, 255));
		numGuestCBox.setEditable(true);
		numGuestCBox.setModel(new DefaultComboBoxModel(new String[] {"", "1 - 2", "3 - 4", "5 - 6", "7 - 8", "9  or more"}));
		
		
		
		JComboBox eventTypeCBox = new JComboBox();
		eventTypeCBox.setBounds(0, 31, 220, 20);
		panel_2.add(eventTypeCBox);
		eventTypeCBox.setEditable(true);
		eventTypeCBox.setBackground(new Color(255, 255, 255));
		eventTypeCBox.setModel(new DefaultComboBoxModel(new String[] {"", "Normal Booking", "Christening", "Childrens Birthday Party", "Holy Communion", "Confirmation", "Birthday Party", "Retirement Party", "Wedding", "Funeral Dinner"}));
		
		JComboBox dietRequestCBox = new JComboBox();
		dietRequestCBox.setBounds(0, 62, 220, 20);
		panel_2.add(dietRequestCBox);
		dietRequestCBox.setEditable(true);
		dietRequestCBox.setBackground(new Color(255, 255, 255));
		dietRequestCBox.setModel(new DefaultComboBoxModel(new String[] {"", "Seafood", 
				"Vegetarian", "Vegan", "Other (Please contact us)"}));
		
		JComboBox allergyCBox = new JComboBox();
		allergyCBox.setBounds(0, 93, 220, 20);
		panel_2.add(allergyCBox);
		allergyCBox.setModel(new DefaultComboBoxModel(new String[] {"", "Shellfish", "Mollusc", "Fish", "Crustacean", "Soybean", "Lupin", "Peanuts", "Tree Nuts", "Milk", "Sulphites", "Gluten/Wheat", "Sesame Seed", "Mustard", "Eggs"}));
		
		allergyCBox.setEditable(true);
		allergyCBox.setBackground(new Color(255, 255, 255));
		
		JComboBox otherReqCBox = new JComboBox();
		otherReqCBox.setBounds(0, 123, 220, 20);
		panel_2.add(otherReqCBox);
		otherReqCBox.setModel(new DefaultComboBoxModel(new String[] {"", "Baby Chair", "Wheelchair Access", "Musicians/ Band", "Other?( Please Specify Above)"}));
		otherReqCBox.setEditable(true);
		
		JLabel lblSpecialRequests = new JLabel("Event Type:");
		lblSpecialRequests.setBounds(302, 103, 122, 14);
		lblSpecialRequests.setForeground(new Color(255, 255, 255));
		frmReserveYourTable.getContentPane().add(lblSpecialRequests);
		
		JLabel lblDietaryRequirements = new JLabel("Dietary Requirements:");
		lblDietaryRequirements.setBounds(302, 134, 134, 14);
		lblDietaryRequirements.setForeground(new Color(255, 255, 255));
		frmReserveYourTable.getContentPane().add(lblDietaryRequirements);
		
		JLabel lblAllergenAlert = new JLabel("Allergen Alert:");
		lblAllergenAlert.setBounds(302, 165, 95, 14);
		lblAllergenAlert.setForeground(new Color(255, 255, 255));
		frmReserveYourTable.getContentPane().add(lblAllergenAlert);
		
		Label label = new Label("Other Requirements:");
		label.setBounds(302, 196, 123, 14);
		label.setForeground(new Color(255, 255, 255));
		frmReserveYourTable.getContentPane().add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(575, 214, -566, 9);
		separator.setForeground(new Color(0, 102, 102));
		separator.setBackground(new Color(51, 153, 51));
		frmReserveYourTable.getContentPane().add(separator);
		
		Panel panel = new Panel();
		panel.setBounds(10, 256, 645, 193);
		panel.setBackground(new Color(204, 102, 51));
		frmReserveYourTable.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(3, 40, 644, 149);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane txtpnOurMenu = new JTextPane();
		txtpnOurMenu.setBounds(0, 0, 644, 184);
		panel_1.add(txtpnOurMenu);
		txtpnOurMenu.setEditable(false);
		txtpnOurMenu.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtpnOurMenu.setForeground(new Color(255, 255, 255));
		txtpnOurMenu.setBackground(new Color(51, 51, 51));
		txtpnOurMenu.setText("Just an hour from Letterkenny, the G13 Restaurants romantically rambling country house has a wonderfully away-from-it all atmosphere - and this quietly luxurious place has always been renowned for good food.\r\n\tLong before \u2018local and seasonal\u2019 came into its own on a national basis, that was just the way things were done around here, with food from the farm and the walled garden taking its rightful place on the table along with the best of other Irish foods.\r\nDear Guest\r\n\tIt is our Great Pleasure to welcome you to G13 Restaurant Dining Room\r\n\r\nDiners enjoy relaxing over an aperitif in the old kitchen bar, while choosing from menus that unselfconsciously introduce the house philosophy and the suppliers they are proud to credit.\r\n\r\n");
		
		dateTextField = new JTextField();
		dateTextField.setBounds(95, 9, 161, 20);
		panel.add(dateTextField);
		dateTextField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(10, 12, 46, 14);
		panel.add(lblDate);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Images\\bannerBookTable1.png"));
		lblNewLabel.setBounds(13, 7, 644, 80);
		frmReserveYourTable.getContentPane().add(lblNewLabel);
		
		JButton reserveNowBtn = new JButton("Reserve your Table Now!");
		reserveNowBtn.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 18));
		reserveNowBtn.setBackground(new Color(204, 51, 0));
		reserveNowBtn.setForeground(new Color(255, 255, 255));
		reserveNowBtn.setBounds(302, 220, 353, 34);
		frmReserveYourTable.getContentPane().add(reserveNowBtn);
	}
	public void updateReservations(){
		int numGuests = Integer.parseInt(numGuestCBox.getSelectedItem().toString());
		String eventType = eventTypeCBox.getSelectedItem().toString();
		String dietRequest = dietRequestCBox.getSelectedItem().toString();
		String allergyAlert = allergyCBox.getSelectedItem().toString();
		String otherReq = otherReqCBox.getSelectedItem().toString();
		String bookDate = ((dateTextField).getText());
		reservation = new Bookings(bookDate,numGuests,numGuests, numGuests, eventType,dietRequest,allergyAlert,otherReq, bookDate);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	public boolean setVisible(boolean b) {
		// TODO Auto-generated method stub
		return(true);
	}
}
