package org.example;

import java.util.Scanner;

class Device {

    // Attributes

    private double price;
    private String brand;
    private String model;
    private long SN;

    static private int count=0;

    // Constructors
    public Device(){   // default constructor
        System.out.println("Creating a Device object using default constructor ....");

        price=100;
        brand="Apple";
        model="14";
        SN=1234455;
        count++;

    }
    public Device(double pr, String br, String mo, long serial ){   // parametrized constructor
        System.out.println("Creating a Device object using parametrized constructor ....");

        price=pr;
        brand=br;
        model=mo;
        SN=serial;
        count++;


    }


    public Device(Device dev)	// copy constructor
    {
        System.out.println("Creating a Device object using copy constructor ....");

        price = dev.price;
        brand = dev.brand;
        model=dev.model;
        SN=dev.SN;
        count++;


    }
    //public int getNumOfDevices()
//    {
//        return numOfDoors;
//    }

    //public void setNumOfDoors(int nd)
//    {
//        numOfDoors = nd;
//    }

    public int findNumberOfCreatedComputers(){return count;}

    public boolean equals(Device dev) {    // Two Devices are considered equal if they have the same brands, the same
        // price and the same model and the same SerialNumber.
        if (brand == dev.brand && price == dev.price && model == dev.model && SN == dev.SN)
            return true;
        else
            return false;

    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double pr)
    {
        price = pr;
    }

    public String toString()
    {
        return "The Brand of this device is:  " + brand +
                " and its price is:  " + price + "$."+" the number of devices so far is : "+findNumberOfCreatedComputers();
    }



}
public class AssignmentOne {

    public static void main(String[] args) {
        System.out.println("Welcome to the Device Center");
        Scanner console = new Scanner(System.in);

        System.out.println("Please enter the maximum number of devices you can have: ");
        int c = console.nextInt();
        Device [] inventory= new Device[c];
        inventory[0]= new Device();
        inventory[2]= new Device(inventory[0]);

        inventory[1]= new Device(1000,"Sumsung","S14",65161882);



        int option = 0;
        while (option!=5) {
            System.out.println("What do you want to do?\n" +
                    "1. Enter new computers (password required)\n" +
                    "2. Change information of a computer (password required) 3. Display all computers by a specific brand\n" +
                    "4. Display all computers under a certain a price.\n" +
                    "5. Quit\n" +
                    "Please enter your choice >");
            option = console.nextInt();
            console.nextLine(); // This line you have to add (It consumes the \n character)
            switch (option) {
                case 1:
                {int n = 0;
                    while (n < 3) {
                        System.out.println("What is your password?\n");
                        String pass = console.nextLine();
                        if (!pass.equals("password")) {
                            n++;
                            System.out.println("it was not correct. You have "+(3-n)+ " attempts ");
                        }
                        else {
                            System.out.println("How many computers do you want to add?\n");
                            int m = console.nextInt();
                            int remaining = 0, last = 0;

                            for (int i = 0; i < inventory.length; i++) {
                                if (inventory[i] == null) {
                                    remaining++;
                                } else {
                                    last = i;
                                }
                            }
                            if (m > remaining) {
                                System.out.println("You exceed the Capacity. The remaining Capacity is: "
                                        + remaining);
                            } else {


                                for (int i = last + 1; i < last + 1 + m; i++) {
                                    System.out.println("You are entering the information of "+(i+1)+ "th devices");
                                    console.nextLine(); // This line you have to add (It consumes the \n character)
                                    System.out.println("Enter the brand of this device: ");
                                    String br = console.nextLine();
                                    System.out.println("Enter the model of this device: ");
                                    String mo = console.nextLine();
                                    System.out.println("Enter the price of this device: ");
                                    double pr = console.nextDouble();
                                    System.out.println("Enter the serial number of this device: ");
                                    long ser = console.nextLong();


                                    inventory[i] = new Device(pr, br, mo, ser);

                                }


                            }
                            n=3;
                        }


                    }
                }


                break;
                case 2:
                    // code block
                    break;
                case 3:
                    // code block
                    break;
                case 4:
                    // code block
                    break;

                case 5:
                {System.out.println("Good bye.\n");
                    break;
                }

                default:
                {System.out.println("What do you want to do?\n" +
                        "1. Enter new computers (password required)\n" +
                        "2. Change information of a computer (password required) 3. Display all computers by a specific brand\n" +
                        "4. Display all computers under a certain a price.\n" +
                        "5. Quit\n" +
                        "Please enter your choice >");
                    option = console.nextInt();}
            }

        }

        System.out.println("Here is the information of the first Device:\n" + inventory[0] + "\n");
        System.out.println("Here is the information of the second Device:\n" + inventory[1] + "\n");
        System.out.println("Here is the information of the third Device:\n" + inventory[2] + "\n");



        // Now, compare these objects

        if (inventory[0].equals(inventory[1]) == true) 		// this can simply be written as if (v1.equals(v2))
        {
            System.out.println("v1 and v2 are identical vehicles");
        }
        else
        {
            System.out.println("v1 and v2 are NOT identical vehicles");
        }

        if (inventory[0].equals(inventory[2])) {
            System.out.println("v1 and v3 are identical vehicles");
        }
        else
        {
            System.out.println("v1 and v3 are NOT identical vehicles");
        }

        System.out.println("Changing the D3:\n");
        inventory[2].setPrice(2000);

        if (inventory[0].equals(inventory[2])) {
            System.out.println("v1 and v3 are identical vehicles");
        }
        else
        {
            System.out.println("v1 and v3 are NOT identical vehicles");
        }


    }
}
