# Shortest Path Finder
This project is a shortest path finder implemented with a React front-end and a Spring Boot back-end.

# Features
Implements Dijkstra's shortest path algorithm.
Visualizes the shortest path on a grid.
Allows the user to modify the start and end nodes on the grid.
Uses React for the front-end and Spring Boot for the back-end.
# Installation
## Prerequisites
1. Node.js
2. Java Development Kit (JDK)
3. Maven
## Steps
1. Clone this repository to your local machine.
2. Navigate to the shortest-path-finder-ui directory and run npm install to install the necessary dependencies.
3. Navigate to the shortest-path-finder-api directory and run mvn clean install to build the back-end.
4. Run java -jar target/shortest-path-finder-api-0.0.1-SNAPSHOT.jar to start the back-end.
5. Run npm start in the shortest-path-finder-ui directory to start the front-end.
## Usage
Once the application is running, you can access the front-end by opening a web browser and navigating to http://localhost:3000.

To use the shortest path finder:

1. Click on a node in the grid to set it as the starting node.
2. Click on another node in the grid to set it as the ending node.
3. Click on any number of nodes in the grid to set them as obstacles.
4. Click the "Find Shortest Path" button to calculate and visualize the shortest path between the starting and ending nodes.
## Contributing
Contributions are welcome! To contribute, please fork this repository, make your changes, and submit a pull request.
