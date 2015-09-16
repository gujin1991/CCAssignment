import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution09 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Solution09 s = new Solution09();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = null;
		String s2 = null;
		System.out.println("Please input a string.");
		s1 = br.readLine();
		System.out.println("Please input a substring of first string.");
		s2 = br.readLine();
		System.out.println("The result is " + s.stringRotation(s1, s2));
	}
	
	public boolean stringRotation(String s1, String s2) {
		/*
		 * the rotation of string s must be substring of ss.
		 */
		if(s1.length() != s2.length())
			return false;
		String newS = s1 + s1;
		
		return newS.contains(s2);
	}
}
