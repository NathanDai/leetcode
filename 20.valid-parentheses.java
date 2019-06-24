/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */
class Solution {    
    public boolean isValid(String s) {

        if(s.length() % 2 != 0){
            return false;
        }
        
        Stack<Character> parens = new Stack();
        
        for(char c : s.toCharArray()){
            switch(c){
                case '(':
                case '[':
                case '{':
                    parens.push( (char) ((c == '(') ? (c + 1) : (c + 2)) );
                    break;
                    
                case ')':
                case ']':                    
                case '}':
                    if(parens.empty() || parens.pop() != c) return false;
            }
        }
		
        return parens.empty();
    }
}

