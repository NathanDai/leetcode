/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */
class Solution {
    public boolean isMatch(String s, String p) {
    int m = s.length(), n = p.length();
    boolean[][] dp = new boolean[m+1][n+1];
    
    // s and p are all empty, they match
    dp[0][0] = true;
    
    // deal with patterns like p = '*' which has nothing before *
    if(p.length() > 0 && p.charAt(0) == '*') return false;
    
    // deal with patterns like 'a*' or 'a*b*' or 'a*b*c*'
    for(int j=1; j<n+1; j++) {
        if(p.charAt(j-1) == '*') dp[0][j] = dp[0][j-2];
    }
    
    // the index of dp is 1 larger than s or p's index, because index 0 is for the empty string
    for(int i=1; i<m+1; i++) {
        for(int j=0; j<n+1; j++) {
            // add j>0 to make first column false, because pattern is empty but text is not
            if(j > 0 && (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.')) {
                // p and s is the same, or they can be seen as the same because of '.'
                dp[i][j] = dp[i-1][j-1];
            } else if(j > 0 && p.charAt(j-1) == '*') {
                // * matches 0 of the preceding element, so 'a*' these two characters could be removed
                dp[i][j] = dp[i][j-2];
                
                // * matches >=1 of preceding element
                // we need to compare j-2 with i-1, because * only match the preceding element
                if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.') {
                    dp[i][j] |= dp[i-1][j];     // don't forget to 'or' itself
                }
            } else {
                // p and s are regular characters, and they are not the same;
                // or the first column which represents pattern is empty but text is not
                dp[i][j] = false;
            }
        }
    }
    return dp[m][n];
}
}

