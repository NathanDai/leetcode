/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        char[] resultChars = new char[s.length()];

        int circle = (2 * numRows) - 2;
        
        int position;
        int counter = 0;
        for (int row = 0; row < numRows; row++) {
            for (int j = row; j < s.length(); j += circle) {
                resultChars[counter++] = s.charAt(j);
                
                position = j + circle - (2 * row);
                
                if (!(row == 0 || row == numRows - 1) && position < s.length()) {
                    resultChars[counter++] = s.charAt(position);
                }
            }
        }
        
        return new String(resultChars);
    }
}

