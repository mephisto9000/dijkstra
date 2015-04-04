package dijkstra;


import java.util.ArrayList;
import java.util.List;



public class Person {
	  public String unique_name;  // all names are unique
	  public List<Person> connections;
	  public List<Integer> connectionPrices;
	  
	  
	  public Person(String name)
	  {
		  super();
		  unique_name = name;
		  this.connections = new ArrayList<Person>();
		  this.connectionPrices = new ArrayList<Integer>();
	  }
	  
	  public void addConnection(Person remote_person)
	  {
		  this.connections.add(remote_person);
	  }
	  
	  public void addConnection(Person remote_person, int price)
	  {
		  this.connections.add(remote_person);
		  this.connectionPrices.add(price);
	  }
	  
	  public int hasConnection(Person remote_person)
	  {
		  return this.connections.indexOf(remote_person);
	  }
	  
	  public int numConnections()
	  {
		  return connections.size();
	  }
}
