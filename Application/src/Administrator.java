/**
 * Registers Administrator employees and sets their salary.
 * @author Alexander Lattas
 */

public class Administrator extends Employee{

//---------------Initialize----------------//

	protected int years;

//----------------Constructor-------------------//
        /**
         * Constructor.
         * @param name
         * @param surname
         * @param married
         * @param username
         * @param password
         * @param years 
         */
	public Administrator(String name, String surname, int married, String username,
		String password, int years){

			super(name, surname, married, username, password);
			this.years = years;

	} // end constructor

//-------------------Getters-------------------//

	public int getYears(){
		return years;
	}

//-------------------Setters-------------------//

	public void setYears(int years){
		this.years = years;
	}

//------------------toString-------------------//

	@Override
        /**
         * Print employee stats plus admin's working years.
         */
	public String toString(){

		return super.toString() + ", working years " + years;

	} // end toString

//------------------Salary---------------------//

	@Override
        /**
         * Sets admin's salary.
         */
	public int salary(){

		return super.salary() + 800 + ((int)(years / 5)) * 50;

	}


} // end class