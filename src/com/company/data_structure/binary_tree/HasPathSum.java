package com.company.data_structure.binary_tree;

/*
     1
    /\
   2  3
  /\   \
 4  5   6
        /
       7
*/
public class HasPathSum {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.right = node3;
        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node6.left = node7;

        Solution s = new Solution();
        System.out.println(s.hasPathSum(node1, 8));
        System.out.println(s.maxPath(node1));
    }

}

class Solution {

    public int maxPath(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE  ;
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        return root.val + Math.max(left, right);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode root, int targetSum, int sum) {
        if(root == null) return false;
        int totalSum = sum + root.val;
        if(root.left == null && root.right == null && totalSum == targetSum) return true;
        return hasPathSum(root.left, targetSum, totalSum) || hasPathSum(root.right, targetSum, totalSum);
    }
}
