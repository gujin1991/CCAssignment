
import java.util.*;
 
public class Solution02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewStack ns = new NewStack();
		ns.push(2);
		ns.push(5);
		ns.push(1);
		ns.push(9);
		ns.push(2);
		System.out.println(ns.peek());
		System.out.println(ns.min());
		System.out.println(ns.isEmpty());
		ns.pop();
		ns.pop();
		ns.pop();
		System.out.println(ns.peek());
		System.out.println(ns.min());
		System.out.println(ns.isEmpty());
	} 
	
	/*in this problem, we use two stacks. one stack is used to store original data, the other is used
	 * to store the minimum element. 
	 */
	private static class NewStack{
		private Stack dataStack = new Stack();
		private Stack minStack = new Stack();
		
		// if the element is the minimum, we push it to two stack.otherwise, just push in original data stack
		public void push(int i) {
			if(dataStack.isEmpty() && minStack.isEmpty()) {
				dataStack.push(i);
				minStack.push(i);
			} else {
				if(i <= (int)minStack.peek()) {
					minStack.push(i);
				}
				dataStack.push(i);
			}
		}
		
		//if the element is the same as top element of minimum stack,we pop it from both stacks, otherwise only from original data stack
		public int pop() {
			if(dataStack.isEmpty()) {
				throw new EmptyStackException();
			}
			
			int top = (int)dataStack.peek();
			if(dataStack.peek() == minStack.peek()) {
				minStack.pop();
			}
			dataStack.pop();
			
			return top;
		}
		
		public int min() {
			if(minStack.isEmpty()) {
				throw new EmptyStackException();
			}
			
			return (int)minStack.peek(); //just return top element of minimum stack
		}
		
		public int peek() {
			if(dataStack.isEmpty()) {
				throw new EmptyStackException();
			}
			
			return (int)dataStack.peek(); 
		}
		
		public boolean isEmpty() {
			return dataStack.isEmpty();
		}
	}

}
