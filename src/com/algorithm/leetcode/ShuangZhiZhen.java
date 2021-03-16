package com.algorithm.leetcode;

public class ShuangZhiZhen {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,2,2,0,4,4};
        //System.out.println(removeDuplicates(arr));
        System.out.println(moveZeros(arr));
    }
    public static int removeDuplicates(int[] nums){
        if(nums == null || nums.length==0) return 0;
        int slow = 0;
        int fast = 1;
        while(fast < nums.length){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
    public static int[] moveZeros(int[] nums){
        if(nums == null) return null;
        int n=nums.length;
        int slow = 0;
        int fast = 0;
        while(fast<n){
            if(nums[fast] !=0 ){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}
