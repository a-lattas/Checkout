

import java.util.Scanner;
import java.util.Arrays;

/**
 * Handles the receipt of an exchange.
 * @author aglat
 */
public class Receipt{

//--------------Initialize--------------//

	private static int code;
	private int day;
	private int month;
	private int year;
	private double total;
	private double payment;
	int[][] quantities = new int[20][2];

	static Scanner scanner = new Scanner(System.in);

	public static int[] daysOfMonths = {0, 31, 29, 31, 30, 31, 30, 31, 31,
            30, 31, 30 ,31 };


//--------------Constructor------------------//


	static Receipt[] receiptArray = new Receipt[20];
	public static int reCounter = 0;
        
        /**
         * Constructor
         * @param day
         * @param month
         * @param year
         * @param total
         * @param payment
         * @param array 
         */
	public Receipt( int day, int month, int year, double total,
                double payment, int array[][] ){

		receiptArray[reCounter] = this;

		reCounter ++;
		this.quantities = array;
		this.day = day;
		this.month = month;
		this.year = year;
		this.total = total;
		this.payment = payment;
		this.code = reCounter;

	}// end Constructor


//---------------Getters----------------//

	public int getDay(){
		return day;
	}

	public int getMonth(){
		return month;
	}

	public int getYear(){
		return year;
 	}

 	public double getTotal(){
		return total;
 	}

 	public double getPayment(){
		return payment;
	}

	public static int getCode(){
		return code;
	}

	public int getPosotites(int i, int j){
		return quantities[i][j];
	}


//--------------Setters----------------//

	public void setDay(int day){
		this.day = day;
	}

	public void setMonth(int month){
		this.month = month;
	}

	public void setYear(int year){
		this.year = year;
	}

	public void setTotal(double total){
		this.total = total;
	}

	public void setPayment(double payment){
		this.payment = payment;
	}

	public void setCode(int code){
		this.code = code;
	}

	public void setAgores(int[][] posotites){
		this.quantities = posotites;
	}


//--------------toString-----------------//
        /**
         * Creates visually formated receipt
         * @return receipt
         */
	public String toString(){

		String temp = String.format("******************** Receipt #%d ********************\n", getCode());
		temp = temp + String.format(" Date %d/%d/%d\n\n", day, month, year );

		for (int i = 0; i < 20; i++){

			if ((quantities[i][1] != 0)){

				temp = temp + String.format("%-17s %4d X %5.2f    %7.2f\n",
                                        Product.productArray[quantities[i][0]].getName(),
					quantities[i][1], Product.productArray[quantities[i][0]].getPrice(),
                                        quantities[i][1] * Product.productArray[quantities[i][0]].getPrice() );

			} // end if

		} // end for

		temp = temp + String.format("Total %35.2f\nCash   %34.2f\nChange %34.2f\n", total, payment, payment - total);

		return temp;

	} // end toString


//--------------cashier---------------//

/**
 * Handles the checkout procedure of a cashier and a customer.
 */
public static void cashier(){

//Card//

	System.out.println();

	int usingCard = -1;
	while (usingCard != 0 && usingCard != 1){

		System.out.println("Press 1 to use a card and 0 to not:");
		usingCard = scanner.nextInt();

	} // end while

//Card Code

	int cardCode = 0;
	if (usingCard == 1){

		System.out.println();
		System.out.println("Please enter card's code:");

		int found = 0; // not found


		while (found == 0){

			cardCode = scanner.nextInt();
			found = Customer.checkCardCode(cardCode);
			if (found == 0)
				System.out.println("Card not found. Please enter correct card's code:");

		} // end while


	} // end if




// initialize //

	int array[][] = new int[20][2];
	for(int i = 0; i <20; i++){
		for(int j = 0; j <2; j++){
			array[i][j] = 0;
		}
	}

// Products //

	System.out.println();
	System.out.println("Now enter products and amounts. "
                + "Press -1 while entering a code to exit. ");

	int inputCode = 0;
	int productCounter = 0;
	int atLeastOne = 0;

	for(int i =0; i < 20; i++){
		for(int j = 0; j<2; j++){
			array[i][j] = 0;
		}
	}
	do{

		System.out.println();

		int found = 0; // not found

		while (found == 0 && inputCode != -1){

			System.out.println("Enter code");
			inputCode = scanner.nextInt();
			if (inputCode != -1){
				found = Product.checkCode(inputCode);

				if (found == 0)
					System.out.printf("%d doesn't exist.\n",
                                                inputCode);
			}//end if

		} // end while

		if (inputCode != -1){

		array[productCounter][0] = inputCode-1;

		int amount = 0;
		while (amount <= 0){

			System.out.println();
			System.out.printf("Enter amount of %s:\n",
                                Product.productArray[inputCode-1].getName() );

			amount = scanner.nextInt();

			if (amount <=0)
				System.out.println("Wrong amount.");

		}// end while

		array[productCounter][1] = amount;
		atLeastOne = 1;
		productCounter ++;
	}// end if -1

	}while (inputCode != -1);


//Total//

if (atLeastOne != 0){
	double totalCost = 0;

	for (int i = 0; i < 20; i++){

		totalCost = totalCost + 
                        (double)array[i][1] * Product.productArray[
                                array[i][0]].getPrice();

	}// end for

	int pointsPlus = (int)(totalCost / (double) 3);

// Payment //

	System.out.println();
	System.out.printf("Total cost: %.2f. Enter Payment: ", totalCost);
	double inputPayment = scanner.nextDouble();

	while (inputPayment < totalCost){

		System.out.println("Invalid Payment. Enter valid Payment.");
		inputPayment = scanner.nextInt();

	}//end while


// Change //

	double change = inputPayment - totalCost;

// Date //

	System.out.println();
	System.out.println("Enter Year of exchange: ");

	int exchangeYear = scanner.nextInt();

	while (exchangeYear < 2014){
		System.out.println("Enter valid year:");
		exchangeYear = scanner.nextInt();
	}


	System.out.println();
	System.out.println("Enter Month of exchange: ");

	int exchangeMonth = scanner.nextInt();

	while ((exchangeMonth > 12) || (exchangeMonth < 1)){
		System.out.println("Enter valid Month:");
		exchangeMonth = scanner.nextInt();
	}


	System.out.println();
	System.out.println("Enter Day of exchange: ");

	int exchangeDay = scanner.nextInt();

	while ((exchangeDay > daysOfMonths[exchangeMonth]) || (exchangeDay < 1)){
		System.out.println("Enter valid Day:");
		exchangeDay = scanner.nextInt();
	}


//Receipt construct and points //

	Receipt receipt = new Receipt( exchangeDay, exchangeMonth, exchangeYear,
                totalCost, inputPayment, array );

	if (usingCard == 1)
		Customer.customerArray[cardCode].setPoints(pointsPlus);

//Print//

	System.out.println();
	System.out.println("Printing receipt:");
	Waiting.waiting();
	System.out.println();
	System.out.print(receiptArray[getCode()-1]);
	System.out.println();



	if(usingCard == 1){

		System.out.printf("You earned %d points.\n", pointsPlus );

		if(Customer.customerArray[cardCode].getPoints() >= 200){

			Customer.customerArray[cardCode].setPoints( Customer.customerArray[
                                cardCode].getPoints() - 200 );
			System.out.println();
			System.out.println("Congratulations. You won a 5 euro "
                                + "gift card for your next exchange.");

		} // end if

		System.out.printf("Remaining points: %d", Customer.customerArray[
                        cardCode].getPoints() );

	}// end if

}// endatLeastOne

else {
	System.out.println();
	System.out.println("no exchange was made.");
}// end if no ex



} // end cashier

}// end Receipt Class