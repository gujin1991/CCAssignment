
public class Solution07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{1,1,1,4},{2,0,2,5},{3,3,0,6},{4,7,8,9}};
		Solution07 s = new Solution07();
		s.rotateMatrix(test, 4);
	}
	
	public void rotateMatrix(int[][] matrix, int n) {
		/*here we change the matrix 90 degree from outside to inside. 
		 * the order here is left to top, bottom to left, right to 
		 * bottom and top to right.
		 * 
		 */
		for(int layer = 0; layer < n / 2; layer++) {	
			int first = layer; //position of first element of that layer
			int last = n - 1 - layer;//position of last element of that layer
			
			for(int i = first; i < last; i++) {
				int top = matrix[first][i]; //reserve the top element
				
				matrix[first][i] = matrix[last - i + first][first];//left to top
				
				matrix[last - i + first][first] = matrix[last][last - i + first];//bottom to left
				
				matrix[last][last - i + first] = matrix[i][last];//right to bottom
				
				matrix[i][last] = top;// top to right
			}
		}
	}
}
