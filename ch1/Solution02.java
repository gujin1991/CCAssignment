import java.io.*;
public class Solution02 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Solution02 s = new Solution02();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = null;
		String s2 = null;
		System.out.println("Please input String1.");
		s1 = br.readLine();
		System.out.println("Please input String2.");
		s2 = br.readLine();
		System.out.println("The result is " + s.checkPermution(s1, s2));
	}
	
	public boolean checkPermution(String s, String t) {
		/*in this problem, if two strings have different length, result 
		 * must be false. Therefore, with the same length, we can use 
		 * a for loop to check if the responding positions have same 
		 * element
		 */
		if(s.length() != t.length())
			return false;
		
		//a for loop to check if the responding positions have same element
		for(int i = 0, j = t.length() - 1; i < s.length(); i++, j--) {
			if(s.charAt(i) != t.charAt(j))
				return false;
		}
		
		return true;
	}
}
