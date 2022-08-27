package assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import assignment.bean.TrainingCourses;
import database.Database;

public class TraCouDAO {
	//Training Course 
	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	int row ;
	List<TrainingCourses> TRTable;
	
	public List<TrainingCourses> selectALL(){
		TRTable = new ArrayList<TrainingCourses>();
		
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select course_id, course_aname, course_ename, max_students, short_descr, detailed_desc from training_course order by course_id");
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				TrainingCourses courses = new TrainingCourses(rs.getInt("course_id"), rs.getString("course_aname"), rs.getString("course_ename"), rs.getInt("max_students"), rs.getString("short_descr"), rs.getString("detailed_desc"));
				TRTable.add(courses);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(rs);
			Database.close(connection);
			Database.close(ps);
		}
		
		return TRTable;
		
	}
	
	public TrainingCourses selectById(int id){
		TrainingCourses courses = null;
		
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select course_id, course_aname, course_ename, max_students, short_descr, detailed_desc from training_course where course_id = ? order by course_id");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				courses = new TrainingCourses(rs.getInt("course_id"), rs.getString("course_aname"), rs.getString("course_ename"), rs.getInt("max_students"), rs.getString("short_descr"), rs.getString("detailed_desc"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(rs);
			Database.close(connection);
			Database.close(ps);
		}
		
		return courses;
		
	}
	
	
	
	public int insert(TrainingCourses courses) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("insert into training_course(course_id, course_aname, course_ename, max_students, short_descr, detailed_desc) values(?, ?, ?, ?, ?, ?)");
			
			int counter = 1;
			ps.setInt(counter++, courses.getCourseid());
			ps.setString(counter++, courses.getAname());
			ps.setString(counter++, courses.getEname());
			ps.setInt(counter++, courses.getMaxstudent());
			ps.setString(counter++, courses.getShortDescr());
			ps.setString(counter++, courses.getDetailedDesc());
			
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(connection);
			Database.close(ps);
		}
		
		return row;
		
	}
	public int update(TrainingCourses courses) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("update training_course set course_aname = ?, course_ename = ?, max_students = ?, short_descr = ?, detailed_desc = ? where course_id = ?");
			
			int counter = 1;
			ps.setString(counter++, courses.getAname());
			ps.setString(counter++, courses.getEname());
			ps.setInt(counter++, courses.getMaxstudent());
			ps.setString(counter++, courses.getShortDescr());
			ps.setString(counter++, courses.getDetailedDesc());
			ps.setInt(counter++, courses.getCourseid());

			
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(connection);
			Database.close(ps);
		}
		
		return row;
		
	}
	public int delete(int id) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete from training_course where course_id = ?");
			
			ps.setInt(1, id);

			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(connection);
			Database.close(ps);
		}
		
		return row;
		
	}
	
	
}
