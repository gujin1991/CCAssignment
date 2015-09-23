package Coding.Boot.Camp;

import java.util.*;



public class Solution09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution09 s = new Solution09();
		int arr[] = {2, 1, 3};
		TreeNode root = s.buildTree(arr); //build a  binary search tree
		
		
		ArrayList<LinkedList<Integer>> alt = s.findSequences(root);
		
		for(int i = 0; i < alt.size(); i++) {
			LinkedList<Integer> lt = alt.get(i);
			for(int j = 0; j < lt.size(); j++) {
				System.out.print(lt.get(j) + " ");
			}
			System.out.println("");
		}
	}
	
	/*in this problem, we recursively find out all sequences of the elements of two  
	 * subtrees
	 */
	public ArrayList<LinkedList<Integer>>  findSequences(TreeNode root) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		if(root == null) {
			result.add(new LinkedList<Integer>());
			return result;
		}
		
		//add current value to prefix
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(root.val);
		
		
		ArrayList<LinkedList<Integer>> lSequences = findSequences(root.left);
		ArrayList<LinkedList<Integer>> rSequences = findSequences(root.right);
		
		for(LinkedList<Integer> l : lSequences) {
			for(LinkedList<Integer> r : rSequences) {
				ArrayList<LinkedList<Integer>> weave = new ArrayList<LinkedList<Integer>>();
				weaveList(l, r, weave, prefix);
				result.addAll(weave);
			}
		}
		
		return result;
	}
	
	// find out all sequences of the elements of two  subtrees
	public void weaveList(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> weave, LinkedList<Integer> prefix) {
		
		if(first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			weave.add(result);
			return;
		}
		
		int p = first.removeFirst();
		prefix.addLast(p);
		weaveList(first, second, weave,prefix);
		prefix.removeLast();
		first.addFirst(p);
		
		int q = second.removeFirst();
		prefix.addLast(q);
		weaveList(first, second, weave,prefix);
		prefix.removeLast();
		second.addFirst(q);
		
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
