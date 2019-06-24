/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */
class Solution {

    String[] s = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        generate(list, "", 0, digits);
        return list;
    }
    
    private void generate (List<String> list, String temp, int pos, String dig) {
        if (temp.length() == dig.length()) {
            list.add(temp);
            return;
        }
        int j = dig.charAt(pos) - '0';
        String cur = s[j];
        
        for(int i = 0; i < cur.length(); i++) {
            generate(list, temp.concat(String.valueOf(cur.charAt(i))) , pos+1, dig);
        }
    }
}

