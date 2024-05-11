# Pathfinding Algorithm for Ice Sliding Puzzles

This project implements a pathfinding algorithm in Java specifically designed to solve puzzles commonly encountered in video games. The algorithm efficiently navigates through maps with obstacles and frictionless surfaces to determine the shortest path from a starting point to a designated finish point.

## Features
- **Pathfinding Algorithm**: Implements the A* algorithm to find the shortest path on maps with varying terrain types.
- **Map Parsing**: Includes a parser to interpret map data from input files, determining the width, height, start, finish, and obstacle locations.
- **Data Structures**: Utilizes priority queues and hash sets to optimize traversal efficiency and memory usage.
- **Path Visualization**: Prints the steps taken to reach the finish point, demonstrating the algorithm's traversal path.

## Usage
1. Clone the repository to your local machine.
2. Compile the Java files using a Java compiler.
3. Run the `Main.java` file, specifying the input map file path as a command-line argument.

```bash
java Main input/map.txt
```

4. View the output to see the parsed map and the shortest path from start to finish.

## Benchmark Examples
Included in the `input` directory are benchmark map files for testing the algorithm's performance. These files contain various map configurations to evaluate the algorithm under different scenarios.

## Performance Analysis
The project includes an analysis of the algorithm's time and space complexities. The A* algorithm's time complexity is O((|N| + |E|) log |N|), while the space complexity is O(N), where N is the number of nodes in the grid.

## Contributing
Contributions are welcome! Feel free to submit bug fixes, improvements, or new features via pull requests. For major changes, please open an issue first to discuss potential updates.



