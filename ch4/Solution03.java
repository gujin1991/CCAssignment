package Coding.Boot.Camp;
import java.util.*;


public class Solution03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution03 s = new Solution03();
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = s.buildTree(arr); //build a three layer binary tree
		
		ArrayList<LinkedList<TreeNode>> alt = s.listOfDepths(root);
		
		for(int i = 0; i < alt.size(); i++) {
			LinkedList<TreeNode> lt = alt.get(i);
			for(int j = 0; j < lt.size(); j++) {
				System.out.print(lt.get(j).val + " ");
			}
			System.out.println("");
		}
		
	}
	/*in this problem, we can check if a node has left or right subtree, if yes, store them in a LinkedList.
	 * then we move to the next layer and do these steps again.
	 */
	ArrayList<LinkedList<TreeNode>> listOfDepths(TreeNode node) {
		ArrayList<LinkedList<TreeNode>> aln = new ArrayList<LinkedList<TreeNode>>();
		if(node == null) return aln;
		
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		current.add(node);
		
		while(current.size() > 0) {
			aln.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for(TreeNode parent: parents) { // store the children nodes
				if(parent.left != null) {
					current.add(parent.left);
				}
				if(parent.right != null) {
					current.add(parent.right);
				}
			}
				
		}
		
		return aln; 
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
