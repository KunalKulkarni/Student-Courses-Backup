package studentCoursesBackup.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Class to store tree returned from the TreeBuilder class to print in the Driver code.
 * The tree data is serially added to a result string that gets updated after a node is traversed.
 * @author Kunal
 *
 */
public class Results implements FileDisplayInterface,StdoutDisplayInterface {

	FileWriter fw;
	PrintWriter pw;
	String resultString;
	public Results(){
		
		resultString="";
	}
	/**
	 * 
	 * @param data Node data coming from TreeBuilder class (printNode) function.
	 */
	void setResult(String data){
		
		resultString=resultString+data+"\n";
	}
	/**
	 * Method to write to stdout.Implemented from StdoutDisplayInterface.
	 */
	@Override
	public void debwrite() {
		// TODO Auto-generated method stub
		System.out.println(resultString);
	}
/**
 * Method to write to a file. The result String that is created is written to the output file.
 * Called from the Driver code.
 */
	@Override
	public void write(String filename) {
		// TODO Auto-generated method stub
		try {
			
			fw=new FileWriter(filename,true);
			pw=new PrintWriter(fw,true);
			pw.println(resultString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in Filename");
			e.printStackTrace();
		}
		
		try {
			
			pw.flush();
			fw.close();
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public String toString(){
	String s="Class used to write the Tree onto the File and StdOut"+resultString;
	return s;
}
	
}
