package view;

import java.util.Observable;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * a Class that contains all the basic variables that every GUI window includes.
 * The class is Observable as a part of the MVP Structure.
 * The class is Runnable as being ruuning in seperate thread.
 * @author Tomer
 *
 */
public abstract class BasicWindow extends Observable implements Runnable  {

	Display display;
	Shell shell;
	
	/**
	 * every class that extends the BasicWindow needs to implement initWidgets,
	 * to initialize all the widgets it has and adding their
	 * event handlers.
	 */
	abstract void initWidgets();
	
	//CTOR used to initiate the shell and display, and define the shell's dimensions.
	public BasicWindow(String title, int width, int height) {
		display = new Display();
		shell = new Shell(display);
		shell.setSize(width, height);
		shell.setText(title);
		
	}
	
	@Override
	public void run() {
		/**
		 * The following order is constant.
		 * First initWidget will initiate the widgets,
		 * Then we'll open the shell (window) and do the main loop
		 */
		
		initWidgets();
		shell.open(); //open the window
		
		// main event loop
		 while(!shell.isDisposed()){ // window isn't closed
		  if(!display.readAndDispatch()){
		   display.sleep();
		  }
		 }
		 display.dispose();
	}

}
