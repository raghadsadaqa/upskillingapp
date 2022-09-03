package assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import assignment.bean.University;
import database.Database;

public class UniDAO {

	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private int row;
	private List<University> UniTable;

	public List<University> selectALL() {
		UniTable = new ArrayList<University>();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select university_id, university_aname, university_ename, website from university order by university_id");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				University university = new University(rs.getInt("university_id"), rs.getString("university_aname"), 
						rs.getString("university_ename"), rs.getString("website"));
				UniTable.add(university);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return UniTable;
	}

	public University selectByid(int id) {

		University university = new University();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select university_id, university_aname, university_ename, website from university "
					+ "where university_id = ?  order by university_id");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				university = new University(rs.getInt("university_id"), rs.getString("university_aname"),
						rs.getString("university_ename"), rs.getString("website"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return university;

	}
	
	public int insert(University university) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into university (university_id, university_aname, university_ename, website) values(?, ?, ?, ?)");
			
			int counter = 1;
			ps.setInt(counter++, university.getId());
			ps.setString(counter++, university.getAname());
			ps.setString(counter++, university.getEname());
			ps.setString(counter++, university.getWebsite());
			
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		
		return row;

	}
	
	public int update(University university) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update university set university_aname = ?, university_ename = ?, website = ? where university_id = ?");
			
			int counter = 1;
			ps.setString(counter++, university.getAname());
			ps.setString(counter++, university.getEname());
			ps.setString(counter++, university.getWebsite());
			ps.setInt(counter++, university.getId());

			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		
		return row;
	}
	
	public int delete(int id) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"delete from university where university_id = ?");
			
			ps.setInt(1, id);

			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		
		return row;
	}

}


