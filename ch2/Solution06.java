import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Solution06 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Solution06 s = new Solution06();
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
		
		System.out.println(s.isPalindromeList(head));
			
	}
	
	public boolean isPalindromeList(Node head) {
    	/*we can first put the data of notes into a vector, then check
    	 * whether elements of corresponding position are the same. 
    	 * if it occurs difference, return false. else return true.
    	 */
    	//special case
    	if(head == null)
    		return false;
    	if(head.next == null)
    		return true;
    	
    	//put the elements into a vector.
    	Vector temp = new Vector();
    	int n = 0;
    	int m = 0;
    	while(head != null) {
    		temp.addElement(head.data);
    		head = head.next;
    	}
    	
    	// see if the corresponding elements are the same.
    	n = temp.size();
    	m = n / 2;
    	for(int i = 0; i < m; i++) {
    		if(temp.elementAt(i) != temp.elementAt(n - 1 - i)) {
    			return false;
    		}
    	}
    	
    	return true;
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
