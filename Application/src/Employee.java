

import java.io.*;
import java.util.Scanner;

/**
 * Parent class for all Employees.
 * *Sets general to String and Salary.
 * *Handles Log in.
 * *Exports all employees.
 * @author Alexander Lattas
 */
public class Employee{

//--------------initialize---------------//

	static Scanner scanner = new Scanner(System.in);

	protected int code;
	protected String name;
	protected String surname;

	protected int married; // 0 no, 1 yes
	protected String username;
	protected String password;

//--------------Constructor-------------------//

	protected static Employee[] employeeArray = new Employee[20];
	static int emCounter = 0;
        /**
         * Constructor.
         * @param name
         * @param surname
         * @param married
         * @param username
         * @param password 
         */
	public Employee(String name, String surname, int married, String username, String password){

		employeeArray[emCounter] = this;

		emCounter ++;

		this.code = emCounter;
		this.name = name;
		this.surname = surname;
		this.married = married;
		this.username = username;
		this.password = password;

	} // end constructor


//----------------Getters------------------//


	public int getCode(){
		return code;
	}

	public String getName(){
		return name;
	}

	public String getSurname(){
		return surname;
	}

	public int getMarried(){
		return married;
	}

	public String getUsername(){
		return username;
	}

	public String getPassword(){
		return password;
	}


//----------------Setters-----------------//

	public void setCode(int code){
		this.code = code;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setSurname(String surname){
		this.surname = surname;
	}

	public void setMarried(int married){
		this.married = married;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public void setPassword(String password){
		this.password = password;
	}


//----------------toString-----------------//
        /**
         * Overrides general toString to add basic employee info.
         * @return Employee's info.
         */
	public String toString(){

		String marriedString = "married";
		if (married == 0) marriedString = "not married";

		String passwordString = "*";
		for (int i = 1; i < password.length(); i++){

			passwordString += "*";

		} //  end for


		return String.format("No. %d, Name: %s %s, %s, Username: %s,"
                        + " Password: %s", code, name,
			surname, marriedString, username, passwordString);

	} // end toString


//----------------Salary------------------//
        /**
         * Sets the salary base according to marriage.
         * @return salary base.
         */
	public int salary(){
		return married * 150;
	}

//----------------Log in------------------//
        /**
         * Logs in the employee and returns his id code.
         * @param inUsername
         * @param inPassword
         * @return Employee Code
         */
	public static int logIn(String inUsername, String inPassword){

		int codeTemp = -1;

		for(int i = 0; i < employeeArray.length; i++){
			if( employeeArray[i] != null ){
				if ( inUsername.equals(employeeArray[i].username)
                                        && inPassword.equals(employeeArray[i].password) ){

					codeTemp = i;
					break;
				} // end if
			}// end if

		} // end for

		return codeTemp;

	} // end login


//-----------------output---------------//
        /**
         * Exports all employees to Employees.txt
         */
	public static void output(){

		String outString = String.format("Employees Records:\r\n");

		for(int i = 0; i < employeeArray.length; i++){
			if (Employee.employeeArray[i] instanceof Cashier){

				outString += (Cashier)employeeArray[i] 
                                        + " salary: " + ((Cashier)employeeArray[i]).salary();
				outString += "\r\n";

			}else if(Employee.employeeArray[i] instanceof Administrator){

				outString += (Administrator)employeeArray[i] 
                                        + " salary: " + ((Administrator)employeeArray[i]).salary();
				outString += "\r\n";

			} // end else if

		} // end for

		try{

			FileWriter fstreamr = new FileWriter ("Employees.txt");
			BufferedWriter out = new BufferedWriter(fstreamr);
			out.write(outString);
			out.close();
			System.out.println("Writing in txt is done!!\n" + outString);

			} catch (Exception ex) {
				ex.printStackTrace();


		} // end try


	} // end output


} // end class

