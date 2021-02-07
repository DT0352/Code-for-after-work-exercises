package com.practice.arithmetic;

import java.util.Arrays;

/**
 * @author ZhiDong
 * <p>
 * 归并排序
 * 2021/2/6
 */
public class MergerSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 41, 41, 312, 0, -1};
        int l = 0;
        int r = array.length - 1;
        mergeSort(array, l, r);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] arr, int l, int r) {
        process(arr, l, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int i1 = 0; i1 < help.length; i1++) {
            arr[l + i1] = help[i1];
        }
    }

    private static void process(int[] array, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        int p2 = mid + 1;
        process(array, l, mid);
        process(array, p2, r);
        merge(array, l, mid, r);
    }
}
