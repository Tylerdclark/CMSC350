package wk6;

//TODO: check whether tree is balanced
//TODO: check whether tree is full
//TODO: check if tree is proper (node has 0 or 2 children)
//TODO: return the height of the tree
//TODO: return the number of nodes (will obviously be used by other methods)
//TODO: return a fully parenthesized inorder traversal of the tree


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
