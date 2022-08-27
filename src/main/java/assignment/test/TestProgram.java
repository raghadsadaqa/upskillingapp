package assignment.test;

import java.util.ArrayList;
import java.util.List;

import assignment.bean.Program;
import assignment.bean.School;
import assignment.dao.ProgramDAO;

public class TestProgram {

	public static void main(String[] args) {
		Program program;
		ProgramDAO dao = new ProgramDAO();
		/*
		program = new Program();
		int row = dao.delete(5, 10);
		System.out.println(row + "deleted");*/
		
	/*	program = new Program(10, "تست", "Test");
		program.setSchool(new School(5));
		int row = dao.insert(program);
		System.out.println(row + "inserted");
		
		/*program = new Program(2, 2, "Ø§Ù„Ø¯ÙˆØ§Ù… Ø§Ù„ÙƒØ§Ù…Ù„", "Full time");
		row = dao.update(program);
		System.out.println(row + "updated");*/

		List<Program> proTable = dao.selectAll();
		System.out.println(proTable);
		
		
	}

}
