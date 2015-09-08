

import java.util.Scanner;

/**
 * Registers, checks given product code and calculates monthly sales of
 * products.
 * @author Alexander Lattas
 */
public class Product{

//---------Initialize----------//

	private int code;
	private String name;
	private int weight; // in gramms
	private double price;

	static Scanner scanner = new Scanner(System.in);


//--------Constructor-------------//

	static Product[] productArray = new Product[20];
	static int counter = 0;
        /**
         * Constructor
         * @param name
         * @param weight
         * @param price 
         */
	public Product( String name, int weight, double price ){

		productArray[counter] = this;

		counter ++;

		this.name = name;
		this.weight = weight;
		this.price = price;
		this.code = counter;


	}




//----------Getters----------------//

	public int getCode(){
		return code;
	}

	public String getName(){
			return name;
	}

	public int getWeight(){
		return weight;
	}

	public double getPrice(){
		return price;
	}

//------------Setters---------------//

	public void setCode(int code){
		this.code = code;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setWeight(){
		this.weight = weight;
	}

	public void setPrice(){
		this.price = price;
	}

//-----------toString--------------//

        /**
         * Returns product's info
         * @return Product's info
         */
	public String toString(){
		return String.format("No.: %d, Name: %s,"
                        + " Weight: %dg, Price %.2feuro", code,
                        name, weight, price);
	}


//-------------checkCode-----------//
        /**
         * Checks if the given input code matches to a product
         * @param inputCode
         * @return 0/1 if product's found.
         */
	public static int checkCode(int inputCode){

		int temp = 0; // 0 = not found
		if ((inputCode >= 1) && (inputCode <= counter)){
			temp = 1; // 1 = found
		}
		return temp;

	}//end CheckCode


//-----------output--------------//
        /**
         * prints code info if input code is found.
         */
	public static void output(){

		System.out.println();
		System.out.println();
		System.out.print("Input product code:");

		int inputCode = scanner.nextInt();

		if (checkCode(inputCode) == 1){

			System.out.println();
			System.out.println(Product.productArray[inputCode - 1]);

		}// end if

		else{

			System.out.printf("\n%d is not used by a product", inputCode);

		}//end else if

	}//end output


//------------monthly-Sales----------//
        /**
         * Gives monthly sales for products for the given year and month.
         * @param year
         * @param month 
         */
	public static void monthlySales(int year, int month){


		int[] totalProducts = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};


		for(int ir = 0; ir < Receipt.reCounter; ir ++){

			if(Receipt.receiptArray[ir] != null){

				if( Receipt.receiptArray[ir].getYear() == year 
                                        && Receipt.receiptArray[ir].getMonth() 
                                        == month ){
					for(int ia = 0; ia < 20; ia++ ){



						if( Receipt.receiptArray[ir].getPosotites(
                                                        ia , 1) > 0 ){

							totalProducts[Receipt.receiptArray[ir].getPosotites(
                                                                ia, 0)] = totalProducts[Receipt.receiptArray[
                                                                        ir].getPosotites(ia, 0)] 
                                                                + Receipt.receiptArray[ir].getPosotites(ia, 1);


						} // end if ia

				}// end ia


				}// end if year/month
			}// end if nuill

		} // end ir



		System.out.println();
		System.out.printf("Total Purchases on month %d of %d:\n", month, year);

		for(int i = 0; i < 5; i++){

			//if( totalProducts[i] != 0 ){
				System.out.printf("%-17s: %4d\n",productArray[i].getName(), totalProducts[i]);
			//}// end if
		};




	} // monthly-Sales



}// end Product
