/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] sortedArray) {
        if (sortedArray == null) {
            return null;
        }
        return createBST(sortedArray, 0, sortedArray.length - 1);
    }

    private TreeNode createBST(int[] sortedArray, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        int mid = (startIndex + endIndex) / 2;
        TreeNode root = new TreeNode(sortedArray[mid]);
        root.left  = createBST(sortedArray, startIndex, mid - 1);
        root.right = createBST(sortedArray, mid + 1, endIndex);
        return root;
    }
}

