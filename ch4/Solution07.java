package Coding.Boot.Camp;

import java.util.*;

public class Solution07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution07 sol = new Solution07();
		String s[] = {"a", "b", "c", "d", "e", "f"};
		String[][] ss = {{"a","d"}, {"b", "d"}, {"f", "b"}, {"d", "c"}, {"f","a"}};
		Project[] p = sol.buildOrder(s, ss);
		// it should be efbadc
		for(int i = 0; i < p.length; i++) {
			System.out.println(p[i].name);
		}
	}
	
	/*in this problem, we should first find out the nodes which have no incoming edge.
	 * these nodes are start node, then we remove the out outgoing edges from them.
	 * we repeat these two step until we find nodes which have no outgoing edges. these
	 * nodes are end nodes.
	 */
	public Project[] buildOrder(String[] projects, String[][] depedencies) {
		Graph graph = buildGraph(projects, depedencies);
		return orderProjects(graph.getNodes());
	}
	
	//bulid nodes and edges to get a graph
	public Graph buildGraph(String[] projects, String[][] depedencies) {
		Graph graph = new Graph();
		for(String project : projects) {
			graph.createProject(project);
		}
		
		for(String[] depedency : depedencies) {
			String first = depedency[0];
			String second = depedency[1];
			graph.addEdge(first, second);
		}
		
		return graph;
	}
	
	// do find and remove steps until we find there is no node left
	public Project[] orderProjects(ArrayList<Project> projects) {
		Project[] order = new Project[projects.size()];
		
		int endOfList = addNonDepedency(order, projects, 0);
		int toBeProcessed = 0;
		while(toBeProcessed < order.length) {
			Project current = order[toBeProcessed];
			
			if(current == null) {
				return null;
			}
			
			ArrayList<Project> children = current.getNextNode();
			for(Project child : children) {
				child.decrementDepedency();
			}
			
			endOfList = addNonDepedency(order, children, endOfList);
			toBeProcessed++;
		}
		
		return order; 
	}
	
	public int addNonDepedency(Project[] order, ArrayList<Project> projects, int offset) {
		for(Project project : projects) {
			if(project.getDepedence() == 0) {
				order[offset] = project;
				offset++;
			}
		}
		
		return offset;
	}
	
	
	private class Graph {
		private ArrayList<Project> nodes = new  ArrayList<Project>();
		private HashMap<String, Project> map = new HashMap<String, Project>();
		
		public Project createProject(String name) {
			if(!map.containsKey(name)) {
				Project node = new Project(name);
				nodes.add(node);
				map.put(name, node);
			}
			
			return map.get(name);
		}
		
		public void addEdge(String start, String end) {
			Project pstart = createProject(start);
			Project pend = createProject(end);
			pstart.addOthers(pend);
		}
		
		public ArrayList<Project> getNodes() {
			return nodes;
		}
	}
	
	private class Project {
		private ArrayList<Project> nextNode = new  ArrayList<Project>();
		private HashMap<String, Project> map = new HashMap<String, Project>();
		private String name;
		private int depedence = 0;
		
		public Project(String name) {
			this.name = name;
		}
		
		public void addOthers(Project node) {
			if(!map.containsKey(node.getName())) {
				nextNode.add(node);
				node.depedence++;
			}
		}
		
		public String getName() {
			return this.name;
		}
		
		public void decrementDepedency() {
			this.depedence--;
		}
		
		public ArrayList<Project> getNextNode() {
			return this.nextNode;
		}
		
		public int getDepedence() {
			return this.depedence;
		}
	}
}
