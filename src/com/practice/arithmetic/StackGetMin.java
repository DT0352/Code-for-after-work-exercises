package com.practice.arithmetic;
import java.util.Stack;
/**
 * @author ZhiDong
 * 实现一个特殊的栈,在实现栈的基本功能的基础上,在实现返回占中最小元素的操作
 * 要求:
 *  Pop ,push,getmin 的操作时间复杂度都是O(1)
 * 2021/1/14
 */

public class StackGetMin {
    private Stack<Integer> stackData = new Stack<>();
    // 存储当前的元素
    private Stack<Integer> stackMin = new Stack<>();
    // 存储最小元素的栈


    public StackGetMin() {
    }
    public void push(int newData){
        this.stackData.push(newData);
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newData);
        }else {
            Integer minData = this.getMin();
            if (minData >= newData){
                this.stackMin.push(newData);
            }
        }
    }
    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        Integer popData = this.stackData.pop();
        if (popData.equals(this.getMin())){
            this.stackMin.pop();
        }
        return popData;
    }

    public int getMin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return stackMin.peek();
    }


    public static void main(String[] args) {

        StackGetMin stack = new StackGetMin();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(0);
        for (Integer stackDatum : stack.stackData) {
            System.out.print(stackDatum);
        }
        System.out.println();
        for (Integer integer : stack.stackMin) {
            System.out.println(integer);
        }
        stack.pop();
        System.out.println(stack.getMin());
    }
}
