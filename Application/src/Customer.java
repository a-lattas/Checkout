

import java.util.Scanner;
/**
 * Registers and Exports Customers. Handles bonus points card.
 * @author Alexander Lattas
 */
public class Customer{

//------------Initialize--------------//

	static Scanner scanner = new Scanner(System.in);

	private int code;
	private String name;
	private String surname;
	private String adress;
	private String phone;
	private int cardCode;
	private int points;


//--------------Constructor------------------//

	static Customer[] customerArray = new Customer[20];
	static int cuCounter = 0;
            
        /**
         * Constructor.
         * @param name
         * @param surname
         * @param adress
         * @param phone 
         */
	public Customer( String name, String surname, String adress, String phone){

		customerArray[cuCounter] = this;

		cuCounter ++;

		this.name = name;
		this.surname = surname;
		this.adress = adress;
		this.phone = phone;

		this.code = cuCounter;
		this.cardCode = cuCounter;
		this.points = 0;


	}// end Customer contructor


//---------------Getters--------------------//

	public int getCode(){
			return code;
	}

	public String getName(){
		return name;
	}

	public String getSurname(){
		return surname;
	}

	public String getAdress(){
		return adress;
	}

	public String getPhone(){
		return phone;
	}

	public int getCardCode(){
		return cardCode;
	}

	public int getPoints(){
		return points;
	}



//--------------Setters----------------//


	public void setCode(int code){
		this.code = code;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setSurname(String surname){
		this.surname = surname;
	}

	public void setAdress(String adress){
		this.adress = adress;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public void setCardCode(int cardCode){
		this.cardCode = cardCode;
	}

	public void setPoints(int points){
		this.points = points;
	}


//--------------toString----------------//
        @Override
        /**
         * Overrides toString to print the corresponding info.
         */
	public String toString(){
		return String.format("No.: %d, Name: %s %s, Adress: %s,"
                        + " Phone: %s, Points: %d", code, name, surname,
			adress, phone, points);
		}


//--------------Output------------------//
        /**
         * Exports Registered Customers.
         */
	public static void output(){

		System.out.println();
		System.out.println("||----------------------Customers---------------------||");
		System.out.println();

		for( int i = 0; i < Customer.customerArray.length; i++){

			if( Customer.customerArray[i] != null){

				System.out.println(customerArray[i]);

			}//end if

		}// end for

	}//end output

//---------------Record-------------//
        /**
         * Records new customer with input from the keyboard.
         */
	public static void record(){

		System.out.println("Name: ");
		String name = scanner.next();
		System.out.println("Surname: ");
		String surname = scanner.next();
		System.out.println("Adress: ");
		String adress = scanner.next();
		System.out.println("Phone: ");
		String phone = scanner.next();

		new Customer( name, surname, adress, phone);

		System.out.println();
		System.out.println("Record Successful");
		System.out.println();


	}// end record


//-------------checkCardCode-----------//
        /**
         * Checks if the given inputCode matches to a customer's card.
         * @param inputCode
         * @return 0/1 if the card was found.
         */
	public static int checkCardCode(int inputCode){

		int temp = 0; // not found
		if ((inputCode >= 1) && (inputCode < cuCounter)){
			temp = 1; // found
		}
		return temp;

	}//end CheckCode


}// end Customer class