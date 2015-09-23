package Coding.Boot.Camp;

import java.util.*;

public class Solution04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackQueue sq = new StackQueue();
		sq.push(1);
		sq.push(2);
		sq.push(3);
		System.out.println(sq.peek());
		sq.pop();
		sq.pop();
		System.out.println(sq.peek());
		
	}
	
	/*here we use two stack to solve the problem. one stack is called front,
	 * and the other is called tail. we push data in tail, and pop data from
	 * front.
	 */
    
	private static class StackQueue {
		private Stack front = new Stack();
		private Stack tail = new Stack();
		
		public void push(int val) {
			tail.push(val);
		}
		
		public void pop() {
			if(isEmpty()) {
				throw new EmptyStackException();
			}
			peek();
			front.pop();
		}
		
		public int peek() { //move the elements from tail to front stack. 
			int ele = 0;
			if(front.isEmpty()) {
				while(!tail.isEmpty()) {
					ele = (int)tail.peek();
					tail.pop();
					front.push(ele);
				}
			}
			
			ele = (int)front.peek();
			return ele;
		}
		
		public boolean isEmpty() {
			return front.isEmpty() && tail.isEmpty();
		}
	}
}
