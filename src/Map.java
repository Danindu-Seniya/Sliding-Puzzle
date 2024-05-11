//Name: N.M.P.J.D.S.B. Nawarathna
//Student ID: w1999511 / 20221681

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Map {
    private int width;
    private int height;
    private Node[][] grid;
    private Node start;
    private Node finish;

//    Read the input data
    public void parseMapFromFile(String filename) throws IOException {

        // Read the map data from the input file
        try(BufferedReader reader = new BufferedReader(new FileReader(filename));){
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();

        // Determine the width and height of the map
         height = lines.size();
         width = lines.get(0).length();

        // Create a grid to store map data
        grid = new Node[height][width];

        // Parse each character in the map data and create corresponding Node objects
        for (int i = 0; i < height; i++) {
            line = lines.get(i);
            for (int j = 0; j < width; j++) {
                char letter = line.charAt(j);
                switch (letter) {
                    case 'S':
                        start = new Node(j, i, "start");
                        grid[i][j] = start;
                        break;
                    case '.':
                        grid[i][j] = new Node(j, i, "ice");
                        break;
                    case 'F':
                        finish = new Node(j, i, "finish");
                        grid[i][j] = finish;
                        break;
                    case '0':
                        grid[i][j] = new Node(j, i, "rock");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid character in map: " + letter);
                }
            }
        }}catch (IOException e){
            e.printStackTrace();
        }

    }

//    Print the map
    public void printMap(){

        for (Node[] row: grid
             ) {

            for (Node node: row
                 ) {

                String type = node.getType();
                switch (type) {
                    case "start":
                        System.out.print("S");
                        break;
                    case "ice":
                        System.out.print(".");
                        break;
                    case "finish":
                        System.out.print("F");

                        break;
                    case "rock":
                        System.out.print("O");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid character in map: " + type);
                }
            }
            System.out.println();

        }

    }


//    Find the shortest path
    public List<Node> getShortestPath(){

//        Check if the start and finish nodes are available
        if(start == null || finish ==  null){
//            todo: throw an error
            throw new IllegalArgumentException("Start and finish nodes are not available in the map.");
        }


        PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparingInt(a->a.getCost()));

//        Initiate start nodes
        start.setCost(getManhattanDistance(start, finish));

        pq.add(start);

        while(!pq.isEmpty()){

            Node current = pq.poll();

            current.setVisited();

            if(finish.equals(current)){
                return tracePath(current);
            }


//           get the list of  neighboring nodes
            List<Node> neighboringNodes = getNeighboringNodes(current);

            for (Node neighbor:   neighboringNodes
                 ) {


                if(neighbor != null){
                if(  !neighbor.getVisited() ){
                    if(!pq.contains(neighbor)){

//                   Set the neighboring node
                    int gCost = getManhattanDistance(start, neighbor);
                    int hCost   = getManhattanDistance(finish, neighbor);
                    neighbor.setCost(gCost + hCost);

                    neighbor.setParent(current);
//                    Add to the pq
                    pq.add(neighbor);

                }}}

            }


        }


//        Return an empty arrayList if no path found
return Collections.emptyList();
    }









//    Trace the path back
    private List<Node> tracePath(Node node){
        List<Node> trace = new ArrayList<Node>();
        while(node != null){
            trace.add(node);
            node = node.getParent();
        }
        Collections.reverse(trace);
        return trace;
    }


//   Calculate manhattan distance
    private int getManhattanDistance(Node one, Node two){
        return (Math.abs(one.getX() - two.getX()) + Math.abs(one.getY() - two.getY()));
    }


//    Get the neighboring nodes according to the rules and current node
    List<Node> getNeighboringNodes(Node current){

        List<Node> nodes = new ArrayList<Node>();

        int lastY = grid.length-1;
        int lastX = grid[0].length -1;

//        Go to all the 4 directions
        for(int a = 0; a < 4; a++){
            int x = current.getX();
            int y = current.getY();

            switch (a){
                case(0): // Up
                    while( y >=0){
                        if(y == 0 || Objects.equals(grid[y - 1][x].getType(), "rock") || Objects.equals(grid[y][x].getType(), "finish")){
                            nodes.add(grid[y][x]);
                            break;
                        }
                    y--;
                    }
                break;

                case(1): // Down
                    while( y <= lastY ){
                        if(y == lastY || Objects.equals(grid[y + 1][x].getType(), "rock") || Objects.equals(grid[y][x].getType(), "finish")){
                            nodes.add(grid[y][x]);
                            break;
                        }
                        y++;
                    }
                    break;


                case(2): // Left
                    while( x >=0){
                        if(x == 0 || Objects.equals(grid[y][x - 1].getType(), "rock") || Objects.equals(grid[y][x].getType(), "finish")){
                            nodes.add(grid[y][x]);
                            break;
                        }
                        x--;
                    }
                    break;


                case(3): // Right
                    while( x <= lastX){
                        if(x == lastX || Objects.equals(grid[y][x + 1].getType(), "rock") || Objects.equals(grid[y][x].getType(), "finish")){
                            nodes.add(grid[y][x]);
                            break;
                        }
                        x++;
                    }
                    break;
            }
        }

    return  nodes;
    }





}
