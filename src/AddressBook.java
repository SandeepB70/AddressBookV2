/**
 * An Address Book used to store, delete, change, and get entries.
 * Relies on the AddressBook interface. 
 * @param E The type of object that will be stored within the address book. It must implement the Comparable interface.
 * @author Sandeep Bindra
 * @version 2.0
 */
public class AddressBook<E extends Comparable<E>> implements AddressBookInterface<E> {
	
	/**
	 * The BinarySearchTree that will hold all the entries of the address book.
	 */
	private BinarySearchTree<E> tree;
	
	/**
	 * Constructor to create an AddressBook with an empty BinarySearchTree
	 */
	public AddressBook() {
		this.tree = new BinarySearchTree<E>();
	}
	
	/**
	 * Adds a particular entry to the address book. Relies on the insert() method from the BinarySearchTree class.
	 * @param element The element to be added to the address book.
	 * @return True if the element has been successfully added, otherwise false.
	 */
	public boolean add(E element) {
		if (this.tree.isEmpty()) {
			this.tree.setRoot(element);
			return true;
		} else {
			try {
				return this.tree.insert(element);
			}
			catch (TreeException err) {
				System.out.println(err);
				return false;
			}
		}
	}
	
	/**
	 * @param element The element to be deleted from the address book. Relies on the delete method from the BinarySearchTree class.
	 * @return True if the element has been successfully deleted, otherwise false.
	 */
	public boolean delete(E element) {
		try {
			return this.tree.delete(element);
		} catch (TreeException err){
			System.out.println(err);
			return false;
		}
	}
	
	/**
	 * Deletes one entry in the address book and adds another. If the old entry has not been successfully deleted,
	 * the new entry will not be added.
	 * @param oldEntry The entry already in the address book that will be deleted
	 * @param newEntry The new entry to add to the address book 
	 * @return True if the change was successful, otherwise false.
	 */
	public boolean change(E oldEntry, E newEntry) {
		if (this.tree.delete(oldEntry)) {
			return this.tree.insert(newEntry);
		} else {
			return false;
		}
	}
	
	/**
	 * Prints out the information in the element with the matching key if it exists.
	 * @param key The key of the element being searched for.
	 */
	public void retrieve(E key) {
		E entry = this.tree.get(key);
		
		if (entry == null) {
			System.out.println("Entry does NOT exist in the address book.\n");
		} else {
			System.out.println(entry);
		}
	}
	
	/**
	 * Checks to see if the element passed as an argument exists within the address book.
	 * @param key The element being checked for in the address book.
	 * @return True if the element is found within the address book, otherwise false.
	 */
	public boolean exists(E key) {
		return tree.search(key);
	}
	
	/**
	 * Returns an iterator over the tree stored in this address book.
	 * @return Returns an iterator of type TreeIterator<E> over the tree stored in this address book.
	 */
	public TreeIterator<E> getIterator() {
		return tree.iterator();
	}
	
	/**
	 * Clears out the entire address book.
	 */
	public void empty() {
		this.tree.makeEmpty();
	}
}