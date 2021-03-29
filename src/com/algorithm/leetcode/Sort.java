package com.algorithm.leetcode;

import java.util.*;

public class Sort {
    public static void main(String[] args){
        //int[] arr = new int[]{6,7,3,2,9,0,1};
        int[] arr = {6,7,3,0,1};
        bucketSort(arr,3);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] array){
        //n times iteration
        boolean isSorted;
        for (var i = 0; i < array.length;i++){
            isSorted = true;
            // each iteration bubble the biggest num to back;
            for(var j = 1; j < array.length-i; j++){
                if(array[j] < array[j-1]){
                    var temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    isSorted = false;
                }
            }
            //if sorted, skip current j loop;
            if(isSorted) return;
        }
    }
    public static void selectionSort(int[] array){
        for(var i = 0; i < array.length; i++){
            var minIndex = i;
            //every iteration find the smallest and swap it with the first one in each iteration;
            for (var j = i; j<array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            var temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
    public static void insertionSort(int[] array){
        //because first iteration only one item, no need to compare
        for(var i = 1; i<array.length; i++){
            for(var j = i; j > 0; j--){
                if(array[j]<array[j-1]){
                    var temp = array[j];
                    array[j]=array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
    public static void mergeSort(int[] array){
        if(array.length<2) return;
        var mid = array.length/2;
        int[] left = new int[mid];
        for(var i = 0; i < mid; i++){
            left[i] = array[i];
        }
        int[] right = new int[array.length-mid];
        for(var j = mid; j<array.length;j++){
            right[j-mid] = array[j];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left,right,array);
    }
    private static void merge(int[] left, int[] right, int[] result){
        int i=0,j=0,k=0;
        while(i<left.length&&j<right.length){
            if(left[i] <= right[j]){
                result[k++] = left[i++];
            }else{
                result[k++] = right[j++];
            }
        }
        while(i<left.length){
            result[k++] = left[i++];
        }
        while(j<right.length){
            result[k++] = right[j++];
        }
    }
    public static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }
    private static void quickSort(int[] array,int start,int end){
        if(start >= end) return;
        var boundary = partition(array,start,end);
        System.out.println(boundary);
        quickSort(array,start,boundary-1);
        quickSort(array,boundary+1,end);
    }
    //this returned int is the correct position for pivot
    private static int partition(int[] array,int start,int end){
        var pivot = array[end];
        var boundary = start-1;
        for(var i = start; i<=end;  i++){
            if(array[i] <= pivot){
                boundary++;
                var temp= array[i];
                array[i] = array[boundary];
                array[boundary] = temp;
            }
        }
        return boundary;
    }
    //有bug待fix
    public static void bucketSort(int[] array, int numberOfBucket){
        List<List<Integer>> buckets = new ArrayList<>();
        for(var i = 0; i < numberOfBucket; i++){
            buckets.add(new ArrayList<>());
        }
        for(var item : array){
            buckets.get(item/numberOfBucket).add(item);
        }
        var i = 0;
        for(var bucket : buckets){
            //Collections.sort（）是Java自带的quickSort方法
            Collections.sort(bucket);
            for(var item : bucket){
                array[i++] = item;
            }
        }
    }
}
