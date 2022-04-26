package rest.api;


import Models.Bill_table;
import Controllers.Bill_tableController;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Bill_tableResources")
public class Bill_tableResource {

	@GET
	@Path("Bill_tables")
	@Produces({MediaType.APPLICATION_JSON })
	public List<Bill_table> getAllBill_tables() throws Exception {
		return Bill_tableController.getInstance().SearchAll();
	}

	@GET
	@Path("Bill_table/{id}")
	@Produces({MediaType.APPLICATION_JSON })
	public List<Bill_table> getBill_table(@PathParam("id") int id) throws Exception {
		Bill_table obj = new Bill_table();
		obj.setId(id);
		return Bill_tableController.getInstance().Search(obj);
	}

	@POST
	@Path("Bill_table")
	public String saveBill_table(Bill_table obj) throws Exception {
		Bill_tableController.getInstance().Save(obj);
		return "Bill_table Saved";
	}

	@PUT
	@Path("Bill_table")
	public String updateBill_table(Bill_table obj) throws Exception {
		Bill_tableController.getInstance().Update(obj);
		return "Bill_table Updated";
	}

	@DELETE
	@Path("Bill_table/{id}")
	public String deleteBill_table(@PathParam("id") int id) throws Exception {
		Bill_table obj = new Bill_table();
		obj.setId(id);
		Bill_tableController.getInstance().Delete(obj);
		return "Bill_table Deleted";
	}
}