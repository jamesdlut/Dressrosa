/*
Topological Sorting
Given an directed graph, a topological order of the graph nodes is defined as follow:
For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.
Example
For graph as follow:
The topological order can be:
[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
*/
/*
入度和出度 每次找到入度为0的点，去掉其边，看剩下的点 拓扑排序并不是唯一的
*/
public class TopSortSol {
	public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		ArrayList<DirectedGraphNode> rst = new ArrayList<DirectedGraphNode>();
		HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
		for (DirectedGraphNode node : graph) {
			for (DirectedGraphNode child : node.neighbors) {
				if (map.containsKey(child)) {
					map.put(child, map.get(child) + 1);
				} else {
					map.put(child, 1);
				}
			}
		}
		Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
		for (DirectedGraphNode node : graph) {
			if (!map.containsKey(node)) {
				q.offer(node);
				rst.add(node);
			}
		}
		while (!q.isEmpty()) {
			DirectedGraphNode node = q.poll();
			for (DirectedGraphNode child : node.neighbors) {
				map.put(child, map.get(child) - 1);
				if (map.get(child) == 0) {
					rst.add(child);
					q.offer(child);
				}
			}
		}
		return rst;
	}
	
	public static class DirectedGraphNode {
		int label;
		ArrayList<DirectedGraphNode> neighbors;
		DirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<DirectedGraphNode>();
		}
	}
	
	public static void main(String[] args) {
		DirectedGraphNode n1 = new DirectedGraphNode(0);
		DirectedGraphNode n2 = new DirectedGraphNode(1);
		DirectedGraphNode n3 = new DirectedGraphNode(2);
		DirectedGraphNode n4 = new DirectedGraphNode(3);
		DirectedGraphNode n5 = new DirectedGraphNode(4);
		DirectedGraphNode n6 = new DirectedGraphNode(5);
		n1.neighbors.add(n2);
		n1.neighbors.add(n3);
		n1.neighbors.add(n4);
		n2.neighbors.add(n5);
		n3.neighbors.add(n5);
		n3.neighbors.add(n6);
		n4.neighbors.add(n5);
		n4.neighbors.add(n6);
		ArrayList<DirectedGraphNode> test = new ArrayList<DirectedGraphNode>();
		test.add(n1);
		test.add(n2);
		test.add(n3);
		test.add(n4);
		test.add(n5);
		test.add(n6);
		for (DirectedGraphNode node : test) {
			System.out.print(node.label);
		}
		System.out.print("\n");
		ArrayList<DirectedGraphNode> rst = topSort(test);
		for (DirectedGraphNode node : rst) {
			System.out.print(node.label);
		}
	}
}
