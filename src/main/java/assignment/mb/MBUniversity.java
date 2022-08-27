package assignment.mb;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;

import assignment.bean.University;
import assignment.dao.UniDAO;
import reports.Reports;
import util.Message;

@ManagedBean(name = "mbUniversity")
@ViewScoped
public class MBUniversity {
	
	private University university;
	private UniDAO dao;
	private List<University> Table;
	
	
	@PostConstruct
	public void init() {
		dao = new UniDAO();
		Table = dao.selectALL();
		university = new University();
	}
	
	public String save() {
		dao = new UniDAO();
		dao.insert(university);
		university = new University();
		
		Message.addMessageByKey("INFO", " ", "msg_save");
		return null;
	}
	
	public String updateUni() {
		dao.update(university);
		Table = dao.selectALL();
		return null;
	}
	
	public String deleteUni() {
		dao.delete(university.getId());
		Table = dao.selectALL();
		return null;
	}
	
	
	public String runUniReport() throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/image/HTULogo-250px.png"));
		param.put("p_image", image);

		Reports report = new Reports();
		report.runPdf("university.jasper", param);

		return null;
	}
	

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public List<University> getTable() {
		return Table;
	}

	public void setTable(List<University> table) {
		Table = table;
	}
	
	

}
