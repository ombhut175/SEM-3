package LAB_16;

import java.util.*;

public class Q1 {
	public static void main(String[] args) {
		Graph g1 = new Graph();
		g1.addEdge(1,2);
		g1.addEdge(2,1);
		g1.addEdge(2,3);
		g1.addEdge(3,2);
		g1.addEdge(2,4);
		g1.addEdge(4,2);
		g1.addEdge(4,5);
		g1.addEdge(5,4);
		System.out.println("dfs");
		g1.dfs(1);
		System.out.println();
		System.out.println("bfs");
		g1.bfs(1);
	}
}


class Graph{
	HashMap<Integer, LinkedList<Integer>> h1;
	public Graph(){
		h1 = new HashMap<>();
	}
	void addEdge(int u,int v){
//		if (!h1.containsKey(u)) h1.put(u,new LinkedList<>());
//		if (!h1.containsKey(v)) h1.put(v,new LinkedList<>());
		h1.putIfAbsent(u,new LinkedList<>());
		h1.putIfAbsent(v,new LinkedList<>());
		h1.get(u).add(v);
		h1.get(v).add(u);
	}
	void dfs(int curr){
		Set<Integer> visited = new HashSet<>();
		dfsUtil(curr,visited);
	}
	private void dfsUtil(int curr,Set<Integer> visited){
		visited.add(curr);
		System.out.print(curr+" ");
		for (int val:h1.getOrDefault(curr,new LinkedList<>())){
			if (!visited.contains(val)){
				dfsUtil(val,visited);
			}
		}
	}
	void bfs(int start){
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q1 = new LinkedList<>();
		visited.add(start);
		q1.add(start);
		while (!q1.isEmpty()){
			int curr = q1.poll();
			System.out.print(curr+" ");
				for (int val : h1.get(curr)) {
					if (!visited.contains(val)) {
						visited.add(val);
						q1.add(val);
					}
				}
		}
	}


}
