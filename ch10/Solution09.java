
public class Solution09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean sortMatrixSearch(int[][] matrix, int elem, int low, int high) {
		if(matrix[0][0] > elem) return false;
		
		int row = 0;
		int col = matrix[0].length - 1;
		while(row <= matrix.length && col >= 0) {
			if(matrix[row][col] > elem) { // it means the whole column is bigger than element
				col--; 
			} else if(matrix[row][col] < elem) { // it means the whole row is smaller than element
				row++;
			} else {	//if they are the same
				return true;
			}
		}
		
		return false;
	}

}
