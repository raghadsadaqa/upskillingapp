package assignment.test;

import java.util.List;

import assignment.bean.Interview;
import assignment.dao.InterviewDAO;

public class test {
	
	InterviewDAO dao = new InterviewDAO();
	
	List<Interview> interviews = dao.selectAll();
	


}
