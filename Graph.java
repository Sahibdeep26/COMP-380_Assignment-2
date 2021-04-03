import java.util.ArrayList;

/*
 * A class representing a Graph as an adjacency matrix,
 * and providing search functions for the Graph.
 */

/*
 * COMP 380
 * Sahibdeep Singh
 * 
 */

public class Graph {
	boolean[][] adjMat;

	// In the adjacency matrix representation of a Graph,
	// if adjMat[i][j] == true, then you can move from
	// node i to node j.
	// i.e. j is a neighbour of i.

	// The constructor builds the adjacency matrix,
	// with initially all values false.
	public Graph(int size) {
		adjMat = new boolean[size][size];
		for (int i = 0; i < adjMat.length; i++) {
			for (int j = 0; j < adjMat.length; j++) {
				adjMat[i][j] = false;
			}
		}
	}

	// Add a transition to the adjacency matrix,
	// i.e. a neighbor relation between two nodes.
	public void add(int from, int to) {
		adjMat[from][to] = true;
	}

	// Carry out uninformed search of the Graph,
	// from the start node to goal node.
	public boolean search(int start, int goal, boolean dp) {
		// The frontier is an ArrayList of Paths.
		ArrayList<Path> frontier = new ArrayList<Path>();

		// Initially the frontier contains just the Path
		// containing only the start node.
		Path firstPath = new Path(start);
		frontier.add(firstPath);

		// Search until the goal is found,
		// or the frontier is empty.

		// For displaying the path to the goal
		ArrayList<String> pathHistory = new ArrayList<String>();
		String tempPath1 = "" + start;
		pathHistory.add(tempPath1);

		while (!frontier.isEmpty()) {

			// *** TO-DO ***

			// CARRY OUT DEPTH-FIRST OR BREADTH-FIRST SEARCH

			if (dp) {
				// For DEPTH-FIRST-SEARCH
				int last = frontier.size() - 1;
				int element = frontier.get(last).getLastNode();
				frontier.remove(last);

				String currentPath = pathHistory.get(last);
				pathHistory.remove(last);

				System.out.println("Inspect node: " + element);
				boolean[] arr = adjMat[element];
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] == true && i != last) {
						Path tempPath = new Path(i);
						frontier.add(tempPath);
						String newPath = currentPath + ", " + i;
						pathHistory.add(newPath);
					}
				
				}
				if (arr[goal]) {
					System.out.println("Inspect node: " + goal);
					System.out.println("Found goal node!");
					System.out.println("[" + currentPath + ", " + goal + "]");
					return true;
				}

			} else {
				// For BREADTH-FIRST-SEARCH

				// Instead of using "start" I can also use 0 as it's just
				// pointing out the position
				int element = frontier.get(start).getLastNode();
				frontier.remove(start);

				String currentPath = pathHistory.get(start);
				pathHistory.remove(start);

				System.out.println("Inspect node: " + element);
				boolean[] arr = adjMat[element];

				for (int i = 0; i < arr.length; i++) {
					if (arr[i] == true && i != element) {
						Path tempPath = new Path(i);
						frontier.add(tempPath);
						String newPath = currentPath + ", " + i;
						pathHistory.add(newPath);
					}
				}
				if (arr[goal]) {
					System.out.println("Inspect node: " + goal);
					System.out.println("Found goal node!");
					// System.out.println(pathHistory);
					System.out.println("[" + currentPath + ", " + goal + "]");
					// I could have used System.out.println(pathHistory); for
					// the solution to come in [0,2,3,4]
					// But it wouldn't have worked for DFS search so I applied
					// this
					return true;
				}
			}
		}
		return false;

	}

	public static void main(String[] args) {
		// Create a Graph containing 7 nodes
		Graph g = new Graph(7);

		// Add edges to the Graph
		g.add(0, 1);
		g.add(0, 2);
		g.add(1, 5);
		g.add(1, 6);
		g.add(2, 3);
		g.add(3, 4);

		// select a search type
		
		//False --->BFS
		boolean breadthFirst = false;
		// True ---> DFS
		boolean depthFirst = true;

		// start searching
		System.out.println("Depth-first Search:\n");
		g.search(0, 4, depthFirst);

		System.out.println("\nBreadth-first Search:\n");
		g.search(0, 4, breadthFirst);

	}
}