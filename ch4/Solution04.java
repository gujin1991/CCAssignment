import java.util.*;


public class Solution04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution04 s = new Solution04();
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = s.buildTree(arr); //build a three layer binary tree
		
		System.out.println(s.isBalanced(root));
		
	}
	
	/*in this problem, we recursively check if the height difference between two subtrees is bigger than one, 
	 * if yes, it means the tree is unbalanced. if no, return the higher one.
	 */
	public int heightOfTreeDFS(TreeNode node) {
		if(node == null) return 0;
		int rHeight = 0;
		int lHeight = 0;
		rHeight = heightOfTreeDFS(node.left);
		lHeight = heightOfTreeDFS(node.right);
		if(rHeight == -1) {
			return -1;
		}
		if(lHeight == -1) {
			return -1;
		}
		if(Math.abs(lHeight - rHeight) > 1) {// if yes, not balanced
			return -1;
		}
		return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
			
	}
	
	public boolean isBalanced(TreeNode node) {
		return heightOfTreeDFS(node) != -1;
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
					current.add(parent.left);
				} else{
					break;
				}
				if(++index < arr.length) {
					parent.right = new TreeNode(arr[index]);
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
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
}
