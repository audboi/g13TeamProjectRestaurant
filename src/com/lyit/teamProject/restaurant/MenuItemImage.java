package com.lyit.teamProject.restaurant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MenuItemImage {
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String dbName = "g13restaurant";
	private String driver = "com.mysql.jdbc.Driver";
	private static String userName = "root";
	private static String password = "password";
	private Statement statement = null;
	private ResultSet resultSet = null;

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url+dbName, userName, password);

		String sql = "SELECT itemname, itemdescription,itemcost,itemclass, itemimage FROM menu_items ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet resultSet = stmt.executeQuery();
		while (resultSet.next()) {
			int itemID = resultSet.getInt(1);
			String itemName = resultSet.getString(2);
			String itemDescription = resultSet.getString(3);
			double itemCost = resultSet.getDouble(4);
			String itemClass = resultSet.getString(5);
			File itemImage = new File("C:\\Users\\audboi\\Google Drive\\TeamProject Workspace\\Restaurant\\Images\\Images\\customers.png");
			FileOutputStream fos = new FileOutputStream(itemImage);

			byte[] buffer = new byte[1];
			InputStream is = resultSet.getBinaryStream(3);
			while (is.read(buffer) > 0) {
				fos.write(buffer);
			}
			fos.close();
		}
		conn.close();
	}
}
