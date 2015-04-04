package dijkstra;



import java.util.ArrayList;
import java.util.List;

public class BFS {
	
	
	static List<Person> visited;
	
	int shortest_path_BFS(Person start, Person finish) {
		
		//Person current_person = start;
		List<Person> stackPeople = new ArrayList<Person>();
		List<Person> stackConnections = new ArrayList<Person>();
		
		stackPeople.add(start);
		
		int count = -1;
		
		while(true)
		{
			
			count++;
			System.out.println(count);
			

			if (stackPeople.isEmpty())
				return - 1;
			
			
			
			for (int i = 0; i < stackPeople.size(); i++)
			{
				 Person p = stackPeople.get(i);
				 
				 System.out.println("visiting " + p.unique_name + ", "+p.connections.size()+" friends");
				 
				 
				 if (visited.indexOf(p)!=-1)
				 {
					 System.out.println("already visited");
					 continue;
				 }
				 
				 visited.add(p); 
				 
				 if (p == finish)
					 return count;
				 
				 if (p.connections.size()>0)
				 {
				    for (int j = 0; j < p.connections.size(); j++)
					     stackConnections.add(p.connections.get(j));
				 }

			}
			stackPeople = stackConnections;
			stackConnections = new ArrayList<Person>();

		}

		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		visited = new ArrayList<Person>();
		
		Person musa = new Person("musa");
		
		Person zhanibek = new Person("zhanibek");
		
		Person eldar  = new Person("bakibayev");
		Person alibek = new Person("alibek");
		Person zhanat = new Person("zhanat");
		
		musa.addConnection(zhanibek);
		zhanibek.addConnection(musa);
		
		    
		zhanibek.addConnection(alibek);
		zhanibek.addConnection(eldar);
		
		
		alibek.addConnection(zhanat);
		
		BFS bfs = new BFS();
		System.out.println("bfs == "+bfs.shortest_path_BFS(musa, zhanat));
		
	}

}
