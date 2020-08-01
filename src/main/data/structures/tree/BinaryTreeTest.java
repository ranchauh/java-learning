package data.structures.tree;

import java.util.Stack;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
//        binarySearchTree.insertRecursive(binarySearchTree.getRoot(),10);
//        binarySearchTree.insertRecursive(binarySearchTree.getRoot(),30);
//        binarySearchTree.insertRecursive(binarySearchTree.getRoot(),5);
//        binarySearchTree.insertRecursive(binarySearchTree.getRoot(),15);
//        binarySearchTree.insertRecursive(binarySearchTree.getRoot(),25);
//        binarySearchTree.insertRecursive(binarySearchTree.getRoot(),35);
//        binarySearchTree.insertRecursive(binarySearchTree.getRoot(),3);
//        binarySearchTree.insertRecursive(binarySearchTree.getRoot(),7);
//        binarySearchTree.insertRecursive(binarySearchTree.getRoot(),13);
//        binarySearchTree.insertRecursive(binarySearchTree.getRoot(),17);
//        binarySearchTree.insertRecursive(binarySearchTree.getRoot(),23);
//        binarySearchTree.insertRecursive(binarySearchTree.getRoot(),27);
//        binarySearchTree.insertRecursive(binarySearchTree.getRoot(),33);
//        binarySearchTree.insertRecursive(binarySearchTree.getRoot(),37);
        binarySearchTree.insert(50);
        binarySearchTree.insert(25);
        binarySearchTree.insert(75);
        binarySearchTree.insert(12);
        binarySearchTree.insert(36);
        binarySearchTree.insert(62);
        binarySearchTree.insert(86);
        binarySearchTree.insert(6);
        binarySearchTree.insert(20);
        binarySearchTree.insert(30);
        binarySearchTree.insert(40);
        binarySearchTree.insert(70);
        binarySearchTree.insert(90);
        System.out.println("\nMin node: " + binarySearchTree.findMin().getData());
        System.out.println("\nMax node: " + binarySearchTree.findMax().getData());
        System.out.println("\nPre-Order Recursive:");
        binarySearchTree.preOrderRecursiveTraversal(binarySearchTree.getRoot());
        System.out.println("\nPre-Order Non-recursive:");
        System.out.println(binarySearchTree.preOrderTraversal());
        System.out.println("\nIn-Order Recursive:");
        binarySearchTree.inOrderRecursiveTraversal(binarySearchTree.getRoot());
        System.out.println("\nIn-Order non-recursive:");
        System.out.println(binarySearchTree.inOrderTraversal());
        System.out.println("\nPost-Order recursive:");
        binarySearchTree.postOrderRecursiveTraversal(binarySearchTree.getRoot());
        System.out.println("\nPost-Order non-recursive:");
        System.out.println(binarySearchTree.postOrderTraversal());

        //testDeleteNodes(binarySearchTree);

        binarySearchTree.displayTree();

    }

    private static void testDeleteNodes(BinarySearchTree binarySearchTree) {
        int data;

        System.out.println("\n=======================Delete Leaf node==================================");
        data = 20;
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));
        System.out.println("\nDelete node: " + binarySearchTree.deleteNode(data));
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));

        System.out.println("\nIn-Order Recursive:");
        binarySearchTree.inOrderRecursiveTraversal(binarySearchTree.getRoot());

        System.out.println("\n=======================Delete Non-Leaf node that has only left child==================================");
        data = 12;
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));
        System.out.println("\nDelete node: " + binarySearchTree.deleteNode(data));
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));

        System.out.println("\nIn-Order Recursive:");
        binarySearchTree.inOrderRecursiveTraversal(binarySearchTree.getRoot());

        System.out.println("\n=======================Delete Non-Leaf node that has a right child==================================");
        data = 62;
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));
        System.out.println("\nDelete node: " + binarySearchTree.deleteNode(data));
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));

        System.out.println("\nIn-Order Recursive:");
        binarySearchTree.inOrderRecursiveTraversal(binarySearchTree.getRoot());

        System.out.println("\n=======================Delete Non-Leaf node that has a right child==================================");
        data = 86;
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));
        System.out.println("\nDelete node: " + binarySearchTree.deleteNode(data));
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));

        System.out.println("\nIn-Order Recursive:");
        binarySearchTree.inOrderRecursiveTraversal(binarySearchTree.getRoot());

        System.out.println("\n=======================Delete Non-Leaf node that has a right child==================================");
        data = 50;
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));
        System.out.println("\nDelete node: " + binarySearchTree.deleteNode(data));
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));

        System.out.println("\nIn-Order Recursive:");
        binarySearchTree.inOrderRecursiveTraversal(binarySearchTree.getRoot());

        System.out.println("\n=======================Delete Non-Leaf node that has a right child==================================");
        data = 36;
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));
        System.out.println("\nDelete node: " + binarySearchTree.deleteNode(data));
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));

        System.out.println("\nIn-Order Recursive:");
        binarySearchTree.inOrderRecursiveTraversal(binarySearchTree.getRoot());

        System.out.println("\n=======================Delete Non-Leaf node that has a right child==================================");
        data = 25;
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));
        System.out.println("\nDelete node: " + binarySearchTree.deleteNode(data));
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));

        System.out.println("\nIn-Order Recursive:");
        binarySearchTree.inOrderRecursiveTraversal(binarySearchTree.getRoot());

        System.out.println("\n=======================Delete Non-Leaf node that has a right child==================================");
        data = 70;
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));
        System.out.println("\nDelete node: " + binarySearchTree.deleteNode(data));
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));

        System.out.println("\nIn-Order Recursive:");
        binarySearchTree.inOrderRecursiveTraversal(binarySearchTree.getRoot());

        System.out.println("\n=======================Delete Non-Leaf node that has a right child==================================");
        data = 90;
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));
        System.out.println("\nDelete node: " + binarySearchTree.deleteNode(data));
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));

        System.out.println("\nIn-Order Recursive:");
        binarySearchTree.inOrderRecursiveTraversal(binarySearchTree.getRoot());

        System.out.println("\n=======================Delete Non-Leaf node that has a right child==================================");
        data = 30;
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));
        System.out.println("\nDelete node: " + binarySearchTree.deleteNode(data));
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));

        System.out.println("\nIn-Order Recursive:");
        binarySearchTree.inOrderRecursiveTraversal(binarySearchTree.getRoot());

        System.out.println("\n=======================Delete Non-Leaf node that has a right child==================================");
        data = 75;
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));
        System.out.println("\nDelete node: " + binarySearchTree.deleteNode(data));
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));

        System.out.println("\nIn-Order Recursive:");
        binarySearchTree.inOrderRecursiveTraversal(binarySearchTree.getRoot());

        System.out.println("\n=======================Delete Non-Leaf node that has a right child==================================");
        data = 6;
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));
        System.out.println("\nDelete node: " + binarySearchTree.deleteNode(data));
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));

        System.out.println("\nIn-Order Recursive:");
        binarySearchTree.inOrderRecursiveTraversal(binarySearchTree.getRoot());

        System.out.println("\nIn-Order Recursive:");
        binarySearchTree.inOrderRecursiveTraversal(binarySearchTree.getRoot());

        System.out.println("\n=======================Delete Non-Leaf node that has a right child==================================");
        data = 40;
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));
        System.out.println("\nDelete node: " + binarySearchTree.deleteNode(data));
        System.out.println("\nFound Node " + data + ": " + (binarySearchTree.find(data) != null));

        System.out.println("\nIn-Order Recursive:");
        binarySearchTree.inOrderRecursiveTraversal(binarySearchTree.getRoot());
    }
}
