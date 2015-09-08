
/**
 * Registers and sets salary for Cashier employee.
 * @author Alexander Lattas
 */

public class Cashier extends Employee{

//---------------Initialize----------------//

	protected int type; // 0: full time, 1: part time
	protected int extraHours;


//----------------Constructor-------------------//
        /**
         * Constructor.
         * @param name
         * @param surname
         * @param married
         * @param username
         * @param password
         * @param type
         * @param extraHours 
         */
	public Cashier(String name, String surname, int married, String username,
		String password, int type, int extraHours){

			super(name, surname, married, username, password);
			this.type = type;
			this.extraHours = extraHours;

	} // end constructor

//-------------------Getters-------------------//
        
	public int getType(){
		return type;
	}

	public int getExtraHours(){
		return extraHours;
	}

//-------------------Setters-------------------//

	public void setType(int type){
		this.type = type;
	}

	public void setExtraHours(int extraHours){
		this.extraHours = extraHours;
	}

//------------------toString-------------------//

	@Override
        /**
         * Overrides parent to String to add their job description and
         * their extra working hours.
         */
	public String toString(){

		String typeString = "full time";
		if (type == 1) typeString = "part time";

		return super.toString() + ", " + typeString + ", extra hours " + extraHours;

	} // end toString

//------------------Salary---------------------//

	@Override
        /**
         * Sets the corresponding salary of the cashier
         */
	public int salary(){

		int base = 400;
		if (type == 0) base = 800;

		return super.salary() + base + extraHours * 7;

	}


} // end class