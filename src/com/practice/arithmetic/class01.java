package com.practice.arithmetic;

import javax.sound.midi.SoundbankResource;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ZhiDong
 * <p>
 * 2020/12/19
 */
public class class01 {
    public static void main(String[] args) {
        int[] arr = generatorArr(20, 3                                      );
        System.out.println(Arrays.toString(singleOdd(arr)));
    }

    /**
     * 整数生成器
     * 返回0 - max 包括max
     *
     * @param size 数组大小
     * @param max  数组最大值
     * @return
     */
    private static int[] generatorArr(int size, int max) {
        int[] arr = new int[size];
        max += 1;
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

    /**
     * 获得一个数转变成二进制数 最右边1的一个数
     *
     * @param source 要求的最右边的为1的数
     *               101001111000
     * @return 000000001000 这是返回结果
     */
    private static int getRightOne(int source) {
        return source & (~source + 1);
    }

    /**
     * 有一个数组,有两种数出现奇数次,其余数出现偶数,求这两个出现奇数的数
     * 解题思路:
     * 通过异或运算获得 两个出现奇数次的数的异或运算值 eor,然后取得 eor 的二进制最右边的1的值 rightOne ,比如说第3位 是1, a,b 必定只有一个数第三位为1
     * 其他数出现次数为偶数 ,对异或运算没有影响, 所以
     * rightOne ^= 就等于 a 或 b
     * eor = a^b
     * rightOne ^ eor = 另外的一个
     */
    private static int[] singleOdd(int[] arr) {
        System.out.print("输入的值为:");
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
                continue;
            }
            count = map.get(i);
            map.put(i, count + 1);
        }
        System.out.println(map);
        // 结果集
        int[] result = new int[2];
        // 假设这两种数为a,b
        // eor = a^b
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        System.out.println(eor);
        //
        int rightOne = getRightOne(eor);
        int onlyOne = 0;
        for (int i : arr) {
            if ((rightOne & i) != 0) {
                onlyOne ^= i;
            }
        }
        result[0] = onlyOne;
        result[1] = eor ^ onlyOne;
        return result;
    }
}
