package Tree.Traversal.LevelOrderTraversal.AssignmentQuestions.InClass;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfABinaryTree {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    static int getMaxWidth(Node root) {
        // Your code here
        // You can create your helper function or
        // class as your convenience
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int maxSize = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            maxSize = Math.max(maxSize, size);

            for(int i = 0; i < size; i++) {
                Node currentNode = queue.poll();

                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }

        return maxSize;
    }
}
