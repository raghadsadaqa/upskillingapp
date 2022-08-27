package assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import assignment.bean.Student;
import assignment.bean.StudentResult;
import assignment.bean.TrainingCourses;
import database.Database;

public class StudentResultDAO {

	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private int row;
	List<StudentResult> resultsTable;

	public List<StudentResult> selectALL() {
		resultsTable = new ArrayList<StudentResult>();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select student_id, course_id, english_mark, interview_mark, accepted_flag, notes from student_result order by student_id");
			rs = ps.executeQuery();

			while (rs.next()) {
				StudentResult studentresult = new StudentResult();

				StudentDAO studentdao = new StudentDAO();
				Student student = studentdao.selectById(rs.getInt("student_id"));
				studentresult.setStudent(student);

				TraCouDAO trainingcoursedao = new TraCouDAO();
				TrainingCourses course = trainingcoursedao.selectById(rs.getInt("course_id"));
				studentresult.setTrainingCourses(course);

				studentresult.setEngMark(rs.getInt("english_mark"));
				studentresult.setInterviewMark(rs.getInt("interview_mark"));
				studentresult.setAcceptedFlag(rs.getString("accepted_flag"));
				studentresult.setNotes(rs.getString("notes"));

				resultsTable.add(studentresult);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return resultsTable;

	}

	public StudentResult selectById(int id) {
		StudentResult result = new StudentResult();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select student_id, course_id, english_mark, interview_mark, accepted_flag, notes from student_result where student_id = ? order by student_id");

			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				StudentResult studentresult = new StudentResult();

				StudentDAO studentdao = new StudentDAO();
				Student student = studentdao.selectById(rs.getInt("student_id"));
				studentresult.setStudent(student);

				TraCouDAO trainingcoursedao = new TraCouDAO();
				TrainingCourses course = trainingcoursedao.selectById(rs.getInt("course_id"));
				studentresult.setTrainingCourses(course);

				studentresult.setEngMark(rs.getInt("english_mark"));
				studentresult.setInterviewMark(rs.getInt("interview_mark"));
				studentresult.setAcceptedFlag(rs.getString("accepted_flag"));
				studentresult.setNotes(rs.getString("notes"));

				resultsTable.add(studentresult);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return result;

	}

	public int insert(StudentResult studentresult) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into student_result(student_id, course_id, english_mark, interview_mark, accepted_flag, notes) values (?,?,?,?,?,?)");

			int counter = 1;

			ps.setInt(counter++, studentresult.getStudent().getStudentid());
			ps.setInt(counter++, studentresult.getTrainingCourses().getCourseid());
			ps.setDouble(counter++, studentresult.getEngMark());
			ps.setDouble(counter++, studentresult.getInterviewMark());
			ps.setString(counter++, studentresult.getAcceptedFlag());
			ps.setString(counter++, studentresult.getNotes());
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	public int update(StudentResult studentResult) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update student_result set course_id = ?, english_mark = ?, interview_mark = ?, accepted_flag = ?, notes = ? where student_id = ?");

			int counter = 1;
			ps.setInt(counter++, studentResult.getTrainingCourses().getCourseid());
			ps.setDouble(counter++, studentResult.getEngMark());
			ps.setDouble(counter++, studentResult.getInterviewMark());
			ps.setString(counter++, studentResult.getAcceptedFlag());
			ps.setString(counter++, studentResult.getNotes());
			ps.setInt(counter++, studentResult.getStudent().getStudentid());

			System.out.println("Stud ID: " + studentResult.getStudent().getStudentid());
			System.out.println("EngMark: " + studentResult.getEngMark());
			System.out.println("Notes: " + studentResult.getNotes());

			row = ps.executeUpdate();

			System.out.println("Row: " + row);

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
			ps = connection.prepareStatement("delete from student_result where student_id = ?");

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
