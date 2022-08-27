package assignment.test;

import java.util.List;

import assignment.bean.University;
import assignment.dao.UniDAO;

public class testUniversity {

	public static void main(String[] args) {
		
		UniDAO dao = new UniDAO();
		
		University university = new University(1);
		int row = dao.delete(1);
		System.out.println(row + "deleted");
		

	     university = new University(5, "جامعة الزرقاء", "Zarqa University", "https://www.zu.edu.jo/ar/index.aspx");
	    row = dao.insert(university);
		System.out.println(row + "inserted");
		
		
		university = new University(3, "الجامعة الهاشمية", "Hasheimte University", "https://hu.edu.jo/");
		row = dao.update(university);
		System.out.println(row + "updated");
		

		List<University> UniTable = dao.selectALL();

		System.out.println(UniTable);
		
		
		University table = dao.selectByid(1);
		System.out.println(table);

		
		
		
		
	}

}
