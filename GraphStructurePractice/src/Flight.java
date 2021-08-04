import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Flight {
    String origin;
    String dest;
    double mileage;
    double duration;
    
    Flight(String origin, String dest, double mileage, double duration) {
        this.origin = origin;
        this.dest = dest;
        this.mileage = mileage;
        this.duration = duration;
    }
    
    @Override
    public String toString() {
        return origin + "," + dest + "," + mileage + "," + duration;
    }
    
    
    public static void main(String[] args) {
        try { //try with resources, look up later
            //import file
            File inputFlights = new File("input.txt");
            Dijkstra d = new Dijkstra(inputFlights);
        } catch (NumberFormatException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


