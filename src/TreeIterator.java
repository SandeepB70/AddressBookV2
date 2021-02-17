import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides an iterator for a Binary Search Tree using a Linked List.
 * Allows for the Linked list to be set in preorder, inorder, or post order.
 * @author Sandeep Bindra
 * @version 2.0
 */
public class TreeIterator<T extends Comparable<T>> implements Iterator<T> {

	private BinaryTreeBasis<T> tree; //The Binary Search Tree an iterator will be created for.
	
	private LinkedList<TreeNode<T>> queue; //Linked list the iterator will be stored in.
	
	/**
	 * Constructor to set the tree and create an empty queue.
	 * @param root The root of the tree.
	 */
	public TreeIterator(BinaryTreeBasis<T> tree) {
		this.tree = tree;
		queue = new LinkedList<TreeNode<T>>();
	}
	
	/**
	 * Returns the next element within the LinkedList, but throws a NoSuchElementException if there are no elements within the list
	 * @return The next element (type TreeNode<T>) within the list
	 * @exception NoSuchElementException Thrown when the list is empty/has no more elements.
	 */
	public T next() throws NoSuchElementException {
		return this.queue.remove().getElement();
	}
	
	/**
	 * Checks if there is another item in the queue.
	 * @return True if there are remaining elements within the queue, otherwise false.
	 */
	public boolean hasNext() {
		return !this.queue.isEmpty();
	}
	
	/**
	 * Used to delete the last element returned by next() from the iterator. This method will not be implemented as
	 * we do not want the iterator being modified. 
	 * @throws UnsupportedOperationException if the remove operation is not supported by this iterator
	 */
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Clears out the queue and places the nodes of the tree in the queue using preorder traversal.
	 * Relies on the preorder() helper method.
	 */
	public void setPreorder() {
		this.queue.clear();
		preorder(this.tree.root);
	}
	
	/**
	 * Recursively adds nodes of the tree to the queue using preorder traversal.
	 * @param node The node to be added to the queue.
	 */
	private void preorder(TreeNode<T> node) {
		if (node != null) {
			this.queue.add(node);
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}
	
	/**
	 * Clears out the queue and places the nodes of the tree in the queue using inorder traversal.
	 * Relies on the inorder() helper method.
	 */
	public void setInorder() {
		this.queue.clear();
		inorder(this.tree.root);
	}
	
	/**
	 * Recursively adds nodes of the tree to the queue using inorder traversal.
	 * @param node The node to be added to the queue.
	 */
	private void inorder(TreeNode<T> node) {
		if (node != null) { 
			inorder(node.getLeft());
			//System.out.println(node.getElement()); //DEBUG
			this.queue.add(node);
			inorder(node.getRight());
		}
	}
	
	/**
	 * Clears out the queue and places the nodes of the tree in the queue using postorder traversal.
	 * Relies on the postorder() helper method.
	 */
	public void setPostorder() {
		this.queue.clear();
		postorder(this.tree.root);
	}
	
	/**
	 * Recursively adds nodes of the tree to the queue using postorder traversal.
	 * @param node The node to be added to the queue.
	 */
	private void postorder(TreeNode<T> node) {
		if (node != null) {
			postorder(node.getLeft());
			postorder(node.getRight());
			this.queue.add(node);
		}
	}
}