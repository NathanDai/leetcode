/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */
class Solution {
    public boolean isPalindrome(int num) {
        if (num < 0)
			return false;
		int reverseNumber = 0, tmp = num;
		while (num > 0) {
			reverseNumber = reverseNumber * 10 + num % 10;
			num = num / 10;
		}
		if (reverseNumber == tmp)
			return true;
		else
			return false;   
    }        
}

