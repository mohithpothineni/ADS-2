/**
 * Class for digraph.
 */
public class Digraph {

    /**
     * seperator in tostring method.
     */
    private static final String NEWLINE = System.getProperty("line.separator");

    /**
     * number of vertices in this digraph.
     */
    private final int vertices;
    /**
     * number of edges in this digraph.
     */
    private int edges;
    /**
     * adj[v] = adjacency list for vertex v.
     */
    private Bag<Integer>[] adj;
    /**
     * indegree[v] = indegree of vertex v.
     */
    private int[] indegree;

    /**
     * outdegree[v] = outdegree of vertex v.
     */
    private int[] outdegree;

    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     * @param  v the number of vertices
     */
    public Digraph(final int v) {
        vertices = v;
        edges = 0;
        indegree = new int[vertices];
        outdegree = new int[vertices];
        adj = (Bag<Integer>[]) new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    /**
     * Returns the number of vertices in this digraph.
     * @return the number of vertices in this digraph
     * Time complexity is O(1).
     */
    public int vertices() {
        return vertices;
    }
    /**
     * Returns the number of edges in this digraph.
     * @return the number of edges in this digraph
     * Time complexity is O(1).
     */
    public int edges() {
        return edges;
    }
    /**
     * Adds the directed edge v→w to this digraph.
     * @param  v the tail vertex
     * @param  w the head vertex
     * Time complexity is O(1).
     */
    public void addEdge(final int v, final int w) {
        adj[v].add(w);
        outdegree[v]++;
        indegree[w]++;
        edges++;
    }
    /**
     * Returns the vertices adjacent from
     * vertex {@code v} in this digraph.
     * @param  v the vertex
     * @return the vertices adjacent from vertex
     * {@code v} in this digraph, as an iterable
     * Time complexity is O(v).
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
    /**
     * Returns the number of directed edges
     * incident to vertex {@code v}.
     * This is known as the <em>indegree</em>
     * of vertex {@code v}.
     * @param  v the vertex
     * @return the indegree of vertex {@code v}
     * Time complexity is O(1).
     */
    public int indegree(final int v) {
        return indegree[v];
    }
    /**
     * Returns the number of directed edges
     * out from vertex {@code v}.
     * This is known as the <em>outdegree</em>
     * of vertex {@code v}.
     * @param  v the vertex
     * @return the outdegree of vertex {@code v}
     * Time complexity is O(1).
     */
    public int outdegree(final int v) {
        return outdegree[v];
    }
    /**
     * Returns a string representation of the graph.
     *
     * @return the number of vertices <em>V</em>,
     * followed by the number of edges <em>E</em>,
     * followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " vertices, " + edges + " edges " + NEWLINE);
        for (int v = 0; v < vertices(); v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
