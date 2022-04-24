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
	
	public String insertpay(
	 @FormParam("name") String name,
	 @FormParam("accNo") String accNo,
	 @FormParam("ccv") String ccv,
	 @FormParam("date") String date)
	{
	 String output = payObj.insertPay(name, accNo, ccv, date);
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
	 String name = payObject.get("name").getAsString();
	 String accNo = payObject.get("accNo").getAsString();
	 String ccv = payObject.get("ccv").getAsString();
	 String date = payObject.get("date").getAsString();
	  
	 String output = payObj.updatePay(name, accNo, ccv, date );
	return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePay(String payData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(payData, "", Parser.xmlParser());

	//Read the value from the element <name>
	 String name = doc.select("name").text();
	 String output = payObj.deletePay(name);
	return output;
	}

}
