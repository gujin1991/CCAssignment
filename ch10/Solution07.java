import java.io.*;
import java.util.*;
public class Solution07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int sortBigFile() throws FileNotFoundException {
		byte[] fileBuffer = new byte[(Integer.MAX_VALUE + 1) / 8];	//an byte array to store all elements
		
		Scanner scan = new Scanner(new FileReader("filename"));
		while(scan.hasNext()) {	//set 1 in byte array according to all existed elements
			int n = scan.nextInt();
			fileBuffer[n / 8] |= 1 << (n % 8); 
		}
		
		//find out the miss element 
		for(int i = 0; i < fileBuffer.length; i++) {
			for(int j = 0; j < 8; j++) {
				if((fileBuffer[i] & (1 << j)) == 0) {
					return i * 8 + j;
				}
			}
		}
		
		return -1;
	}
	// follow up discussion
	/*if we have only 10MB memory, we can
	 *1 divide the integer into blocks of some size which fits 10MB memory
	 *2 find the block which its number of interger is smalller than size of block
	 *3 use the method above to find the missing integer.
	 */

}
