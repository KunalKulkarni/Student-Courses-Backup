package studentCoursesBackup.myTree;

/**
 * Observer Pattern- Subject Interface
 * @author Kunal
 *
 */
public interface SubjectI {

	void register(Node node);
	void deregister(Node node);
	void notifyAll(String operation,String courses);	
}
