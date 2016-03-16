package com.lyit.teamProject.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Point;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Color;

public class CustFoodView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application. RANDOM COMMENT
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustFoodView frame = new CustFoodView();
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
	public CustFoodView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\chef.png"));
		setTitle("theG13 Menu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 711, 634);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(10, 11, 689, 573);
		contentPane.add(tabbedPane);
		
		JTabbedPane starterTab = new JTabbedPane(JTabbedPane.TOP);
		starterTab.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Starters", new ImageIcon("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\starters1.png"), starterTab, null);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Menu\\startersCopy.png"));
		starterTab.addTab("", null, lblNewLabel, null);
		starterTab.setEnabledAt(0, false);
		starterTab.setBackgroundAt(0, new Color(255, 255, 255));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Mains", new ImageIcon("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\mains1.png"), tabbedPane_1, null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Menu\\mains.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		tabbedPane_1.addTab("", null, label, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Desserts", new ImageIcon("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\dessert1.png"), tabbedPane_2, null);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Menu\\Desserts.png"));
		tabbedPane_2.addTab("", null, label_1, null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Side Orders", new ImageIcon("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Icons\\starters1.png"), tabbedPane_3, null);
	}
}
