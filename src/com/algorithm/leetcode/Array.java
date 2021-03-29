package com.algorithm.leetcode;
import java.util.*;
public class Array {
    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(max(arr));
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        System.out.println(intersect(list1,list2));
        System.out.println(reverse(list1));
        System.out.println(insertAt(list1,0,8));
        list2.addAll(list1);
        System.out.println(list2);
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr1 = {1};
        int[] arr2 = {0};
        int[] arr3 = {-1};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray(arr1));
        System.out.println(maxSubArray(arr2));
        System.out.println(maxSubArray(arr3));
    }
    public static int max(int[] arr){
        //O(n): Because we have to iterate over
        // the entire array to find the largest number.
        int max = Integer.MIN_VALUE;
        for(int item : arr){
            if(item > max){
                max = item;
            }
        }
        return max;
    }
    public static List<Integer> intersect(List<Integer> list1, List<Integer> list2){
        List<Integer> list = new ArrayList<>();
        for(int item : list1){
            /*if(list2.indexOf(item) >= 0){
                list.add(item);
            }方法二*/
            if(list2.contains(item)){
                list.add(item);
            }
        }
        return list;
    }
    public static List<Integer> reverse(List<Integer> list){
        List<Integer> newList = new ArrayList<>();
        for(int i = list.size()-1; i >= 0 ;i--){
            newList.add(list.get(i));
        }
        return newList;
    }
    public static List<Integer> insertAt(List<Integer> list, int index, int item){
        list.add(index,item);
        return list;
    }
    //最大子序和
    public static int maxSubArray(int[] nums){
        if(nums.length==0) return 0;
        var curSum = nums[0];
        var maxSum = nums[0];
        for(int i = 1; i <nums.length; i++){
            curSum = Math.max(nums[i],nums[i]+curSum);
            maxSum = Math.max(curSum,maxSum);
        }
        return maxSum;
    }
    public static int maxSubArray2(int[] numbers){
        if(numbers.length==0) return 0;
        int ans = numbers[0];
        int sum = 0;
        for(int n : numbers){
            if(sum > 0){
                sum += n;
            }else{
                sum = n;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
