package assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import assignment.bean.Program;
import assignment.bean.School;
import database.Database;

public class ProgramDAO {

	private Database db = null;
	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private int row;
	List<Program> proTable;
	
	public List<Program> selectAll() {
		proTable = new ArrayList<Program>();
		
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select school_id, program_id, program_aname, program_ename from program order by school_id, program_id");
			rs = ps.executeQuery();
					
			while (rs.next()) {
				Program program = new Program(rs.getInt("school_id"), rs.getInt("program_id"), rs.getString("program_aname"), rs.getString("program_ename"));
				
				SchoolDAO schoolDAO = new SchoolDAO();
				School school = schoolDAO.selectById(rs.getInt("school_id"));
				program.setSchool(school);
				
				proTable.add(program);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(rs);
			Database.close(connection);
			Database.close(ps);
		}
		
		return proTable;
		
	}
	
	public Program selectById(int id) {
		Program program = null;
		
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select school_id, program_id, program_aname, program_ename from program where program_id = ? order by school_id, program_id");
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
					
			if (rs.next()) {
				program = new Program(rs.getInt("school_id"), rs.getInt("program_id"), rs.getString("program_aname"), rs.getString("program_ename"));
				
				SchoolDAO schoolDAO = new SchoolDAO();
				School school = schoolDAO.selectById(rs.getInt("school_id"));
				program.setSchool(school);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(rs);
			Database.close(connection);
			Database.close(ps);
		}
		
		return program;
		
	}
	
	
	
	public int insert(Program program) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("insert into program (school_id, program_id, program_aname, program_ename) values(?, ?, ?, ?)");
			
			int counter = 1;
			
			ps.setInt(counter++, program.getSchoolid());
			ps.setInt(counter++, program.getProgramid());
			ps.setString(counter++, program.getAname());
			ps.setString(counter++, program.getEname());
			
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(connection);
			Database.close(ps);
		}
		
		return row;
		
	}
	public int update(Program program) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("update program set program_aname = ?, program_ename = ? where school_id = ? and program_id = ?");
			
			int counter = 1;
			
			ps.setString(counter++, program.getAname());
			ps.setString(counter++, program.getEname());
			ps.setInt(counter++, program.getSchool().getId());
			ps.setInt(counter++, program.getProgramid());
			
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(connection);
			Database.close(ps);
		}
		
		return row;
		
	}
	public int delete(int id1) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete from program where program_id = ?");
					
		
			ps.setInt(1, id1);
			
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(connection);
			Database.close(ps);
		}
		
		return row;
		
	}
	
	
	
}
