
public class Solution05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution05 sol = new Solution05();
		String[] str = {"at", "","","","ball","", "","car","","dad",""};
		System.out.println(sol.binarySearchString(str, "ball", 0, str.length -1));
		System.out.println(sol.binarySearchString(str, "abc", 0, str.length -1));
	}
	
	public int binarySearchString(String[] str, String s, int left, int right) {
		if(str == null || s == null) return -1;
		if(left > right) return -1;
		
		int mid = left + (right - left) / 2;
		int low = mid;
		int high = mid;
		
		while(str[mid].isEmpty()) { //search the first null string around str[mid]; 
			low--;
			high++;
			if(low < left && high > right) {
				return -1;
			} else if(low >= left && !str[low].isEmpty()) {
				mid = low;	//change the mid position
			} else if(high <= right && !str[high].isEmpty()) {
				mid = right;
			}
		}
		
		//binary search
		if(str[mid].compareTo(s) > 0) {
			return binarySearchString(str, s, left, mid - 1);
		} else if(str[mid].compareTo(s) < 0) {
			return binarySearchString(str, s, mid + 1, right);
		} else {
			return mid;
		}
	}

}
