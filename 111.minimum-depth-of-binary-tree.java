/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
    public int minDepth(TreeNode root) {
        if(root == null){ return 0;}
        if(root.left == null){
            //I am not sure why it works for those node that are not the real root.
            return minDepth(root.right) + 1;
        }
        else if(root.right == null ){
             return minDepth(root.left) + 1;
        }
        else{
            int l = minDepth(root.left);
            int r = minDepth(root.right);
            return l<r?l+1:r+1;
        }
    }
}

