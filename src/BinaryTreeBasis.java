/**
 * Represents a tempate for creating a binary search tree by providing basic methods, including:
 * 1: Creating a new tree with an empty root
 * 2: Creating a new tree with a given root.
 * 3: Checking if the tree is empty.
 * 4: Making the tree empty.
 * 5: Returning the element contained within the root node of the tree.
 * 6: Setting the element contained within the root node of the tree.
 * @author Sandeep Bindra
 * @version 2.0
 */
public abstract class BinaryTreeBasis<T> {
	
	protected TreeNode<T> root; //Root node of the tree
	
	/**
	 * Default constructor for creating an empty root.
	 */
	public BinaryTreeBasis() {
		this.root = null;
	}
	
	/**
	 * Creates a root containing an object of type T and no left or right subtree.
	 * @param element The object held within the root node.
	 */
	public BinaryTreeBasis(T element) {
		this.root = new TreeNode<T>(element);
	}
	
	/**
	 * @return True if the tree is empty, otherwise false. 
	 */
	public boolean isEmpty() {
		return this.root == null;
	}
	
	/**
	 * Empties the tree by setting the root to null
	 */
	public void makeEmpty() {
		this.root = null;
	}
	
	/**
	 * @return The element within the root of the tree.
	 * @exception TreeException if the tree is empty.
	 */
	public T getRoot() throws TreeException {
		if (this.root == null) {
			throw new TreeException("Tree Exception: Empty Tree");
		} else {
			return this.root.getElement();
		}
	}
	
	/**
	 * Allows the root to be changed to a root containing a different element.
	 * @param element The element contained within the new root.
	 * @exception UnsupportedOperationException if the operation is not implemented.
	 */
	public abstract void setRoot(T newRoot) throws UnsupportedOperationException;
}
