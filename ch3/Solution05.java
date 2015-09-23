package Coding.Boot.Camp;

import java.util.*;


public class Solution05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortStack ss = new SortStack();
		ss.push(3);
		ss.push(6);
		ss.push(3);
		ss.push(2);
		ss.push(8);
		System.out.println(ss.peek());
	}
	
	/*in this problem, we use a tmp stack to store elements which are bigger than input element.
	 * 
	 */
	private static class SortStack {
		private Stack data = new Stack();
		private Stack tmp = new Stack();
		
		public void push(int val) {
			if(data.isEmpty()) {
				data.push(val);
			} else {
				if(val < (int)data.peek()) {
					data.push(val);
				} else {
					while((val > (int)data.peek()) && !data.empty()) {
						tmp.push(data.peek()); // push the elements of data stack to tmp stack
						data.pop();
						System.out.println(!data.empty());
					}
					
					data.push(val);
					
					while(!tmp.isEmpty()) { //push back the original element
						data.push(tmp.pop());
					}
				}
			}
		}
		
		public int pop() {
			if(data.isEmpty()) {
				throw new EmptyStackException();
			}
			
			return (int)data.pop();	
		}
		
		public int peek() {
			if(data.isEmpty()) {
				throw new EmptyStackException();
			}
			
			return (int)data.peek();	
		}
		
		public boolean isEmpty() {
			return data.isEmpty();
		}
	}

}
