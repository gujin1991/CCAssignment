
public class Solution03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution03 s = new Solution03();
		int arr[] = {12,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println(s.searchRarray(arr, 5, 0, 11));
	}
	
	public int searchRarray(int arr[], int d, int left, int right) {
		int low = left;
		int high = right;
		int middle = low + (high - low) / 2;
		if(arr[middle] == d) {
			return middle;
		}
		
		if(low > high) {
			return -1;
		}
		
		if(arr[left] < arr[middle]) {	//left halve is order 
			if(arr[left] < d && arr[middle] > d) {	//the target is between the order subarray
				return searchRarray(arr, d, low, middle -1);
			} else {	//search the other subarray
				return searchRarray(arr, d, middle + 1, high);
			} 
		} else if(arr[left] > arr[middle]) {
			if(arr[middle] < d && arr[high] > d) {
				return searchRarray(arr, d, middle + 1, high);
			} else {
				return searchRarray(arr, d, low, middle -1);
			}
		} else if(arr[middle] == arr[low]) { //search both two arrays
			if(arr[middle] != arr[right]) {	//left halves is the same.
				return searchRarray(arr, d, middle + 1, high);
			} else {
				int result = searchRarray(arr, d, low, middle -1);
				if(result == -1) {
					return searchRarray(arr, d, middle + 1, high);
				} else {
					return result;
				}
			}
			
		}
			
		return -1;
	}
}
