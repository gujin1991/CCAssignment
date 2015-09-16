import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution06 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Solution06 s = new Solution06();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = null;
		System.out.println("Please input a string.");
		s1 = br.readLine();
		System.out.println("The result is " + s.stringCompression(s1));
	}
	
	public String stringCompression(String str) {
		/*we can use a count number and a new string to solve this
		 * problem. if the element of the string equals to last element, 
		 * count number plus one. if it does not equal to last element,
		 * we reset the count number and append the responding char and
		 * count number to the new string.
		 */
		int count = 1;
		String newS = "";
		char last = str.charAt(0);
		
		//create a new string with count number
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == last) {
				count++;
			} else {
				newS += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}
		
		newS += last + "" + count;//append last element
		
		//return the smaller size string.
		if(str.length() < newS.length())
		{
			return str;
		} else {
			return newS;
		}
		
	}
}
