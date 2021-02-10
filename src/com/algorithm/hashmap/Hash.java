package com.algorithm.hashmap;

public class Hash {
    public static int hashInt(int key){
        return key % 100;
    }
    public static int hashStr(String key){
        var hashValue = 0;
        for(var ch : key.toCharArray()) {
            //because we declared hashValue as Integer, when we apply
            //the augmented assignment + operator between a character and an \
            //Integer, this character will get automatically converted to an Integer. 1221
            hashValue += ch;
        }
        return hashValue % 100;
    }
}
