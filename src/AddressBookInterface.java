/**
 * Interface to create an address book
 * @author Sandeep Bindra
 * @version 2.0
 */
public interface AddressBookInterface<E extends Comparable<E>> {
	
	/**
	 * Adds a particular entry to the address book.
	 * @param element The element to be added to the address book.
	 * @return true if the element has been successfully added, otherwise false.
	 */
	public boolean add(E element);
	
	/**
	 * @param element The element to be deleted from the address book.
	 * @return true if the element has been successfully deleted, otherwise false.
	 */
	public boolean delete(E element);
	
	/**
	 * Deletes one entry in the address book and adds another.
	 * @param oldEntry The existing entry that will be deleted
	 * @param newEntry The entry to be added to the address book 
	 * @return true if the change was successful, otherwise false.
	 */
	public boolean change(E oldEntry, E newEntry);
	
	/**
	 * Prints out the information for the element being searched for if it exists.
	 * @param key The element being searched for.
	 */
	public void retrieve(E key);
	
	/**
	 * Checks to see if the element passed as an argument exists within the address book.
	 * @param key The element being checked for in the address book.
	 * @return true if the element is found within the address book, otherwise false.
	 */
	public boolean exists(E key);
	
	/**
	 * Returns an iterator over the tree stored in this address book.
	 * @return Returns an iterator of type TreeIterator<E> over the tree stored in this address book.
	 */
	public TreeIterator<E> getIterator();
	
	/**
	 * Clears out the entire address book.
	 */
	public void empty();
}