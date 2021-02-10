package com.algorithm.hashmap;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
//find the first non-repeat character:
//"a green apple": iterate the String from the beginning to the end, and count the number of time each character has been repeated
//we can store each character and the number of times repeated in a hash table(HashMap):
public class CharFinder {
    public char findFirstNonRepeatingChar(String str){
        Map<Character,Integer> map = new HashMap<>();
        var chars = str.toCharArray();
        for(char ch : chars){
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch,count + 1);
        }
        System.out.println(map);
        for(char ch : chars){
            if(map.get(ch) == 1)
                return ch;
        }
       // return Character.MIN_VALUE;
        return '0';
    }
    public char findFirstRepeatedChar(String str){
        Set<Character> set = new HashSet<>();
        for(var ch : str.toCharArray()){
            if(set.contains(ch))
                return ch;
            set.add(ch);
        }
        //no print on the console if no match
        return Character.MIN_VALUE;
    }
}
