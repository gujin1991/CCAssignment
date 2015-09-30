

import java.util.*;

public class Solution03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetOfStacks ss = new SetOfStacks(3);
		ss.push(1);
		ss.push(2);
		ss.push(3);
		ss.push(4);
		ss.pop();
	}
	
	/*we can use an ArrayList to store all the stacks. if one stack is full, we 
	 * create a new one to store new element.
	 * 
	 */
	private static class SetOfStacks {
		private int sizeOfStack;
		ArrayList<Stack> stackArray = new ArrayList<Stack>();
		
		public SetOfStacks(int size) {
			this.sizeOfStack = size;
		}
		public void push(int v) {
			Stack stack = getLast();
			if(isFull(stack) || stack == null) { // see if the last stack is full
				System.out.println("One stack is full or the stack is null.");
				Stack s = new Stack(); //if yes, create a new stack
				s.push(v);
				stackArray.add(s);
			} else {
				stack.push(v); // if not, just push the element.
			}
			
		}
		
		public int pop() {
			Stack stack =  getLast();
			int val;
			if(stack.isEmpty() || stack == null) {
				throw new EmptyStackException();
			} else {
				val = (int)stack.peek(); //return the top element of last stack
				stack.pop();
			}
			
			if(stack.isEmpty()) { //if the stack is null, delete this stack
				System.out.println("One stack is empty.");
				stackArray.remove(stackArray.size() - 1);
			}
			
			return val;
		}
		
		public boolean isFull(Stack s) {
			if(s == null)
				return false;
			return s.size() == sizeOfStack;
		}
		
		public Stack getLast() {//get last stack
			if(stackArray.isEmpty())
				return null;
			return stackArray.get(stackArray.size() - 1);
		}
	}

}
