package com.algorithm.hashmap;
import java.util.LinkedList;

public class HashTable {
    private class Entry{
        private int key;
        private String value;
        public Entry(int key, String value){
            this.key = key;
            this.value = value;
        }
    }
    //!
    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value){
        /*var index = hash(key);
        if(entries[index]==null)
            entries[index] = new LinkedList<>();
        var bucket = entries[index];
        for(var entry : bucket){
            if(entry.key == key) {
                entry.value = value;
                return;
            }
        }
        bucket.addLast(new Entry(key,value));*/
        var entry = getEntry(key);
        if(entry != null)
            entry.value = value;
        getOrCreateBucket(key).addLast(new Entry(key, value));
    }
    public String get(int key){
        /*var index = hash(key);
        var bucket = entries[index];
        //we would get exception when iterate over a null,
        if (bucket != null){
            for (var entry : bucket){
              if(entry.key == key)
                return entry.value;
            }
        }
        return null;*/
        var entry = getEntry(key);
        /*if(entry == null)
            return null;
        return entry.value;*/
        return (entry == null) ? null : entry.value;
    }

    public void remove(int key){
        /*var index = hash(key);
        var bucket = entries[index];
        if(bucket == null)
            throw new IllegalStateException();
        for(var entry :bucket){
            if(entry.key == key) {
                bucket.remove(entry);
                //找到了就立马返回，没有必要遍历剩下的
                return;
            }
        }
        //we couldn't find a entry with this key
        throw new IllegalStateException();*/
        var entry = getEntry(key);
        if(entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }
    private LinkedList<Entry> getBucket(int key){
        return entries[hash(key)];
    }
    private LinkedList<Entry> getOrCreateBucket(int key){
        var index = hash(key);
        if(entries[index] == null)
            entries[index] = new LinkedList<>();
        return entries[index];
    }
    private Entry getEntry(int key){
        var bucket = getBucket(key);
        if(bucket != null){
            for(var entry : bucket)
                if(entry.key == key)
                    return entry;
        }
        return null;
    }
    private int hash(int key){
        //if someone enter a negative value, abs() will return a positive value
        var posKey = Math.abs(key);
        return posKey % entries.length;
    }
}
