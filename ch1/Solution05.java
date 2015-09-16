import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution05 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Solution05 s = new Solution05();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = null;
		String s2 = null;
		System.out.println("Please input String1.");
		s1 = br.readLine();
		System.out.println("Please input String2.");
		s2 = br.readLine();
		System.out.println("The result is " + s.isOneWay(s1, s2));
	}
	
	public boolean isOneWay(String s1, String s2) {
		/*we solve this problem according to different situations.
		 * if the lengths of two string are the same, it should be
		 * replacement problem. else it should be insertion or 
		 * remove problem and these problem can be solved with one
		 * solution. 
		 */
		if(s1.length() == s2.length()) 
			return isReplacement(s1, s2);
		if(Math.abs(s1.length() - s2.length()) == 1)
			return isInsertOrRemove(s1, s2);
		
		return false;
		
	}
	
	public boolean isReplacement(String s1, String s2) {
		/*because there is only one different letter between two
		 * strings in replacement, we can use a mark variable to see if 
		 * there is only one different element.
		 */
		boolean difference = false; //mark variable
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(difference) { // if difference occurs twice
					return false;
				}
					
				difference = true;// the fist time the difference occurs
			} 
		}
		
		return true;
	}
	
	public boolean isInsertOrRemove(String s1, String s2) {
		/*to solve two problem with one solution, we make the shorter
		 * string to be newS1 and the longer newS2. then we find if 
		 * the difference between two responding element of two strings 
		 * occurs twice. if yes, return false. else return true.
		 * 
		 */
		int index1 = 0;
		int index2 = 0;
		boolean difference = false;
		
		//merge two problems into one problem
		String newS1 = (s1.length() < s2.length()) ? s1 : s2;
		String newS2 = (s1.length() > s2.length()) ? s1 : s2;
		
		while(index1 < newS1.length() && index2 < newS2.length()) {
			if(newS1.charAt(index1) != newS2.charAt(index2)) {
				if(difference) { // if difference occurs twice
					return false;
				}
				
				difference = true; // the fist time the difference occurs
			} else {
				index1++;
			}
			
			index2++; //move the element of longer string.
		}
		
		return true;
	}
}
