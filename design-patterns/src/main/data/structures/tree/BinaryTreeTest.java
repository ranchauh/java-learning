package data.structures.tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(new BinaryTreeNode(20));
        binaryTree.preOrderRecursiveTraversal(binaryTree.getRoot());
//        binaryTree.insertRecursive(binaryTree.getRoot(),10);
//        binaryTree.insertRecursive(binaryTree.getRoot(),30);
//        binaryTree.insertRecursive(binaryTree.getRoot(),5);
//        binaryTree.insertRecursive(binaryTree.getRoot(),15);
//        binaryTree.insertRecursive(binaryTree.getRoot(),25);
//        binaryTree.insertRecursive(binaryTree.getRoot(),35);
//        binaryTree.insertRecursive(binaryTree.getRoot(),3);
//        binaryTree.insertRecursive(binaryTree.getRoot(),7);
//        binaryTree.insertRecursive(binaryTree.getRoot(),13);
//        binaryTree.insertRecursive(binaryTree.getRoot(),17);
//        binaryTree.insertRecursive(binaryTree.getRoot(),23);
//        binaryTree.insertRecursive(binaryTree.getRoot(),27);
//        binaryTree.insertRecursive(binaryTree.getRoot(),33);
//        binaryTree.insertRecursive(binaryTree.getRoot(),37);
        binaryTree.insert(10);
        binaryTree.insert(30);
        binaryTree.insert(5);
        binaryTree.insert(15);
        binaryTree.insert(25);
        binaryTree.insert(35);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(13);
        binaryTree.insert(17);
        binaryTree.insert(23);
        binaryTree.insert(27);
        binaryTree.insert(33);
        binaryTree.insert(37);
        System.out.println("\nPre-Order Recursive:");
        binaryTree.preOrderRecursiveTraversal(binaryTree.getRoot());
        System.out.println("\nPre-Order Non-recursive:");
        System.out.println(binaryTree.preOrderTraversal());
        System.out.println("\nIn-Order Recursive:");
        binaryTree.inOrderRecursiveTraversal(binaryTree.getRoot());
        System.out.println("\nIn-Order non-recursive:");
        System.out.println(binaryTree.inOrderTraversal());
        System.out.println("\nPost-Order recursive:");
        binaryTree.postOrderRecursiveTraversal(binaryTree.getRoot());
        System.out.println("\nPost-Order non-recursive:");
        System.out.println(binaryTree.postOrderTraversal());

    }
}
