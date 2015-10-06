
public class Solution07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*here I take the idea from the textbook.
	 * first I use a mask like 1010101010 to get the value of odd bits
	 * and then we left shift to make it in even spots. then I use the 
	 * same idea to shift the value of even spots to odd spots. finally,
	 * I use an or operation to make them together.
	 */
	
	public int pairSwap(int num) {
		return (num & 0xaaaaaaaa >>> 1) | (num & 0x55555555 << 1);
	}
}
