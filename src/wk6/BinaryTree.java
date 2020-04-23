package wk6;

//TODO: check whether tree is balanced
//TODO: check whether tree is full
//TODO: check if tree is proper (node has 0 or 2 children)



import java.util.Stack;

public class BinaryTree {

    Node parent, child;

    public BinaryTree(String input) throws InvalidTreeSyntax {

        Stack<Node> nodeStack = new Stack<>();
        String[] inputArray = input.substring(1, input.length()-1) // remove first parenthesis
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
        //subtract one since in this exercise, root is 0
        return recHeight(this.parent) - 1;
    }

    private int recHeight(Node root) {
        return (root == null) ? 0 : Math.max(recHeight(root.left), recHeight(root.right))+1;

    }

    public int nodes() {
        return recNodes(this.parent);
    }

    private int recNodes(Node root) {
        return (root == null) ? 0 : 1 + recNodes(root.left) + recNodes(root.right);

    }

    public String inOrder() {
        return recInOrder(this.parent);
    }

    private String recInOrder(Node root) {
        return (root == null) ? "" : "("  + recInOrder(root.left) + root.info  + recInOrder(root.right) + ")";
    }

    // simply calls the the root node toString
    @Override
    public String toString() {
        return parent.toString();
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
            else if (this.getRight() == null){  this.setRight(child); }
            else{ throw new InvalidTreeSyntax("Problems adding child");} }

        //Simple setter and getters for the nodes
        public void setLeft(Node newLeft) { left = newLeft; }
        public void setRight(Node newRight) { right = newRight; }
        public Node getLeft() { return left; }
        public Node getRight() { return right; }

        //To call the recursive method
        @Override
        public String toString() {
            return toString(this);
        }
        // recursively printing out the nodes
        public static String toString(Node root) {
            return (root == null) ? "" : "(" + root.info  + toString(root.left) + toString(root.right) + ")";
        }
    }
}