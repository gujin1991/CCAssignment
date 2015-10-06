import java.util.*;
public class Solution03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution03 s = new Solution03();
		System.out.println(s.flipToWin(0b01111111110011101111));
	}
	
	/*first we change the number bit by bit and see the maximum of
	 * all sequences
	 */
			
	public int flipToWin(int num) {
		int sequence_length = 32;
		if(num == -1) {
			return sequence_length;
		}
		int max = 1;
		for(int i = 0; i < sequence_length; i++) {
			int count = 0;
			int localMax = 0;
			for(int j = 0; j < sequence_length; j++) {
				if((j == i) || (num & (1 << j)) != 0) { // find the longest sequence only one selected bit changed  
					count++;
					localMax = Math.max(localMax, count);
				} else {
					count = 0;
				}
			}
			max = Math.max(max, localMax);//find the longest sequence among all local longest sequence
		}
		
		return max;
	}
	
	

}
