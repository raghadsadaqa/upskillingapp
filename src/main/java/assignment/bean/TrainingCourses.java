package assignment.bean;

public class TrainingCourses {

	private int courseid;
	private String aname;
	private String ename;
	private int maxstudent;
	private String shortDescr;
	private String detailedDesc;
	
	public TrainingCourses() {

	}
	

	public TrainingCourses(int courseid) {
		this.courseid = courseid;
	}


	public TrainingCourses(int courseid, String aname, String ename, int maxstudent, String shortDescr,
			String detailedDesc) {
		this.courseid = courseid;
		this.aname = aname;
		this.ename = ename;
		this.maxstudent = maxstudent;
		this.shortDescr = shortDescr;
		this.detailedDesc = detailedDesc;
	}



	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
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
	public int getMaxstudent() {
		return maxstudent;
	}
	public void setMaxstudent(int maxstudent) {
		this.maxstudent = maxstudent;
	}
	public String getShortDescr() {
		return shortDescr;
	}
	public void setShortDescr(String shortDescr) {
		this.shortDescr = shortDescr;
	}
	public String getDetailedDesc() {
		return detailedDesc;
	}
	public void setDetailedDesc(String detailedDesc) {
		this.detailedDesc = detailedDesc;
	}
	
	@Override
	public String toString() {
		return "TrainingCourses [courseid=" + courseid + ", aname=" + aname + ", ename=" + ename + ", maxstudent="
				+ maxstudent + ", shortDescr=" + shortDescr + ", detailedDesc=" + detailedDesc + "] \n";
	}
	
	

	
}
