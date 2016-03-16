//sean P Test Dawid test... 
package com.lyit.teamProject.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdminLogin dialog = new AdminLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\images.png"));
		setTitle("Employee Login");
		setBounds(100, 100, 383, 292);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Login Name:");
			lblNewLabel.setBounds(28, 142, 122, 14);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblLoginArea = new JLabel("Login area:");
		lblLoginArea.setBounds(28, 70, 102, 14);
		contentPanel.add(lblLoginArea);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(28, 167, 77, 14);
		contentPanel.add(lblPassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Staff Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(118, 123, 173, 68);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(6, 41, 161, 20);
		panel_1.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(6, 16, 161, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JComboBox empRoleCB = new JComboBox();
		empRoleCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		empRoleCB.setBackground(new Color(255, 255, 255));
		empRoleCB.setBounds(118, 67, 163, 20);
		contentPanel.add(empRoleCB);
		empRoleCB.setModel(new DefaultComboBoxModel(new String[] {"", "Managers Portal", "Chef's Portal", "Staff Portal"}));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(102, 41, 189, 60);
		contentPanel.add(panel_2);
		panel_2.setBorder(new TitledBorder(null, "Employee Role", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Images\\bannerBookTable.png"));
		label.setBounds(-138, 0, 434, 39);
		contentPanel.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Login");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				okButton.setForeground(new Color(153, 51, 0));
				okButton.setBackground(new Color(255, 255, 255));
				okButton.setActionCommand("Login");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setForeground(new Color(153, 51, 0));
				cancelButton.setBackground(new Color(255, 255, 255));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
