package data.structures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(){ }

    public BinarySearchTree(Node root){
        this.root = root;
    }


    public Node findMin(){
        if(root == null){
            return null;
        }
        Node currentNode = root;
        while(currentNode.getLeft() != null){
            currentNode = currentNode.getLeft();
        }
        return currentNode;
    }

    public Node findMax(){
        if(root == null){
            return null;
        }
        Node currentNode = root;
        while(currentNode.getRight() != null){
            currentNode = currentNode.getRight();
        }
        return currentNode;
    }

    public Node insertRecursive(Node current, int data){
        if(current == null) {
            current = new Node(data);
        }
        if(data < current.getData()){
            current.setLeft(insertRecursive(current.getLeft(),data));
        }else if(data > current.getData()){
            current.setRight(insertRecursive(current.getRight(),data));
        }
        return current;
    }

    public Node insert(int data){
        Node node = new Node(data);
        if(this.getRoot()==null){
            this.setRoot(node);
            return this.getRoot();
        }
        Node current = this.getRoot();
        boolean inserted = false;
        while (!inserted){
            if(data < current.getData()){
                if(current.getLeft() == null) {
                    current.setLeft(node);
                    inserted = true;
                }
                else
                    current = current.getLeft();
            }else if(data > current.getData()) {
                if(current.getRight() == null) {
                    current.setRight(node);
                    inserted = true;
                }
                else
                    current = current.getRight();
            }
        }
        return this.getRoot();
    }

    public void preOrderRecursiveTraversal(Node current){
        if(current != null){
            System.out.print(current.getData() + ", ");
            preOrderRecursiveTraversal(current.getLeft());
            preOrderRecursiveTraversal(current.getRight());
        }
    }

    public List<Integer> preOrderTraversal(){
        List<Integer> preOrderResponse = new ArrayList<>();
        if(this.getRoot()==null){
            return preOrderResponse;
        }
        Stack<Node> nodes = new Stack<>();
        nodes.push(this.getRoot());
        while (!nodes.isEmpty()) {
            Node tmp = nodes.pop();
            preOrderResponse.add(tmp.getData());
            //push the right child first so that it should be popped last
            if(tmp.getRight() != null){
                nodes.push(tmp.getRight());
            }
            if(tmp.getLeft() != null){
                nodes.push(tmp.getLeft());
            }
        }
        return preOrderResponse;
    }

    public void inOrderRecursiveTraversal(Node current){
        if(current != null){
            inOrderRecursiveTraversal(current.getLeft());
            System.out.print(current.getData() + ", ");
            inOrderRecursiveTraversal(current.getRight());
        }
    }

    public List<Integer> inOrderTraversal(){
        ArrayList<Integer> inOrderResponse = new ArrayList<>();
        if(this.getRoot() == null){
            return inOrderResponse;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(this.getRoot());
        Node current = this.getRoot();
        while (!stack.isEmpty()){
            if(current != null) {
                current = current.getLeft();
            }else {
                current = stack.pop();
                inOrderResponse.add(current.getData());
                current = current.getRight();
            }
            if(current != null) {
                stack.push(current);
            }
        }
        return inOrderResponse;
    }

    public void postOrderRecursiveTraversal(Node current){
        if(current != null){
            postOrderRecursiveTraversal(current.getLeft());
            postOrderRecursiveTraversal(current.getRight());
            System.out.print(current.getData() + ", ");
        }
    }

    public List<Integer> postOrderTraversal(){
        ArrayList<Integer> postOrderResponse = new ArrayList<>();
        if(this.getRoot()==null){
            return postOrderResponse;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(this.getRoot());
        Node previous = null;
        while(!stack.isEmpty()){
            Node current = stack.peek();
            if(previous == null || previous.getLeft() == current || previous.getRight() == current) {
                if(current.getLeft()!=null){
                    stack.push(current.getLeft());
                }else if(current.getRight()!=null){
                    stack.push(current.getRight());
                }
            }else if(current.getLeft()==previous){
                if(current.getRight()!=null){
                    stack.push(current.getRight());
                }
            }else {
                postOrderResponse.add(current.getData());
                stack.pop();
            }
            previous = current;
        }
        return postOrderResponse;
    }

    /**
     * Deletes a tree node with the given data.
     * @param dataToDelete
     * @return
     */
    public boolean deleteNode(int dataToDelete){
        if(this.root == null){
            return false;
        }

        Node nodeToDelete = root;
        Node parentNode = root;
        boolean isLeftChild = false;
        while (nodeToDelete.getData() != dataToDelete) {
            if (dataToDelete < nodeToDelete.getData()) {
                parentNode = nodeToDelete;
                nodeToDelete = nodeToDelete.getLeft();
                isLeftChild = true;
            } else {
                parentNode = nodeToDelete;
                nodeToDelete = nodeToDelete.getRight();
                isLeftChild = false;
            }
            if(nodeToDelete == null){
                return false;
            }
        }

        // Delete the leaf node
        if(nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null){
            if(nodeToDelete == root){
                root = null;
            }else if(isLeftChild) {
                parentNode.setLeft(null);
            }else {
                parentNode.setRight(null);
            }
        }
        // Delete a node having only left child
        else if(nodeToDelete.getRight() == null){
            if(nodeToDelete == root){
                root = nodeToDelete.getLeft();
            }else if(isLeftChild){
                parentNode.setLeft(nodeToDelete.getLeft());
            }else {
                parentNode.setRight(nodeToDelete.getLeft());
            }
        }
        // Delete a node having only right child
        else if(nodeToDelete.getLeft() == null){
            if(nodeToDelete == root){
                root = nodeToDelete.getRight();
            }else if(isLeftChild){
                parentNode.setLeft(nodeToDelete.getRight());
            }else {
                parentNode.setRight(nodeToDelete.getRight());
            }
        }
        // Delete a node having 2 children
        else {
            Node successor = findSuccessor(nodeToDelete);
            if(nodeToDelete == root){
                root = successor;
            }else if(isLeftChild){
                parentNode.setLeft(successor);
            }else {
                parentNode.setRight(successor);
            }
            successor.setLeft(nodeToDelete.getLeft());
        }
        return true;
    }

    private Node findSuccessor(Node nodeToDelete) {
        Node successorNode = nodeToDelete.getRight();
        Node successorParentNode = nodeToDelete;
        while (successorNode.getLeft() != null){
            successorParentNode = successorNode;
            successorNode = successorNode.getLeft();
        }
        if(successorNode != nodeToDelete.getRight()){
            successorParentNode.setLeft(successorNode.getRight());
            successorNode.setRight(nodeToDelete.getRight());
        }
        return successorNode;
    }

    public Node find(int valueToFind){
        if(this.root == null){
            return null;
        }
        Node foundNode = root;
        while (foundNode.getData() != valueToFind) {
            if (valueToFind < foundNode.getData()) {
                foundNode = foundNode.getLeft();
            } else {
                foundNode = foundNode.getRight();
            }
            if(foundNode == null){
                return null;
            }
        }
        return foundNode;
    }

    public void displayTree() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");

        while(!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();
            isRowEmpty = true;
            for(int j=0; j<nBlanks; j++) {
                System.out.print(" ");
            }

            while(!globalStack.isEmpty()) {
                Node temp = globalStack.pop();
                if(temp != null) {
                    System.out.print(temp.getData());
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    if(temp.getLeft() != null || temp.getRight() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for(int j=0; j<nBlanks*2-2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();
            nBlanks = nBlanks/2;

            while(!localStack.isEmpty())
                globalStack.push( localStack.pop() );
        }
        System.out.println( "......................................................");

    }

    public Node getRoot(){
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
