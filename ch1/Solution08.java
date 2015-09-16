
public class Solution08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{1,1,1,4},{2,0,2,5},{3,3,0,6},{4,7,8,9}};
		Solution08 s = new Solution08();
		test = s.zeroMatrix(test);
	}
	
	public int[][] zeroMatrix(int[][] matrix) {
		/*in this problem. we first find if the first row and column
		 * has zero element. then we find if the rest element has zero.
		 * if yes, make the responding elements of first row and column
		 * to be zero. after that, we check if the elements of first row 
		 * and column is zero. if yes, we make the corresponding row and 
		 * column to be all zero. finally we make the first row and 
		 * column to be zero if at the beginning they have zero elements. 
		 */
		boolean zeroOfRow = false;
		boolean zeroOfCol = false;
		
		//check if first row and column have zero elements.
		for(int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				zeroOfRow = true;
				break;
			}
		}
		
		for(int j = 0; j < matrix.length; j++) {
			if(matrix[j][0] == 0) {
				zeroOfCol = true;
				break;
			}
		}
		
		//make the rest elements are zero
		for(int i = 1; i < matrix.length; i++) {
			for(int j = 1; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		//check first row and column and make corresponding rows and
		//element to be all zero.
		for(int i = 1; i < matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				for(int j = 0; j < matrix.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		
		for(int i = 1; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				for(int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		//check if first row and column have zero at the beginning. if yes, make 
		//first row or column to be zero.
		if(zeroOfRow) {
			for(int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}
		
		if(zeroOfCol) {
			for(int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
		
		return matrix;
	}
}
