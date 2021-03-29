package com.algorithm.leetcode;

public class Search {
    public static void main(String[] args){
        int[] numbers = {7,1,2,6,9};
        System.out.println(jumpSearch(numbers,0));
    }
    public static int linearSearch(int[] array, int target){
        for (var i = 0; i < array.length; i++){
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] array, int target){
        return binarySearchRecusive(array,target,0,array.length-1);
    }
    //binary search assume the list is sorted, if not sorted, we should sort list first
    private static int binarySearchRecusive(int[] array, int target,int left, int right){
        if(right < left) return -1;
        //in case left + right is too big
        var mid = left+(right-left)/2;
        if(array[mid] == target) return mid;
        if (array[mid] > target) {
           return binarySearchRecusive(array,target,left,mid-1);
        }
        return binarySearchRecusive(array,target,mid+1,right);
    }
    public static int binarySearchIteration(int[] array, int target){
        var left = 0;
        var right = array.length-1;
        while(left <= right){
            var mid = left +(right-left)/2;
            if(array[mid] == target){
                return mid;
            }else if(array[mid] > target){
                right = mid -1;
            }else if(array[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }
    public static int jumpSearch(int[] array,int target){
        int blockSize = (int)Math.sqrt(array.length);
        var start = 0;
        var next = start + blockSize;
        while(start < array.length && array[next-1] < target){
            start = next;
            next += blockSize;
            if(next > array.length){
                next = array.length;
            }
        }
        for(var i = start; i < next; i++){
            if(array[i] == target) return i;
        }
        return -1;
    }

}
