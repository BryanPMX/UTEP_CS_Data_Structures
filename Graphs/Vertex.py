class Vertex:
    def __init__(self, id):
        """
        Initialize a new Vertex with a unique identifier.

        :param id: The unique identifier for the vertex.
        """
        self.id = id
        self.adjacency_list = []  # List to store adjacent vertices
        self.properties = {}      # Dictionary to store properties

    def add_adjacent_vertex(self, vertex):
        """
        Add a vertex to the adjacency list of this vertex.

        :param vertex: The Vertex instance to be added as adjacent.
        """
        if vertex not in self.adjacency_list:
            self.adjacency_list.append(vertex)

    def add_property(self, key, value):
        """
        Adds or updates a property associated with this vertex.

        :param key: The key for the property.
        :param value: The value of the property.
        """
        self.properties[key] = value

    def get_property(self, key):
        """
        Retrieves the property value associated with the specified key.

        :param key: The key of the property to retrieve.
        :return: The value of the property, or None if the key does not exist.
        """
        return self.properties.get(key)

    def __str__(self):
        """
        Return a string representation of the vertex and its connections for easier debugging.
        Lists only the IDs of adjacent vertices.
        """
        adjacent_ids = [v.id for v in self.adjacency_list]  # Get IDs of adjacent vertices
        return f"Vertex({self.id}) --> {adjacent_ids}"

# Example of using the Vertex class
if __name__ == "__main__":
    # Create vertices
    v1 = Vertex("1")
    v2 = Vertex("2")
    v3 = Vertex("3")

    # Add edges
    v1.add_adjacent_vertex(v2)
    v1.add_adjacent_vertex(v3)

    # Print vertex
    print(v1)
