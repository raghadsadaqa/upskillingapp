package assignment.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import assignment.bean.Interview;
import assignment.bean.Student;
import database.Database;

public class InterviewDAO {
	
	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private int row;
	List<Interview> table;
	
	
	public List<Interview> selectAll(){
		table = new ArrayList<Interview>();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select student_id, INTERVIEW_DATE, start_time, end_time from interview order by student_id");
		
			rs = ps.executeQuery();

			while (rs.next()) {
				Interview interview = new Interview(rs.getDate("interview_date"), rs.getDate("start_time"), rs.getDate("end_time"));
				
				StudentDAO studentDAO = new StudentDAO();
				Student student = studentDAO.selectById(rs.getInt("student_id"));
				interview.setStudent(student);
				
				
				table.add(interview);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		
		return table;
	}
	
	public int insert(Interview interview) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("INSERT INTO INTERVIEW(STUDENT_ID, INTERVIEW_DATE, START_TIME, "
					+ "END_TIME) VALUES(?, ?, ?, ?)");
			
			int counter = 1;
			
			ps.setInt(counter++, interview.getStudent().getStudentid());
			
			java.sql.Date date = new java.sql.Date(interview.getInterviewDate().getTime());
			ps.setDate(counter++, date);
			
			java.sql.Date date1 = new java.sql.Date(interview.getStartTime().getTime());
			ps.setDate(counter++, date1);
			
			java.sql.Date date2 = new java.sql.Date(interview.getEndTime().getTime());
			ps.setDate(counter++, date2);
			
			
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	
	public int update(Interview interview) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("UPDATE INTERVIEW SET INTERVIEW_DATE = ?, START_TIME = ?, END_TIME = ? WHERE STUDENT_ID = ?");
			
			int counter = 1;
			
			
			java.sql.Date date = new java.sql.Date(interview.getInterviewDate().getTime());
			ps.setDate(counter++, date);
			
			java.sql.Date date1 = new java.sql.Date(interview.getStartTime().getTime());
			ps.setDate(counter++, date1);
			
			java.sql.Date date2 = new java.sql.Date(interview.getEndTime().getTime());
			ps.setDate(counter++, date2);
			
			ps.setInt(counter++, interview.getStudent().getStudentid());
			
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
