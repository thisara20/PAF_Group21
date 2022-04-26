package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Request {
	//A common method to connect to the DB
	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");
	 

	 //Provide the correct details: DBServer/DBName, username, password
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/request", "root", "");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 }
	
	//insert
	public String insertRequest(String fullname,String email,String phoneno,String pAddress,String electricitySupply, String purposeofusage )
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for inserting."; }
	 
	 // create a prepared statement
	 String query = " insert into requestservice(`requestId`,`fullname`,`email`,`phoneno`,`pAddress`,`electricitySupply`,`purposeofusage`)" 
	 +  
	 " values(?, ?, ?, ?, ?, ?, ?)";
	
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values

	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, fullname);
	 preparedStmt.setString(3, email);
	 preparedStmt.setString(4, phoneno);
	 preparedStmt.setString(5, pAddress);
	 preparedStmt.setString(6, electricitySupply);
	 preparedStmt.setString(7, purposeofusage);
	 
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Inserted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while inserting the Customer New Requests.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }		
	
	public String readRequests()
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	 
	 // Prepare the html table to be displayed
	 output = "<table border='1'><tr><th>Request Id</th><th>Full Name</th>" +
	 "<th>Email</th>" + "<th>Phone No</th>" +
	 "<th> Address of the Premises where Electricity Supply is Required</th>" +
	 "<th>Required Electricity Supply</th>" + 
	 "<th>Purpose of Usage</th>"+
	 "<th>Update</th><th>Remove</th></tr>";

	 String query = "select * from requestservice";
	 
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	 String requestId = Integer.toString(rs.getInt("requestId"));
	 String fullname = rs.getString("fullname");
	 String email = rs.getString("email");
	 String phoneno = rs.getString("phoneno");
	 String pAddress = rs.getString("pAddress");
	 String electricitySupply = rs.getString("electricitySupply");
	 String purposeofusage = rs.getString("purposeofusage");

	 
	 // Add into the html table
	 output += "<td>" + requestId + "</td>";
	 output += "<td>" + fullname + "</td>";
	 output += "<td>" + email + "</td>";
	 output += "<td>" + phoneno + "</td>";
	 output += "<td>" + pAddress + "</td>";
	 output += "<td>" + electricitySupply + "</td>";
	 output += "<td>" + purposeofusage + "</td>";
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
	 + "<td><form method='post' action='request.jsp'>"
	 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
	 + "<input name='fullname' type='hidden' value='" + fullname + "'>" + "</form></td></tr>";
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the Customer new Requests.";
	 System.err.println(e.getMessage());
	 }
	 return output;
 }
	public String updateRequest(String requestId,String fullname,String email,String phoneno,String pAddress,String electricitySupply,String purposeofusage) 
	{
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for updating."; }
		 // create a prepared statement
		 String query = "UPDATE requestservice SET fullname=?, email=?,phoneno=?,pAddress=?,electricitySupply=?,purposeofusage=? WHERE requestId=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setString(1, fullname);
		 preparedStmt.setString(2, email);
		 preparedStmt.setString(3,phoneno);
		 preparedStmt.setString(4,pAddress);
		 preparedStmt.setString(5,electricitySupply);
		 preparedStmt.setString (6,purposeofusage);
		 
		 preparedStmt.setInt(7, Integer.parseInt(requestId));
		 
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Updated successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while updating the New Request.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		public String deleteRequest(String requestId)
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for deleting."; }
		 // create a prepared statement
		 String query = "delete from requestservice where requestId=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setString(1, requestId);
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Deleted successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while deleting the Customer New Request.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }		

}











