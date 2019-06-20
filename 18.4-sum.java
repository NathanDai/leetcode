/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 3; i++) {
            if( i > 0 && nums[i] == nums[i - 1] ) // remove duplicate
                continue;
            if( nums[i] + 3 * nums[nums.length - 1] < target ) // current num is too small
                continue;
            if( nums[i] * 4 > target ) // current num is too large
                break;
            for(int j = i + 1; j < nums.length - 2; j++) {
                if( j > i + 1 && nums[j] == nums[j - 1] ) // duplicate removal
                    continue;
                if( nums[i] + nums[j] + 2 * nums[nums.length - 1] < target ) // current num is too small
                    continue;
                if( nums[i] + nums[j] * 3 > target ) // current num is too large
                    break;
                int begin = j + 1, end = nums.length - 1;
                while( begin < end ) {
                    int sum = nums[i] + nums[j] + nums[begin] + nums[end];
                    if( sum > target ) 
                        end--;
                    else if( sum < target )
                        begin++;
                    else if( sum == target ) {
                        if( begin == j + 1 || nums[begin] != nums[begin - 1] ) {
                            List<Integer> currentList = new ArrayList<Integer>();
                            currentList.add(nums[i]);
                            currentList.add(nums[j]);
                            currentList.add(nums[begin]);
                            currentList.add(nums[end]);
                            resultList.add(currentList);
                        }
                        begin++;
                        end--;
                    }
                }
            }
        }
        return resultList;
    }
}

