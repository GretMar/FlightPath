Flight Path with Dijkstra Algorithm

For: Price Point, coding assessment

Author: Gretchen Marie

References: https://github.com/westonjackson/FlightPath

Program to find all flight paths and prices between cities, sorted by price

***
IMPORTANT NOTE:

I understand this project is not entirely complete. I used a project called FlightPath from GitHub (referenced above) as a skeleton.
Weston's FlightPath project is meant to calculate the shortest path between cities and display them in a GUI based on JComboBox.
Because his algorithm was geared with quite a different purpose, it would cost me about 2 more days to figure it out and rewrite the algorithm.
1. I would try to display ALL paths instead of looking for the shortest one and tossing the rest, like Weston's program does.
2. I'd also use a simple sort() method to sort the displayed paths by price, as outlined in the description.

I believe these are the only 2 elements missing from my program.

ISSUES:

I highly recommend IntelliJ for viewing the code, since other IDEs such as VSC cannot read or write Java well. When you run via WSL for Linux, do NOT click run within the IDE. This would result in duplicated outputs.
***

INSTRUCTIONS

This program can simply be run within the IDE if you wish to pull up the code. Running within the IDE is more user-friendly in that it's more readable with a better UI than looking at a Linux list. This way you can open the text files to view changes and compare output.txt to actualOutput.txt using the Compare Files tool (Ctrl+D on Windows IntelliJ).

Run Flight.java using Linux:
1. Open WSL (Windows subsystem for Linux)
2. cd into the GraphStructurePractice folder, wherever you saved it. 
For example, my Linux path starts as G5-Laptop:/mnt/host/c/Users/missu/IdeaProjects/GraphStructurePractice#
3. Read over the following command to ensure the java.exe is in the correct path for your computer. If you do not have Java version 11.0.8 installed, I recommend installing it to avoid uneccessary version conflicts with the program. Run:

   /mnt/host/c/"Program Files"/Java/jdk-11.0.8/bin/j
   ava.exe -classpath out/production/GraphStructurePractice Flight < input.txt > actualOutput.txt 2> actualError.txt ; diff
   output.txt actualOutput.txt ; diff error.txt actualError.txt

OUTPUT

The output will display the differences between output.txt (the expected output) and actualOutPut.txt (actual output). It also displays the differences between error.txt and actualError.txt. I had a JUnit thought process here. The IDE also updates with these changes so you can run the program on Linux, then view and compare the files in IntelliJ.
***
Flight.java

This class instantiates variables used to calculate and display paths and prices. It imports the input.txt file and calls the Dijkstra.java class to process the file's data for paths and prices.

Dijkstra.java

This class implements dijkstra's algorithm. It reads in a file of cities, distances, and durations in creating the inner graph. One of the most important fields for this class is the "cityList" hashMap. This field allows a city's name, in the form of a string, to then map to a vertex in the inner graph.
See comments within the code for details on adding to the hashmap and arraylists, searching through them, and accessing vertexes.
Also note that comments of sysout lines with "-------" are just debugging tools.


Vertex.java

The vertex class contains fields for both Kruskal's (not used in my program) and Dijkstra's algorithm. Because this class could be used for both programs in Weston's program, making it a separate class worked better than using it as an inner class. Finally, the class contains accessor and mutator methods that will allow the vertex fields to be updated and accessed.
