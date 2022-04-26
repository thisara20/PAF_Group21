package Controllers;


import Models.Bill_table;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Bill_tableController{

	Connector con = Connector.getInstance();
	
	private double unit_price = 10;

	private Bill_tableController(){
	}

	private static final Bill_tableController obj = new Bill_tableController();

	public static Bill_tableController getInstance(){
		return obj;
	}

	public void Save(Bill_table data) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO bill_table(acc_no,customer_name,address,qty,total_price,date_time) values ('" + data.getAcc_no()+ "','" + data.getCustomer_name()+ "','" + data.getAddress()+ "','" + data.getQty()+ "','" + data.getQty() * this.unit_price + "','" + data.getDate_time()+ "') " );
	}

	public void Update(Bill_table data) throws Exception {
		con.getConnection();
		con.aud("UPDATE bill_table SET acc_no  = '" + data.getAcc_no()+ "',customer_name  = '" + data.getCustomer_name()+ "',address  = '" + data.getAddress()+ "',qty  = '" + data.getQty()+ "',total_price  = '" + data.getQty() * this.unit_price + "',date_time  = '" + data.getDate_time()+ "' WHERE id = '" + data.getId()+ "'");
	}

	public void Delete(Bill_table data) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM bill_table WHERE id = '" + data.getId()+ "'");
	}

	public List<Bill_table> SearchAll() throws Exception {
		List<Bill_table> objList = new ArrayList<Bill_table>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM bill_table");
		while(rset.next()){
			Bill_table obj = new Bill_table();
			obj.setId(rset.getInt(1));
			obj.setAcc_no(rset.getInt(2));
			obj.setCustomer_name(rset.getString(3));
			obj.setAddress(rset.getString(4));
			obj.setQty(rset.getDouble(5));
			obj.setTotal_price(rset.getDouble(6));
			obj.setDate_time(rset.getString(7));
			objList.add(obj);
		}

	return objList;
	}

	public List<Bill_table> Search(Bill_table data) throws Exception {
		List<Bill_table> objList = new ArrayList<Bill_table>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM bill_table WHERE id = '" + data.getId()+ "'");
		while(rset.next()){
			Bill_table obj = new Bill_table();
			obj.setId(rset.getInt(1));
			obj.setAcc_no(rset.getInt(2));
			obj.setCustomer_name(rset.getString(3));
			obj.setAddress(rset.getString(4));
			obj.setQty(rset.getDouble(5));
			obj.setTotal_price(rset.getDouble(6));
			obj.setDate_time(rset.getString(7));
			objList.add(obj);
		}

	return objList;
	}

}