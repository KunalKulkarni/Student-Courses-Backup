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


"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: ] -- 02/13/2018

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

A Binary Search Tree (BST) is used in this assignment as it is a memory efficient data structure which allows fast addition, deletion and lookup of any item present in it. The average case complexity for the BST operations of Insert,Delete,Search and Travsersal is O(log n) whereas the Worst case time complexity for these operations is O(n). As we have a bunch of random entries as the input, the chances of the BST being skewed and thus imbalanced are very less.

Implementation of the Observer Pattern

The functions register(),deregister() and notifyAll() are part of the SubjectI interface that are used to register the backup nodes and notify them of any changes to the original tree.
The function update() in the ObserverI interface has been implememted which is used to update the observer/backup nodes of our original tree.

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

1. http://www.sanfoundry.com/java-program-implement-binary-search-tree/

2. https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/

