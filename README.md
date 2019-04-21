Assuming you are in the directory containing this README:

## To clean:
ant -buildfile studentCoursesBackup/src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile studentCoursesBackup/src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1_file.txt -Darg3=output2_file.txt -Darg4=output3_file.txt

-----------------------------------------------------------------------

A Binary Search Tree (BST) is used in this as it is a memory efficient data structure which allows fast addition, deletion and lookup of any item present in it. The average case complexity for the BST operations of Insert,Delete,Search and Travsersal is O(log n) whereas the Worst case time complexity for these operations is O(n). As we have a bunch of random entries as the input, the chances of the BST being skewed and thus imbalanced are very less.

Implementation of the Observer Pattern

The functions register(),deregister() and notifyAll() are part of the SubjectI interface that are used to register the backup nodes and notify them of any changes to the original tree.
The function update() in the ObserverI interface has been implememted which is used to update the observer/backup nodes of our original tree.


