package com.example.shortestpathfinder;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class GraphController {
    private final Map<String, Node> nodeMap = new HashMap<>();

    @PostMapping("/graph")
    public void receiveGraph(@RequestBody Graph graph) {
        nodeMap.clear();
        for (Node node : graph.getNodes()) {
            nodeMap.put(node.getId(), node);
        }
        for (Edge edge : graph.getEdges()) {
            Node sourceNode = nodeMap.get(edge.getSource());
            Node targetNode = nodeMap.get(edge.getTarget());
            sourceNode.addOutgoingEdge(targetNode, edge.getWeight());
        }
    }

    @GetMapping("/shortest-path")
    public List<Node> getShortestPath(@RequestParam String sourceId, @RequestParam String targetId) {
        Node sourceNode = nodeMap.get(sourceId);
        Node targetNode = nodeMap.get(targetId);

        Map<Node, Integer> distance = new HashMap<>();
        Map<Node, Node> parent = new HashMap<>();

        // Initialize the distance map
        for (Node node : nodeMap.values()) {
            distance.put(node, Integer.MAX_VALUE);
        }
        distance.put(sourceNode, 0);

        // Initialize the priority queue with the source node
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));
        queue.offer(sourceNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == targetNode) {
                break;
            }

            for (Map.Entry<Node, Integer> entry : node.getOutgoingEdges().entrySet()) {
                Node neighbor = entry.getKey();
                int weight = entry.getValue();
                int newDistance = distance.get(node) + weight;
                if (newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);
                    parent.put(neighbor, node);
                    queue.offer(neighbor);
                }
            }
        }

        // Reconstruct the path from the target node to the source node
        List<Node> path = new ArrayList<>();
        Node currentNode = targetNode;
        while (currentNode != null) {
            path.add(currentNode);
            currentNode = parent.get(currentNode);
        }
        Collections.reverse(path);

        return path;
    }


}
