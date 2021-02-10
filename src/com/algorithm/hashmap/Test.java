package com.algorithm.hashmap;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
public class Test {
    public static void main(String[] args){
        Map<Integer, String> map = new HashMap<>();
        //allow same value, but not the same key;key can't repeat
        map.put(1,"cici");
        map.put(2,"cici");
        map.put(3,"kiki");
        map.put(4,"andy");
        //it's ok to put null, but no use case
        map.put(null,null);
        map.remove(null);
        var value = map.get(3);
        System.out.println(value);
        System.out.println(map);
        System.out.println(map.containsKey(3));//O(1)
        System.out.println(map.containsValue("cici"));//O(n)
//Set is very useful when we want non-repeat values/arrays.
//Remove duplicates;
        Set<Integer> set = new HashSet<>();
        int[] numbers = {1,2,3,3,2,1,5};
        for(var number : numbers)
            set.add(number);
        System.out.println(set);

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(12345,"Cici");
        System.out.println(Hash.hashInt(12345));
        Map<String,String> map2 = new HashMap<>();
        map2.put("1234-f","cici");
        System.out.println(Hash.hashStr("1234-f"));

        //In Java, every object has a method called hashCode()
        String name = "cici";
        //a numeric representation of String
        System.out.println(name.hashCode());
    }
}
