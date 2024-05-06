package algorithm;

import java.util.HashSet;
import java.util.Set;
/*
 * TreeNode class represents the nodes of the binary tree with a value (val) and pointers to the left and right child nodes.
 * MaxDistinctNodesInPath class contains the main logic to find the maximum number of distinct nodes in a binary tree path.
 * maxDistinctNodesInPath method initializes the maxDistinctNodes variable and starts the Depth-First Search (DFS) traversal by calling the dfs method.
 * dfs method is a recursive DFS traversal that takes the current node and a visited set to keep track of the visited nodes in the path. The method explores the binary tree paths and calculates the number of distinct nodes in each path.
 * When a leaf node is reached (a node with no children), it calculates the number of distinct nodes in the current path and updates the maxDistinctNodes variable if necessary.
 * During DFS, a new copy of the visited set is passed to the left and right child nodes to avoid modifying the set for other paths in the binary tree.
 * In the main method, an example binary tree is created, and the MaxDistinctNodesInPath class is used to find the maximum number of distinct nodes in a path and prints the result.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class MaxDistinctNodesInPath {
    private int maxDistinctNodes;

    public int maxDistinctNodesInPath(TreeNode root) {
        maxDistinctNodes = 0;
        dfs(root, new HashSet<>());
        return maxDistinctNodes;
    }

    private void dfs(TreeNode node, Set<Integer> visited) {
        if (node == null) {
            return;
        }

        visited.add(node.val);

        // Check if the current node is a leaf node (has no children)
        if (node.left == null && node.right == null) {
            // Calculate the number of distinct nodes in the current path
            maxDistinctNodes = Math.max(maxDistinctNodes, visited.size());
        }

        // Perform DFS on the left and right subtrees, passing a new copy of the
        // 'visited' set
        // to avoid modifying the set for other paths in the binary tree
        dfs(node.left, new HashSet<>(visited));
        dfs(node.right, new HashSet<>(visited));
    }

    public static int getDisCnt(TreeNode root) {
        Set uniq = new HashSet<>();
        if (root == null) {
            return 0;
        }
        return getMaxHelper(root, uniq);
    }

    private static int getMaxHelper(TreeNode root, Set uniq) {
        if (root == null) {
            return uniq.size();
        }
        int l = 0;
        int r = 0;
        if (uniq.add(root.val)) {
            l = getMaxHelper(root.left, uniq);
            r = getMaxHelper(root.right, uniq);
            uniq.remove(uniq.size() - 1);
        } else {
            l = getMaxHelper(root.left, uniq);
            r = getMaxHelper(root.right, uniq);
        }
        return Math.max(l, r);
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(2);

        MaxDistinctNodesInPath maxDistinct = new MaxDistinctNodesInPath();
        int result = maxDistinct.maxDistinctNodesInPath(root);
        System.out.println("Maximum number of distinct nodes in a path: " + result);
    }
}
