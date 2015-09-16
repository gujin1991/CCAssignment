package coding.boot.camp;

public class Solution07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution07 s = new Solution07();
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
		Node testNode = s.intersectionList(head, p3);
		
		System.out.println(testNode.data);
			
		
	}
	
	public Node intersectionList(Node l1, Node l2) {
    	/*in this problem, we can use two pointers to solve it. at first,
    	 * two pointers move at the same speed. if one of the pointer reaches
    	 * the end, then we make it point to the head of another list. finally
    	 * they will meet at the intersected node.
    	 */
    	//special case
    	if(l1 == null || l2 == null) {
    		System.out.println("At least one of two lists is null");
    		return null;
    	}
    		
    	// two pointers to find out intersected node.
    	Node p1 = l1;
    	Node p2 = l2;
    	
    	while(p1 != null && p2 != null && p1 != p2) {
    		p1 = p1.next;
    		p2 = p2.next;
    		
    		if(p1 == p2)
    		{
    			System.out.println("There is no intersection between two lists.");
    			return p1; 
    		}
    		if(p1 == null)
    			p1 = l2;
    		if(p2 == null)
    			p2 = l1;
    	}
    	
    	
    	return p1;
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