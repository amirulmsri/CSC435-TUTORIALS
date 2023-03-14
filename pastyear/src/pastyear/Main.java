package pastyear;

class Fruit{
	private String name;
	private String type;
	private double weight;
	private double price;
	
	//normal 
	Fruit(String name,String type,double weight,double price){
		this.setdata(name,type,weight,price);
	}
	
	public void setdata(String name,String type,double weight,double price) {
		this.name=name;
		this.type=type;
		this.weight=weight;
		this.price=price;
	}
	public String getname() {return name;}
	public String gettype() {return type;}
	public double getweight() {return weight;}
	public double getprice() {return price;}
	
	public boolean isLocal() {
		if (type.equalsIgnoreCase("local"))
			return true;
		else {
		return false;}
	}
	
	public double calcTotalPrice() {
		double totalprice=0;
		if(isLocal()==true)
		totalprice=(price*weight)*0.97;
		else {
			totalprice=price*weight;
		}
		return totalprice;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruit fruitList[]=new Fruit[3];
		fruitList[0]= new Fruit("limau","local",20,30);
		fruitList[1] = new Fruit("orange","import",20,30);
		fruitList[2] = new Fruit("watermelon","import",30,40);
		
		//System.out.println(String.format("RM%-10.2f", fruitList[0].calcTotalPrice()));
		System.out.println(String.format("RM%-10.2f", fruitList[1].calcTotalPrice()));
		System.out.println(String.format("RM%-10.2f", fruitList[2].calcTotalPrice()));
		double max=fruitList[0].calcTotalPrice();
		int j =1;
		for(int i =1;i<fruitList.length;i++) {
			
			if(fruitList[i].calcTotalPrice()> max) {
				max=fruitList[i].calcTotalPrice();
				j++;
			}
			
		}
		//System.out.println(fruitList[max].getname());
		double ttprice=0;
		for(int i =0;i<3;i++) {
			if(fruitList[i].isLocal()==false) {
				ttprice+=fruitList[i].calcTotalPrice();
			}
		}
		System.out.println(ttprice);
		    
	}

}
