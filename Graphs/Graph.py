from Vertex import *
from Edge import *

class Graph:
    """
    Represents a graph, managing its vertices and edges.
    """

    def __init__(self):
        """
        Initializes a new empty Graph.
        """
        self.vertices = {}  # dictionary to hold vertices keyed by vertex id

    def add_vertex(self, vertex):
        """
        Add a vertex to the graph.

        :param vertex: The Vertex to add.
        """
        if vertex.id not in self.vertices:
            self.vertices[vertex.id] = vertex
        else:
            print(f"Vertex {vertex.id} already exists.")

    def add_edge(self, start_id, end_id, weight=1, is_directed=False):
        """
        Add an edge to the graph between two vertices.

        :param start_id: The starting vertex id.
        :param end_id: The ending vertex id.
        :param weight: The weight of the edge, defaults to 1.
        :param is_directed: Boolean indicating if the edge is directed, defaults to False.
        """
        start_vertex = self.vertices.get(start_id)
        end_vertex = self.vertices.get(end_id)
        if start_vertex and end_vertex:
            edge = Edge(start_vertex, end_vertex, weight, is_directed)
            start_vertex.add_adjacent_vertex(end_vertex)
            if not is_directed:
                end_vertex.add_adjacent_vertex(start_vertex)
        else:
            print(f"One or both vertices not found: {start_id}, {end_id}")

    def get_vertex(self, vertex_id):
        """
        Retrieve a vertex by its ID.

        :param vertex_id: The ID of the vertex to retrieve.
        :return: The vertex if found, None otherwise.
        """
        return self.vertices.get(vertex_id)

    def display_graph(self):
        """
        Display the graph as adjacency list for each vertex.
        """
        for vertex in self.vertices.values():
            # Create a list of the IDs of the adjacent vertices
            adjacent_ids = [adj_vertex.id for adj_vertex in vertex.adjacency_list]
            # Print the vertex and the list of adjacent vertex IDs
            print(f"{vertex} -> {adjacent_ids}")


# Example of using the Graph class
if __name__ == "__main__":
    # Create a graph instance
    graph = Graph()

    # Test adding vertices
    vertices = ["1", "2", "3", "4"]
    for v in vertices:
        graph.add_vertex(Vertex(v))

    # Test adding duplicate vertex
    print("Adding duplicate vertex '1':")
    graph.add_vertex(Vertex("1"))

    # Test adding edges
    print("\nAdding edges:")
    graph.add_edge("1", "2", weight=2)
    graph.add_edge("1", "3", weight=3)
    graph.add_edge("2", "4", weight=1)
    graph.add_edge("3", "4", weight=4, is_directed=True)

    # Test adding edge with non-existing vertices
    print("\nAdding edge with non-existing vertices '5' to '6':")
    graph.add_edge("5", "6", weight=2)

    # Test adding edge to existing and non-existing vertex
    print("\nAdding edge from '2' to non-existing vertex '5':")
    graph.add_edge("2", "5", weight=1)

    # Displaying the graph
    print("\nCurrent Graph Structure:")
    graph.display_graph()

    # Retrieve and display properties of a vertex
    print("\nProperties of vertex '1':")
    v1 = graph.get_vertex("1")
    if v1:
        v1.add_property("color", "blue")
        print(f"Color: {v1.get_property('color')}")
    else:
        print("Vertex '1' not found.")

    # Displaying the graph with properties
    print("\nGraph with properties on vertices:")
    graph.display_graph()

