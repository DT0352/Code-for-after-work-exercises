package com.practice.arithmetic;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;

import java.util.Arrays;

/**
 * @author ZhiDong
 * <p>
 * 2021/2/27
 */

// 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
public class Merge {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 7, 0, 2};
        int res = process(nums, 0, nums.length - 1);
        int[] num = new int[]{3, 1, 7, 0, 2};

        int result = baoli(num);
        System.out.println(result);
    }

    private static int baoli(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (nums[i] > nums[i1]) {
                    res += 1;
                }
            }
        }
        return res;

    }
    private static int process(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
        return process(nums, l, mid) + process(nums, mid + 1, r) + merge(nums, l, r, mid);
    }

    // 小 大   逆序对是 (x,y ) x > y  1,4,     2,3,5
    private static int merge(int[] nums, int l, int r, int mid) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            res += nums[p1] > nums[p2] ? (mid - p1+1) : 0;
            help[i++] = nums[p1] > nums[p2] ? nums[p2++] : nums[p1++];
        }
        while (p1 <= mid) {
            help[i++] = nums[p1++];
        }
        while (p2 <= r) {
            help[i++] = nums[p2++];
        }
        for (int i1 = 0; i1 < help.length; i1++) {
            nums[l + i1] = help[i1];
        }
        return res;
    }
}
