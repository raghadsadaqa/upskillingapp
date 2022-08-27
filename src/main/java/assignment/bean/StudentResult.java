package assignment.bean;

public class StudentResult {

	//private int studentid;
	//private int courseid;
	private double engMark;
	private double interviewMark;
	private String acceptedFlag;
	private String notes;
	
	private Student student;
	private TrainingCourses trainingCourses;
	
	public StudentResult() {

	}

	

	public StudentResult(String acceptedFlag) {
		this.acceptedFlag = acceptedFlag;
	}

	public StudentResult( double engMark, double interviewMark, String acceptedFlag,
			String notes) {
		//this.studentid = studentid;
	//	this.courseid = courseid;
		this.engMark = engMark;
		this.interviewMark = interviewMark;
		this.acceptedFlag = acceptedFlag;
		this.notes = notes;
	}
	
	/*public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}*/
	public double getEngMark() {
		return engMark;
	}
	public void setEngMark(double engMark) {
		this.engMark = engMark;
	}
	public double getInterviewMark() {
		return interviewMark;
	}
	public void setInterviewMark(double interviewMark) {
		this.interviewMark = interviewMark;
	}
	public String getAcceptedFlag() {
		return acceptedFlag;
	}
	public void setAcceptedFlag(String acceptedFlag) {
		this.acceptedFlag = acceptedFlag;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	public TrainingCourses getTrainingCourses() {
		return trainingCourses;
	}

	public void setTrainingCourses(TrainingCourses trainingCourses) {
		this.trainingCourses = trainingCourses;
	}


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}



	@Override
	public String toString() {
		return "StudentResult [engMark=" + engMark + ", interviewMark=" + interviewMark + ", acceptedFlag="
				+ acceptedFlag + ", notes=" + notes + ", student=" + student + ", trainingCourses=" + trainingCourses
				+ "]";
	}



	
	
	
}
