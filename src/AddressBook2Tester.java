import java.io.*;
import java.util.Scanner;

/**
 * Tests the functionality of the AddressBook and any related components, such as the BinarySearchTree.
 * @author Sandeep Bindra
 * @version 2.0
 */
public class AddressBook2Tester {
	
	/**
	 * Creates an AddressBook and loads it up with the test data from a file. Calls the appropriate methods
	 * that ensure the AddressBook and all related classes function as they should.
	 */
	public static void start() {
		
		AddressBook<PersonRecord> book = new AddressBook<PersonRecord>();
		//Open the file that the test data will be read from.
		try {
			File testFile = new File("TestData.txt");
			//Load up the address book with the test data.
			fillBook(testFile, book);
		} catch (IOException err) {
			System.out.println("Error with input file.\n Program will terminate");
			return;
		}
		
		/**
		 * Display the data within the AddressBook using different traversal orders.
		 */
		System.out.println("Printing in order");
		showInorder(book);
		//System.out.println("\nPrinting pre order\n");
		//showPreorder(book);
		//System.out.println("\nPrinting post order\n");
		//showPostorder(book);
		
		/**
		 * Delete nodes and then print out the AddressBook using in order traversal to ensure they are gone.
		 */
		String name = "Minna Amigon";
		//Deleting data within the AddressBook.
		System.out.println("\nDeleting node with no children.\n"); //True if using "test9recs.txt" file
		deleteNode(book, "Minna Amigon");
		showInorder(book);
		
		exists(book, "Art Venere");
		
		System.out.println("\nDeleting node with one child.\n"); //True if using "test9recs.txt" file
		deleteNode(book, "Art Venere");
		showInorder(book);
		
		/**
		 * Checking if an entry exists.
		 */
		System.out.println("\nSearching for Sage Wieser.");
		exists(book, "Sage Wieser");
		//Check if an entry that has been deleted exists.
		System.out.println("\nSearching for Art Venere.");
		exists(book, "Art Venere");
		showInorder(book);
		
		name = "Maryann Royster"; //Must be changed if using the "test9recs.txt" file since this entry is not in there
		System.out.println("\nDeleting node with name: " + name + "\n");
		deleteNode(book, name);
		showInorder(book);
		
		System.out.println("\nDeleting node with two children.\n");
		deleteNode(book, "James Butt");
		showInorder(book);
		
		System.out.println("\nDeleting node with two children again.\n"); //True if using "test9recs.txt" file
		deleteNode(book, "Lenna Paprocki");
		showInorder(book);
		
		//Test getting an entry.
		System.out.println("\nRetrieving entry.");
		testRetrieve(book, "Simona Morasca");
		
		/**
		 * Test if we can add entries.
		 */
		System.out.println("\nAdding two new entries\n");
		testAdd(book);
		showInorder(book);
		
		/**
		 * Test emptying the book
		 */
		System.out.println("\nEmptying address book.");
		testEmpty(book);
		//See if a value that was in the address book before still exists once the book has been emptied.
		testRetrieve(book, "Simona Morasca");
		
		/**
		 * Add entries to an empty book and ensure we cannot add duplicates.
		 */
		System.out.println("\nAdding two new entries to empty book.");
		testAdd(book);
		showInorder(book);
		System.out.println("\nAdding another two new entries to the book.");
		testAdd2(book);
		showInorder(book);
		System.out.println("\nAttemping to add duplicate entries.");
		testAdd2(book);
		showInorder(book);
		
		/**
		 * Test replacing an entry.
		 */
		System.out.println("\nAttempting to replace an entry");
		testReplace(book);
		showInorder(book);
	}
	
	/**
	 * Loads up an AddressBook with data from the supplied file. The AddressBook is emptied before adding new entries.
	 * @param testFile The file that will supply the data to create each PersonRecord entry for the AddressBook.
	 * @param book The AddressBook that will be loaded up with new entries.
	 * @throws IOException If there is any issue with reading from the file.
	 */
	public static void fillBook(File testFile, AddressBook<PersonRecord> book) throws IOException {
		book.empty();
		//Create a Scanner object to read from testFile
		Scanner testData = new Scanner(testFile);
		while(testData.hasNext()) {
			//Each line of the file should have the data to create a new PersonRecord
			String readData = testData.nextLine();
			String[] bookData = readData.split(";");
			
			//Create the new address and PersonRecord based off that data read from the file.
			Address add = new Address(bookData[1], bookData[2], bookData[3], bookData[4]);
			PersonRecord entry = new PersonRecord(bookData[0], add, bookData[5]);
			//Add to the address book
			book.add(entry);
		}
		testData.close();
	}
	
	/**
	 * Display the content of the AddressBook through inorder traversal.
	 * @param book The AddressBook that will be displayed.
	 */
	public static void showInorder(AddressBook<PersonRecord> book) {
		//Create an iterator to go through the entire tree. The default order is inorder.
		TreeIterator<PersonRecord> entries = book.getIterator();
		while (entries.hasNext()) {
			System.out.println(entries.next());
		}
	}
	
	/**
	 * Display the content of the AddressBook through pre order traversal.
	 * @param book The AddressBook that will be displayed.
	 */
	public static void showPreorder(AddressBook<PersonRecord> book) {
		TreeIterator<PersonRecord> entries = book.getIterator();
		entries.setPreorder();
		while (entries.hasNext()) {
			System.out.println(entries.next());
		}
	}
	
	/**
	 * Display the content of the AddressBook through post order traversal.
	 * @param book The AddressBook that will be displayed.
	 */
	public static void showPostorder(AddressBook<PersonRecord> book) {
		TreeIterator<PersonRecord> entries = book.getIterator();
		entries.setPostorder();
		while(entries.hasNext()) {
			System.out.println(entries.next());
		}
	}
	
	/**
	 * Deletes an entry containing the specified name within the AddressBook if it exists.
	 * @param book The AddressBook the entry will be deleted from
	 * @param name The entry to be deleted
	 */
	public static void deleteNode(AddressBook<PersonRecord> book, String name) {
		PersonRecord person = new PersonRecord();
		person.setName(name);
		book.delete(person);
	}
	
	/**
	 * Checks if the given entry exists within the AddressBook
	 * @param book The AddressBook to be checked.
	 * @param name The entry being searched for.
	 */
	public static void exists(AddressBook<PersonRecord> book, String name) {
		PersonRecord record = new PersonRecord();
		record.setName(name);
		if(book.exists(record)) {
			System.out.println("\nEntry for " + name + " exists.\n");
		} else {
			System.out.println("\nEntry for " + name + " does NOT exist.\n");
		}
	}
	
	/**
	 * Prints out all of the information on the given entry if it exists within the AddressBook.
	 * @param book The AddressBook to be checked.
	 * @param name The entry being searched for.
	 */
	public static void testRetrieve(AddressBook<PersonRecord> book, String name) {
		System.out.println("\nRetrieving entry with name: " + name);
		PersonRecord record = new PersonRecord();
		record.setName(name);
		book.retrieve(record);
	}
	
	/**
	 * Add two new entries to the AddressBook
	 * @param book The AddressBook the entries will be added to.
	 */
	public static void testAdd(AddressBook<PersonRecord> book) {
		String firstEntry = "Guy Random;101-182nd St;Queens;NY;11034;718-123-4567"; //Data for the first new entry.
		String secondEntry = "Lady Random;Hunt Road;Colonie;CA;34567;516-888-2233"; //Data for the second new entry.
		String[] array = firstEntry.split(";");
		
		//Create and add the first new entry.
		Address address = new Address(array[1], array[2], array[3], array[4]);
		PersonRecord record = new PersonRecord(array[0], address, array[5]);
		book.add(record);
		
		//Create and add the second new entry.
		array = secondEntry.split(";");
		address = new Address(array[1], array[2], array[3], array[4]);
		record = new PersonRecord(array[0], address, array[5]);
		book.add(record);
	}
	
	/**
	 * Add two new entries to the AddressBook
	 * @param book The AddressBook the entries will be added to.
	 */
	public static void testAdd2(AddressBook<PersonRecord> book) {
		String firstEntry = "Some Person;64th Ave;Brooklyn;NY;11066;718-987-5423"; //Data for the first new entry.
		String secondEntry = "Another Someone;Fox Drive;Palo Alto;CA;39497;747-822-1456"; //Data for the second new entry.
		String[] array = firstEntry.split(";");
		
		//Create and add the first new entry.
		Address address = new Address(array[1], array[2], array[3], array[4]);
		PersonRecord record = new PersonRecord(array[0], address, array[5]);
		book.add(record);
		
		//Create and add the second new entry.
		array = secondEntry.split(";");
		address = new Address(array[1], array[2], array[3], array[4]);
		record = new PersonRecord(array[0], address, array[5]);
		book.add(record);
	}
	
	/**
	 * Empty the address book.
	 * @param book The book that will be emptied.
	 */
	public static void testEmpty(AddressBook<PersonRecord> book) {
		book.empty();
	}
	
	/**
	 * Replaces one existing entry in the AddressBook for another.
	 * @param book The AddressBook the entries will be exchanged in.
	 */
	public static void testReplace(AddressBook<PersonRecord> book) {
		//Create a new person record that will replace someone in the book.
		String newEntry = "Harry Potter;115-19 Godric's Hollow;West Country;UK;23344;518-302-1122";
		String[] array = newEntry.split(";");
		Address address = new Address(array[1], array[2], array[3], array[4]);
		PersonRecord newRecord = new PersonRecord(array[0], address, array[5]);
		
		String oldEntry = "Another Someone";
		PersonRecord oldRecord = new PersonRecord();
		oldRecord.setName(oldEntry);
		if (book.change(oldRecord, newRecord)) {
			System.out.println("\nSuccess with exchange.\n");
		} else {
			System.out.println("\nFailure with exchange.\n");
		}
	}
}