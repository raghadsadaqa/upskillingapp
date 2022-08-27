package assignment.bean;

public class School {

	private int id;
	private String aname;
	private String ename;
	private String website;


	public School() {

	}

	public School(int id) {
		this.id = id;
	}

	public School(int id, String aname, String ename) {
		this.id = id;
		this.aname = aname;
		this.ename = ename;
	}

	
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
		return "School [schoolid=" + id + ", aname=" + aname + ", ename=" + ename + "] \n";
	}
	
	
	
}
