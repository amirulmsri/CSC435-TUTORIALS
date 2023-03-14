package tuto4;

public class Student {
	//Data Members
	private String name;
	private String id;
	private char gender;
	private double cgpa;
	
	//default constructor
	public Student() {
		name="unknown";
		id ="null";
		//gender = 'm';
		cgpa = 0;
	}
	//normal constructor
	Student (String name,String id,char gender,double cgpa){
		this.name = "abu";
		this.id ="s123";
		this.gender = 'M';
		this.cgpa = 3.5;
	}
	//copy constructor
	Student(Student myStudent) {
		name=myStudent.id;
		id = myStudent.id;
		gender = myStudent.gender;
		cgpa = myStudent.cgpa;
	}
	
	//Mutator
	void SetInfo(String name,String id,char gender,double cgpa) {
		this.name = name;
		this.id =id;
		this.gender = gender;
		this.cgpa = cgpa;
	}
	//Accessor
	public String Getname() {
		return name;
	}
	public String Getid() {
		return id;
	}
	public String Getn() {
		return name;
	}
	
	
	public static void main(String[] args) {
		Student myStudent = new Student(); 
		System.out.println(myStudent.cgpa);

	}

}
