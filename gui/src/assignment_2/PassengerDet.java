package assignment_2;

public class PassengerDet {
	private String firstName;
	private String lastName;
	private String passportNum;
	private String phoneNum;
	private String email;
	private String countryCode;
	
	private String EM_name;
	private String EM_phonNum;
	
	public PassengerDet(String firstName,String lastName,String passportNum,String phoneNum,String email,String countryCode) {
		
	}
	
	public String getfirstName() {return firstName;}
	public String getlastName() {return lastName;}
	public String getpassportNum() {return passportNum;}
	public String getphoneNum() {return phoneNum;}
	public String getemail() {return email;}
	public String getcountryCode() {return countryCode;}
	
	public void setfirstName(String firstName) {this.firstName = firstName;}
	public void setlastName(String lastName) {this.lastName = lastName;}
	public void setpassportNum(String passportNum) {this.passportNum = passportNum;}
	public void setemail(String email) {this.email = email;}
	public void setcountryCode(String countryCode) {this.countryCode = countryCode;}

}
