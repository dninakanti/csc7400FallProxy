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
public class FileStringifierProxy extends Thread {
	private String fileName;
	private SlowFileStringifier slowFileStringifier;
	PrintWriter outWriter = new PrintWriter(System.out);
	
	/**
	 * Construct FileStringifierProxy with fileName
	 * @param fileName
	 */
	public FileStringifierProxy(String fileName) {
		this.fileName = fileName;
		//Print file name
		outWriter.println("Reading "+this.fileName);
		outWriter.flush();
		// Initialize SlowFileStringifier
		slowFileStringifier = new SlowFileStringifier(this.fileName);
	 }

/**
 * Run the FileStringifierProxy thread and display the content of file using slowFileStringifier.display
 */
  public void run() {
	  	slowFileStringifier.display(outWriter);	
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
	

}
