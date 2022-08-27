package assignment.test;

import java.util.List;

import assignment.bean.Student;
import assignment.bean.StudentResult;
import assignment.bean.TrainingCourses;
import assignment.dao.StudentResultDAO;

public class TestStudentResult {

	public static void main(String[] args) {
		
		 int row;
	        StudentResult studentResult = new StudentResult();
	        StudentResultDAO dao = new StudentResultDAO();



	       // **Delete**
	        System.out.println("---------------------------------");



	       row = dao.delete(1);
	        System.out.println(row + " deleted");



	       // **insert**
	        System.out.println("---------------------------------");
	        studentResult = new StudentResult(98.5, 78.4, "1", "no");
	        studentResult.setStudent(new Student(1));
	        studentResult.setTrainingCourses(new TrainingCourses(2));
	        row = dao.insert(studentResult);
	        System.out.println(studentResult.toString());
	        System.out.println(row + " inserted");



	       // **update**
	    /*    System.out.println("---------------------------------");
	        studentResult.setAcceptedFlag("1");
	        row = dao.update(studentResult);
	        System.out.println(row + " updated");*/



	       // **Select all**
	        System.out.println("---------------------------------");



	       List<StudentResult> studentResultsTable = dao.selectALL();
	        System.out.println(studentResultsTable);
		
	}

}
