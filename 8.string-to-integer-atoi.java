/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */
class Solution {
    public int myAtoi(String str) {
        str=str.trim();
        if(str.length()==0) return 0;
        
        int neg=1;
        if(str.length()==1&&(str.charAt(0)=='-'||str.charAt(0)=='+') )
            return 0; 
       
        
        if(str.charAt(0)=='-'){
								neg=-1;
                               str=str.substring(1);
                              }
      else  if(str.charAt(0)=='+'){ 
                               str=str.substring(1);
                              }
        long result=0;
        for(int i=0;i<str.length()&&Character.isDigit(str.charAt(i));i++)
        {
            
            result=result*10+(str.charAt(i)-'0');
            
            if(result*neg<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(result*neg>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            
        }
        return (int)result*neg;
    }
}

