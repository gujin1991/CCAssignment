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
		if(s.length() != t.length())
			return false;
		
		return sort(s).equals(sort(t));
	}
	
	public String sort(String s){ 
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		return	new String(charArray);
	}
}
