import java.util.*;
public class Solution11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*in this problem, we can just sort the array and then swap every two elements.
	 * 
	 */
	public void peakAndValley(int[] arr) {
		if(arr.length <= 1) return;
		
		Arrays.sort(arr);
		for(int i = 1; i < arr.length; i += 2) {
			int tmp = arr[i - 1];
			arr[i - 1] = arr[i];
			arr[i] = tmp;
			
		}
	}

}
