package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
/**
 * Class to create the tree. Insertion,Deletion,Search functions implemented.
 * Two backup trees created called tr1,tr2. Getters/Setters implemented to get these backups from driver code.
 * Print function stores the node in a Results class instance.
 * @author Kunal
 *
 */
public class TreeBuilder {
	
	FileProcessor fp;
	Node node_orig;
	Node backup_Node_1;
	Node backup_Node_2;
	TreeBuilder tr1;
	TreeBuilder tr2;
	public TreeBuilder(){
		
		node_orig=null;
	}
	public void setbackup1(TreeBuilder backup1){
		
		tr1=backup1;
	}
	public TreeBuilder getbackup1(){
		
		return tr1;
	}
	
	public void setbackup2(TreeBuilder backup2){
		
		tr2=backup2;
	}
	public TreeBuilder getbackup2(){
		
		return tr2;
	}
	/**
	 * Function to either insert new nodes into the tree or add courses to a node already present.
	 * If new node encountered immediately two backups are created and added to the backup trees.
	 * Two backup nodes are also registered as backups to the original node using register method.
	 * @param Bnumber
	 * @param course
	 */
	public void insertC(int Bnumber,String course){
		
		Node n;
		Node n1;
		if((n1=searchNode(Bnumber))!=null){
			
			n1.add(course);
			n1.notifyAll("insert",course);
		}
		else {
			n=new Node(Bnumber,course);
		insertN(n);
		backup_Node_1=new Node(Bnumber,course);
		backup_Node_2=new Node(Bnumber,course);
		n.register(backup_Node_1);
		n.register(backup_Node_2);
		tr1.insertN(backup_Node_1);
		tr2.insertN(backup_Node_2);
		
	}
	}
	private void insertN(Node n){
		
		node_orig=insert(node_orig,n);
	}
	/**
	 * Typical BST insert function to insert a new node into the existing tree.
	 * @param n
	 * @param nIn
	 * @return
	 */
	private Node insert(Node n,Node nIn){
		
		if(n==null){
			
			n=nIn;	
			return n;
		}
		
		else if(nIn.getBnumber()>n.getBnumber()){
			
				n.right=insert(n.right,nIn);
			}
		else if(nIn.getBnumber()<n.getBnumber()){
			
				n.left=insert(n.left,nIn);
			}
			
		return n;
	}
/**
 * Function to search and return a node if already present in the tree.
 * @param Bnumber
 * @return
 */
	private Node searchNode(int Bnumber){
		
		Node n=new Node();
		n=search(node_orig,Bnumber);
		return n;
	}
	/**
	 * BST search function.
	 * @param n
	 * @param Bnumber
	 * @return
	 */
	private Node search(Node n,int Bnumber){
		
		boolean found = false;

		while((n!= null) && !found){
			
			int rval = n.getBnumber();
			if(Bnumber < rval){
				
				n=n.getLeft();
			}
			else if(Bnumber > rval) {
				
				n=n.getRight();
			}
			else{
				
				found = true;
				break;
			}
			
			n = search(n, Bnumber);
		}

		return n;
	}
	/**
	 * Method to delete the courses from the students course list.
	 * @param Bnumber
	 * @param course
	 */
	private void delete(int Bnumber,String course){
		
		Node n=searchNode(Bnumber);
		if(n==null){
			
		}
		else {
			
			n.remove(course);
			n.notifyAll("delete", course);
		}
	}
	/**
	 * Method to read from the input/delete file and pass on the line read to either Insert or delete functions.
	 * Reading done through the FileProcessor class.
	 * @param filename
	 * @param operation
	 * @param tr
	 */
	public void read(String filename,String operation,TreeBuilder tr){
		
		fp=new FileProcessor(filename);
		String line;
		while((line=fp.readLine())!=null){
			
			String str[]=line.split(":");
			int Bnumber=Integer.parseInt(str[0]);
			String course=str[1];
			if(course.charAt(0)<='K')
			{
			if(operation.equals("insert"))
			tr.insertC(Bnumber, course);
			else if(operation.equals("delete"))
			tr.delete(Bnumber, course);
			}
		}
	}
	public void printNodes(Results r){
		
		print(node_orig,r);
		
	}
	/**
	 * Method to print inorder traversal of the tree through the Result class.
	 * @param n
	 * @param r
	 */
	private void print(Node n,Results r){
		
		if(n!=null){
			
			print(n.getLeft(),r);
			r.setResult(n.getBnumber()+":"+n.getCourses());
			print(n.getRight(),r);
		}
	}

	public String toString()
	{
		String s="Used to create Tree and implemenet functions  insert/Delete/search";
		return s;
	}
}
