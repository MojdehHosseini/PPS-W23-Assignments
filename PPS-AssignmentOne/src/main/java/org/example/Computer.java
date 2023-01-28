package org.example;

public class Computer {
	// Attributes

    private String brand;
    private String model;
    private double price;
    private long SN;
    static private int count=0;

	public Computer() {
		// TODO Auto-generated constructor stub
		
        System.out.println("Creating a Device object using default constructor ....");
		this.brand="Apple";
        this.model="14";
        this.SN=1234455;
        this.price=100;
        count++;
	}
	
	public Computer(String br, String mo, long serial, double pr) {
	    System.out.println("Creating a Device object using parametrized constructor ....");
        this.price=pr;
        this.brand=br;
        this.model=mo;
        this.SN=serial;
        count++;
    }
	
	public Computer(Computer dev) {
		System.out.println("Creating a Device object using copy constructor ....");
        price = dev.price;
        brand = dev.brand;
        model=dev.model;
        SN=dev.SN;
        count++;
    }
	
	//accessors
	 public String getBrand() {
        return brand;
	 }
	 public long getSN() {
        return SN;
     }
	 public String getModel() {
         return model;
     }
	 public double getPrice() {
         return price;
     }
	 public static int findNumberOfCreatedComputers() {
         return count;
     }
	 
	 //mutators
     public void setBrand(String brand) {
        this.brand=brand;
     }
     public void setSN(long sN) {
         SN = sN;
     }
     public void setModel(String model) {
         this.model = model;
     }
     public void setPrice(double price) {
         this.price = price;
     }
     public static void setNumberOfCreatedComputers(int num) {
         count=num;
     }
     
     public boolean equals(Computer obj) {
         if (obj == null) {
             return false;
         }
         if(this==obj)
             return true;
         if(this.brand.equals(obj.brand)&&
                 this.model.equals(obj.model)&&
                 this.price==obj.price) {
             return true;
         }
         return false;
     }
     
     //display all information
     public String toString()
     {
         return "Brand: " + this.getBrand() + "\nModel: "+this.getModel()+"\nSN: "+this.getSN()+
                 "\nPrice: $" + this.getPrice()+"\n#devices so far: "+findNumberOfCreatedComputers();
     }

}
