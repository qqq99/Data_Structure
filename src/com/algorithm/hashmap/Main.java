package com.algorithm.hashmap;

public class Main {
    public static void main(String[] args){
        CharFinder finder = new CharFinder();
        var ch = finder.findFirstNonRepeatingChar("AABBCC");
        System.out.println(ch);
        var ch2 = finder.findFirstRepeatedChar("green apple");
        System.out.println(ch2);

        HashTable table = new HashTable();
        table.put(6,"kk");
        table.put(8,"cc");
        table.put(11,"gg");
        table.put(11,"gg");
        table.put(6,"kiki");
        System.out.println(table.get(6));
        System.out.println(table.get(10));
        table.remove(6);
        System.out.println(table.get(6));

        HashMapExercise exercise = new HashMapExercise();
        int[] numbers ={1,7,5,9,2,12,3};
        System.out.println(exercise.countPairsWithDiff(numbers,2));
        String[] arr = {"ci","ci","a","aa","aaa"};
        System.out.println(exercise.mostFrequentWord(arr));
        int[] arr2 = {1,2,2,3,3,3,4};
        System.out.println(exercise.mostFrequentInt(arr2));
    }
}
