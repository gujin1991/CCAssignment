
public class Solution04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution04 s = new Solution04();
		s.getNumber(0b10011110000011);
	}
	
	public void getNumber(int num) {
		int next = getNext(num);
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString(next));
		int prev = getPrev(num);
		System.out.println(Integer.toBinaryString(prev));
	}
	
	/* first we check if the lowest bit is 1. if yes, we find the first bit which is 0 and turn this
	 * bit to 1. otherwise, we find the rightmost non-trailing zero and turn it to 1. after that,
	 * we should move all the 1s to lowest position.
	 */
	private int getNext(int num) {
		int sequence_length = 32;
		int count0 = 0;
		int count1 = 0;
		if((num & 1) == 1) {
			while((num & 1) != 0 && count0 + count1 < sequence_length) {
				count1++;	//number of 1s
				num = num >> 1;
			}
		} else {
			while((num & 1) != 1 && count0 + count1 < sequence_length) {
				count0++; // number of 0s
				num = num >> 1;
			}
			
			while((num & 1) != 0 && count0 + count1 < sequence_length) {
				count1++;
				num = num >> 1;
			}
		}
		
		if(count0 + count1 == 32 || count0 + count1 == 0) {
			return -1;
		}
		
		num = num | 1; 	//set the bit
		num = num << (count0 + count1);
		num = num | ((1 << count1 - 1) - 1); //move all the 1s to lowest position
		
		return num;
	}
	
	/*we can use the similar way above to solve the problem, but here we find the position
	 * where we turn 1 to zero and move all the 1s just behind the position we found.
	 */
	private int getPrev(int num) {
		int sequence_length = 32;
		int count0 = 0;
		int count1 = 0;
		//find the position
		if((num & 1) == 0) {
			while((num & 1) != 1 && count0 < sequence_length) {
				count0++;
				num = num >> 1;
			}
		} else {
			while((num & 1) != 0 && count1 < sequence_length) {
				count1++;
				num = num >> 1;
			}
			
			while((num & 1) != 1 && count0 < sequence_length) {
				count0++;
				num = num >> 1;
			}
		}
		
		if(count0 + count1 == 32 || count0 + count1 == 0) {
			return -1;
		}	
		
		num >>= 1;
		num = num << (count0 + count1 + 1); //clear all the bits below the position we found
		int mask = (1 << count1 + 1) - 1; //use a mask like 11110000
		mask <<= count0 - 1;
		num = num | mask;
		
		return num;
	}
	
	

}
