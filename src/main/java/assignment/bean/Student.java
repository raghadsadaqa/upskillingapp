package assignment.bean;

import java.util.Date;

public class Student {

	private int studentid;
	private String aname;
	private String ename;
	private String mobile;
	private Date birthDate;
	private String sex;
	private String email;
	private int universityid;
	private int shcoolid;
	private int programid;
	private Double finalAvg;
	private Double maxAvg;
	private String rate;
	private int graduateYear;
	private int graduateSem;

	private University university;
	private School school;
	private Program program;

	public Student() {

	}
	
	public Student(String email) {
		this.email = email;
	}


	public Student(int studentid, String aname, String ename, String mobile, Date birthDate, String sex, String email,
			int universityid, int shcoolid, int programid, Double finalAvg, Double maxAvg, String rate,
			int graduateYear, int graduateSem) {
		this.studentid = studentid;
		this.aname = aname;
		this.ename = ename;
		this.mobile = mobile;
		this.birthDate = birthDate;
		this.sex = sex;
		this.email = email;
		this.universityid = universityid;
		this.shcoolid = shcoolid;
		this.programid = programid;
		this.finalAvg = finalAvg;
		this.maxAvg = maxAvg;
		this.rate = rate;
		this.graduateYear = graduateYear;
		this.graduateSem = graduateSem;
	}


	public Student(int studentid) {
		this.studentid = studentid;
	}

	public Student(int studentid, String aname, String ename, String mobile, Date birthDate, String sex, String email,
		 int shcoolid, int programid, Double finalAvg, Double maxAvg, String rate,
			int graduateYear, int graduateSem) {
		this.studentid = studentid;
		this.aname = aname;
		this.ename = ename;
		this.mobile = mobile;
		this.birthDate = birthDate;
		this.sex = sex;
		this.email = email;
		this.shcoolid = shcoolid;
		this.programid = programid;
		this.finalAvg = finalAvg;
		this.maxAvg = maxAvg;
		this.rate = rate;
		this.graduateYear = graduateYear;
		this.graduateSem = graduateSem;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getUniversityid() {
		return universityid;
	}

	public void setUniversityid(int universityid) {
		this.universityid = universityid;
	}

	public int getShcoolid() {
		return shcoolid;
	}

	public void setShcoolid(int shcoolid) {
		this.shcoolid = shcoolid;
	}

	public int getProgramid() {
		return programid;
	}

	public void setProgramid(int programid) {
		this.programid = programid;
	}

	public Double getFinalAvg() {
		return finalAvg;
	}

	public void setFinalAvg(Double finalAvg) {
		this.finalAvg = finalAvg;
	}

	public Double getMaxAvg() {
		return maxAvg;
	}

	public void setMaxAvg(Double maxAvg) {
		this.maxAvg = maxAvg;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public int getGraduateYear() {
		return graduateYear;
	}

	public void setGraduateYear(int graduateYear) {
		this.graduateYear = graduateYear;
	}

	public int getGraduateSem() {
		return graduateSem;
	}

	public void setGraduateSem(int graduateSem) {
		this.graduateSem = graduateSem;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", aname=" + aname + ", ename=" + ename + ", mobile=" + mobile
				+ ", birthDate=" + birthDate + ", sex=" + sex + ", email=" + email + ", universityid=" + universityid
				+ ", shcoolid=" + shcoolid + ", programid=" + programid + ", finalAvg=" + finalAvg + ", maxAvg="
				+ maxAvg + ", rate=" + rate + ", graduateYear=" + graduateYear + ", graduateSem=" + graduateSem
				+ ", university=" + university + ", school=" + school + ", program=" + program + "]";
	}

	

}
