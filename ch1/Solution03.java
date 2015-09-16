
public class Solution03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution03 s = new Solution03();
		char[]  str = new char[100];
		str = "Mr John Smith    ".toCharArray();
		str = s.URLify(str, 13);
		System.out.println("The result of ¡°Mr John Smith   ¡± is " + String.valueOf(str));
		
	}
	
	public char[] URLify(char[] str, int length) {
	    /* in this problem, we assume the char array has infinity size,
	     * therefore, we use two loop to make space to be "%20".
	     * the first loop finds out the number of space. then we add space*2
	     * more size¡£ Finally we use a second loop to change the array from
	     * tail to front.
	     */
			// check the number of space.
			int newlength = length;
			for(int i = 0; i < length; i++) {
				if(str[i] == ' ') {
					newlength += 2;
				}
			}
			
			//if there is no space, return.
			if(newlength == length) {
				return str;
			}
			
			//change space to "%20"
			for(int i = length - 1; i >= 0; i--) {
				if(str[i] == ' ') {
					str[newlength - 1] = '0';
					str[newlength - 2] = '2';
					str[newlength - 3] = '%';
					newlength -= 3;
					
				}else {
					str[newlength - 1] = str[i];
					newlength--;
					
				}
			}
			
			return str;
		}
}
