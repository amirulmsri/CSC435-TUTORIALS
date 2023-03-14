package tuto9;

abstract class Student{
	protected String studentName;
	protected String studentMatric;
	protected String programmerCode;
	protected char gender;
	
	public Student(String studentName,String studentMatric,String programmerCode,char gender) {
		
	}
}

class Resident extends Student{

	private String collegeID;
	
	public Resident(String studentName, String studentMatric, String programmerCode, char gender,String collegeID) {
		super(studentName, studentMatric, programmerCode, gender);
		this.setCollegeID(collegeID);
	}
	
	public String getCollegeID() {return collegeID;}
	public void setCollegeID(String collegeID) {this.collegeID = collegeID;}
	
	public String toString() {
		return super.studentName +super.studentMatric + super.programmerCode+ super.gender 
				+collegeID;
	}
	
	public double calculateFee() {
	
		if(super.programmerCode.charAt(2) == '2')
		    return 1200.00;
		else
			return 600.00;
	}
}

class NonResident extends Student{

	private boolean studyMode;
	
	public NonResident(String studentName, String studentMatric, String programmerCode, char gender,boolean studyMode) {
		super(studentName, studentMatric, programmerCode, gender);
		this.setStudyMode(studyMode);
	}
	public boolean getStudyMode() {return  studyMode;}
	public void setStudyMode(boolean studyMode) {this.studyMode = studyMode;}
	
	public String toString() {
		return super.studentName +super.studentMatric + super.programmerCode+ super.gender 
				+ studyMode;
	}
	
	public double calculateFee() {
		
		if(super.programmerCode.charAt(2) == '2') {
			if(this.getStudyMode()==false)
				return (950.00+200.00);
			else
				return 950.00;
		}
		
		else
			return 400.00;

	}
}


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
