from Vertex import *

class Edge:
    """
    Represents an edge in a graph connecting two vertices, optionally with a weight and direction.
    """

    def __init__(self, start_vertex, end_vertex, weight=1, is_directed=False):
        """
        Initializes a new Edge.

        :param start_vertex: The starting vertex of the edge.
        :param end_vertex: The ending vertex of the edge.
        :param weight: The weight of the edge, defaults to 1.
        :param is_directed: Boolean indicating if the edge is directed, defaults to False.
        """
        self.start_vertex = start_vertex  # The starting point of the edge
        self.end_vertex = end_vertex      # The endpoint of the edge
        self.weight = weight              # Weight of the edge, useful for weighted graphs
        self.is_directed = is_directed    # Indicates if the edge is directed

    def __str__(self):
        """
        Provides a string representation of the edge, including its direction and weight.
        """
        direction = "->" if self.is_directed else "--"
        return f"{self.start_vertex.id} {direction} {self.end_vertex.id} [Weight: {self.weight}]"

# Example of using the Edge class
if __name__ == "__main__":
    # Create vertices
    v1 = Vertex("1")
    v2 = Vertex("2")

    # Create an edge
    e1 = Edge(v1, v2, weight=2, is_directed=True)

    # Print edge
    print(e1)
