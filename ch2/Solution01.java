import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Solution01 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Solution01 s = new Solution01();
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
		Node testNode = s.removeDupsList(head);
		while(testNode != null) {
			System.out.println(testNode.data);
			testNode = testNode.next;
		}
		
	}
	
	public Node removeDupsList(Node head) {
		/*we can use two points to solve this problem. the first pointer points 
		 * every node of the list, the second node points to the rest nodes to 
		 * see if two points are the same. if yes, remove the same node.
		 */
		//special case
		if(head == null) { 
			return head;
		}
		
		//two pointers p, q to find out duplications.
		Node p = head;
		while(p != null) {
			Node q = p;
			while(q.next != null) {
				if(q.next.data == p.data) {
					q.next = q.next.next;
				} else {
					q = q.next;
				}
			}
			
			p = p.next;
		}
		
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
