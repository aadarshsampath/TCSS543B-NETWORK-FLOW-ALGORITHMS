package graphs1;
public class Edge {
    /** the first endpoint of the edge */
    private Vertex v1;
    
    /** the second endpoint of the edge */
    private Vertex v2;
    
    private Object data;  // an object associated with this edge
    private Object name;  // a name associated with this edge
    
    /**
     * Constructor that allows data and a name to be associated
     * with the edge.
     * @param v     the first endpoint of this edge
     * @param w     the second endpoint of this edge
     * @param data  data to be associated with this edge
     * @param name  a name to be associated with this edge
     */
    public Edge (Vertex v, Vertex w, Object data, Object name) {
        this.data = data;
        this.name = name;
        this.v1 = v;
        this.v2 = w;
    }

    /**
     * Return the first endpoint of this edge.
     * @return  the first endpoint of this edge
     */
    public Vertex getFirstEndpoint() {
        return this.v1;
    }

    /**
     * Return the second endpoint of this edge.
     * @return  the second endpoint of this edge
     */
    public Vertex getSecondEndpoint() {
        return this.v2;
    }

    /**
     * Return the data associated with this edge.
     * @return  the data of this edge
     */
    public Object getData() {
        return this.data;
    }
        
    /**
     * Set the data associated with this edge.
     * @param data  the data of this edge
     */
    public void setData(Object data) {
        this.data = data;
    }
    
    /**
     * Return the name associated with this edge.
     * @return  the name of this edge
     */
    public Object getName() {
        return this.name;
    }
    
    public void setName(Object data) {
        this.name=data;
    }
    
}
