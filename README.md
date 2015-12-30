# ComparingBooks
 This project is an analysis of 2 books, which allows the programmer to see if the books are written by the same author.
 
 This program should be ran using Command line or Terminal. 
 Have two text files saved on the computer with there locations known.
 
 
 This command can allow us to use different searching methods to determine/print all the words:
 
             java WordCount [ -b | -a | -h ] [ -frequency | -num_unique ] <filename>
• -b Use an Unbalanced BST to implement the DataCounter
• -a Use an AVL Tree
• -h Use a Hashtable
• -frequency Print all the word/frequency pairs, ordered by frequency, and then by the
words in lexicographic order
• -num_unique Print the number of unique words in the document. This is the total
number of distinct (different) words in the document. Words that appear more than once
are only counted as a single word for this statistic.


To understand the Correlation we can run the command:

Usage: java Correlator [ -b | -a | -h ] <filename1> <filename2>
• -b Use an Unbalanced BST in the backend
• -a Use an AVL Tree in the backend
• -h Use a Hashtable in the backend

Running this command provides us with a number, which is associated with the similarity between the books. 
The correlator integer is the running sum, which is an Euclidean sum giving the correlation difference between the two documents.
Larger the number more the similarities between the texts.

A benchmark class is also attached which provides different run times for the different algorithms implemented. We can compare speeds 
and efficiencies that each algorithms, also view the memory usage.
