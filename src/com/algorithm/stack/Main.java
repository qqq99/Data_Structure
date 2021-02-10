package com.algorithm.stack;

public class Main {

    public static void main(String[] args){
        String str = "abcdefg";
        StringReverser reverser = new StringReverser();
        String str2 = reverser.reverse(str);
        System.out.println(str2);
        /*//receive NullPointerException
        System.out.println(reverser.reverse(null));
        fixed by throwing exception*/
        String str3 = "((1+2)>";
        BalancedExp balancedExp = new BalancedExp();
        var result = balancedExp.isBalanced(str3);
        System.out.println(result);

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

        TwoStack twoStack = new TwoStack(10);
        twoStack.push1(1);
        twoStack.push2(1);
        twoStack.push1(2);
        twoStack.push2(2);
        twoStack.push1(3);
        twoStack.push2(3);
        System.out.println(twoStack.toString());
    }
}
