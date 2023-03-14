package assignment_2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
 
	  private String passengerName;
	  private String flightNumber;
	  private String origin;
	  private String destination;
	  private Date departureDate;
	  private Date returnDate;
	  private String bookingClass;
	  private int numPass;
	
	Booking(String origin,String destination,Date departureDate,Date returnDate,String bookingClass,int numPass){
		this.setOriginal(origin);
		this.setDestination(destination);
		this.setDepartureDate(departureDate);
		this.setReturnDate(returnDate);
		this.setbookingClass(bookingClass);
		this.setnumPass(numPass);
	}
	
	public String getorigin() {return origin;}
	public String getDestination() {return destination;}
	public Date getDepartureDate() {return departureDate;}
	public Date getReturnDate() {return returnDate;}
	public String getBookingClass() {return bookingClass;}
	public int getnumPass() {return numPass;}
	
	public void setOriginal(String origin) {this.origin = origin;}
	public void setDestination(String destination) {this.destination = destination;}
	public void setDepartureDate(Date departureDate) {this.departureDate = departureDate;}
	public void setReturnDate(Date returnDate) {this.returnDate = returnDate;}
	public void setbookingClass(String bookingClass) {this.bookingClass = bookingClass;}
	public void setnumPass(int numPass) {this.numPass = numPass;}
	
	public String departDateFormatter() {
		Date date = this.getDepartureDate();  
	    DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");  
	    String strDate = dateFormat.format(date);
	    
	    return strDate;
	}
	public String returnDateFormatter() {
		Date date = this.getReturnDate();  
	    DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");  
	    String strDate = dateFormat.format(date);
	    
	    return strDate;
	}

	
}
