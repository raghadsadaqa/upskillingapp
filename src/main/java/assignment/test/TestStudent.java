package assignment.test;

import java.util.Date;
import java.util.List;

import assignment.bean.Student;
import assignment.dao.StudentDAO;

public class TestStudent {

	public static void main(String[] args) {
		
		StudentDAO dao = new StudentDAO();
	/*	
		Student student = new Student(1);
		int row = dao.delete(1);
		System.out.println(row + "deleted");
		
		student = new Student(1, "Ø±ØºØ¯ ØµØ¯Ù‚Ø©", "raghad sadaqa", "123456",new Date(), "female", "raghad.com", 2, 1, 1, 88.5, 100.0, "55", 2021, 2);
		row = dao.insert(student);
		System.out.println(row + "inserted");*/
		
		//Student student = new Student("أماني", "Amani", "0791848592", new Date(), "female", "amani.a@yahoo.com", 2, 1, 1, 88.5, 89.1, "85", 2017, 2);
		//int row = dao.insert(student);
		//System.out.println(row + "inserted");
		
		List<Student> studentTable = dao.selectALL();
		System.out.println(studentTable);
		
	}

}
