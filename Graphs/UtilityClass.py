from Graph import *

class UtilityClass:
    @staticmethod
    def find_path(graph, start_id, end_id):
        """
        Find a simple path from start vertex to end vertex using BFS.

        :param graph: The Graph instance.
        :param start_id: ID of the start vertex.
        :param end_id: ID of the end vertex.
        :return: List of vertex IDs representing the path, or None if no path found.
        """
        visited = set()
        queue = [(start_id, [start_id])]

        while queue:
            current, path = queue.pop(0)
            if current == end_id:
                return path
            if current not in visited:
                visited.add(current)
                for neighbor in graph.get_vertex(current).adjacency_list:
                    if neighbor.id not in visited:
                        queue.append((neighbor.id, path + [neighbor.id]))

        return None

    @staticmethod
    def vertex_degree(vertex):
        """
        Return the degree of a vertex.

        :param vertex: The Vertex instance.
        :return: Degree of the vertex.
        """
        return len(vertex.adjacency_list)

    @staticmethod
    def graph_summary(graph):
        """
        Provide a summary of the graph including number of vertices and edges.

        :param graph: The Graph instance.
        :return: A string summarizing the graph.
        """
        vertices_count = len(graph.vertices)
        edges_count = sum(len(v.adjacency_list) for v in graph.vertices.values()) // 2
        return f"Graph has {vertices_count} vertices and {edges_count} edges."

# Example of using the GraphUtility class
if __name__ == "__main__":
    graph = Graph()
    # Add vertices and edges as previously shown
    for v in ['A', 'B', 'C', 'D']:
        graph.add_vertex(Vertex(v))
    graph.add_edge('A', 'B')
    graph.add_edge('B', 'C')
    graph.add_edge('C', 'D')
    graph.add_edge('D', 'A')

    # Test utility methods
    print("Path from A to C:", UtilityClass.find_path(graph, 'A', 'C'))
    print("Degree of vertex B:", UtilityClass.vertex_degree(graph.get_vertex('B')))
    print(UtilityClass.graph_summary(graph))
