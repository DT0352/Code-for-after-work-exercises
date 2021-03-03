package com.practice.arithmetic;

import java.util.Arrays;

/**
 * @author ZhiDong
 * <p>
 * 2021/2/28
 * 经典的荷兰国旗问题
 * 一个无序的数组 把它分为三部分 从前到后 分别为小于num 等于num 大于num  要求时间复杂度 O(n)  空间复杂度为1
 * 返回相等位置的开始和结束索引
 */
public class DutchFlag {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 31, 24, 5, 7, 5};
//        swap(ints,1,3);
        int num = 5;
        int[] res = method(ints, 0, ints.length - 1, num);
        System.out.println(Arrays.toString(res));
    }

    private static int[] method(int[] ints, int l, int r, int num) {
        System.out.println(Arrays.toString(ints));
        if (l > r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, l};
        }
        int less = l - 1;
        int more = r + 1;
        int index = l;
        while (index < more) {
            if (ints[index] == num) {
                index++;
            } else if (ints[index] > num) {
                swap(ints, index, --more);
            } else {
                swap(ints, index++, ++less);
            }
        }
        return new int[]{less + 1, more - 1};
    }

    // 在数组中交换元素
    public static void swap(int[] ints, int a, int b) {
        int temp = ints[a];
        ints[a] = ints[b];
        ints[b] = temp;
    }

    @org.junit.Test
    public void test01() throws Exception {
        int[] ints = {1, 2};
        swap(ints, 1, 0);
        System.out.println(Arrays.toString(ints));
    }
}
