/**
 * Represents a Binary Search Tree capable of adding, deleting, and searching for nodes.
 * It can also return an iterator on itself. 
 * @author Sandeep Bindra
 * @version 2.0
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTreeBasis<T> {
	
	/**
	 * Default constructor to create a new BinarySearchTree with an empty root.
	 */
	public BinarySearchTree() {
		super();
	}
	
	/**
	 * Constructor to create a new BinarySearchTree with the a new root.
	 * @param newRoot The root of the BinarySearchTree
	 */
	public BinarySearchTree(TreeNode<T> newRoot) {
		super(newRoot.getElement());
	}
	
	/**
	 * Stores a new node in the root node of this BinarySearchTree.
	 * @param newRoot The new root of this BinarySearchTree.
	 */
	public void setRoot(T newRoot) {
		this.root = new TreeNode<T>(newRoot);
	}
	
	/**
	 * Searches for a particular element within the tree. Relies on the helper method contains().
	 * @param key The value being searched for
	 * @return true if the element is present within the tree, otherwise false.
	 */
	public boolean search(T key) {
		return contains(key, this.root);
	}//End contains
	
	/**
	 * Helper method used by search() to recursively check if an element exists within the tree.
	 * @param key The element being searched for.
	 * @param node Node of the tree that will be checked to see if it contains the element.
	 * @return true if the element exists within the tree, otherwise false.
	 */
	private boolean contains(T key, TreeNode<T> node) {
		//Base case
		if (node == null) {
			return false;
		} 
		
		int compare = key.compareTo(node.getElement());
		
		if(compare < 0) {
			return contains(key, node.getLeft());
		} else if(compare > 0) {
			return contains(key, node.getRight());
		} else { //This is the element being searched for.
			return true;
		}
	}
	
	/**
	 * Inserts a new value into the tree. If that value already exists in the tree, it never gets inserted.
	 * Relies on the helper method insert().
	 * @param key The new value being inserted into the tree.
	 * @return true if the value was successfully inserted, otherwise false.
	 * @exception TreeException Thrown by the add() method if the value already exists within the tree, which should not happen
	 * 				since search() checks if the value exists first.
	 */
	public boolean insert(T key) throws TreeException {
		//If the element already exists within the tree, return false.
		if (search(key)) {
			return false;
		} else {
			this.root = add(key, this.root);
			return true;
		}
	} // End insert
	
	/**
	 * Helper method used by insert() that recursively goes through the tree to insert a new element.
	 * @param key The new element to be added to the tree.
	 * @param node The node we are currently at in the tree.
	 * @return A node that should now have the new element attached somewhere within its subtrees or is the root in the case of an empty tree.
	 * @throws TreeException If the element has been found in the tree, which should not happen since insert() checks to see if it exists first
	 * 			using search().
	 */
	private TreeNode<T> add(T key, TreeNode<T> node) throws TreeException {
		//Base case
		if (node == null) {
			return node = new TreeNode<T>(key);
		} 
		//Compare the node to be inserted to the node already in this tree to find out where this node belongs.
		int compare = key.compareTo(node.getElement());

		if (compare < 0) {
			node.setLeft(add(key, node.getLeft()));
			return node;
		} else if (compare > 0) {
			node.setRight(add(key, node.getRight()));
			return node;
		} else {
			throw new TreeException("Error: Element exists within tree already.");
		}
	}
	
	/**
	 * Deletes a node containing a certain element, if it is present in the tree. Relies on the remove() helper method.
	 * @param key The element to be deleted
	 * @return true if the node containing the passed key has been found and deleted, otherwise false.
	 * @throws TreeException Thrown if there is any issue with the removal of the node.
	 */
	public boolean delete(T key) throws TreeException {
		
		if( !search(key)) {
			return false;
		} else {
			this.root = remove(key, this.root);
			return true;
		}
	}//End delete
	
	/**
	 * Recursively goes through the tree in order to remove a node containing the specified element.
	 * Relies on the removeTwo() helper method when the node to be removed has two children to be removed.
	 * @param key The element to be deleted.
	 * @param node The node we are currently at within the tree.
	 * @return A TreeNode that has been altered properly to account for the newly deleted node so if it
	 * 			has a subtree, the nodes have been moved around to maintain the Binary Search Tree properties.
	 * @throws TreeException Thrown if there is any issue with the removal of the node.
	 */
	private TreeNode<T> remove(T key, TreeNode<T> node) throws TreeException {
		
		int compare = key.compareTo(node.getElement());
		
		if (compare < 0) {
			node.setLeft(remove(key, node.getLeft()));
			return node;
		} else if (compare > 0) {
			node.setRight(remove(key, node.getRight()));
			return node;
		} else { //This is the node to be deleted.
			byte children = numKids(node); //Determine the number of kids this node has to determine how it will be removed.
			
			switch(children) {
				case 2: 
					node = removeTwo(node);
					return node;
				case 1:
					if(node.getLeft() != null) {
						node = node.getLeft();
					} else {
						node = node.getRight();
					}
					return node;
				case 0:
					return null;
				default:
					throw new TreeException("Tree Exception: Error with removal of node");
			}
		}
	}//End remove
	
	/**
	 * Creates an iterator over the current tree with a default order of inorder traversal.
	 * @return A TreeIterator<T> of the current tree.
	 */
	public TreeIterator<T> iterator() {
		TreeIterator<T> iterate = new TreeIterator<T>(this);
		iterate.setInorder();
		return iterate;
	}
	
	/**
	 * Retrieves the matching element within the tree if it exists. Relies on the helper method retrieve()
	 * @param key The element being searched for.
	 * @return The element being searched for, otherwise null.
	 */
	public T get(T key) { 
		return retrieve(key, this.root);
	}
	
	/**
	 * Helper method that recursively goes through the tree to retrieve an element. 
	 * @param key The element being searched for
	 * @param node The node we are currently at within the tree.
	 * @return The element being searched for if it exists.
	 */
	private T retrieve(T key, TreeNode<T> node) {
		if (node == null) {
			return null;
		}
		
		int compare = key.compareTo(node.getElement());
		
		if (compare < 0) { //Node being searched for is in the left subtree
			return retrieve(key, node.getLeft());
		} else if (compare > 0) { //Node being searched for is in the right subtree
			return retrieve(key, node.getRight());
		} else { //This is the node being searched for.
			return node.getElement();
		}
	}
	
	/**
	 * Helper method used by the delete() method to check how many children a node has.
	 * @param node The node that will be checked for children.
	 * @return A byte representing the number of children a node has. The max is 2 and the minimum value is 0
	 */
	private byte numKids(TreeNode<T> node) {
		if (node.getLeft() != null && node.getRight() != null) {
			return 2;
		} else if (node.getLeft() != null) {
			return 1;
		} else if (node.getRight() != null) {
			return 1;
		} else {
			return 0;
		}
	}//End numKids
	
	/**
	 * Helper method used by the delete() method to delete a node that has two children. Relies on the
	 * removeLargest() method.
	 * @param parentNode The parent of the node to be deleted.
	 * @return A TreeNode<T> that is the replacement node for the node to be deleted.
	 */
	private TreeNode<T> removeTwo(TreeNode<T> deleteNode) {
			TreeNode<T> replacement = removeLargest(deleteNode.getLeft());
			//Check if the left child of the node to be deleted is the largest node, in which case
			//only the right child of the node to be deleted will be taken.
			if (replacement.getElement().compareTo(deleteNode.getLeft().getElement()) == 0) {
				replacement.setRight(deleteNode.getRight());
			} else {
				//Assign the left and right children of the new node from the node to be deleted.
				replacement.setLeft(deleteNode.getLeft());
				replacement.setRight(deleteNode.getRight());
			}
			deleteNode.setRight(null);
			deleteNode.setLeft(null);
			return replacement;
	}// End removeTwo
	
	/**
	 * Helper method used by removeTwo() to extract the largest node within the left subtree of the node to be removed.
	 * @param node The left child of a node that will be deleted. Its largest node will be taken out.
	 * @return The largest node within this subtree.
	 */
	private TreeNode<T> removeLargest(TreeNode<T> node) {
		TreeNode<T> rightTree = node.getRight();
		// Base case when the current node is the largest node.
		if (rightTree == null) {
			return node;
			} else {
				//Check if the the next node is the largest node, in which case this node's right child must be set 
				//to the left  child of the largest node if it exists, otherwise it is set to null.
				if(rightTree.getRight() == null) {
					node.setRight(rightTree.getLeft());
				}
				return(removeLargest(rightTree));
		}
	}// End removeLargest
}