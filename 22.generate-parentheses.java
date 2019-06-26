/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] chars = new char[n * 2];

        chars[0] = '(';
        helper(result, chars, 1, n - 1, n);
        
        return result;
    }
    
    private void helper(List<String> result, char[] chars, int index, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(new String(chars));
            return;
        }
        
        if (left > 0) {
            chars[index] = '(';
            helper(result, chars, index + 1, left - 1, right);
        }
        if (left < right) {
            chars[index] = ')';
            helper(result, chars, index + 1, left, right - 1);
        }
    }
}

