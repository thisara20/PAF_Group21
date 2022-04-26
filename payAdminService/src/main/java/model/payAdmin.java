package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class payAdmin {

	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bill", "root", "");
			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
	// read

		public String readPay() {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for reading.";
				}
				// Prepare the html table to be displayed
				//String payID, payDate, String name, String email,String amount, String accNo, String ccv, String expireDate
				
				output = "<table border='1'><tr><th>payID</th>" +"<th>payDate</th>" + "<th>name</th>" + "<th>email</th>" + "<th>amount</th>" + "<th>accNo</th>" +    "<th>ccv</th>" +  "<th>expireDate</th>" 
						+ "<th>Update</th><th>Remove</th></tr>";
				String query = "select * from payment";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				// iterate through the rows in the result set
				while (rs.next()) {
					String payID = Integer.toString(rs.getInt("payID"));
					String payDate = rs.getString("payDate");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String amount = Float.toString(rs.getFloat("amount"));
					String accNo = rs.getString("accNo");
					String ccv = Integer.toString(rs.getInt("ccv"));
					String expireDate = rs.getString("expireDate");

					// Add a row into the html table
					output += "<tr><td>" + payID + "</td>";
					output += "<td>" + payDate + "</td>";
					output += "<td>" + name  + "</td>";
					output += "<td>" + email + "</td>";
					output += "<td>" + amount + "</td>";
					output += "<td>" + accNo + "</td>";
					output += "<td>" + ccv + "</td>";
					output += "<td>" + expireDate + "</td>";
					
					// buttons
					output += "<td><input name='btnUpdate' type='button' value='Update'></td>"
							+ "<td><form method='post' action='payment.jsp'>"
							+ "<input name='btnRemove' type='submit' value='Remove'>"
							+ "<input name='payID' type='hidden' value='" + payID + "'>" + "</form></td></tr>";
				}
				con.close();
				// Complete the html table
				output += "</table>";
			} catch (Exception e) {
				output = "Error while reading the payments.";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		
		// delete
		public String deletePay(String payID) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}
				// create a prepared statement
				String query = "delete from payment where payID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1,Integer.parseInt(payID));

				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Deleted successfully";
			} catch (Exception e) {
				output = "Error while deleting the item.";
				System.err.println(e.getMessage());
			}
			return output;
		}
}
