package org.example;

public class Main {
    public static void main(String[] args) {
    	 System.out.println("Welcome to the Device Center");
    	 System.out.println("Please enter the maximum number of devices you can have: ");
    	 Computerstore compstore = new Computerstore(Inputstream.scanner().nextInt());

         int option = 0;
         while (option!=5) {
        	 System.out.print("What do you want to do?\n" +
                     "1. Enter new computers (password required)\n" +
                     "2. Change information of a computer (password required)\n"+ 
                     "3. Display all computers by a specific brand\n" +
                     "4. Display all computers under a certain a price.\n" +
                     "5. Quit\n" +
                     "Please enter your choice >");
        	 option = Inputstream.scanner().nextInt();
        	 if (option == 5) {
        		 System.out.println("Good bye.\n");
                 return;
             }
        	 compstore.switcher(option);
         }
    }
}