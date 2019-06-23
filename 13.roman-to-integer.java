/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */
class Solution {
    public int romanToInt(String s) {
        int []romN=new int[26];
        romN['I'-65]=1;
        romN['V'-65]=5;
        romN['X'-65]=10;
        romN['L'-65]=50;
        romN['C'-65]=100;
        romN['D'-65]=500;
        romN['M'-65]=1000;
        char cur,nex;
        int number=0;
        for(int i=0;i<s.length();i++){
            cur=s.charAt(i);
            if(i+1<s.length()){
                nex=s.charAt(i+1);            
                int curNum=romN[cur-65];
                int nexNum=romN[nex-65];
                if(curNum<nexNum){//subtract
                    number+=(nexNum-curNum);
                    i++;//total i+=2
                }
                else{
                    number+=curNum;
                }
            }
            else{
                number+=romN[cur-65];
            }
        }
        return number;
    }
}

