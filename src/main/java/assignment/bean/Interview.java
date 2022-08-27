package assignment.bean;

import java.sql.Date;

public class Interview {

	private Student student;
	//private int studentid;
	private Date interviewDate;
	private Date startTime;
	private Date endTime;
	

	public Interview() {

	}


	public Interview(Date interviewDate, Date startTime, Date endTime) {
		this.interviewDate = interviewDate;
		this.startTime = startTime;
		this.endTime = endTime;
	}







	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Date getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	@Override
	public String toString() {
		return "Interview [student=" + student + ", interviewDate=" + interviewDate + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}


	

	
}
