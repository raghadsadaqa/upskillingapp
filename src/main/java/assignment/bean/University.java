package assignment.bean;

public class University {

	private int id;
	private String aname;
	private String ename;
	private String website;

	public University(int id, String aname, String ename, String website) {
		this.id = id;
		this.aname = aname;
		this.ename = ename;
		this.website = website;
	}
	public University() {
	}
	public University(int id) {
		this.id = id;
	}
	
	//Getter and Setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	@Override
	public String toString() {
		return "University [universityid=" + id + ", aname=" + aname + ", ename=" + ename + ", website="
				+ website + "] \n";
	}
	
	
	
	
}
