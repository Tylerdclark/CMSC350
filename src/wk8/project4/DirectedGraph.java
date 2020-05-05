package wk8.project4;



public class DirectedGraph<E> {

    Vertex<E> firstVertex;


    public void addVertex(E label){

        if (firstVertex == null){
            firstVertex = new Vertex<>(label);
        } else{
            Vertex<E> current = firstVertex;
            while(current.nextVertex != null){
                current = current.nextVertex;
            }
            current.nextVertex = new Vertex<>(label);
        }
    }

    private static class Vertex <E>{
        E element;
        Edge<E> firstEdge;
        Vertex<E> nextVertex;
        boolean discovered;

        public Vertex(E label){
            element = label;
            discovered = false;
        }


        public void addEdge(Edge<E> newEdge) {
            Edge<E> current = firstEdge;
            if (current == null) {
                current = newEdge;
                current.nextEdge = null;
            } else {
                while (current.nextEdge != null) {
                    current = current.nextEdge;
                }
                current.nextEdge = newEdge;
            }
        }

    }

    private static class Edge<E>{
        //the vertex that the edge connects to
        Vertex<E> vertex;
        Edge<E> nextEdge;

        public Edge(Vertex<E> v){
            vertex = v;
        }
        public void setNextEdge(Edge<E> nextEdge) {
            this.nextEdge = nextEdge;
        }

    }

    //TODO: method to allow edges to be added to the graph
    //TODO: method to do a depth-first search
    //TODO: method to display unreachable vertices
}
