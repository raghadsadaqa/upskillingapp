package assignment.test;

import java.util.List;

import assignment.bean.School;
import assignment.dao.SchoolDAO;

public class TestSchool {

	public static void main(String[] args) {
		
		SchoolDAO dao = new SchoolDAO();
		
		School school = new School(3);
		int row = dao.delete(3);
		System.out.println(row + "deleted");

		
		school = new School(3, "القانون", "low");
		row = dao.insert(school);
		System.out.println(row + "inserted");
		
		school = new School(4, "التمريض", "Nursing");
		row = dao.update(school);
		System.out.println(row + "Updated");

		
		List<School> schoolTable = dao.selectALL();
		System.out.println(schoolTable);
		
		
		
	}

}
