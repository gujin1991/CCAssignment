import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution04 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Solution04 s = new Solution04();
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
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		Node testNode = s.partition(head, 5);
		while(testNode != null) {
			System.out.println(testNode.data);
			testNode = testNode.next;
		}
	}
	
	public Node partition(Node head, int x) {
		/*in this problem, we can use two new list to store the nodes
		 * which their elements are smaller than given number and the 
		 * rest nodes. finally, we merge two lists. 
		 * 
		 */
		//special case
		if(head == null || head.next == null) {
			return head;
		}
		
		//put every node into corresponding list according to their data.  
		Node before = null;
		Node after = null;
		
		while(head != null) {
			Node next = head.next;
			if(head.data < x) {
				head.next = before;
				before = head;
			} else {
				head.next = after;
				after = head;
			}
			
			head = next;
		}
		
		//if all elements are bigger than given number.
		if(before == null) {
			return after;
		}
		
		//merge two lists
		head = before;
		while(before.next != null) {
			before = before.next;
		}
		before.next = after;
		
		return head;
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
