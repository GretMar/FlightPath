/*
This is the class that implements Dijkstra's algorithm
by Weston Jackson
wjj2106
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dijkstra {
    public ArrayList<Vertex> theList;            //The vertices
    public ArrayList<Vertex> path;                //The optimal path
    public File infile;
    public Scanner in;
    public HashMap<String, Vertex> cityList;    //vertex, city-name map
    
    public Dijkstra(File f) throws FileNotFoundException {
        infile = f;
        in = new Scanner(infile);
        cityList = new HashMap<String, Vertex>();
        theList = new ArrayList<Vertex>();
        path = new ArrayList<Vertex>();
        makeGraph();
    }
    
    //returns # of cities
    public int size() {
        return cityList.size();
    }
    
    //returns hashMap of city names and vertices
    public HashMap<String, Vertex> getMap() {
        return cityList;
    }
    
    //returns the optimal path
    //------NEED TO RETURN ALL PATHS------
    public ArrayList<Vertex> getList() {
        return theList;
    }
    
    //creates the graph using the file information
    public void makeGraph() {
        while (in.hasNextLine()) {
            
            String line = in.nextLine();
            //create substring up to first space (if command, then), then trim the substring off, separate by comma
            String[] tokens = line.split(" ", 2); //0 is command, 1 is rest of line
            String command = tokens[0];
            String[] params = tokens[1].split(","); //params[0] is origin
            String originCity = params[0];
            String destCity = params[1];
            
            if (command.equals("ADD") && params.length == 4) {
                double distance = Double.valueOf(params[2]);
                double duration = Double.valueOf(params[3]);
                double price = (distance * 15) + (duration * 30);
                //see if start city is already in hashmap
                if (cityList.containsKey(originCity)) {
                    Vertex v1 = cityList.get(originCity);
                    
                    //if endCity city is not in map, add it
                    if (!cityList.containsKey(destCity)) {
                        Vertex x = new Vertex(destCity);
                        cityList.put(destCity, x);
                    }
                    Vertex v2 = cityList.get(destCity);
                    
                    
                    //add a path to adjacency list
                    v1.addEdge(v2, distance, duration, price);
                    System.out.println("EDGE: " + originCity + "," + destCity + "," + distance + "," + duration);
                }
                
                //if start city is not in hashmap, add it
                else if (!cityList.containsKey(originCity)) {
                    Vertex v1 = new Vertex(originCity);
                    
                    //if endCity city is not in map, add it
                    if (!cityList.containsKey(destCity)) {
                        Vertex x = new Vertex(destCity);
                        cityList.put(destCity, x);
                    }
                    Vertex v2 = cityList.get(destCity);
                    
                    //add a path to adjacency list
                    v1.addEdge(v2, distance, duration, price);
                    System.out.println("EDGE: " + originCity + "," + destCity + "," + distance + "," + duration);
                    
                    //add start city to hashmap
                    cityList.put(originCity, v1);
                }
            } else if (command.equals("QUERY")) {
                cityList.forEach((cityName, city) -> {
                    if (originCity.equals(cityName)) {
                        //System.out.println("-------" + originCity + " - " + cityName);
                        if (city.adjacencyList.contains(cityList.get(destCity))) {
                            //System.out.println("-------" + destCity + " - " + cityName);
                            double distanceQuery = city.distances.get(city.adjacencyList.indexOf(cityList.get(destCity)));
                            double durationQuery = city.durations.get(city.adjacencyList.indexOf(cityList.get(destCity)));
                            System.out.println(line);
                            double cost = (distanceQuery * 15) + (durationQuery * 30);
                            System.out.printf("PATH %.2f,%s,%s\n", cost, originCity, destCity);
                        }
                    }
                });
                {
                
                    
                }
            } else {
                System.err.println("MALFORMED " + command + "," + tokens[1]);
            }
        }

//        Collection<Vertex> vertices = cityList.values();
//        Iterator<Vertex> it = vertices.iterator();
//
//        for (int i = 0; i < vertices.size(); i++) {
//            //create the list of vertices from the hashmap
//            theList.add(it.next());
//        }
        
    }
    
    //dijkstras algorithm
//    public void findPath(String city) {
//        MyMinHeap<Vertex> heap = new MyMinHeap<Vertex>(); //stores path lengths & looks for minimum distance??
//        //reset vertices
//        for (int i = 0; i < theList.size(); i++) {
//            Vertex v = theList.get(i);
//            v.setKnown(false);
//            v.setDist(Double.POSITIVE_INFINITY);
//            v.setPath(null);
//            heap.insert(v);
//        }
//
//        //decrease key of starting vertex
//        Vertex start = cityList.get(city);
//        Vertex x = start;
//        start.setDist(0);
//        heap.decreaseKey(x, start);
//
//
//        for (; ; ) {
//            Vertex v = heap.deleteMin();                //get closest vertex
//            v.setKnown(true);
//            for (int i = 0; i < v.getList().size(); i++) {
//                Vertex w = v.getList().get(i);            //get adjacent vertices
//                if (!w.getKnown()) {
//                    double cost = v.getDistances().get(i);
//                    if (cost + v.getDist() < w.getDist()) {        //compare costs
//                        Vertex old = w;
//                        w.setDist(v.getDist() + cost);
//                        w.setPath(v);
//                        heap.decreaseKey(old, w);
//                    }
//
//                    //new vertex is found
//                    else if (w.getDist() == Double.POSITIVE_INFINITY) {
//                        Vertex old = w;
//                        w.setDist(cost + v.getDist());
//                        w.setPath(v);
//                        heap.decreaseKey(old, w);
//                    }
//                }
//            }
//
//            if (heap.isEmpty())
//                break;
//        }
//    }
//
//    //Use recursion to get shortest path to city
//    public void setPath(String city) {
//        path.clear();
//        Vertex v = cityList.get(city);
//        setPath(v);
//    }
//
//    //find path shortest recursively
//    public void setPath(Vertex v) {
//        if (v.getPath() != null) {
//            setPath(v.getPath());
//            path.add(v);
//        } else
//            path.add(v);
//    }
//
//    //returns the path distance
//    public double getDistance(String city) {
//        return getDistance(cityList.get(city));
//    }
//
//    public double getDistance(Vertex v) {
//        return v.getDist();
//    }
//
//    //returns the path as an arrayList of vertices
//    public ArrayList<Vertex> getPath() {
//        return path;
//    }
}
