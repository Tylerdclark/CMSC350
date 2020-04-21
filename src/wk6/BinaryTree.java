package wk6;

//TODO: check whether tree is balanced
//TODO: check whether tree is full
//TODO: check if tree is proper (node has 0 or 2 children)
//TODO: return the height of the tree
//TODO: return the number of nodes (will obviously be used by other methods)
//TODO: return a fully parenthesized inorder traversal of the tree


import java.util.Stack;

public class BinaryTree {

    Node parent, child;

    public BinaryTree(String input) throws InvalidTreeSyntax {

        Stack<Node> nodeStack = new Stack<>();
        String[] inputArray = input.substring(1, input.length()-1) // remove first and last parenthesis
                //and split the String into a arr of strings, retain the parenthesis
                .split("(?<=\\()|(?=\\()|(?<=\\))|(?=\\))");


        parent = new Node(inputArray[0]); //setting the first character to the root

        for (int i = 1; i < inputArray.length - 1; i++){

            if (inputArray[i].equals("(")){
                nodeStack.push(parent);
                if (child != null) {
                    parent = child;
                }

            }else if(inputArray[i].equals(")")){
                child = parent;
                parent= nodeStack.pop();

            }else{
                child = new Node(inputArray[i]);
                if (parent != null) {
                    parent.addChild(child);
                }

            }
            System.out.println(parent);
        }
    }



    public boolean checkBalanced() {
        return true;
    }

    public boolean checkFull() {
        return true;
    }

    public boolean isProper() {
        return true;
    }

    public int height() {
        return 0;
    }

    public int nodes() {
        return 0;
    }

    public BinaryTree inOrder() {
        return null;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "parent=" + parent +
                ", child=" + child +
                '}';
    }
    //===============================================================================================
    //   Nested node class/ arguments: character info/ helper methods for nodes
    //  description: Creates nodes to be used in tree and methods to act on them
    //===============================================================================================

    public static class Node {
        private String info;
        private Node left;
        private Node right;

        public Node(String info) { this.info = info; }

        public void addChild(Node child) throws InvalidTreeSyntax {
            if (this.getLeft() == null){ this.setLeft(child); }
            else if (this.getRight() == null){ this.setRight(child); }
            else{ throw new InvalidTreeSyntax("Problems");}
        }

        public void setLeft(Node link) { left = link; }

        public void setRight(Node link) { right = link; }

        public Node getLeft() { return left; }

        public Node getRight() { return right; }

        @Override
        public String toString() {
            return "Node{" +
                    "info=" + info +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}