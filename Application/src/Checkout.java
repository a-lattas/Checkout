/**
 * The Application was created in order to implement in a simplified way 
 * the procedure a cashier is handling while working in a market.
 * @author Alexander Lattas
 */


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Checkout{

	public static int choice = 0;
        /**
        * The Application was created in order to implement in a simplified way 
        * the procedure a cashier is handling while working in a market.
        */
	public static void main( String[] args){

// Initialize //

		Scanner scanner = new Scanner(System.in);

	// Product input //

                readProducts();

	// Customers //

		Customer customer1 = new Customer("Steve", "Jobs",
                        "Alta Mesa Memorial Park", "408-996-1010");
		Customer customer2 = new Customer("James", "Gosling",
                        "Something 8 Something", "123-456-789");
		Customer customer3 = new Customer("Alexandros", "Lattas",
                        "Magnisias 4 Papagou", "6976976976");

	// Employees //

		Cashier cashier1 = new Cashier("Roula", "Roulitsa", 1,
                        "roula123", "qwerty", 0, 4);
		Administrator admin1 = new Administrator("Mimika", "Loliou",
                        0, "mimi", "1234", 28);
                
        // Intro //
                
		System.out.println("Hello, Welcome to SuperMarket Mixanografisi");


// MENU //

	// Print MENU //
		int first = 0;
		int exit = 0;
		while(exit == 0){

			int id = -1;

			while(id == -1){

				//finishing rest of the line

				if(first == 0){
					System.out.println("Press enter to log in");
					first ++;
				} // end if first
				scanner.nextLine();

				Waiting.waiting();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("Please Log in");
				System.out.println();
				System.out.printf("Enter Username: ");
				String inUsername = scanner.nextLine();
				System.out.printf("\nEnter Password: ");
				String inPassword = scanner.nextLine();
				System.out.println();

				id = Employee.logIn(inUsername, inPassword);

				if(id == -1){
					System.out.println("Username and Password don't match to an existing account.");
				}else{
					System.out.printf("\nWelcome %s!\n", Employee.employeeArray[id].getName() );
				} //  end if


			} // end while id

			choice = 0;

			while( choice != -1){
				if (Employee.employeeArray[id] instanceof Cashier){

					cashierActions();

				}else if(Employee.employeeArray[id] instanceof Administrator){

					adminActions();

				} // end else if

			}// end while choice

			System.out.println();
			System.out.println("If you want to log another account, press 0");
			System.out.println("If you want to exit, press 1");

			exit = -1;
			while(exit != 1 && exit != 0){

				exit = scanner.nextInt();
				if(exit != 1 && exit != 0){

					System.out.println("Wrong input");


				}// end if

			}// end while set exit


		} // end while exit





	}//end main
        /**
         * Reads products list from the stored Products.txt
         */
	public static void readProducts(){
                
		try{
                        File file = new File("Products.txt");
                        System.out.println(file.canExecute());
                        System.out.println(file.canRead());
                        System.out.println(file.canWrite());
                        System.out.println(file.exists());
                        System.out.println(file.isFile());
                        System.out.println(file.isDirectory());
			FileInputStream fstream = new FileInputStream("Products.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader( new InputStreamReader(in));

			String line;
			String[] readArray;

			while((line = br.readLine())!=null){

				readArray = line.split(",");

				String readName = readArray[0];
				int readWeight = Integer.parseInt(readArray[1]);
				double readPrice = Double.parseDouble(readArray[2]);

				new Product(readName, readWeight, readPrice);
			} // end while

			in.close();

		} // end try

		catch(Exception ex){

			System.out.println("An exception is caught!! ");
			ex.printStackTrace();

		} // end catch

	} // end read

        /**
         * Prints supported actions for cashier employee and starts the
         * corresponding one.
         */
	public static void cashierActions(){

		Waiting.waiting();
		System.out.println();
		System.out.println("Press the number to make an action. to exit pres -1");
		System.out.println();
		System.out.println("1. Print a specific product ");
		System.out.println("2. Register a customer");
		System.out.println("3. Make an exchange");

		Scanner scanner2 = new Scanner(System.in);
		choice = scanner2.nextInt();

		if(choice == 1){

			Product.output();

		}else if(choice == 2){

			Customer.record();

		}else if(choice == 3){

			Receipt.cashier();

		}else if(choice != -1){
			System.out.println("Wrong input.");
		}

	} // end cashierActions
        
        /**
         * Prints supported actions for admin employee and starts the
         * corresponding one.
         */
	public static void adminActions(){

		Waiting.waiting();
		System.out.println();
		System.out.println("Press the number to make an action. to exit pres -1");
		System.out.println();
		System.out.println("1. Print all customers");
		System.out.println("2. Print and export all Employees");
		System.out.println("3. Print monthly sales of every product");

		Scanner scanner2 = new Scanner(System.in);
		choice = scanner2.nextInt();

		if(choice == 1){

			Customer.output();

		}else if(choice == 2){

			Employee.output();

		}else if(choice == 3){

			System.out.println("Enter month:");
			int inputMonth = scanner2.nextInt();
			System.out.println("Enter year:");
			int inputYear = scanner2.nextInt();

			Product.monthlySales(inputYear , inputMonth);

		}else if(choice != -1){
			System.out.println("Wrong input.");
		}

	} // end cashierActions



}// end Checkout