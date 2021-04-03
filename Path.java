import java.util.ArrayList;

/*
 * DO NOT EDIT THIS CLASS
 * 
 * A very simple class representing a Path (sequence of nodes).
 * 
 * This is really just a wrapper for an ArrayList, with a few
 * helpful methods.
 */

public class Path {

	// The only instance field is an ArrayList of Integers.
	// i.e. a Path consists of a sequence of nodes, and the
	// nodes are identified by their Integer id's. 
	private ArrayList<Integer> p;
	
	
	// First constructor: creates a Path consisting just of the 
	// start node.
	public Path(Integer start)
	{
		p = new ArrayList<Integer>();
		p.add(start);		
	}
	
	// Second constructor: creates a new Path by taking 
	// an existing Path and extending it by one node.
	public Path(Path p2, Integer newNode)
	{
		p = new ArrayList<Integer>(p2.returnList());
		p.add(newNode);
		
	}
	
	// get the last node in the Path
	public int getLastNode()
	{	
		return p.get(p.size()-1);	
	}
	
	// get the entire ArrayList (sequence of nodes)
	public ArrayList<Integer> returnList()
	{
		return p;
	}
	
	// a String representation of the Path
	public String toString()
	{
		return p.toString();
	}
}