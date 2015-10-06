
public class Solution08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*first we find the position of x1 and x2 in screen[]. then we set the byte between 
	 * them to be 1, finally we set the start and end of the line with two masks.
	 */
	
	public void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		int offset1 = x1 % 8;
		int offset2 = x2 % 8;
		int startByte = x1 / 8;
		int endByte = x2 / 8;
		
		if(offset1 != 0) {
			startByte++;
		}
		
		if(offset2 != 7) {
			endByte--;
		}
		
		//set the byte between x1 and x2 to be 1
		for(int count = startByte; count <= endByte; count++) {
			screen[width / 8 * y + count] = (byte) 0xff;
		}
		
		// two masks to set the start and end of the line
		byte startMask = (byte) (0xff >> offset1);
		byte endMask = (byte) ~(0xff >> (offset1 + 1));
		
		if(x1 / 8 == x2 / 8) {
			byte mask = (byte) (startMask & endMask);
			screen[width / 8 * y + x1 / 8] |= mask; 
		} else {
			if(offset1 != 0) {
				screen[width / 8 * y + startByte - 1] |= startMask;
			}
			
			if(offset2 != 7) {
				screen[width / 8 * y + endByte + 1] |= endMask;
			}
		}
	}

}
