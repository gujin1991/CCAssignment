import java.io.*;
public class Solution02 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Solution02 s = new Solution02();
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
		Node testNode = s.kToLast(head, 3);
		while(testNode != null) {
			System.out.println(testNode.data);
			testNode = testNode.next;
		}
	}
	
	public Node kToLast(Node head, int k) {
		/*we can use two points to solve this problem. first, the front pointer moves
		 * k steps. then two pointers move in the same speed. when the front reach the 
		 * last node, the tail pointer points to the kth node to last node. Here if
		 * k = 0, return the last node.
		 */
		//special case
		if(k < 0) return null;
		Node front = head;
		Node tail = head;
		
		// the front pointer move k step;
		for(int i = 0; i < k; i++) {
			if(front == null) return null;
			front = front.next;
		}
		if(front == null) return null; //if k is too big.
		
		//two pointer move in the same speed.
		while(front.next != null) {
			front = front.next;
			tail = tail.next;
		}
		
		return tail;
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
