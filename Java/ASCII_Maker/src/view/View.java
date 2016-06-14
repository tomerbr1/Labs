package view;

/**
 * Defines what every View type must implement.
 * @author Tomer
 *
 */
public interface View {
	
	/**
	 * Starting the user interface.
	 */
	void start();
	
	void display(String fileName);
	
}
