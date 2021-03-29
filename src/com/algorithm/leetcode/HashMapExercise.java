package com.algorithm.leetcode;

import java.util.*;

public class HashMapExercise {
    public static void main(String[] args){

    }
    public static int[] twoSum(int[] nums, int target){
        int len = nums.length;
        Map<Integer,Integer> hashMap = new HashMap<>(len-1);
        for(int i=0; i<len;i++){
            int another = target - nums[i];
            if(hashMap.containsKey(another)){
                return new int[]{i,hashMap.get(another)};
            }
            hashMap.put(nums[i],i);
        }
        return new int[]{};
    }
}
