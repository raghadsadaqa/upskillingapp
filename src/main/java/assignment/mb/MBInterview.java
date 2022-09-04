package assignment.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import assignment.bean.Interview;
import assignment.bean.Student;
import assignment.dao.InterviewDAO;
import assignment.dao.StudentDAO;
import util.Email;
import util.Message;


@ManagedBean (name = "mbInterview")
@ViewScoped
public class MBInterview {

	private Interview interview;
	private InterviewDAO dao;
	private Interview selectedInterview;
	List<Interview> table;
	
	List<Student> studentTable;
	
	@PostConstruct
	public void init() {
		StudentDAO studentDAO = new StudentDAO();
		studentTable = studentDAO.selectALL();
		
		dao = new InterviewDAO();
		table = dao.selectAll();
		interview = new Interview();
		selectedInterview = new Interview();
		interview.setStudent(new Student());
	}
	
	
	public String save() {
		StudentDAO studentDAO = new StudentDAO();
		studentTable = studentDAO.selectALL();
		
		dao = new InterviewDAO();
		dao.insert(interview);
		interview = new Interview();
		
		interview = new Interview();
		interview.setStudent(new Student());
		
		Message.addMessageByKey("INFO", " ", "msg_save");
		return null;
	}
	
	public String updateInterview() {
		dao = new InterviewDAO();
		dao.update(interview);
		table = dao.selectAll();
		interview = new Interview();

		return null;
	}
	
	public String sendEmail() {
		String body = "Dear student, your interview for ICT upskilling program will be on " + selectedInterview.getInterviewDate() +" from " +selectedInterview.getStartTime() +" to " + selectedInterview.getEndTime();

		Email.sendEmail(selectedInterview.getStudent().getEmail(), body);
		return null;
	}

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}

	public InterviewDAO getDao() {
		return dao;
	}

	public void setDao(InterviewDAO dao) {
		this.dao = dao;
	}

	public List<Interview> getTable() {
		return table;
	}

	public void setTable(List<Interview> table) {
		this.table = table;
	}


	public List<Student> getStudentTable() {
		return studentTable;
	}


	public void setStudentTable(List<Student> studentTable) {
		this.studentTable = studentTable;
	}


	public Interview getSelectedInterview() {
		return selectedInterview;
	}


	public void setSelectedInterview(Interview selectedInterview) {
		this.selectedInterview = selectedInterview;
	}



	
	
	
}
