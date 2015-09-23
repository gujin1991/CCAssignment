import java.util.*;



public class Solution08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution08 s = new Solution08();
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = s.buildTree(arr); //build a three layer binary tree
		
		TreeNode node = s.findAncestor(root, root.left, root.right.left);
		System.out.println(node.val); // it should be root.val
	}
	
	
	/*in this problem, we check if two nodes are in the same subtree, if not, we return the parent node.
	 * if yes, we move forward until we find two nodes are not in the same subtree.
	 */
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(!containsNode(root, p) || !containsNode(root, q)) return null;
		
		return findAncestor(root, p , q);
	}
	
	public TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) {
			return null;
		} else if(containsNode(q, p)) {
			return q;
		} else if(containsNode(p, q)) {
			return p;
		}
		
		if(containsNode(root.left, p) != containsNode(root.left, q)) { //if two nodes in different subtree
			return root;
		} else {// move forward
			TreeNode nextTree = containsNode(root.left, p) == true ? root.left : root.right;
			return findAncestor(nextTree, p, q);
		}
	}
	
	public boolean containsNode(TreeNode root, TreeNode node) {
		if(root == null) return false;
		
		if(root == node) {
			return true;
		} else{
			return containsNode(root.left, node) || containsNode(root.right, node);
		}
	}
	
	public TreeNode buildTree(int arr[]) {
		if(arr.length == 0) return null;
		
		TreeNode root = new TreeNode(arr[0]);
		int index = 0;
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		current.add(root);
		while(index < arr.length -1) {
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for(TreeNode parent: parents) {
				if(++index < arr.length) {
					parent.left = new TreeNode(arr[index]);
					parent.left.parent = parent;
					current.add(parent.left);
				} else{
					break;
				}
				if(++index < arr.length) {
					parent.right = new TreeNode(arr[index]);
					parent.right.parent = parent;
					current.add(parent.right);
				} else{
					break;
				}
			}
		}
		
		return root;
	}
	
	private class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode parent;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

}
