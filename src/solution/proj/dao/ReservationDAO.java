package solution.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import solution.proj.exception.AppException;
import solution.proj.model.Reservation;
import solution.proj.utils.DBUtil;

public class ReservationDAO {
	
	public List<Reservation> getAll() throws AppException{
		List<Reservation> resList = new ArrayList<Reservation>();
		
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select * from reservation");
			rs = ps.executeQuery();
			
			while(rs.next()){
				Reservation res = new Reservation();
				res.setReserveId(rs.getInt("R_ID"));
				res.setName(rs.getString("R_NAME"));
				res.setPhone(rs.getString("R_PHONE"));
				res.setEmail(rs.getString("R_EMAIL"));
				res.setDate(rs.getString("R_DATE"));
				res.setTime(rs.getString("R_TIME"));
				res.setSize(rs.getInt("R_SIZE"));
				res.setEvent(rs.getString("R_EVENT"));
				
				resList.add(res);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new AppException("Error in fetching records from database", e.getCause());
		}
		finally{
			DBUtil.closeResources(ps, rs, con);
		}		
		return resList;
	}
	
	
	public Reservation addReservation(Reservation rev) throws AppException{
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("INSERT INTO hotel_db.reservation (R_NAME, R_PHONE, R_EMAIL, R_DATE, R_TIME, R_SIZE, R_EVENT) VALUES (?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, rev.getName());
			ps.setString(2, rev.getPhone());
			ps.setString(3, rev.getEmail());
			ps.setString(4, rev.getDate());
			ps.setString(5, rev.getTime());
			ps.setInt(6, rev.getSize());
			ps.setString(7, rev.getEvent());
			
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			
			if(rs.next()){
				rev.setReserveId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error is adding new entry to the database", e.getCause());
		} finally {
			DBUtil.closeResources(ps, rs, con);
		}
		
		return rev;
	}
}
