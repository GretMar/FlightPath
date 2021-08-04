import java.util.ArrayList;
import java.util.Scanner;

public class FlightImage {
    String origin;
    String dest;
    double mileage;
    double duration;
    
    FlightImage(String origin, String dest, double mileage, double duration) {
        this.origin = origin;
        this.dest = dest;
        this.mileage = mileage;
        this.duration = duration;
    }
    
    @Override
    public String toString() {
        return origin + "," + dest + "," + mileage + "," + duration;
    }
    
    ;
    
    
    public static void main(String[] args) {
        try { //try with resources, look up later
            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //FileWriter writer = new FileWriter("output.txt");
            Scanner scanner = new Scanner(System.in);
            ArrayList<FlightImage> flights = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //create substring up to first space (if command, then), then trim the substring off, separate by comma
                String[] tokens = line.split(" ", 2); //0 is command, 1 is rest of line
                String command = tokens[0];
                String[] params = tokens[1].split(","); //params[0] is origin
                String originCity = params[0];
                String destCity = params[1];
                if (command.equals("ADD") && params.length == 4) {
                    FlightImage newFlight = new FlightImage(originCity, destCity, Double.valueOf(params[2]), Double.valueOf(params[3]));
                    System.out.println("EDGE " + newFlight.toString());
                    
                    flights.add(newFlight);
                    
                } else if (command.equals("QUERY")) {
                    for (FlightImage flight : flights) {
                        if (originCity.equals(flight.origin) && destCity.equals(flight.dest)) {
                            System.out.println(line);
                            double cost = (flight.mileage * 15) + (flight.duration * 30);
                            System.out.printf("PATH %.2f,%s,%s\n", cost, originCity, destCity);
                        }
                        
                    }
                } else {
                    System.err.println("MALFORMED " + command + "," + tokens[1]);
                }
            }
            //reader.close();
            //writer.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
            
            //Flight flightObj = new Flight();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}


