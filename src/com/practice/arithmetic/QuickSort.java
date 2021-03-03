package com.practice.arithmetic;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ZhiDong
 * <p>
 * 2021/2/28
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] ints = randomArr(5);
        System.out.println(Arrays.toString(ints));
        quick(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
//        int[] ints = randomArr(5);
//        System.out.println(Arrays.toString(ints));
//        int[] dutchFlag = dutchFlag(ints, 0, ints.length - 1);
//        System.out.println(Arrays.toString(dutchFlag));
//        System.out.println(Arrays.toString(ints));
    }

    private static void quick(int[] ints, int l, int r) {
        if (l >= r || ints.length < 2) {
            return;
        }
        DutchFlag.swap(ints, l + (int) (Math.random() * (r - l + 1)), r);
        int[] equalFlag = dutchFlag(ints, l, r);
        quick(ints, l, equalFlag[0] - 1);
        quick(ints, equalFlag[1] + 1, r);
    }

    // 1 2
    private static int[] dutchFlag(int[] ints, int l, int r) {
        if (l == r) {
            return new int[]{l, r};
        }
        if (l > r) {
            return new int[]{-1, -1};
        }
        int less = l - 1;
        int more = r;
        int index = l;
        // num = ints[r]
        while (index < more) {
            if (ints[index] == ints[r]) {
                index++;
            } else if (ints[index] > ints[r]) {
                DutchFlag.swap(ints, index, --more);
            } else {
                DutchFlag.swap(ints, index++, ++less);
            }
        }
        DutchFlag.swap(ints, more, r);
        return new int[]{less + 1, more};
    }

    public static int[] randomArr(int length) {
        int[] ints = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            ints[i] = random.nextInt(10);
        }
        return ints;
    }
}
