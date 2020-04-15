package wk6;

public class BinaryTree {

    public static class Node<T>{
        private T info;
        private Node<T> left;
        private Node<T> right;

        public Node(T info){
            this.info = info;
            left = null; //explicitly stating null
            right = null;
        }
        public void setInfo(T info){
            this.info = info;
        }
        public T getInfo(){
            return info;
        }
        public void setLeft(Node<T> link){
            left = link;
        }
        public void setRight(Node<T> link){
            right = link;
        }
        public Node<T> getLeft(){
            return left;
        }
        public Node<T> getRight(){
            return right;
        }
    }



}
