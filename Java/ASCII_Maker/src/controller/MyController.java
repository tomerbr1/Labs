package controller;

import model.Model;
import view.View;

/**
 * Implements what every controller needs to do.
 * @author Tomer
 *
 */
public class MyController implements Controller {

	protected Model model;
	protected View view;
	
	public MyController(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void convert(String fileName){
		if (fileName != null){
			model.convert(fileName);
		}
	}

	@Override
	public void display(String asciiFile) {
		if (asciiFile != null){
			view.display(asciiFile);
		}
		
	}
}
