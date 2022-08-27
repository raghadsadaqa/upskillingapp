package assignment.bean;

public class StudentTC {
	
	private Student student;
	private TrainingCourses trainingCourses;
	private int courseid;
	private int priority;
	

	public StudentTC() {

	}
	
	public StudentTC(int priority) {
		this.priority = priority;
	}
	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public TrainingCourses getTrainingCourses() {
		return trainingCourses;
	}

	public void setTrainingCourses(TrainingCourses trainingCourses) {
		this.trainingCourses = trainingCourses;
	}

	@Override
	public String toString() {
		return "StudentTC [student=" + student + ", trainingCourses=" + trainingCourses + ", priority=" + priority
				+ "]";
	}
	
	
	

}
