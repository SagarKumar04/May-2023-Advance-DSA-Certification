package Tree.BinaryTree.AssignmentQuestions.InClass;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {
    static class Node {
        int data;
        Node left;
        Node right;
    }
    public static void rootToLeafPathsHelper(Node node, List<Integer> currentList, List<List<Integer>> resultList) {
        if(node != null) {
            currentList.add(node.data);

            if(node.left == null && node.right == null) {
                List<Integer> newList = new ArrayList<>(currentList);
                resultList.add(newList);
            }

            rootToLeafPathsHelper(node.left, currentList, resultList);
            rootToLeafPathsHelper(node.right, currentList, resultList);
            currentList.remove(currentList.size() - 1);
        }
    }

    public static List<List<Integer>> rootToLeafPaths(Node root) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        rootToLeafPathsHelper(root, currentList, resultList);

        return resultList;
    }
}
