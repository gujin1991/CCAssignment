package Coding.Boot.Camp;


public class Solution02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution02 s = new Solution02();
		int arr[] = {1, 2, 3, 4, 5, 6};
		
		TreeNode n = s.createMinBST(arr, 0, 5);
		s.inOrderTraverse(n);
	}
	
	/*in order to create a minimal height BST, the root element of should be the middle value which means 
	 * we need to match numbers of left subtree and right subtree as much as possible.
	 */
	public TreeNode createMinBST(int arr[], int start, int end) {
		if(end < start) return null;
		
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);//put the first node
		n.left = createMinBST(arr, start, mid - 1);//update the maximum
		n.right = createMinBST(arr, mid + 1, end); //update the minimum
		return n;
	}
	
	private class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public void inOrderTraverse(TreeNode root) {
		if(root != null) {
			inOrderTraverse(root.left);
			System.out.println(root.val);
			inOrderTraverse(root.right);
		}
	}

}
