

import java.util.EmptyStackException;

public class Solution01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StackArray s = new StackArray(3); 
		try {
			s.push(1, 1);
			s.push(1, 2);
			s.push(1, 3);
			s.push(2, 4);
			s.push(2, 5);
			s.push(2, 6);
			s.push(3, 7);
			s.push(3, 8);
			s.push(3, 9);
			System.out.println(s.peek(2));
			s.pop(2);
			System.out.println(s.peek(2));
			s.pop(1);
			System.out.println(s.peek(1));
			s.pop(1);
			System.out.println(s.peek(1));
			s.pop(1);
			System.out.println(s.isEmpty(1));
			System.out.println(s.isEmpty(2));
			System.out.println(s.isFull(3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//In this problem, we can divide an array into 3 parts, each part is a stack 
	 
	
	private static class StackArray {
		private int capacity;
		private int stackNum = 3;
		private int[] value;
		private int[] size;
		
		public StackArray(int cap) {
			this.capacity = cap;
			value = new int[stackNum * capacity];
			size = new int[stackNum];
		}
		
		public void push(int stacknum, int val) throws Exception{
			
			if(isFull(stacknum)) { // check if a stack is full
				throw new Exception();
			}
			
			//push the element into corresponding position, and increase the size of stack
			size[stacknum - 1]++;  
			int index = topIndex(stacknum);
			value[index] = val;
			
		}
		
		public int pop(int stacknum) throws EmptyStackException{	
			if(isEmpty(stacknum)) { // check if a stack is empty
				throw new EmptyStackException();
			}
			
			//get the peek element and decrease the size of stack
			int val = peek(stacknum);
			value[topIndex(stacknum)] = 0;
			size[stacknum - 1]--;
			return val;
		}
		
		public boolean isEmpty(int stacknum) {
			stacknum = stacknum - 1;
			if(size[stacknum] < 1)
				return true;
			else
				return false;
		}
		
		public int topIndex(int stacknum) {
			stacknum = stacknum - 1;
			return stacknum * capacity + size[stacknum] - 1;
		}
		
		public int peek(int stacknum) {
			stacknum = stacknum - 1;
			if(isEmpty(stacknum + 1)) {
				throw new EmptyStackException();
			}
			
			//return the top element of stack
			return value[topIndex(stacknum + 1)];
		}
		
		public boolean isFull(int stacknum) {
			stacknum = stacknum - 1;
			return size[stacknum] == capacity;	
		}
	}

}
