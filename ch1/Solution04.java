import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution04 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Solution04 s = new Solution04();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = null;
		System.out.println("Please input a string.");
		s1 = br.readLine();
		System.out.println("The result is " + s.isPalindromePermutation(s1));
	}
	
	public boolean isPalindromePermutation(String str) {
		/*in this problem, we first change all letters to lowercase
		 * and remove all non-letter char. finally, use a boolean array 
		 * to find out the result. if the char of string never occurs, 
		 * set responding element of array true and count number plus 
		 * one. if it occurs second time, set responding element false
		 * and count number minus one. in this way, finally the count
		 * number should no larger than one if the string is palindrome
		 * permutation.  
		 */
		int count = 0;
		//change the string for easily operating.
		str = str.toLowerCase();
		str = str.replaceAll("[^a-z]", "");
		//a for loop to calculate count number
		boolean[] letters = new boolean[26]; 
		for(int i = 0; i < str.length(); i++) {
			if(letters[str.charAt(i) - 'a'] == false) {
				letters[str.charAt(i) - 'a'] = true;
				count++;
			} else {
				letters[str.charAt(i) - 'a'] = false;
				count--;
			}
		}
		// the number should no larger than 1.
		if(count <= 1)
			return true;
		else
			return false;
	}
}
