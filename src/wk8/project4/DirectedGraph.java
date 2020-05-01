package wk8.project4;

public class DirectedGraph {


    private static class Vertex <E>{
        E element;
        Edge<E> firstEdge;
        Vertex<E> nextVertex;
    }
    private static class Edge<E>{
        Vertex<E> vertex;
        Edge<E> nextEdge;
    }
}
