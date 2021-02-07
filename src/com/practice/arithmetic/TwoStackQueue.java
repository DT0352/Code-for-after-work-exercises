package com.practice.arithmetic;

import java.util.Stack;

/**
 * @author ZhiDong
 * 两个栈实现队列
 *
 * 思路:
 *  栈都是先进后出,两个栈 正好可以彼此抵消 实现先进先出
 *  找两个栈 一个为压入栈 一个为弹出栈 将所有压入的操作都在压入栈执行, 弹出的都在弹出栈
 *  如果弹出栈没有元素了 那就把压入栈的攒的元素遍历到弹出栈 在进行弹出 如果 压入栈也没元素了 则 整个队列就没元素了
 *
 * 2021/1/15
 */
public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(Integer value) {
        stackPush.push(value);
    }

    public int poll() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("queue 为空..");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("队列为空..");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.add(1);
        twoStackQueue.add(2);
        twoStackQueue.add(3);
        twoStackQueue.add(4);
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.poll());
        twoStackQueue.add(0);
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.poll());
    }
}
