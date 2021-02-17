This project represents an ADT Address Book that is meant to hold the name, address, and phone number of individuals. The AddressBook class depends on the BinarySearchTree class to store these entries and modify them by adding more, deleting existing entries, or changing them. 

Four testing files have been provided, but the main ones to demonstrate proper functionality are "test9recs.txt" and "TestData.txt". "TestData.txt" contains 97 entries while "test9recs.txt" contains only 9 entries but was made since it represents a smaller tree and could easily be used to test proper deletion of nodes with zero, one, or two children. It was also easier to determine correct pre-order and post-order traversal using the smaller tree. "TestData.txt" is used to show proper functionality with a larger data set. Currently AddressBook2Tester (holds all the testing methods) uses "TestData.txt" to obtain all its data, but this can easily be changed within the code.

The project was built using Java version 8 update 261 on Eclipse IDE Version 2020-03 (4.15.0).

A brief description of the source code files follows below.

PersonRecord -
The class that represents an entry for an individual in the Address Book. Stores their name, address, and phone number.

Address - 
The class that represents where an individual lives by storing their street, city, state, and zip code.

TreeNode -
Represents the nodes that make up the binary search tree. Provides methods for setting the right and left child of a node and changing the element stored within the node.

BinaryTreeBasis - 
A superclass that serves as a template for creating the binary search tree. 

BinarySearchTree - 
The actual representation of the binary search tree. Provides methods for deleting and adding nodes. 

TreeIterator - 
Provides an iterator using a LinkedList to traverse through the binary search tree through in-order, pre-order, or post-order traversal.

AddressBook - 
Represents the address book that can be used to store PersonRecord objects.
Implements the AddressBook interface. 

TreeException - 
A custom RuntimeException made for possible errors with certain operations for the BinarySearchTree.

AddressBook2Tester - 
A tester class that holds all the testing methods.

RunTester - 
Contains the main method.