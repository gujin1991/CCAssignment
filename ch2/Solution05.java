import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution05 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Solution05 s = new Solution05();
		Node head = new Node(2);
		Node p1 = new Node(7);
		Node p2 = new Node(6);
		Node p3 = new Node(9);
		Node p4 = new Node(5);
		Node p5 = new Node(6);
		Node p6 = new Node(7);
		head.next = p1;
		p1.next = p2;
		p2.next = p3;
		p4.next = p5;
		p5.next = p6;
		Node testNode = s.sumList(head, p4);
		while(testNode != null) {
			System.out.println(testNode.data);
			testNode = testNode.next;
		}
		
		/*Node testNode = s.sumList(head, p4);
		while(testNode != null) {
			System.out.println(testNode.data);
			testNode = testNode.next;
		}*/
		
	}
	
	public Node sumListReverse(Node first, Node second) {
		/*In this problem, we can use a carry bit to sum elements of two lists.
		 * Therefore, the element of a new node equals to sum of two current 
		 * elements of two lists plus previous carry bit.
		 */
		int carry = 0;
		Node newListHead = new Node(0);	
		//add notes to the new list
		while(first != null && second != null) {
			int val = first.data + second.data + carry;
			if(val >= 10) {
				carry = 1;
			} else {
				carry = 0;
			}
			
			first = first.next;
			second = second.next;				
			newListHead.appendTotail(val % 10);
		}
		
		//add the rest nodes
		while(first != null) {
			int val = first.data + carry;
			if(val >= 10) {
				carry = 1;
			} else {
				carry = 0;
			}
			
			first = first.next;	
			newListHead.appendTotail(val % 10);
		}
		
		while(second != null) {
			int val = second.data + carry;
			if(val >= 10) {
				carry = 1;
			} else {
				carry = 0;
			}
			
			
			second = second.next;	
			newListHead.appendTotail(val % 10);
		}
		
		//add one more node if carry still equals to 1
		if(carry == 1) {
			newListHead.appendTotail(carry);
		}
		
		Node newList = newListHead.next;
		return newList;
		
	}

	public Node sumList(Node first, Node second) {
		/*the only different between this problem and previous problem is that we need
		 * to calculate the new value from the end of two lists to the front. and Stack
		 * is a good structure to solve this problem. 
		 */
		Node p = first;
		Node q = second;
		int count1 = 0;
		int count2 = 0;
		int carry = 0;
		Node newList = null;
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		while(p != null) {
			s1.add(p);
			p = p.next;
			count1++;
		}
		while(q != null) {
			s2.add(q);
			q = q.next;
			count2++;
		}
		
		//add notes to the new list
		while(!s1.isEmpty() && !s2.isEmpty()) {
			int val = s1.pop().data + s2.pop().data + carry;
			if(val >= 10) {
				carry = 1;
			} else {
				carry = 0;
			}
			
			
			Node newNode = new Node(val % 10);
			newNode.next = newList;
			newList = newNode;
		}
		
		//add the rest nodes
		if(count1 > count2) {
			while(!s1.isEmpty()) {
				int val = s1.pop().data + carry;
				if(val >= 10) {
					carry = 1;
				} else {
					carry = 0;
				}
				
				
				Node newNode = new Node(val % 10);
				newNode.next = newList;
				newList = newNode;
				if(s1.size() == 0 && carry == 1) {
					Node newNode1 = new Node(carry);
					newNode1.next = newList;
					newList = newNode1;
				}
			}
		} else if(count1 < count2) {
			while(!s2.isEmpty()) {
				int val = s2.pop().data + carry;
				if(val >= 10) {
					carry = 1;
				} else {
					carry = 0;
				}
				
				
				Node newNode = new Node(val % 10);
				newNode.next = newList;
				newList = newNode;
				if(s2.size() == 0 && carry == 1) {
					Node newNode1 = new Node(carry);
					newNode1.next = newList;
					newList = newNode1;
				}
			}
		} else if(carry == 1) { //add one more node if carry still equals to 1
			Node newNode1 = new Node(carry);
			newNode1.next = newList;
			newList = newNode1;
		}
		
		
		return newList;
	}
}

class Node {
	Node next = null;
	Node prev = null;
	int data;
	
	public Node(int d) {
		this.data = d;
	}
	
	public Node(int d, Node next, Node prev) {
		this.data = d;
		this.next = next;
		this.prev = prev;
	}
	
	public void appendTotail(int d) {
		Node end = new Node(d);
		Node n = this;
		while(n.next != null) {
			n = n.next;
		}
		
		n.next = end;
	}
	
	public Node deleteNode(Node head, int d) {
		Node n = head;
		
		if(n.data == d) {
			return head.next;
		}
		
		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
				return head;
			}			
			n = n.next;
		}
		
		return head;
	}
}
