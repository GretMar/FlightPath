/*
This is the vertex class for Dijkstra's/Kruskal's algorithm
by Weston Jackson
wjj2106
*/

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>{
	public ArrayList<Vertex> adjacencyList;	//adjacent vertices
	public ArrayList<Double> distances;		//distances to vertices
	public ArrayList<Double> durations;		//durations to vertices
	public ArrayList<Double> prices;		//prices of edges
	public boolean known;						//field for dijkstras
	public String name;						//city name
	public Vertex path;						//previous node for dijkastras
	public double dist;						//distance to path node
	public int number;							//int label for kruskal's
	public int x;								//coordinates
	public int y;
	
	//constructor for no city name
	public Vertex(){
		adjacencyList = new ArrayList<Vertex>();
		distances = new ArrayList<Double>();
		durations = new ArrayList<Double>();
		prices = new ArrayList<Double>();
		known = false;
		dist = -1;
		path = null;
	}
	
	//constructor for city name
	public Vertex(String n){
		name = n;
		adjacencyList = new ArrayList<Vertex>();
		distances = new ArrayList<Double>();
		durations = new ArrayList<Double>();
		prices = new ArrayList<Double>();
		known = false;
		dist = -1;
		path = null;
	}
	
	//vertex must be comparable
	public int compareTo(Vertex other){
		if(this.dist<other.dist)
			return -1;
		if(this.dist>other.dist)
			return 1;
		else
			return 0;
	}
	
	//add another adjacent vertex
	public void addEdge(Vertex v, double dist, double dur, double price){
		adjacencyList.add(v);
		distances.add(dist);
		durations.add(dur);
		prices.add(price);
	}
	
	//X-coordinate methods
	public void setX(int x){
		this.x=x;
	}
	public int getX(){
		return x;
	}
	
	//Y-coordinate methods
	public void setY(int y){
		this.y=y;
	}
	public int getY(){
		return y;
	}
	
	//distance to previous node in Dijkstra path
	public double getDist(){
		return dist;
	}
	public void setDist(double d){
		dist = d;
	}
	
	//previous node in Dijkstra path
	public Vertex getPath(){
		return path;
	}
	public void setPath(Vertex v){
		path = v;
	}
	
	//known field for Dijkstra's algorithm
	public void setKnown(boolean x){
		known = x;
	}
	public boolean getKnown(){
		return known;
	}
	
	//accessor for adjacency list
	public ArrayList<Vertex> getList(){
		return adjacencyList;
	}
	
	//accessor for distances to vertices
	public ArrayList<Double> getDistances(){
		return distances;
	}
	
	//accessor for city name
	public String getName(){
		return name;
	}
	
	//field for kruskal's algorithm
	public void setNumber(int n){
		number = n;
	}
	public int getNumber(){
		return number;
	}
}
