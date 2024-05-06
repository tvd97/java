package algorithm;

public class BinaryTree {
    Node root;

    // Find Minimum Depth of a Binary Tree?
    int minimumDepth() {
        return minimumDepth(root);
    }

    int minimumDepth(Node root) {
        // Corner case. Should never be hit unless the code is called on root = NULL
        if (root == null)
            return 0;
        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null)
            return 1;
        // If left subtree is NULL, recur for right subtree
        if (root.left == null)
            return minimumDepth(root.right) + 1;
        // If right subtree is NULL, recur for right subtree
        if (root.right == null)
            return minimumDepth(root.left) + 1;
        return Math.min(minimumDepth(root.left), minimumDepth(root.right)) + 1;
    }

    // Find Maximum Path Sum in a Binary Tree in Java?
    int findMaxUtil(Node node, Res res) {
        if (node == null)
            return 0;

        // l and r store maximum path sum going through left and right child of root
        // respectively
        int l = findMaxUtil(node.left, res);
        int r = findMaxUtil(node.right, res);

        // Max path for parent call of root. This path must include at-most one child of
        // root
        int maxSingle = Math.max(Math.max(l, r) + node.data, node.data);

        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        int maxTop = Math.max(maxSingle, l + r + node.data);

        // Store the Maximum Result.
        res.val = Math.max(res.val, maxTop);
        return maxSingle;
    }

    int findMaxSum() {
        return findMaxSum(root);
    }

    // Returns maximum path sum in tree with given root
    int findMaxSum(Node node) {
        // Initialize result
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        // Compute and return result
        findMaxUtil(node, res);
        return res.val;
    }

    // Max path for parent call of root. This path must
    public static void main(String args[]) {
        // BinaryTree tree = new BinaryTree();
        // tree.root = new Node(1);
        // tree.root.left = new Node(2);
        // tree.root.right = new Node(3);
        // tree.root.left.left = new Node(4);
        // tree.root.left.right = new Node(5);
        // System.out.println("The minimum depth of " +
        // "binary tree is : " + tree.minimumDepth());
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        System.out.println("maximum path sum is : " +
                tree.findMaxSum());
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Res {
    public int val;
}
