package dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.lang.Integer;


public class DijkstraPriorityQueue {

	
	private class Adjacency
	{
		public int[] neighbourIdx;

		public int[] cost;
	}
	
	private class Node
	{
		public int idx;
		public int weight;
	}
	
	int s   = -1;
	int end = -1;
	int []d;

	
	PriorityQueue q;
	
	Adjacency[] g;
	List<Person> people;
	

	Comparator<Node> comparator = new Comparator<Node> () 
	{
		
		@Override
		public int compare(Node o1, Node o2) {
			if( o1.weight > o2.weight ){
				return -1;
			}
			if( o1.weight < o2.weight ){
				return 1;
			}
			return 0;
		}
	};
	
	
	
	DijkstraPriorityQueue(List<Person> guys)
	{
		super();
		
		people = guys;
		
		d = new int[guys.size()];

		g = new Adjacency[guys.size()];
		
		q = new PriorityQueue (guys.size(), comparator);
		
		for (int i = 0; i < guys.size(); i++)
		{
			d[i] = Integer.MAX_VALUE;

			
			
			
			g[i] = new Adjacency();
			
			Person p = guys.get(i);
			g[i].neighbourIdx = new int[p.connections.size()];
			g[i].cost = new int[p.connections.size()];

			
			for (int j = 0; j < p.connections.size(); j++)
			{
				g[i].neighbourIdx[j] = -1;
				for (int x = 0; x < guys.size(); x++)
					if (p.connections.get(j) == guys.get(x))
					{
						
						g[i].neighbourIdx[j] = x;
						break;
					}
				g[i].cost[j] = 1;
			}
			
		}
	
		
	}
	
	int shortest_path_BFS(Person start, Person finish) {
		
		
		
		for (int i = 0; i < people.size(); i++ )
		{
			if (start == people.get(i))
			{
				s = i;
				d[s] = 0;
				
				Node n = new Node();
				n.weight = 0; //Integer.MAX_VALUE;
				n.idx = i;
				q.add(n);
				

			}
			else

			
			if (finish == people.get(i))
				end = i;
		}
		
		
		
		int n = people.size();
		
		
		
		
		
		
			int v = -1;
			
		
			
			while (!q.isEmpty())
			{
			Node node = (Node) q.poll();
			
			
			
			if (node != null)
				
			{
				v = node.idx;
			for (int j = 0; j < g[v].neighbourIdx.length; j++)
			{
				int to = g[v].neighbourIdx[j];
				int w = g[v].cost[j];
				
				
				if (d[to] > (d[v] + w))
				{
					d[to] = d[v] + w;
					
					Node node1 = new Node();
					node1.idx = to;
					node1.weight = d[to];
					
					q.add(node1);
					
				}
			}
			}
			
			if (v == end)
				return d[v];
			}
		
		
		
			
		return -1;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Person musa = new Person("musa");
		
		Person zhanibek = new Person("zhanibek");
		
		Person eldar  = new Person("bakibayev");
		Person alibek = new Person("alibek");
		Person zhanat = new Person("zhanat");
		Person monsterbek = new Person("monsterbek");
		
		musa.addConnection(zhanibek);
		zhanibek.addConnection(musa);
		
		    
		zhanibek.addConnection(alibek);
		zhanibek.addConnection(eldar);
		
		
		alibek.addConnection(zhanat);
		
		List<Person> guys = new ArrayList<Person>();
		guys.add(zhanibek);
		guys.add(eldar);
		guys.add(musa);
		guys.add(zhanat);
		guys.add(alibek);
		guys.add(monsterbek);
		
		//BFS bfs = new BFS();
		DijkstraPriorityQueue algo = new DijkstraPriorityQueue(guys);
		int val = algo.shortest_path_BFS(musa, zhanat);
		System.out.println("dijkstra == "+val);

	}

}
