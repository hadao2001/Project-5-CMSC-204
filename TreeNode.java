
/**
 * This generic class represents each node in the morse code tree.
 * @author Ha T Dao
 * @param <T> data type for data reference of node
 */
public class TreeNode<T> {

	 /**
     * Left child node
     */
    protected TreeNode<T> left;
    
    /**
     * Data of current node
     */
    protected T data;
    
    /**
     * Right child node
     */
    protected TreeNode<T> right;
    	
	
	/**
	 * Constructor to create a new TreeNode with left and right
	 * child set to null and data set to dataNode
	 * @param dataNode the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		data = dataNode;
		left = right = null;
	}
	
	/**
	 * Constructor used for making deep copies
	 * @param node to make a copy of
	 */
	public TreeNode(TreeNode<T> node) {
		left = new TreeNode<T> (node.left);
		right = new TreeNode<T> (node.right);
		data = node.data;
	}

	/** 
	 * Gets the data of the current node.
	 * @return data
	 */
	public T getData() {
		return data;
	}
}
