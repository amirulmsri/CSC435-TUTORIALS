package tuto7;

public class Fruit {
	
	String type;
	double weightInKg, pricePerKg;
	
	public Fruit(String type,double weightInKg,double pricePerKg){
		
		this.type=type;
		this.weightInKg=weightInKg;
		this.pricePerKg=pricePerKg;
	}
	//copy constructor
	Fruit(Fruit fruit){
		type=fruit.type;
		weightInKg=fruit.weightInKg;
		pricePerKg=fruit.pricePerKg;
	}

	//processor
	public boolean isLocal() {
		boolean local = false;
		if(this.type.equalsIgnoreCase("local"))
		    local=true;
		else if(this.type.equalsIgnoreCase("imported"))
			local= false;
		
		return local;
	} 
	
	public double calcTotalPrice() {
		double totalprice;
		totalprice=this.weightInKg* this.pricePerKg;
		return totalprice;
	}
	
	public boolean isCheaper(Fruit f2) {
		if (this.calcTotalPrice()<f2.calcTotalPrice())
			return true;
		else 
		return false;
	}
}
