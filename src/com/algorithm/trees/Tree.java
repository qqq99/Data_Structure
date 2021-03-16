package com.algorithm.trees;

public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;
        public Node(int value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "Node=" + value;
        }
    }
    private Node root;
    public void insert(int value){
        var node = new Node(value);
        if(root == null){
            root = node;
            return;
        }
        var current = root;
        while(true){
            if(value < current.value){
                if(current.leftChild == null){
                    current.leftChild = node;
                    //System.out.println("before break");
                    return;
                }
               // System.out.println("after break");
                current = current.leftChild;
            }
            else{
                if(current.rightChild == null){
                   current.rightChild = node;
                   return;
                }
                current=current.rightChild;
            }
        }
    }
    public boolean find(int value){
        var current = root;
        while(current != null){
            if(value < current.value){
                current = current.leftChild;
            }else if(value > current.value){
                current = current.rightChild;
            }else {
                return true;
            }
        }
        return false;
    }

    /*public static int factorial(int n){
        //base condition:
        if(n==0) return 1;
        return n * factorial(n-1);
    }*/
    //because Node is private not accessible from outside
    public void traversePreOrder(){
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root){
        // r -> L -> R
        //base condition
        if(root == null) return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }
    public void traverseInOrder(){
        traverseInOrder(root);
    }
    private void traverseInOrder(Node root){
        if(root == null) return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }
    public void traversePostOrder(){
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root){
        if(root == null) return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }
    public int height(){
        return height(root);
    }
    private int height(Node root){
        if(root==null){
            return 0;
        }else{
        return 1+Math.max(height(root.leftChild),height(root.rightChild));}
    }
    private int min(Node root){
        if(root.leftChild ==null && root.rightChild==null){
            return root.value;
        }
        var left = min(root.leftChild);
        var right = min(root.rightChild);
        return Math.min(Math.min(left,right), root.value);
    }
}
