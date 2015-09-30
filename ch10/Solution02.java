import java.util.*;
public class Solution02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution02 s = new Solution02();
		String[] str = {"dsa", "bfwsa", "awe", "awe","asd","aswfb","fbasw"};
		s.groupAnagrams(str);
		
		
	}
	
	/*to find if two strings are anagrams, we can sort them and see if they are the same.
	 * then we map all string with same anagram to an arraylist, finally we put the elements
	 * of each arraylist one by one into original array.
	 */
	public void groupAnagrams(String[] str) {
		if(str.length < 3) return;
		HashMap<String, ArrayList> hml = new HashMap<String, ArrayList>();
		//sort the array and put all strings of same anagram to an arraylist
		for(int i = 0; i < str.length; i++) {
			char[] c = str[i].toCharArray();
			String sortS = insertionSort(c);
			if(!hml.containsKey(sortS)) {
				ArrayList al = new ArrayList();
				al.add(str[i]);
				hml.put(sortS, al);
			} else {
				hml.get(sortS).add(str[i]);
			}
		}
		
		//put the elements of each arraylist one by one into original array.
		int index = 0;
		for(String key : hml.keySet()) {
			ArrayList al2 = hml.get(key);
			for(int i = 0; i < al2.size(); i++) {
				str[index] = (String) al2.get(i);
				index++;
			}
		}
		
		for(int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
		
			
	}
	
	public String insertionSort(char[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int index = i - 1;
			char tmp = arr[i];
			while( index >= 0 && arr[index] > tmp) {
				arr[index + 1] = arr[index];
				index--;		
			}
			
			arr[++index] = tmp;
		}
		
		return new String(arr);		
	}
	
}
