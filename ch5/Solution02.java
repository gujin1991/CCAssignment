
public class Solution02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution02 s = new Solution02();
		s.binaryToString(0.72);
	}
	
	/*first use a string buffer to store the binary number.
	 * then use a if-else to determine put a "1" or "0" 
	 * in the buffer. finally output the buffer as a string.
	 */
	public void binaryToString(double num) {
		if(num > 1 || num < 0) {
			System.out.println("Error");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("0.");
		
		double num2 = num * 2;
		while(num > 0) {
			if(sb.length() >= 32) {
				System.out.println("Error");
				return;
			}

			if(num2 >= 1) {
				sb.append(1);
				num = num2 - 1;
			} else {
				sb.append(0);
				num = num2;
			}
			
			num2 = num * 2;
		}
		
		 System.out.println(sb.toString());
	}

}
