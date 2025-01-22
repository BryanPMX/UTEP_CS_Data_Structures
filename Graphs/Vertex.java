package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Vertex class represents a node in a graph. It holds details about
 * the connections to other vertices and can store additional metadata.
 */
public class Vertex {
    // Unique identifier for the vertex. Using String to allow flexible vertex naming.
    private String id;

    // List to store adjacent vertices. This simplifies the management of edges in undirected graphs.
    private List<Vertex> adjacencyList;

    // A map to hold arbitrary metadata for the vertex. This allows extending vertex properties dynamically.
    private Map<String, Object> properties;

    /**
     * Constructor for creating a new Vertex with a given identifier.
     * @param id The unique identifier for the vertex.
     */
    public Vertex(String id) {
        this.id = id;
        this.adjacencyList = new ArrayList<>();
        this.properties = new HashMap<>();
    }

    /**
     * Adds an adjacent vertex to the connectivity list. This method ensures that
     * the graph structure can be built by adding edges from this vertex to others.
     * @param vertex The vertex to be added as adjacent.
     */
    public void addAdjacentVertex(Vertex vertex) {
        if (!adjacencyList.contains(vertex)) { // Prevents duplicate edges
            adjacencyList.add(vertex);
        }
    }

    /**
     * Adds or updates a property to this vertex's metadata.
     * @param key The key under which the property is stored.
     * @param value The value of the property.
     */
    public void addProperty(String key, Object value) {
        properties.put(key, value);
    }

    /**
     * Retrieves a property value by key.
     * @param key The key of the property to retrieve.
     * @return The value of the property, or null if not found.
     */
    public Object getProperty(String key) {
        return properties.get(key);
    }

    /**
     * Returns the unique identifier of this vertex.
     * @return The identifier of the vertex.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns a list of all vertices directly connected to this vertex.
     * @return A list of adjacent vertices.
     */
    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }
}