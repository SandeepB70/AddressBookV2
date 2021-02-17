/**
 * Represents a node of that would be used in a tree data structure and provides basic methods such as:
 * 1. Getting an element
 * 2. Setting an element
 * 3. Setting a right child
 * 4. Getting a right child
 * 5. Setting a left child
 * 6. Getting a left child
 * @author Sandeep Bindra
 * @version 2.0
 */
public class TreeNode<T> {
	
	private T element; //The element stored within this node.
	private TreeNode<T> left; //The left child of this node.
	private TreeNode<T> right; //The right child of this node.
	
	
	/**
	 * Default constructor to create an empty tree node.
	 */
	public TreeNode() {
		this.element = null;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Constructor to create a TreeNode with an element, but no left or right children.
	 * @param element The element to be assigned to the newly created node.
	 */
	public TreeNode(T element) {
		this.element = element;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Constructor to create a TreeNode with an element, left child, and right child.
	 * @param element The T object to be assigned to the newly created node.
	 * @param left The left child of the newly created node.
	 * @param right The right child of the newly created node.
	 */
	public TreeNode(T element, TreeNode<T> left, TreeNode<T> right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Returns the element stored within a tree node.
	 * @return The element stored within this node.
	 */
	public T getElement() {
		return element;
	}
	
	/**
	 * Sets the element for the node.
	 * @param element The element that will be stored within this node.
	 */
	public void setElement(T element) {
		this.element = element;
	}
	
	/**
	 * Sets the right child of this node.
	 * @param node The right child of this node.
	 */
	public void setRight(TreeNode<T> node) {
		this.right = node;
	}
	
	/**
	 * @return The TreeNode<T> representing the right child
	 */
	public TreeNode<T> getRight() {
		return this.right;
	}
	
	/**
	 * Sets the left child of this node.
	 * @param node The left child of this node.
	 */
	public void setLeft(TreeNode<T> node) {
		this.left = node;
	}
	
	/**
	 * @return The TreeNode<T> representing the left child.
	 */
	public TreeNode<T> getLeft() {
		return this.left;
	}
}