package data.structures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTreeNode insertRecursive(BinaryTreeNode current,int data){
        if(current == null) {
            current = new BinaryTreeNode(data);
        }
        if(data < current.getData()){
            current.setLeft(insertRecursive(current.getLeft(),data));
        }else if(data > current.getData()){
            current.setRight(insertRecursive(current.getRight(),data));
        }
        return current;
    }

    public BinaryTreeNode insert(int data){
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(data);
        if(this.getRoot()==null){
            this.setRoot(binaryTreeNode);
            return this.getRoot();
        }
        BinaryTreeNode current = this.getRoot();
        boolean inserted = false;
        while (!inserted){
            if(data < current.getData()){
                if(current.getLeft() == null) {
                    current.setLeft(binaryTreeNode);
                    inserted = true;
                }
                else
                    current = current.getLeft();
            }else if(data > current.getData()) {
                if(current.getRight() == null) {
                    current.setRight(binaryTreeNode);
                    inserted = true;
                }
                else
                    current = current.getRight();
            }
        }
        return this.getRoot();
    }

    public void preOrderRecursiveTraversal(BinaryTreeNode current){
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
        Stack<BinaryTreeNode> binaryTreeNodes = new Stack<>();
        binaryTreeNodes.push(this.getRoot());
        while (!binaryTreeNodes.isEmpty()) {
            BinaryTreeNode tmp = binaryTreeNodes.pop();
            preOrderResponse.add(tmp.getData());
            //push the right child first so that it should be popped last
            if(tmp.getRight() != null){
                binaryTreeNodes.push(tmp.getRight());
            }
            if(tmp.getLeft() != null){
                binaryTreeNodes.push(tmp.getLeft());
            }
        }
        return preOrderResponse;
    }

    public void inOrderRecursiveTraversal(BinaryTreeNode current){
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
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(this.getRoot());
        BinaryTreeNode current = this.getRoot();
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

    public void postOrderRecursiveTraversal(BinaryTreeNode current){
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
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(this.getRoot());
        BinaryTreeNode previous = null;
        while(!stack.isEmpty()){
            BinaryTreeNode current = stack.peek();
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

    public BinaryTree(BinaryTreeNode root){
        this.root = root;
    }

    public BinaryTreeNode getRoot(){
        return this.root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }
}
