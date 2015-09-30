
public class Solution08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void findDup(int arr[]) {
		//create an buffer array to check if the element occurs again.
		int[] arrBuffer = new int[32000 >> 5 + 1];	
		
		for(int i = 0; i < arr.length; i++) {
			int num = arr[i];
			int bufferIndex = (num - 1) >> 5;
			int bitIndex = (num - 1) % 32;
			if((arrBuffer[bufferIndex] &= 1 << bitIndex) == 0) {	//if the element occurs again
				System.out.println(num);
			} else {	//if the element occurs first time, set element of buffer array to 1
				arrBuffer[bufferIndex] |= 1 << bitIndex;
			}
		}
	}

}
