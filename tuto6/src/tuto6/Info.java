package tuto6;

public class Info {
	private String name;
	private double weight;
	private double height;
	private String status;
	//normal
	public Info(String name,double weight,double height) {
		this.setname(name);
		this.setweight(weight);
		this.setheight(height);
	}
	
	Info(Info personList){
		this.name = personList.name;
		this.weight = personList.weight;
		this.height = personList.height;
	}
	//accessor
	public String getname() {return name;}
	public double getweight() {return weight;}
	public double getheight() {return height;}
	
	
	//mutator
	public void setname(String name) {
		this.name = name;
	}
	public void setweight(double weight) {
		this.weight = weight;
	}
	public void setheight(double height) {
		this.height = height;
	}
	
	//processor
	public String bmiCategory(){
		//String status= new String();
		double bmi = weight/(height*height);

		if (bmi < 15)
			status= "very severely underweight";
		else if (bmi >= 15 && bmi <= 18.49)
			status=  "underweight";
		else if (bmi >=18.50 && bmi <=25.00)
			status=  "Normal";
		else if (bmi >=25.01 && bmi <= 40.00)
			status=  "obese";
		else if (bmi>40)
			status=  "very severely obese";
		return status;
}
	
	public String Display() {
		
		return name;
		
	}
	
	}
