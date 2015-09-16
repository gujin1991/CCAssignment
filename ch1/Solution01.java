import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Solution01 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = null;
		System.out.println("Please input a string.");
		s1 = br.readLine();
		Solution01 s = new Solution01();
		System.out.println("The result is " + s.isUnique(s1));
	}
	
	public boolean isUnique(String str) {
		/*in this problem, we use a variable to check if a string is unique
		 * first we set corresponding bit of the variable to 1 if one char
		 * occurs first, then when it occurs again, we can judge if it occur 
		 * before
		 */
		int checker = 0;
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 1) { //check if it occurs twice;
				return false;
			}
			
			checker |= 1 << val; //set corresponding bit to 1
		}
		
		return true;
	}

}
