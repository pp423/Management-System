package solution.proj.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import solution.proj.dao.ReservationDAO;
import solution.proj.exception.AppException;
import solution.proj.model.Reservation;

@Path("/reservation")
public class ReservationController {
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getAll(){
		AppResponse resp = new AppResponse();
		
		try {
			ReservationDAO dao = new ReservationDAO();
			List<Reservation> resList = dao.getAll();
			resp.setPayload(resList);
		} catch (AppException e) {
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		}	
		return resp;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse addReservation(Reservation rev){
		AppResponse resp = new AppResponse();
		
		
		try{
			ReservationDAO dao = new ReservationDAO();
			rev = dao.addReservation(rev);
			resp.setMessage("Reservation added successfully");
			resp.setPayload(rev);
		} catch (AppException e) {
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		} 
		return resp;
	}
}
