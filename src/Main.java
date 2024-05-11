//Name: N.M.P.J.D.S.B. Nawarathna
//Student ID: w1999511 / 20221681

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFile = "input/map.txt"; // Input file path

        Map map = new Map();


        try {
            // Parse the map from the input file
           map.parseMapFromFile(inputFile);

            // Display the parsed map (for testing)
            map.printMap();

//            Find the shortest path
            List<Node> shortestPath =  map.getShortestPath();

//            Print the path
            if(shortestPath.isEmpty()){
                System.out.println("\nNo path found !!!");
            }
            else {
                System.out.println("\nPath found !!!");

                for(int i = 0 ; i < shortestPath.size()+1 ; i++){
                    if(i == 0){
                        System.out.println((i+1) + ". start at  (" + (shortestPath.get(i).getX() + 1) + "," + (shortestPath.get(i).getY() + 1) + ")");
                    }else if(i < shortestPath.size()) {
                        int xDifference  = shortestPath.get(i).getX() -  shortestPath.get(i-1).getX();
                        int yDifference  = shortestPath.get(i).getY() -  shortestPath.get(i-1).getY();

                        if(xDifference > 0){
                            System.out.println((i+1) + ". move right to  (" + (shortestPath.get(i).getX() + 1) + "," + (shortestPath.get(i).getY() + 1) + ")");
                        }else if(xDifference < 0){
                            System.out.println((i+1) + ". move left to  (" + (shortestPath.get(i).getX() + 1) + "," + (shortestPath.get(i).getY() + 1) + ")");
                        } else if (yDifference > 0) {
                            System.out.println((i+1) + ". move down to  (" + (shortestPath.get(i).getX() + 1) + "," + (shortestPath.get(i).getY() + 1) + ")");
                        }else if(yDifference < 0) {
                            System.out.println((i + 1) + ". move up to  (" + (shortestPath.get(i).getX() + 1) + "," + (shortestPath.get(i).getY() + 1) + ")");
                        }

                    }else {
                        System.out.println((i+1) + " Done.");

                    }

                }


            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
