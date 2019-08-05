package com.wxl.configserver;

import java.util.Stack;

public class TwoStackAsAQueue {

    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        push(4);
        System.out.println(pop());
    }

    public static void push(int node) {
        // 正常入栈
        stack1.push(node);
    }

    public static int pop() {
        // 先出全部栈到中间栈
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        // 取出中间栈栈顶元素
        int result = stack2.pop();

        // 中间栈全部元素出全部到原栈
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}
