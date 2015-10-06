
public class Solution06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*use an or operation to find the different and then count the number of 1s
	 * in a^b.
	 */
	public int conversion(int a, int b) {
		int count = 0;
		for(int c = a ^ b; c > 0; c >>= 1) {
			count += c & 1;
		}
		
		return count;
	}

}
