package coding.boot.camp;

import java.util.Hashtable;

public class Solution08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution08 s = new Solution08();
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
		p6.next = p3;
		System.out.println(s.loopDectionList(head));
			
	}
	
	public Node loopDectionList(Node head) {
    	/*here we can use a hashtable to check if one node occurs
    	 * twice. if yes, return the node. else return null node.
    	 */
    	//special case
    	if(head == null) {
    		System.out.println("The list is null");
    		return null;
    	}
    	
    	//a hashtable to check if one node occurs twice.
    	Hashtable hs = new Hashtable();
    	int count  = 0; 
    	while(head != null) {
    		if(hs.containsKey(head)) {
    			return head;
    		} else {
    			hs.put(head, count); //here the hash value means nothing, cause we do not need to use it.
    			count++;
    			head = head.next;
    		}
    	}
    	
    	System.out.println("There is no loop in the list.");
    	return null;
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