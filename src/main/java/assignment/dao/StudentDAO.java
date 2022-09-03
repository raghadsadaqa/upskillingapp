package assignment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import assignment.bean.Program;
import assignment.bean.School;
import assignment.bean.Student;
import assignment.bean.University;
import database.Database;

public class StudentDAO {

	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private int row ;
	List<Student> studentTable;
	
	public List<Student> selectALL(){
		studentTable = new ArrayList<Student>();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select student_id, student_aname, student_ename, mobile, birthdate, sex, email, "
					+ "university_id, school_id, program_id, final_average, max_average, rate, graduate_year, "
					+ "graduate_sem from student order by student_id ");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Student student = new Student(rs.getInt("student_id"), rs.getString("student_aname"), 
						rs.getString("student_ename"), rs.getString("mobile"), rs.getDate("birthdate"), rs.getString("sex"),
						rs.getString("email"), rs.getInt("school_id"), rs.getInt("program_id"), rs.getDouble("final_average"),
						rs.getDouble("max_average"), rs.getString("rate"), rs.getInt("graduate_year"),
						rs.getInt("graduate_sem"));
				
				UniDAO uniDAO = new UniDAO();
				University university = uniDAO.selectByid(rs.getInt("university_id"));
				student.setUniversity(university);
				
				SchoolDAO schoolDAO = new SchoolDAO();
				School school = schoolDAO.selectById(rs.getInt("school_id"));
				student.setSchool(school);
				
				ProgramDAO programDAO = new ProgramDAO();
				Program program = programDAO.selectById(rs.getInt("program_id"));
				student.setProgram(program);
				
				studentTable.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		
		return studentTable;
	}
	
	public Student selectById(int id){
		Student student = new Student();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select student_id, student_aname, student_ename, mobile, birthdate, sex, email,"
					+ " university_id, school_id, program_id, final_average, max_average, rate, graduate_year, "
					+ "graduate_sem from student where student_id = ? order by student_id ");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				student = new Student(rs.getInt("student_id"), rs.getString("student_aname"), rs.getString("student_ename"), rs.getString("mobile"), rs.getDate("birthdate"), rs.getString("sex"), rs.getString("email"), rs.getInt("school_id"), rs.getInt("program_id"), rs.getDouble("final_average"), rs.getDouble("max_average"), rs.getString("rate"), rs.getInt("graduate_year"), rs.getInt("graduate_sem"));
			
				UniDAO uniDAO = new UniDAO();
				University university = uniDAO.selectByid(rs.getInt("university_id"));
				student.setUniversity(university);
				
				SchoolDAO schoolDAO = new SchoolDAO();
				School school = schoolDAO.selectById(rs.getInt("school_id"));
				student.setSchool(school);
				
				ProgramDAO programDAO = new ProgramDAO();
				Program program = programDAO.selectById(rs.getInt("program_id"));
				student.setProgram(program);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		
		return student;
	}
	
	private int selectMaxId() {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select nvl(max(student_id), 0) AS STUDENT_ID from student");
			rs = ps.executeQuery();
					
			if (rs.next()) {
			    return rs.getInt("student_id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("Finally");
			Database.close(rs);
			Database.close(connection);
			Database.close(ps);
		}
		
		return 0;
	}
	
	
	public int insert(Student student) {
		try {
		/*	int maxId = selectMaxId();
			System.out.println(maxId); */

			
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("insert into student(student_id, student_aname, student_ename, "
					+ "mobile, birthdate, sex, email, university_id, school_id, program_id, final_average, "
					+ "max_average, rate, graduate_year, graduate_sem) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			int counter = 1;
			
			ps.setInt(counter++, student.getStudentid());
			//ps.setInt(counter++, maxId + 1);
			ps.setString(counter++, student.getAname());
			ps.setString(counter++, student.getEname());
			ps.setString(counter++, student.getMobile());
			Date date = new Date(student.getBirthDate().getTime());
			ps.setDate(counter++, date);
			ps.setString(counter++, student.getSex());
			ps.setString(counter++, student.getEmail());
			ps.setInt(counter++, student.getUniversity().getId());
			ps.setInt(counter++, student.getShcoolid());
			ps.setInt(counter++, student.getProgramid());
			ps.setDouble(counter++, student.getFinalAvg());
			ps.setDouble(counter++, student.getMaxAvg());
			ps.setString(counter++, student.getRate());
			ps.setInt(counter++, student.getGraduateYear());
			ps.setInt(counter++, student.getGraduateSem());
			
			row = ps.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(ps);
			Database.close(connection);
		}
		
		return row;
		
	}
	
	public int update(Student student) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("update student set student_aname = ?, student_ename = ?, mobile = ?, birthdate = ?, sex = ?, email = ?, university_id = ?, school_id = ?, program_id = ?, final_average = ?, max_average = ?, rate = ?, graduate_year = ?, graduate_sem = ? where student_id = ?");
			
			int counter = 1;
			
			ps.setString(counter++, student.getAname());
			ps.setString(counter++, student.getEname());
			ps.setString(counter++, student.getMobile());
			Date date = new Date(student.getBirthDate().getTime());
			ps.setDate(counter++, date);
			ps.setString(counter++, student.getSex());
			ps.setString(counter++, student.getEmail());
			ps.setInt(counter++, student.getUniversity().getId());
			ps.setInt(counter++, student.getShcoolid());
			ps.setInt(counter++, student.getProgramid());
			ps.setDouble(counter++, student.getFinalAvg());
			ps.setDouble(counter++, student.getMaxAvg());
			ps.setString(counter++, student.getRate());
			ps.setInt(counter++, student.getGraduateYear());
			ps.setInt(counter++, student.getGraduateSem());
			ps.setInt(counter++, student.getStudentid());
			
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
			ps = connection.prepareStatement("delete from student where student_id = ?");
			
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
