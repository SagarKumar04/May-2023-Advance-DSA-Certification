package Tree.Traversal.LevelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalII {
    class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    static void levelOrder(Node root){
        //Enter your code here
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                System.out.print(currentNode.data + " ");

                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            System.out.println();
        }
    }
}
