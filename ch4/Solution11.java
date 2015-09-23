package Coding.Boot.Camp;

import java.util.LinkedList;
import java.util.Random;


public class Solution11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution11 s = new Solution11();
		
		TreeNode root = new TreeNode(1); //build a three layer binary tree
		root.insertInorder(2);
		root.insertInorder(3);
		root.insertInorder(4);
		root.insertInorder(5);
		root.insertInorder(6);
		root.insertInorder(7);
		
		
		System.out.println(root.getRandomNode().val);
		System.out.println(root.getRandomNode().val);
		System.out.println(root.getRandomNode().val);
		System.out.println(root.getRandomNode().val);
		System.out.println(root.getRandomNode().val);
		System.out.println(root.getRandomNode().val);
		System.out.println(root.getRandomNode().val);
	}
	
	/*in this problem, we divide the tree into tree parts, which are the root, left subtree and right tree.
	 * therefore, probabilities of each part are 1/n, left size / n and right size / n. when we move forward,
	 * it is also right, therefore we can get the node equally. 
	 */
    static class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		public int size = 0;
		
		public TreeNode(int val) {
			this.val = val;
			this.size = 1;
		}
	
	
		public TreeNode getRandomNode() {
			int leftsize = (left == null) ? 0 : left.size();
			Random random = new Random();
			// get an int index from 0 to size
			int index = random.nextInt(size);
			if(index < leftsize) {
				return left.getRandomNode();
			} else if(index == leftsize) {
				return this;
			} else {
				return right.getRandomNode();
			}
		}
		
		//build a tree
		public void insertInorder(int d) {
			if(d < val) {
				if(left == null) {
					left = new TreeNode(d);
				} else {
					left.insertInorder(d);
				}
			} else {
				if(right == null) {
					right = new TreeNode(d);
				} else {
					right.insertInorder(d);
				}
			}
			size++;
		}
		
		public int size() {
			return size;
		}
		
		public int data() {
			return val;
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

}
