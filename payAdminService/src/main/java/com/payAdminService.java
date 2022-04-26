package com;
 

import model.payAdmin;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Pay")

public class payAdminService {

	payAdmin payObj = new payAdmin();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPay() {
		
		
		return payObj.readPay();
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
	 String payID = doc.select("payID").text();
	 String output = payObj.deletePay(payID);
	return output;
	}
}
	