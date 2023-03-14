package assignment_2;

public class FlightSummary  {
	private String departTime;
	private String arriveTime;
	private double departFare;
	private double returnFare;
	private double taxes;
	
	FlightSummary(String departTime, String arriveTime) {
		this.setdepartTime(departTime);
		this.setarriveTime(arriveTime);
		taxes = 325.86;
		//this.setdepartFare(departFare);
		//this.setreturnFare(returnFare);
	
	}
	
	public String getdepartTime() {return departTime;}
	public String getarriveTime() {return arriveTime;}
	public double getdepartFare() {return departFare;}
	public double getreturnFare() {return returnFare;}
	public double getTaxes() {return taxes;}
	
	public void setdepartTime(String departTime) {this.departTime = departTime;}
	public void setarriveTime(String arriveTime) {this.arriveTime = arriveTime;}
	public void setdepartFare(double departFare) {this.departFare = departFare;}
	public void setreturnFare(double returnFare) {this.returnFare = returnFare;}
	public void setTaxes(double taxes) {this.taxes = taxes;}
	
	public double TotalCharge() {
		double TotalCharge=0;
		
		TotalCharge = this.getTaxes() + this.getdepartFare() + this.getreturnFare();
		
		return TotalCharge;
	}
	


}
