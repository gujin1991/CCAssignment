import java.util.LinkedList;

public class Solution04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double noSizeSearch(Listy l, int val) {
		if(l.elementAt(0) == val)
			return 0;
		
		int factor = 0;
		double index = 1;
		//when element at index is not out off bound.
		while(l.elementAt(index) != -1) {
			if(l.elementAt(index) == val) {
				return index;
			} else if(l.elementAt(index) < val) {
				index *= 2;  //larger the upper range.
			} else {
				return binarySearch(l, val, index / 2, index); // binary search the element in [index/2, index]
			}
		}
		
		//when the element is in [index, +infinity)
		index = index / 2;
		while(l.elementAt(index) != -1) {
			if(l.elementAt(index) == val) {
				return index;
			} else {
				index++;
			}
		}
		
		return -1;
	}
	
	public int binarySearch(Listy l, int val, int low, int high) {
		if(low > high) return -1;
		
		int mid = low + (high - low) / 2;
		if(l.elementAt(mid) > val) {
			return binarySearch(l, val, low, mid - 1);
		} else if(l.elementAt(mid) < val) {
			return binarySearch(l, val, mid + 1, high);
		} else {
			return mid;
		}
		
	}

}
