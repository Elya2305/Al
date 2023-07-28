package com.company.data_structure.binary_tree;

import java.util.*;

/*
    1
   /\
  2  3
 /\   \
4  5   6
       /
      7
 */
public class Traversal {
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

        DFSTraversal traversal = new DFSTraversal();
        System.out.println(traversal.traverse(node1));
        System.out.println(traversal.traverseRecursion(node1));

        BFSTraversal dfsTraversal = new BFSTraversal();
        System.out.println(dfsTraversal.traverse(node1));
    }

}


class BFSTraversal {
    public List<Integer> traverse(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if (root == null) return lst;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            lst.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return lst;
    }

        /*
        1
       /\
      2  3
     /\   \
    4  5   6
           /
          7
     */ // [1, 2, 3, 4, 5, 6, 7]

//    public List<Integer> traverseRecursion(TreeNode root) {
//    a tricky one, usually is not used
//    }
}

class DFSTraversal {
    public List<Integer> traverse(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if (root == null) return lst;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            lst.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return lst;
    }
    /*
        1
       /\
      2  3
     /\   \
    4  5   6
           /
          7
     */ // [1, 2, 4, 5, 3, 6, 7]
    public List<Integer> traverseRecursion(TreeNode root) {
        if (root == null) return List.of();
        List<Integer> lstLeft = traverseRecursion(root.left);
        List<Integer> lstRight = traverseRecursion(root.right);

        List<Integer> newLst = new ArrayList<>();
        newLst.add(root.val);
        newLst.addAll(lstLeft);
        newLst.addAll(lstRight);
        return newLst;
    }
}

class TraversalGood {
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        return List.of();
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversal(root, new ArrayList<>());
    }

    private List<Integer> inorderTraversal(TreeNode root, List<Integer> lst) {
        if (root == null) return lst;
        inorderTraversal(root.left, lst);
        lst.add(root.val);
        inorderTraversal(root.right, lst);
        return lst;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
