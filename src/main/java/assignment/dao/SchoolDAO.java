package assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import assignment.bean.School;
import assignment.bean.Student;
import assignment.bean.University;
import database.Database;

public class SchoolDAO {

	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private int row ;
	private List<School> SchoolTable;
	
	public List<School> selectALL(){
		SchoolTable = new ArrayList<School>();
		
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select school_id, school_aname, school_ename from school order by school_id");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				School school = new School(rs.getInt("school_id"), rs.getString("school_aname"), rs.getString("school_ename"));
				SchoolTable.add(school);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		
		return SchoolTable;
	}
	
	public School selectById(int id){
		School school = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select school_id, school_aname, school_ename from school where school_id = ? order by school_id");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				school = new School(rs.getInt("school_id"), rs.getString("school_aname"), rs.getString("school_ename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		
		return school;
	}
	
	
	
	
	public int insert(School school) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("insert into school(school_id, school_aname, school_ename) values(?, ?, ?)");
			
			int counter = 1;
			
			ps.setInt(counter++, school.getId());
			ps.setString(counter++, school.getAname());
			ps.setString(counter++, school.getEname());
			
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(ps);
			Database.close(connection);
		}
		
		return row;
		
	}
	
	public int update(School school) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("update school set school_aname = ?, school_ename = ? where school_id = ?");
			
			int counter = 1;
			ps.setString(counter++, school.getAname());
			ps.setString(counter++, school.getEname());
			ps.setInt(counter++, school.getId());
			
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(ps);
			Database.close(connection);
		}
		
		return row;
		
	}
	public int delete(int id) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete from school where school_id = ?");
			
			ps.setInt(1, id);
			
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(ps);
			Database.close(connection);
		}
		
		return row;
	}
}
