package studentCoursesBackup.myTree;

import java.util.ArrayList;
import java.util.HashSet;
/** Class to create Tree layout. Implements ObserverI and SubjectI interfaces.
 * Left and Right nodes created with Bnumber and arraylist of courses to be stored as data in the tree.
 * Update,register,deregister as well as notifyAll implemented.
 * @author Kunal
 *
 */
public class Node implements ObserverI,SubjectI {
	
	public Node left,right;
	public int height;
	int Bnumber;
	HashSet<String> courses=new HashSet<String>();
	ArrayList<Node> backups=new ArrayList<Node>();
	
	public Node(){
		
		left=null;
		right=null;
		Bnumber=0;
		courses=null;
		height=1;
	}
	/**
	 * Parameterized Constructor for Node class.
	 * @param BnumberIn
	 * @param courseIn
	 */
	public Node(int BnumberIn,String courseIn){
		
		Bnumber=BnumberIn;
		courses.add(courseIn);
		
	}
	public void setBnumber(int BnumberIn){
		
		Bnumber=BnumberIn;
	}
	public int getBnumber() {
		return Bnumber;
	}
	
	public void setCourses(HashSet<String> coursesIn){
		
		courses=coursesIn;
	}
	public HashSet<String> getCourses(){
		
		return courses;
	}
	
	public void setLeft(Node nodeIn){
		
		left=nodeIn;
	}
	public Node getLeft(){
		
		return left;
	}	
	
	public void setRight(Node nodeIn){
		
		right=nodeIn;
	}
	public Node getRight(){
		
		return right;
	}
/**
 * Method to register observer.
 */
	@Override
	public void register(Node node) {
		// TODO Auto-generated method stub
		backups.add(node);
	}
/**
 * Method to deregister observer
 */
	@Override
	public void deregister(Node node) {
		// TODO Auto-generated method stub
		backups.remove(node);
	}
	/**
	 * Method to notify all the observers of the change in the Subject.
	 * 
	 */
	@Override
	public void notifyAll(String operation,String course) {
		// TODO Auto-generated method stub
		if(operation.equals("insert")){
			
			for(int i=0;i<backups.size();i++){
				
				Node n=backups.get(i);
				if(n!=null)
				n.update("insert",course);
				
			}
		}
		if(operation.equals("delete")){
			
			for(int i=0;i<backups.size();i++){
				
				Node n=backups.get(i);
				if(n!=null)
					n.update("delete", course);
			}
		}
	}
	/**
	 * Method to add course to the HashSet
	 * @param course Course Information
	 */
	public void add(String course){
		courses.add(course);
	}
	/**
	 * Remove course from HashSet
	 * @param course
	 */
	public void remove(String course){
		courses.remove(course);
	}
	/**
	 * Method to update the observer depending on the operation to be performed.
	 */
	@Override
	public void update(String operation,String course) {
		// TODO Auto-generated method stub
	if(operation.equals("insert")){
		
		add(course);
	}
	if(operation.equals("delete")){
		
		remove(course);
	}	
	}
	
}
