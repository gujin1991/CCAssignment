
public class Solution10 {
	RankedNote root = null; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*in this problem, we can use a BST to solve it. In the BST, every node has a variable which records
	 * the number of nodes which are smaller than it. therefore, when we need to get the rank of an element,
	 * we just add all these numbers up.
	 */
	
	public void track(int num) {
		//insert the elements to make a binary search tree
		if(root == null) {
			root = new RankedNote(num);
		} else {
			root.insert(num);
		}
	}
	
	public int getRankOfNumber(int num) {
		return root.getRank(num);
	}
	
	
	
	class RankedNote {
		private int leftSize;
		private int val;
		private RankedNote left;
		private RankedNote right;
		
		public RankedNote(int val) {
			this.val = val;
			this.leftSize = 0;
			this.left = null;
			this.right = null;
		}
		
		public void insert(int num) {
			RankedNote p = root;
			//find the position
			while(p != null) {
				if(num <= p.val) {
					p.leftSize++; //increase the size of left
					p = p.left;
					
					
				} else if(num > p.val) {
					p = p.right;
				}
			}

			RankedNote newNote = new RankedNote(num);
			p = newNote;
			
		}
		
		
		public int getRank(int num) {
			if(num == val) {	//when the element was found
				return leftSize;
			} else if(num < val) { //when the element is on the left
				if(left == null) {
					return -1;
				} else {
					return left.getRank(num);
				}
			} else {
				if(right == null) {	//when the element is on the left
					return -1;
				} else {
					return leftSize + 1 + right.getRank(num);
				}
				
			}
		}
		
	}
	
}
