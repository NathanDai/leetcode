/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> integerMap=new HashMap<Character, Integer>();
        int length=0;
        int start =-1;
        int end=0;
        for(end=0;end<s.length();end++){
            char c=s.charAt(end);
            if (integerMap.containsKey(c)){
                int newstart =integerMap.get(c);
                start=Math.max(start,newstart);
            }
            length=Math.max(length,end-start);
            integerMap.put(c,end);
        }
        return  length;
    }
}

