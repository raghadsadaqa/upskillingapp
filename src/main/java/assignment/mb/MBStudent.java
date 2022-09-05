package assignment.mb;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;

import assignment.bean.Program;
import assignment.bean.School;
import assignment.bean.Student;
import assignment.bean.University;
import assignment.dao.StudentDAO;
import assignment.dao.UniDAO;
import reports.Reports;
import util.Message;

@ManagedBean(name = "mbStudents")
@ViewScoped
public class MBStudent {
	
	private Student student;
	private StudentDAO dao;
	private List<Student> table;
	private Student selectedStudent;
	private List<University> universityTable;
	

	@PostConstruct
	public void init() {
		UniDAO uniDAO = new UniDAO();
		universityTable = uniDAO.selectALL();
		System.out.println(universityTable);
		
		dao = new StudentDAO();
		table = dao.selectALL();
		student = new Student();
		student.setUniversity(new University());
		student.setSchool(new School());
		student.setProgram(new Program());
	}
	
	public String searchByStudent() {
		student = dao.selectById(student.getStudentid());
		return null;
	}
	
	public String save() {
		dao = new StudentDAO();
		System.out.println("Student: " + student);
		dao.insert(student);
		
		student = new Student();
		student.setUniversity(new University());
		
		Message.addMessageByKey("INFO", " ", "msg_save");
		return null;
	}
	
	public String updateStudent() {
		dao.update(student);
		table = dao.selectALL();
		student = new Student();
		Message.addMessageByKey("INFO", " ", "msg_save");

		return null;
	}
	
	public String deleteStudent() {
		dao.delete(student.getStudentid());
		table = dao.selectALL();
		student = new Student();
		Message.addMessageByKey("INFO", " ", "msg_save");

		return null;
	}
	
	public String runStudentReport() throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/image/HTULogo-250px.png"));
		param.put("p_studentID", student.getStudentid());
		param.put("p_image", image);

		Reports report = new Reports();
		report.runPdf("student.jasper", param);

		return null;
	}
	
	
	public Student getStudent() {
		return student;
	}
	
	/*public Student getStudent() {
		if (student == null) {
			student = new Student();
			student.setUniversity(new University());
			student.setSchool(new School());
			student.setProgram(new Program());
		}
		return student;
	}*/
	
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<Student> getTable() {
		return table;
	}
	public void setTable(List<Student> table) {
		this.table = table;
	}

	public Student getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(Student selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

	public List<University> getUniversityTable() {
		return universityTable;
	}

	public void setUniversityTable(List<University> universityTable) {
		this.universityTable = universityTable;
	}
	
	

}
