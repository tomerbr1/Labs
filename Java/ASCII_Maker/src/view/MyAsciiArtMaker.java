package view;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Text;

import controller.Controller;

public class MyAsciiArtMaker extends BasicWindow implements View {

	String fileName;
	Text asciiText;
	Controller controller;

	public MyAsciiArtMaker(String title, int width, int height) {
		super(title, width, height);
	}

	public void setController(Controller controller) {
		this.controller=controller;
	}

	@Override
	void initWidgets() {
		shell.setLayout(new GridLayout(2, false)); //2 Columns, length of columns is not equal

		Button openButton = new Button(shell, SWT.PUSH);
		openButton.setText("open image file");
		openButton.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false, 1, 1));
		openButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd=new FileDialog(shell,SWT.OPEN);
				fd.setText("open");
				fd.setFilterPath("E:/workspace/89210 part3");
				String[] filterExt = { "*.png", "*.gif", "*.jpg", "*.bmp" };
				fd.setFilterExtensions(filterExt);
				fileName = fd.open();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});



		asciiText = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		asciiText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 3)); //it will take 3 row cells

		Button convertButton = new Button(shell, SWT.PUSH);
		convertButton.setText("Convert to ASCII");
		convertButton.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false, 1, 1));

		convertButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (fileName!= null)
					controller.convert(fileName);	
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {				
			}
		});

		Button changeFontButton = new Button(shell, SWT.PUSH);
		changeFontButton.setText("Change Font");
		changeFontButton.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false, 1, 1));

		changeFontButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FontDialog dlg = new FontDialog(shell);
				dlg.setText("set font please");
				FontData fd = dlg.open();
				if (dlg != null) {
					asciiText.setFont(new Font(display, fd));
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

	}

	@Override
	public void start() {
		run();

	}

	@Override
	public void display(String fileName) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String line;
			asciiText.setText(""); //clear the text

			while((line=in.readLine()) != null) //while we didn't finish read the file
				asciiText.append(line+"\n");
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //read every line in file and send it to asciiText
	}



}
