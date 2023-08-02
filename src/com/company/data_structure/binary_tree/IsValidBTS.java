package com.company.data_structure.binary_tree;



/*
    5
   /\
  4  6
    / \
   3   7
 */
public class IsValidBTS {
    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MIN_VALUE - 1);

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(7);

        node1.right = node3;
        node1.left = node2;
        node3.right = node5;
        node3.left = node4;

//        Solution2 isValidBTS = new Solution2();
//        System.out.println(isValidBTS.isValidBST(node1));

    }
}


// O(n^2)
class Solution2 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        return isValidNode(root.left, root.val, true) && isValidNode(root.right, root.val, false) && isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean isValidNode(TreeNode node, int val, boolean isLeft) {
        if(node == null) return true;

        boolean isValid = (isLeft && node.val < val) || (!isLeft && node.val > val);
        return isValid && isValidNode(node.left, val, true) && isValidNode(node.right, val, false);
    }
}

// O(n)
class Solution3 {
    public boolean isValidBST(TreeNode root) {
        return checkBoundaries(root, null, null);
    }

    private boolean checkBoundaries(TreeNode node, Integer left, Integer right) {
        if(node == null) return true;

        return (left == null || left < node.val) && (right == null || node.val < right)
                && checkBoundaries(node.left, left, node.val)
                && checkBoundaries(node.right, node.val, right);
    }
}
