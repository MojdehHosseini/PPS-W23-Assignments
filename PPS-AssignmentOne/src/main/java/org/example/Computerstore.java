package org.example;

import java.util.Scanner;
import java.util.ArrayList;

public class Computerstore {
	private Computer[] inventory;
    private final String password = "password";
    private int currentcomp = 0;

	public Computerstore(int computer_max) {
        inventory = new Computer[computer_max];
    }
	
	public void switcher(int option) {
		// TODO Auto-generated method stub
		switch (option) {
        case 1:
            option1_2(1);
            break;
        case 2:
            option1_2(2);
            break;
        case 3:
            option3();
            break;
        case 4:
            option4();
            break;
    }
	}
	
	private void option1_2(int option) {
		int n = 0;
		//only three tries
        while (n < 3) {
            System.out.print("What is your password?\n");
            String pass = Inputstream.scanner().next();
            if (!pass.equals(password)) {
                n++;
                System.out.println("it was not correct. You have "+(3-n)+ " attempts ");
            }
            else {
            	switch (option) {
	                case 1:
	                    addcomputer();
	                    break;
	                case 2:
	                    changecomputer();
	                    break;
            	}
            	break;  
            }
        }
    }
	
	private void option3() {
		System.out.print("input brand name: ");
	    String brand = Inputstream.scanner().next();
	    ArrayList<Computer> brandcomputers = findComputerByBrand(brand);
	    if (brandcomputers.size() == 0) {
	        System.out.println("nothing found");
	    }
	    for (Computer i: brandcomputers) {
	    	System.out.println(i);
	    }
    }
	
	private ArrayList<Computer> findComputerByBrand(String brand) {
        ArrayList<Computer> brandcomputers = new ArrayList<Computer>();
        for (Computer i: inventory) {
            if (i == null) {
                return brandcomputers;
            }
            if (i.getBrand().equals(brand)) {
            	brandcomputers.add(i);
            }
        }
        return brandcomputers;
    }
	
	private void option4() {
		System.out.print("input price: ");
        double price = Inputstream.scanner().nextDouble();
        ArrayList<Computer> cheapcomputers = findCheaperThan(price);
        if (cheapcomputers.size() == 0) {
            System.out.println("nothing found");
        }
        for (Computer i: cheapcomputers) {
        	System.out.println(i);
        }
	}
	
	private ArrayList<Computer> findCheaperThan(double price) {
		ArrayList<Computer> cheapcomputers = new ArrayList<>();
        for (Computer i: inventory) {
            if (i == null) {
                return cheapcomputers;
            }
            if (i.getPrice() < price) {
            	cheapcomputers.add(i);
            }
        }
        return cheapcomputers;
    }
	
	private void addcomputer() {
		System.out.println("How many computers do you want to add?\n");        
		int totalcomputernum = Inputstream.scanner().nextInt();
		
		if(totalcomputernum <= inventory.length - currentcomp)
	        for (int i = 0; i < totalcomputernum; i++) {
	        	System.out.println("You are entering the information of "+(i+1)+ "th devices");
                System.out.println("Enter the brand of this device: ");
                String br = Inputstream.scanner().next();
                System.out.println("Enter the model of this device: ");
                String mo = Inputstream.scanner().next();
                System.out.println("Enter the price of this device: ");
                double pr = Inputstream.scanner().nextDouble();
                System.out.println("Enter the serial number of this device: ");
                long ser = Inputstream.scanner().nextLong();
                inventory[currentcomp] = new Computer(br, mo, ser,pr);
                currentcomp++;
	        }
		else
           	System.out.println("You exceed the Capacity. The capacity is: " + (inventory.length - currentcomp));
        
    }
	
	private void changecomputer() {
		System.out.print("Index of the computer(from 0): ");
        int index = Inputstream.scanner().nextInt();
        if (index >= currentcomp) {
            System.out.println("Computer does not exist, input should be less than "+currentcomp);
            System.out.println("Retry: input any number, Main menu: input 1");
            switch (Inputstream.scanner().nextInt()) {
                case 1:
                	return;
                default:
                	changecomputer();
                    break;
            }
        }
        else if(index<currentcomp) {
	        Computer compobject = inventory[index];
	        System.out.println("Computer # " + index);
	        System.out.println(compobject);
	        changecomputerattribute(compobject);}
	}
	
	private void updatemenu() {
        System.out.print("What information would you like to change?\n" +
                "1. brand\n" +
                "2. model\n" +
                "3. SN\n" +
                "4. price\n" +
                "5. Quit\n" +
                "Enter your choice > ");
    }
	
	private void changecomputerattribute(Computer compobject) {
		updatemenu();
        try {
            int index = Inputstream.scanner().nextInt();
            if (index < 1 || index > 5) {
                throw new Exception();
            }
            switch (index) {
                case 1:
                    System.out.print("input brand: ");
                    compobject.setBrand(Inputstream.scanner().next());
                    break;
                case 2:
                    System.out.print("input model: ");
                    compobject.setModel(Inputstream.scanner().next());
                    break;
                case 3:
                    System.out.print("input SN: ");
                    compobject.setSN(Inputstream.scanner().nextLong());
                    break;
                case 4:
                    System.out.print("input price: ");
                    compobject.setPrice(Inputstream.scanner().nextDouble());
                    break;
                case 5:
                    return;
            }
            System.out.println("Information updated.");
	        System.out.println(compobject);
            changecomputerattribute(compobject);
        } catch (Exception e) {
            System.out.println("input valid number from 1 to 5");
            Inputstream.setdefault();
            changecomputerattribute(compobject);
        }
    }
}
