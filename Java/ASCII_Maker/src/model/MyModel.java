package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import controller.Controller;

/**
 * Implements what every model needs to do.
 * @author Tomer
 *
 */
public class MyModel implements Model {
	
	Controller controller;
	ASCIIMaker am;
	
	public MyModel() {
		am = new ASCIIMaker();
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void convert(String fileName) {
		try{			
			BufferedInputStream in=new BufferedInputStream(new FileInputStream(fileName));
			BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(fileName+".asc"));
			am.convertToAscii(in, out);
			in.close();
			out.close();
			controller.display(fileName+".asc");
		}catch (Exception e){}
	}

}
