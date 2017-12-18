package edu.fitchburgstate.csc7400.f2017fall.proxy;

import java.io.PrintWriter;

/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 10
 * 
 * Date: 2017-12-17
 * @author Divya Ninakanti & Nitesh Vuppula 
 *
 */
public class FileStringifierProxy implements FileStringifier{
	private String fileName;
	private SlowFileStringifier slowFileStringifier;
	
	
	/**
	 * Construct FileStringifierProxy with fileName
	 * @param fileName
	 */
	public FileStringifierProxy(String fileName) {
		this.fileName = fileName;
		//Print file name
		System.out.println("Reading "+this.fileName);
		// Initialize SlowFileStringifier
		slowFileStringifier = new SlowFileStringifier(this.fileName);
	 }

/**
 * display the FileStringifierProxy thread and display the content of file using slowFileStringifier.display
 */
  @Override
  public void display(PrintWriter outWriter) {
	  	new Thread(
	  		new Runnable() {
				public void run() {
					outWriter.println(stringify());
					outWriter.flush();
					//slowFileStringifier.display(outWriter);	
				}
			}).start();;	
		}
	
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the slowFileStringifier
	 */
	public SlowFileStringifier getSlowFileStringifier() {
		return slowFileStringifier;
	}
	/**
	 * @param slowFileStringifier the slowFileStringifier to set
	 */
	public void setSlowFileStringifier(SlowFileStringifier slowFileStringifier) {
		this.slowFileStringifier = slowFileStringifier;
	}

	@Override
	public String stringify() {
		return slowFileStringifier.stringify();
	}
	

}
