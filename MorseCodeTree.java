
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * A generic linked binary tree representing the morse code alphabet.
 * The TreeNode is parameterized as a String
 *  
 * @author Ha T Dao
 * @param <T> data type for data reference
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	/**
     * Root of tree
     */
	protected TreeNode<String> root;

	/**
	 * Constructor calls the buildTree method.
	 */
	public MorseCodeTree() {
		buildTree();
	}
	
	/**
	 * This is a recursive method that adds an element to the correct position
	 * in the tree based on the code.
	 * Adds a node to the tree with the data of the passed English letter
	 * @param root the reference node for an iteration
	 * @param code the morse code string
	 * @param letter the English letter to be inserted 
	 */
	
	 @Override
	    public void addNode(TreeNode<String> root, String code, String letter) {
	        if (code.length() == 1) {
	            if (code.equals(".")) {
	                root.left = new TreeNode<>(letter);
	            } else if (code.equals("-")) {
	                root.right = new TreeNode<>(letter);
	            }
	        } else {
	            if (code.charAt(0) == '.') {
	                addNode(root.left, code.substring(1), letter);
	            } else if (code.charAt(0) == '-') {
	                addNode(root.right, code.substring(1), letter);
	            }
	        }
	    }
	
     /**
 	 * Create the morse code binary tree via the insert method
 	 */
 	
 	public void buildTree() {
 		
 		// level 0
 		setRoot(new TreeNode<String>(""));
 		
 		// level 1
 		insert(".", "e");
 		insert("-", "t");
 		
 		// level 2
 		insert("..", "i");
 		insert(".-", "a");
 		insert("-.", "n");
 		insert("--", "m");
 		
 		// level 3
 		insert("...", "s");
 		insert("..-", "u");
 		insert(".-.", "r");
 		insert(".--", "w");
 		insert("-..", "d");
 		insert("-.-", "k");
 		insert("--.", "g");
 		insert("---", "o");
 		
 		// level 4
 		insert("....", "h");
 		insert("...-", "v");
 		insert("..-.", "f");
 		insert(".-..", "l");
 		insert(".--.", "p");
 		insert(".---", "j");
 		insert("-...", "b");
 		insert("-..-", "x");
 		insert("-.-.", "c");
 		insert("-.--", "y");
 		insert("--..", "z");
 		insert("--.-", "q");
 		
 	}

 	/**
	 * Insert an node into the morse code tree
	 * @return the current state of the tree
	 */
	
	public MorseCodeTree insert(String code, String letter) {
		addNode(getRoot(), code, letter);
		return this;
	}

	/**
	 * This method returns a reference to the root
	 */
	@Override
	public TreeNode<String> getRoot() {
        return root;
    }

	/**
	 * Sets the root node of the tree
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		// set the root of the MorseCodeTree
		root = newNode;
	}

	/**
	 * This method fetches the data in the tree based on the code by calling the recursive
	 * method fetchNode.
	 */
	public String fetch(String code) {	
		if(code.equals("/")) {
			return " ";
		}
		return fetchNode(getRoot(), code);		
	}


	/**
	 * Recursively get the alphanumeric character which is represented by the remaining code and reference node.
	 * @param root the reference node from which traversal occurs
	 * @param code the code for this particular recursive instance of addNode
	 * @return letter (String) corresponding to the code.
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String letter = "";
		if (code.length() == 1) {
			if (code.equals(".")) {
				letter = root.left.data;
			}else if (code.equals("-")) {
				letter = root.right.data;
			} 		
		} else {
			if (!code.isEmpty()) {
			if (code.charAt(0) == '.') {
				letter = fetchNode(root.left, code.substring(1));
			} else if (!code.isEmpty() && code.charAt(0) == '-') {
				letter = fetchNode(root.right, code.substring(1));
			}
		}
	}
		return letter;
	}

	/**
	 * This is a recursive method used to put the contents of the tree in an in LNR order
	 * @param root starting point of traversal
	 * @param list storage for all visited nodes
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root != null) {
			LNRoutputTraversal(root.left, list);
			list.add(root.data);
			LNRoutputTraversal(root.right, list);
		}

	}
	
	/**
	 * Create and return a list to display the morse binary tree
	 * @return the contents of the LNR traversal
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> treeList = new ArrayList<>();
		LNRoutputTraversal(root, treeList);
		return treeList;
	}

	
	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This method is not yet supported.");
	}

	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This method is not yet supported.");
	}


	
}