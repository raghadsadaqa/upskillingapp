package assignment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import assignment.bean.Interview;
import assignment.bean.Student;
import assignment.bean.StudentResult;
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
			ps = connection.prepareStatement("SELECT STUDENT_ID,\r\n" + 
					"       TO_CHAR(INTERVIEW_DATE, 'DD/MM/YYYY') as INTERVIEW_DATE,\r\n" + 
					"       TO_CHAR(START_TIME, 'HH:MI') as START_TIME,\r\n" + 
					"       TO_CHAR(END_TIME, 'HH:MI') as END_TIME,\r\n" + 
					"       'Dear student, your interview for upskilling program will be on ' ||\r\n" + 
					"       TO_CHAR(INTERVIEW_DATE, 'DD/MM/YYYY') || ' from ' ||\r\n" + 
					"       TO_CHAR(START_TIME, 'HH:MI') || ' to ' || TO_CHAR(END_TIME, 'HH:MI') AS MSG\r\n" + 
					"  FROM INTERVIEW;");
		
			rs = ps.executeQuery();

			while (rs.next()) {
				Interview interview = new Interview(rs.getDate("INTERVIEW_DATE"), rs.getDate("START_TIME"), rs.getDate("END_TIME"));
				
				StudentDAO studentDAO = new StudentDAO();
				Student student = studentDAO.selectById(rs.getInt("STUDENT_ID"));
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
			Date date = new Date(interview.getInterviewDate().getTime());
			ps.setDate(counter++, date);
			Date date1 = new Date(interview.getStartTime().getTime());
			ps.setDate(counter++, date1);
			Date date2 = new Date(interview.getEndTime().getTime());
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
			ps = connection.prepareStatement("UPDATE INTERVIEW SET STUDENT_ID = ?, INTERVIEW_DATE = ?, START_TIME = ?, END_TIME = ? WHERE STUDENT_ID = ?");
			
			int counter = 1;
			
			
			Date date = new Date(interview.getInterviewDate().getTime());
			ps.setDate(counter++, date);
			Date date1 = new Date(interview.getStartTime().getTime());
			ps.setDate(counter++, date1);
			Date date2 = new Date(interview.getEndTime().getTime());
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
