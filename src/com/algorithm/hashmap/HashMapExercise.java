package com.algorithm.hashmap;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

//Runtime complexity of this method is O(n) because we have to iterate the entire array to populate our hash table.
public class HashMapExercise {
    //因为这个只需要返回一个遇到的 a+b = target;
    //1，first, using HashMap store value(key) and index(value);
    //不需要把全部array populate to HashMap(put); 一边put 一边找pair的index
    public int[] twoSum(int[] numbers, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            var complement = target - numbers[i];
            if(map.containsKey(complement))
                return new int[]{map.get(complement), i};
            map.put(numbers[i],i);
        }
        return null;
    }

    public int mostFrequentInt(int[] numbers){
        //find the most frequent item in an array, use HashMap to store the item and their frequencies.
        Map<Integer,Integer> map = new HashMap<>();
        for(var num : numbers){
            var count = map.getOrDefault(num,0);
            map.put(num,count+1);
        }
        //after populated our hash table, iterate over the entry, find the one with highest value
        var max = -1;
        //局部变量必须声明初始值；
        var result = numbers[0];
        for( var entry : map.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
    public String mostFrequentWord(String[] sentence){
        Map<String,Integer> map = new HashMap<>();
        for(var str : sentence){
            var count = map.getOrDefault(str,0);
            map.put(str,count+1);
        }
        var max = -1;
        var word = sentence[0];
        for(var entry : map.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                word = entry.getKey();
            }
        }
        return word;
    }
    //Input: [1, 7, 5, 9, 2, 12, 3] diff =2
    //output 4: 因为有四对 four pairs with difference 2: (1, 3), (3, 5), (5, 7), (7, 9).
    public int countPairsWithDiff(int numbers[], int diff){
        // For a given number (a) and difference (diff), number (b) can be:
        // b = a + diff
        // b = a - diff
        /*We can iterate over our array of numbers, and for each number,
        check to see if we have (current + diff) or (current - diff).
        But looking up items in an array is an O(n) operation. With this
        algorithm, we need two nested loops (one to pick a,
        and the other to find b). This will be an O(n^2) operation.
        We can optimize this by using a set. Sets are like hash tables
        but they only store keys. We can look up a number in constant time.
        No need to iterate the array to find it.*/
        Set<Integer> set = new HashSet<>();
        //set only contain keys, and they are non-repeated
        for(var num : numbers)
            set.add(num);
        var count = 0;
        for(var num : numbers){
            if(set.contains(num + diff))
                count++;
            if(set.contains(num - diff))
                count++;
            set.remove(num);
        }
        return count;
    }
}
