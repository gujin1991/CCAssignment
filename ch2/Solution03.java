public class Solution03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution03 s = new Solution03();
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
		 s.deleteNode(p3);
		Node testNode = head;
		while(testNode != null) {
			System.out.println(testNode.data);
			testNode = testNode.next;
		}
		
	}
	
	public void deleteNode(Node n) {
		/*just make data of next node to be data of current node 
		 * and the next pointer of current node to be the next node
		 * of the next node.
		 */
		if(n == null) return;
		
		if(n.next == null) {
			n = null;
		}
		
		n.data = n.next.data;
		n.next = n.next.next;
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
