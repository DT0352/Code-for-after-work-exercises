package com.practice.arithmetic;

/**
 * @author ZhiDong
 * 用数组实现队列
 * 2021/1/15
 */
public class MyQueueByRingArray {
    public static class MyQueue {
        private int[] arr;
        private int pushI = 0;
        private int pollI = 0;
        private int size = 0;
        private final int limit;

        public MyQueue(int limit) {
            this.limit = limit;
            this.arr = new int[limit];
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("栈满了...");
            }
            size++;
            arr[pushI] = value;
            pushI = nextInt(pushI);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("栈是空的..");
            }
            size--;
            int popValue = arr[pollI];
            pollI = nextInt(pollI);
            return popValue;
        }
        public boolean isEmpty(){
            return size == 0;
        }

        private int nextInt(int value) {
            return value < limit - 1 ? value + 1 : 0;
        }

    }
}
