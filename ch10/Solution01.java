
public class Solution01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution01 s = new Solution01();
		int arr[] = {1,2,3,4,5};
		int arr2[] = {1,2,3,4,5};
		s.sortedMerge(arr, arr2);
		
	}
	
	/*in this problem, we just insert the elements of B array in to A.
	 * we first check if the last element of A is bigger than the first 
	 * element of B. if yes, we move the last element of A backward because
	 * there is much space not use in that area. if no, we insert the element
	 * of B after that element of A.
	 */
	public void sortedMerge(int[] A, int[] B) {
		for(int i = 0; i < B.length; i++) {
			int index = A.length - 1 + i; // index of last element of A
			while(B[i] < A[index] && index >= 0) { //find the right position for B
				A[index + 1] = A[index];
				index--;
			}
			
			A[++index] = B[i]; //insert the element.
			
		}
	}

}
