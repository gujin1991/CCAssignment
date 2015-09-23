package Coding.Boot.Camp;
import java.util.*;
public class Solution01 {
	enum State{unvisit, visiting, visited}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution01 s = new Solution01();
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		a.adjacency = new Node[]{b,c};
		b.adjacency = new Node[]{d};
		c.adjacency = new Node[]{d};
		//d.adjacency = new Node[]{e};
		
		Graph g = new Graph();
		g.nodes = new Node[]{a,b,c,d,e};
		
		System.out.println(s.search(g, a, e));
	}
	/*in order to check every only once, we used a state bit to mark if the node had been visited.
	 * From the first node, we check if the adjacent nodes are end node.
	 */
	public boolean search(Graph g, Node start, Node end) {
		if(start == end) return true;
		for(Node i : g.getNodes()) {
			i.state = State.unvisit;
		}
		
		LinkedList<Node> ll = new LinkedList<Node>();
		start.state = State.visiting;
		ll.add(start);
		
		while(!ll.isEmpty()) {
			Node u = ll.removeFirst();
			if(u!= null) {
				for(Node v : u.getAdjacency()) {
					if(v.state == State.unvisit) {
						if(v == end) {
							return true;
						}else { // if not, change the state of node and add the node to a LinkedList
							v.state = State.visiting;
							ll.add(v);
						}
					}
					
				}
				u.state = State.visited; //after checking, make the state of current node as visited 
			}
			
		}
		
		return false;
	}
	
	static class Node{
		public String name;
		public State state;
		public Node[] adjacency = new Node[]{};
		
		public Node(String name) {
			this.name = name;
		}
		
		public Node[] getAdjacency() {
			return this.adjacency;
		}
	}
	
	static class Graph {
		public Node[] nodes;
		
		public Node[] getNodes() {
			return this.nodes;
		}
	}
 
}
