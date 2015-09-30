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

}
