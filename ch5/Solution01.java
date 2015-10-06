import java.util.*;
public class Solution01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution01 s = new Solution01();
		int k = s.insertion(0b10000000000, 0b10011, 2, 6);
		System.out.println(Integer.toBinaryString(k));
	}
	
	/*first get a mask like 111000001111 to clear the bits in n,
	 * then left shift m to be m00;
	 * finally use an or operation to get the result.
	 */
	public int insertion(int n, int m, int i, int j) {
		int ones = ~0;
		int mask = (ones << (j + 1)) | ((1 << i) - 1);
		
		m = m << i;
		return (n & mask) | m;
	}

}
