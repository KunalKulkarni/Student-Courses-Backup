package studentCoursesBackup.driver;

import java.io.File;


import studentCoursesBackup.util.Results;	
import studentCoursesBackup.util.TreeBuilder;
/**
 * Driver code, which facilitates following actions:
 * 1. Validation of Command Line Arguments
 * 2. Creates three trees , performs insertion and deletion.
 * 3. Result instances used to print the tree in their respective files.
 * @author Kunal
 *
 */
public class Driver {

	/**
	 * Function to check if the command line arguments are valid or not.
	 * @param arr - Array of command line arguments.
	 */
	static void argCheck(String arr[]){
		
			for(int i=0;i<arr.length;i++){
				
				if(arr.length!=5){
					
					System.out.println("Invalid Number of Arguments.Enter 5 Arguments- Input Delete Output1 Output2 Output3");
					System.exit(1);
				}
				if(arr[i].contains("${")){
					
				System.out.println("Invalid Entry.Enter 5 Arguments- Input Delete Output1 Output2 Output3");
				System.exit(1);
			}
			}
		}
		/**
		 * Function to check if the input and delete files exist.
		 * @param filename - input and delete files. 
		 */
	static void fileCheck(String filename){
		
		File file=new File(filename);
		if(file.exists()==false){
			
			System.out.println(filename+ "File does not exist. Please Enter a valid filename/path");
			System.exit(1);
		}
	}
	/**
	 * Main function to create three trees and perform insertion and deletion.
	 * Results used to print all the trees.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		argCheck(args);
		String inputF=args[0];
		String deleteF=args[1];
		String outputF1=args[2];
		String outputF2=args[3];
		String outputF3=args[4];
		fileCheck(inputF);
		fileCheck(deleteF);
		
		TreeBuilder orig=new TreeBuilder();
		TreeBuilder tr1=new TreeBuilder();
		TreeBuilder tr2=new TreeBuilder();
		orig.setbackup1(tr1); // Backup 1 Created
		orig.setbackup2(tr2); // Backup 2 Created
		orig.read(inputF, "insert", orig);
		orig.read(deleteF, "delete", orig);
		Results r=new Results();
		orig.printNodes(r);
		r.write(outputF1); // Write to output1
		System.out.println("Original Tree");
		r.debwrite();
		r=new Results();
		tr1.printNodes(r);
		r.write(outputF2); // Write to output2
		System.out.println("Backup Tree 1");
		r.debwrite();
		r=new Results();
		tr2.printNodes(r);
		r.write(outputF3);  // Write to output3
		System.out.println("Backup Tree 2");
		r.debwrite();
	}
	
public	 String toString()
	{
		return "Driver code to call all backups as well as original";
	}
	
}
