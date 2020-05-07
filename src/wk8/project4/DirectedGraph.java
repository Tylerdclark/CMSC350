package wk8.project4;

//TODO: method to allow edges to be added to the graph
//TODO: method to do a depth-first search
//TODO: method to display unreachable vertices


public class DirectedGraph<E> {

    Vertex<E> firstVertex;

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
    }

    //===============================================================================================
    //  Static nested Edge class.
    //===============================================================================================

    private static class Edge<E>{
        //the vertex that the edge connects to
        Vertex<E> vertex;
        Edge<E> nextEdge;

        public Edge(Vertex<E> v){ vertex = v; }

        public Edge<E> next(){ return nextEdge;}
        public boolean hasNext() { return (nextEdge != null); }

        public String toString(){
            return vertex.element.toString();
        }
    }

    //===============================================================================================
    //  createEdge - either finds or creates the Vertices for which it will made an edge between
    //===============================================================================================

    public void createEdge(E from, E to) {
        // if the vertex doesnt exist, it gets made, otherwise returned
        Vertex<E> fromVertex = findAddVertex(from);
        Vertex<E> toVertex = findAddVertex(to);

        AddEdge(fromVertex, toVertex);
    }

    //===============================================================================================
    //  AddEdge - called by createEdge to do some of the work of traversing the linked lists
    //===============================================================================================

    private void AddEdge(Vertex<E> fromVertex, Vertex<E> toVertex) {
        //what if the first edge is null?
        if (fromVertex.firstEdge == null){ fromVertex.firstEdge = new Edge<>(toVertex); }
        else{ Edge<E> currentEdge = fromVertex.firstEdge;
            while(currentEdge.hasNext()){
                currentEdge = currentEdge.next();
            }currentEdge.nextEdge = new Edge<>(toVertex);
        }
    }

    //===============================================================================================
    //  findAddVertex - attempts to find a vertex and return it, otherwise adds it and returns it
    //===============================================================================================

// v-----> This is clearly the problem area <-----v //
    public Vertex<E> findAddVertex(E value) {
        if (firstVertex == null){
            return firstVertex = new Vertex<>(value);
        }
        Vertex <E> current = firstVertex;
        while (current.hasNext()){
            if (current.element == value){ return current; }
            current = current.next();
        }
        return current.nextVertex = new Vertex<>(value);
    }// ^-----> This is clearly the problem area <-----^ //

    //===============================================================================================
    //  toString - overridden, will be adjusted later
    //===============================================================================================

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Vertex<E> currentVertex = firstVertex;
        while (currentVertex != null) {
          //  if (currentVertex.firstEdge != null){
                sb.append(currentVertex.element).append(": ");
                // do the edges here
//                Edge<E> currentEdge = currentVertex.firstEdge;
//                sb.append(currentEdge).append(" ");
//                while(currentEdge.hasNext()){
//                    sb.append(currentEdge.next()).append(" ");
//                    currentEdge = currentEdge.next();
//                }
                sb.append('\n');
       //     }
            currentVertex = currentVertex.next();
        }
        return sb.toString();
    }
}