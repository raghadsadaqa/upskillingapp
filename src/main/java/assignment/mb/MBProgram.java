package assignment.mb;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;

import assignment.bean.Program;
import assignment.bean.School;
import assignment.dao.ProgramDAO;
import assignment.dao.SchoolDAO;
import reports.Reports;
import util.Message;

@ManagedBean(name = "mbProgram")
@ViewScoped
public class MBProgram {

	private Program program;
	private ProgramDAO dao;
	private List<Program> table;
	List<School> schoolTable;

	@PostConstruct
	public void init() {
		SchoolDAO schoolDAO = new SchoolDAO();
		schoolTable = schoolDAO.selectALL();
		
		dao = new ProgramDAO();
		table = dao.selectAll();
		program = new Program();
		program.setSchool(new School());
	}

	public String save() {
		dao = new ProgramDAO();
		dao.insert(program);
		program = new Program();
		
		Message.addMessageByKey("INFO", " ", "msg_save");
		return null;
	}
	
	public String updateProgram() {
		dao.update(program);
		table = dao.selectAll();
		return null;
	}
	
	public String deleteProgram() {
		dao.delete(program.getProgramid());
		table = dao.selectAll();
		return null;
	}
	
	public String runProgramReport() throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/image/HTULogo-250px.png"));
		param.put("p_image", image);

		Reports report = new Reports();
		report.runPdf("program1.jasper", param);

		return null;
	}
	

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public List<Program> getTable() {
		return table;
	}

	public void setTable(List<Program> table) {
		this.table = table;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	
	
}
