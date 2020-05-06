package wk8.project4;

//TODO: method to allow edges to be added to the graph
//TODO: method to do a depth-first search
//TODO: method to display unreachable vertices


public class DirectedGraph<E> {

    // Some instance variables
    Vertex<E> firstVertex, lastVertex;
    private static int vertices, edges;
    public static int fileEntityCount;


    //===============================================================================================
    //  Static nested Vertex class.
    //===============================================================================================
    private static class Vertex <E>{
        E element;
        Edge<E> firstEdge;
        Vertex<E> nextVertex;
        boolean discovered;

        public Vertex(E label){
            element = label;
            discovered = false;
        }
        public boolean hasNext(){ return (nextVertex != null); }
        public Vertex<E> next(){ return nextVertex; }


    } // end vertex class
    //===============================================================================================
    //  Static nested Edge class.
    //===============================================================================================
    private static class Edge<E>{
        //the vertex that the edge connects to
        Vertex<E> vertex;
        Edge<E> nextEdge;

        public Edge(Vertex<E> v){
            vertex = v;
        }

        public Edge<E> next(){ return nextEdge;}
        public boolean hasNext() { return (nextEdge != null); }

        public String toString(){
            return vertex.element.toString();
        }
    } // end edge class



    public void addVertex(E label){

        if (firstVertex == null){
            firstVertex = new Vertex<>(label);
        } else{
            Vertex<E> current = firstVertex;
            while(current.hasNext()){
                current = current.next();
            }
            current.nextVertex = new Vertex<>(label);
            vertices++;
        }
    }

    public void createEdge(E from, E to) {
        // if the vertex doesnt exist, it gets made, otherwise returned
        Vertex<E> fromVertex = findAddVertex(from);
        Vertex<E> toVertex = findAddVertex(to);

        AddEdge(fromVertex, toVertex);
    }

    private void AddEdge(Vertex<E> fromVertex, Vertex<E> toVertex) {
        //what if the first edge is null?
        if (fromVertex.firstEdge == null){ fromVertex.firstEdge = new Edge<>(toVertex); }
        else{ Edge<E> currentEdge = fromVertex.firstEdge;
            while(currentEdge.hasNext()){
                currentEdge = currentEdge.next();
            }currentEdge.nextEdge = new Edge<>(toVertex);
        }

    }


    public Vertex<E> findAddVertex(E value) {
        if (firstVertex != null) {
            Vertex<E> current = firstVertex;
            if (value == current.element) {
                return current; //check first vertex
            } else {
                while (current.hasNext()) { // loop over all of the vertices
                    if (value == current.element) {
                        return current;
                    } // if we find, return it
                    else {
                        current = current.next();
                    } //update
                }//if it gets here, it doesn't exist. Create it and recall this method
                addVertex(value);
                return findAddVertex(value);
            }
        } else{
            addVertex(value);
            return findAddVertex(value);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Vertex<E> currentVertex = firstVertex;
        while (currentVertex != null) {
            sb.append(currentVertex.element);

            sb.append('\n');
            currentVertex = currentVertex.next();
        }


        return sb.toString();
    }
}

