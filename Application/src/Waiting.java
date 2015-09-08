/**
 * Creates a loading sprite of three dots while waiting.
 * (Just for artistic puproses.)
 * @author Alexander Lattas
 */
public class Waiting{

	public static void waiting(){

		System.out.print(".");
		try {
		Thread.sleep(1000);
		} catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
		}
		System.out.print(".");
		try {
		Thread.sleep(700);
		} catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
		}
		System.out.print(".");
		try {
		Thread.sleep(700);
		} catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
		}

	}//end waiting
}// end Waiting

