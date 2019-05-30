package com.keshav.ctci.leetcode;


public class SerdeBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        TreeNode(String s) {
            val = toString().toCharArray()[0];
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        String r = "";
        return r + root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        TreeNode root = null;
        deserializeHelper(arr, 0, root);
        return root;
    }

    private int deserializeHelper(String[] arr, int i, TreeNode root) {
        if (arr[i] == "null") return i+1;
        root = new TreeNode(arr[i]);
        int l = deserializeHelper(arr, i+1, root.left);
        return deserializeHelper(arr, l, root.right);
    }
}
