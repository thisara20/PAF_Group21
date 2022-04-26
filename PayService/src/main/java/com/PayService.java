package com;

import model.Pay;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Pays")

public class PayService {

	Pay payObj = new Pay();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPay() {
		
		
		return payObj.readPay();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)  //request type
	@Produces(MediaType.TEXT_PLAIN) //respond type
	
	//String payID, payDate, String name, String email,String amount, String accNo, String ccv, String expireDate
	public String insertpay(
	 @FormParam("payDate") String payDate,
	 @FormParam("name") String name,
	 @FormParam("email") String email,
	 @FormParam("amount") String amount,
	 @FormParam("accNo") String accNo,
	 @FormParam("ccv") String ccv,
	 @FormParam("expireDate") String expireDate)
	{
	 String output = payObj.insertPay( payDate,  name,  email, amount,  accNo,  ccv, expireDate);
	return output;
	}
	
	//update
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)  //request media type
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePay(String PayData)
	{
	//Convert the input string to a JSON object
	 JsonObject payObject = new JsonParser().parse(PayData).getAsJsonObject();
	
	 //Read the values from the JSON object and capture the json data set
	 String payID = payObject.get("payID").getAsString();
	 String payDate = payObject.get("payDate").getAsString();
	 String name = payObject.get("name").getAsString();
	 String email= payObject.get("email").getAsString();
	 String amount = payObject.get("amount").getAsString();
	 String accNo = payObject.get("accNo").getAsString();
	 String ccv = payObject.get("ccv").getAsString();
	 String expireDate = payObject.get("expireDate").getAsString();
	  
	 String output = payObj.updatePay(payID,payDate,name,email,amount, accNo,ccv, expireDate );
	return output;
	}
	
	 

}
