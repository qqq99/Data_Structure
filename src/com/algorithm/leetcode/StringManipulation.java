package com.algorithm.leetcode;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.lang.StringBuilder;
import java.util.*;
public class StringManipulation {
    public static void main(String[] args){
        String sentence = "trees are green";
        String[] words = sentence.split(" ");
        System.out.println(Arrays.toString(words));
        int[] nums = {2,6,3,1,5};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int[] arr1 = {1,2,4,3};
        int[] arr2 = {1,2,4,3};
        int[] arr3 = {1,2,3,4};
        System.out.println(Arrays.equals(arr1,arr2));
        System.out.println(Arrays.equals(arr2,arr3));
        System.out.println(countVowels("gekasdeioc"));
        System.out.println(reverseStr("abcdefg"));
        System.out.println(reverseStr2("abcdefg"));
        System.out.println(reverseOnlyStr("a-b!cde=fg"));
        System.out.println(reverseSentence("goats are beautiful"));
        System.out.println(removeDuplicates("goats are beautiful"));
        System.out.println(getMaxOccuringChar("goats are beautiful"));
        System.out.println((int)Math.sqrt(15));
    }
    public static int countVowels(String str){
        if(str == null) return 0;
        int count = 0;
        String Vow = "aeiou";
        for(var ch : str.toCharArray()){
            if(Vow.indexOf(ch) != -1 ){
                count++;
            }
        }
        return count;
    }
    public static String reverseStr(String str){
        if(str.length() == 0) return "";
        StringBuilder reversed = new StringBuilder();
        for(int i = str.length()-1; i >=0; i--){
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
    public static String reverseStr2(String str){
        if(str.length() == 0) return "";
        Stack<Character> stack = new Stack<>();
        StringBuilder reversed = new StringBuilder();
        for(char c : str.toCharArray()){
            stack.push(c);
        }
        for(int i = 0; i <str.length();i++){
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
    //如果说还有标点符号啥的
    public static String reverseOnlyStr(String str){
        if(str.length() == 0) return "";
        Stack<Character> stack = new Stack();
        StringBuilder newStr = new StringBuilder();
        for(char c : str.toCharArray()){
            if(Character.isLetter(c)){
                stack.push(c);
            }
        }
        for(var i = 0 ; i <str.length(); i++){
            if(Character.isLetter(str.charAt(i))){
                newStr.append(stack.pop());
            }else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
    public static String reverseSentence(String sentence){
        if(sentence == null) return "";
        String[] words = sentence.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ",words);
    }
    //ABCD -> BCDA || CDAB || DABC || ABCD
    //ABCDABCD
    public static boolean isRotation(String str1, String str2){
        if(str1 == null || str2 == null) return false;
        return (str1.length() == str2.length() && (str1+str1).contains(str2));
    }
    public static String removeDuplicates(String str){
        if(str == null) return "";
        StringBuilder newStr = new StringBuilder();
        Set<Character> hashSet = new HashSet<>();
        for(char ch : str.toCharArray()){
            if(!hashSet.contains(ch)){
                hashSet.add(ch);
                newStr.append(ch);
            }
        }
        return newStr.toString();
    }
    public static char getMaxOccuringChar(String str){
        Map<Character,Integer> hashMap = new HashMap<>();
        for(char ch : str.toCharArray()){
            if(hashMap.containsKey(ch)){
                hashMap.replace(ch,hashMap.get(ch)+1);
            }else{
                hashMap.put(ch,1);
            }
        }
        char maxCh= ' ';
        int max = 0;
        for(char item : hashMap.keySet()){
            if(hashMap.get(item) > max){
                max = hashMap.get(item);
                maxCh = item;
            }
        }
        return maxCh;
    }
}
