package com.algorithm.leetcode;
public class Test {
    public static void main(String[] args) {
        testBreak();
        testContinue();
        testReturn();
        System.out.println("--主函数------------");
    }
    private static void testBreak() {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                break;
            }
            System.out.println("--break------------" + i);
        }
        System.out.println("--break-------for循环外-----");
    }
    private static void testContinue() {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println("--continue------------" + i);
        }
        System.out.println("--continue-------for循环外-----");
    }
    private static void testReturn() {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                return;
            }
            System.out.println("--return------------" + i);
        }
        System.out.println("--return-------for循环外-----");
    }
}