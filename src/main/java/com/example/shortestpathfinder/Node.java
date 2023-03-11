package com.example.shortestpathfinder;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private String id;
    private String label;
    private Map<Node, Integer> outgoingEdges = new HashMap<>();

    public Node() {
    }

    public Node(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public void addOutgoingEdge(Node target, int weight) {
        outgoingEdges.put(target, weight);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Map<Node, Integer> getOutgoingEdges() {
        return outgoingEdges;
    }

    public void setOutgoingEdges(Map<Node, Integer> outgoingEdges) {
        this.outgoingEdges = outgoingEdges;
    }

    // Add getters and setters for the id and label
}
