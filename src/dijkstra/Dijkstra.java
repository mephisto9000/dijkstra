package dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

	
	private class Adjacency
	{
		public int[] neighbourIdx;
		public int[] cost; // price of edge
	}
	
	int s   = -1;
	int end = -1;
	int []d;
	boolean[] used;
	
	Adjacency[] g;
	List<Person> people;
	
	Dijkstra(List<Person> guys)
	{
		super();
		
		people = guys;
		
		d = new int[guys.size()];
		used = new boolean[guys.size()];
		g = new Adjacency[guys.size()];
		
		for (int i = 0; i < guys.size(); i++)
		{
			d[i] = Integer.MAX_VALUE;
			used[i] = false;
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
	
	int dijkstra_compute(Person start, Person finish) {
		
		for (int i = 0; i < people.size(); i++ )
		{
			if (start == people.get(i))
			{
				s = i;
				d[s] = 0;
			}
			
			if (finish == people.get(i))
				end = i;
		}
						
		int n = people.size();
										
		for (int i = 0; i < n; i++)
		{
			int v = -1;
			for (int j = 0; j < n; j++)
			{
				if (used[j]==false  && (v==-1 || d[j] < d[v]))
					v = j;
			}
			
			if ( v == -1 || d[v] == Integer.MAX_VALUE)
				break;
			
			used[v] = true;
			
			for (int j = 0; j < g[v].neighbourIdx.length; j++)
			{
				int to = g[v].neighbourIdx[j];
				int w = g[v].cost[j];
				
				if (d[to] > (d[v] + w))
					d[to] = d[v] + w;
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
		
		
		Person musa = new Person("mussabek");
		
		Person igor  = new Person("igor");
		Person askar = new Person("askar");
		Person olzhas = new Person("olzhas");
		Person yermek = new Person("yermek");
		Person nurlan = new Person("nurlan");
		
		musa.addConnection(igor);
		askar.addConnection(musa);
		musa.addConnection(askar);
		musa.addConnection(yermek);
		
		    
		yermek.addConnection(olzhas);
		olzhas.addConnection(nurlan);
								
		List<Person> guys = new ArrayList<Person>();
		guys.add(musa);
		guys.add(igor);
		guys.add(askar);
		guys.add(olzhas);
		guys.add(nurlan);
		guys.add(yermek);
				
		
		Dijkstra algo = new Dijkstra(guys);
		int val = algo.dijkstra_compute(yermek, musa);
		System.out.println("dijkstra length == "+val);

	}

}
