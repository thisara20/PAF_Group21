package Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bill_table{

	private int id;
	private int acc_no;
	private String customer_name;
	private String address;
	private double qty;
	private double total_price;
	private String date_time;

public Bill_table(){
}

public Bill_table(int id){
	this.id = id;
}
public Bill_table(int id,int acc_no,String customer_name,String address,double qty,double total_price,String date_time){
	this.id = id;
	this.acc_no = acc_no;
	this.customer_name = customer_name;
	this.address = address;
	this.qty = qty;
	this.total_price = total_price;
	this.date_time = date_time;
}

public int getId(){
return id;
}

public void setId(int id){
	this.id = id;
}

public int getAcc_no(){
return acc_no;
}

public void setAcc_no(int acc_no){
	this.acc_no = acc_no;
}

public String getCustomer_name(){
return customer_name;
}

public void setCustomer_name(String customer_name){
	this.customer_name = customer_name;
}

public String getAddress(){
return address;
}

public void setAddress(String address){
	this.address = address;
}

public double getQty(){
return qty;
}

public void setQty(double qty){
	this.qty = qty;
}

public double getTotal_price(){
return total_price;
}

public void setTotal_price(double total_price){
	this.total_price = total_price;
}

public String getDate_time(){
return date_time;
}

public void setDate_time(String date_time){
	this.date_time = date_time;
}

}