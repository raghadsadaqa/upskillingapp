package assignment.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import assignment.bean.Student;
import assignment.bean.StudentTC;
import assignment.bean.TrainingCourses;
import assignment.dao.STCDAO;
import assignment.dao.StudentDAO;
import assignment.dao.TraCouDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbStudentTrainingCourse")
public class MBSTC {
	
	private StudentTC studentTrainingCourse;
	private STCDAO dao;
	private List<StudentTC> table;
	
	private List<Student> studentTable;
	private List<TrainingCourses> trainingCourseTable;
	
	@PostConstruct
	public void init() {
		StudentDAO studentDAO = new StudentDAO();
		studentTable = studentDAO.selectALL();
		
		TraCouDAO traCouDAO = new TraCouDAO();
		trainingCourseTable = traCouDAO.selectALL();
		
		dao = new STCDAO();
		table = dao.selectAll();
		
		studentTrainingCourse = new StudentTC();
		studentTrainingCourse.setStudent(new Student());
		studentTrainingCourse.setTrainingCourses(new TrainingCourses());
	}
	
	public String Save() {
		StudentDAO studentDAO = new StudentDAO();
		studentTable = studentDAO.selectALL();
		
		TraCouDAO traCouDAO = new TraCouDAO();
		trainingCourseTable = traCouDAO.selectALL();
		
		dao = new STCDAO();
		dao.insert(studentTrainingCourse);
		studentTrainingCourse = new StudentTC();
		
		studentTrainingCourse.setStudent(new Student());
		studentTrainingCourse.setTrainingCourses(new TrainingCourses());
		
		Message.addMessageByKey("INFO", " ", "msg_save");
		return null;
	}
	
	public String Update() {
		dao = new STCDAO();
		dao.update(studentTrainingCourse);
		studentTrainingCourse.setStudent(new Student());
		studentTrainingCourse.setTrainingCourses(new TrainingCourses());
		
		studentTrainingCourse = new StudentTC();
		return null;
	}
	
	public String DeleteSTC() {
		dao = new STCDAO();
		dao.delete(studentTrainingCourse.getStudent().getStudentid(), studentTrainingCourse.getTrainingCourses().getCourseid());
		
		dao = new STCDAO();
		table = dao.selectAll();
		
		/*studentTrainingCourse = new StudentTC();
		studentTrainingCourse.setStudent(new Student());
		studentTrainingCourse.setTrainingCourses(new TrainingCourses());*/
		
		return null;
	}

	public StudentTC getStudentTrainingCourse() {
		if (studentTrainingCourse == null){
			studentTrainingCourse = new StudentTC();
			studentTrainingCourse.setStudent(new Student());
			studentTrainingCourse.setTrainingCourses(new TrainingCourses());
		}
		return studentTrainingCourse;
	}

	public void setStudentTrainingCourse(StudentTC studentTrainingCourse) {
		this.studentTrainingCourse = studentTrainingCourse;
	}

	public List<StudentTC> getTable() {
		return table;
	}

	public void setTable(List<StudentTC> table) {
		this.table = table;
	}

	public List<Student> getStudentTable() {
		return studentTable;
	}

	public void setStudentTable(List<Student> studentTable) {
		this.studentTable = studentTable;
	}

	public List<TrainingCourses> getTrainingCourseTable() {
		return trainingCourseTable;
	}

	public void setTrainingCourseTable(List<TrainingCourses> trainingCourseTable) {
		this.trainingCourseTable = trainingCourseTable;
	}
	

}
