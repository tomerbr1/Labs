package boot;

import controller.MyController;
import model.MyModel;
import view.MyAsciiArtMaker;

public class run {
	
	public static void main(String[] args) {
		MyModel model = new MyModel();
		MyAsciiArtMaker win = new MyAsciiArtMaker("ASCII", 500,300);
		MyController controller = new MyController(model, win);	

		win.setController(controller);
		model.setController(controller);

		win.run();
	}

}
