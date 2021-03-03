package com.practice.arithmetic;

import lombok.Data;

/**
 * @author ZhiDong
 * <p>
 * 2021/2/28
 */
// 堆结构 的实现
@Data
public class MyHeap {
    private int heapSize;
    private int limit;
    private int[] heap;

    public MyHeap(int limit) {
        heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }

    public void push(int value) {
        if (heapSize >= limit) {
            throw new RuntimeException("heap is full!!!");
        }
        heap[heapSize] = value;
        heapInsert(heap, heapSize++);

    }

    // 弹出最大值 并维护大端堆结构
    public int pop() {
        int max = heap[0];
        swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);
        return max;

    }

    private void heapify(int[] heap, int i, int heapSize) {
        int left = i * 2 + 1;
        while (left < heapSize) {
            // 最大孩子的索引
            int largest = (left + 1) < heapSize && heap[left] > heap[left + 1] ? left : left + 1;
            largest = heap[i] < heap[largest] ? largest : i;
            if (largest == i) {
                break;
            }
            swap(heap, i, largest);
            i = largest;
            left = i * 2 + 1;
        }
    }

    // 堆的新增
    private void heapInsert(int[] heap, int index) {
        int max = heap[0];
        while (heap[index] >= heap[(index - 1) / 2]) {
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


    private void swap(int[] heap, int index, int i) {
        int temp = heap[i];
        heap[i] = heap[index];
        heap[index] = heap[temp];
    }

}
