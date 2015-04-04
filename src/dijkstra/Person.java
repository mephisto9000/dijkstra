package dijkstra;


import java.util.ArrayList;
import java.util.List;



public class Person {
	  String unique_name;  // all names are unique
	  List<Person> connections;
	  
	  
	  public Person(String name)
	  {
		  super();
		  unique_name = name;
		  this.connections = new ArrayList<Person>();
	  }
	  
	  public void addConnection(Person remote_person)
	  {
		  this.connections.add(remote_person);
	  }
	  
	  public int hasConnection(Person remote_person)
	  {
		  return this.connections.indexOf(remote_person);
	  }
}
