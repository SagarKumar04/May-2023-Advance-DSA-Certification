package Tree.BinaryTree.AssignmentQuestions.InClass;

import java.util.ArrayList;

public class BinaryTreeFromInorderAndPostorder {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data) {
            this.data = data;
        }
    }

    static Node buildTreeHelper(ArrayList<Integer> inorder,
                                ArrayList<Integer> postorder,
                                int inorderStart,
                                int inorderEnd,
                                int postorderStart,
                                int postorderEnd) {
        if(inorderStart > inorderEnd) {
            return null;
        }

        int rootData = postorder.get(postorderEnd);
        Node node = new Node(rootData);

        if(inorderStart == inorderEnd) {
            return node;
        }

        int rootIndex = 0;
        for(int i = inorderStart; i <= inorderEnd; i++) {
            if(inorder.get(i) == rootData) {
                rootIndex = i;
                break;
            }
        }

        node.left = buildTreeHelper(inorder, postorder, inorderStart, rootIndex - 1, postorderStart, postorderStart + rootIndex - inorderStart - 1);
        node.right = buildTreeHelper(inorder, postorder, rootIndex + 1, inorderEnd, postorderEnd - inorderEnd + rootIndex, postorderEnd - 1);

        return node;
    }

    static Node buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        // Write your code here
        int length = inorder.size();
        return buildTreeHelper(inorder, postorder, 0, length - 1, 0, length - 1);
    }
}
