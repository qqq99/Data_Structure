package com.algorithm.leetcode;

public class Factorial {
    public static void main(String[] args){
        System.out.println(fact(4));
        System.out.println(fact2(4));
    }
    public static int fact(int n){
        var fac = 1;
        for(int i = 1; i <=n; i++){
            fac *= i;
        }
        return fac;
    }
    public static int fact2(int n){
        //base condition
        if(n == 0)
            return 1;
        return n*fact2(n-1);
    }
}
