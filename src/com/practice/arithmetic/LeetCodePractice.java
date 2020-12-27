package com.practice.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Checksum;

/**
 *
 */

public class LeetCodePractice {
    /**
     * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
     * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
     * 输入：accounts = [[1,2,3],[3,2,1]]
     * 输出：6
     * 解释：
     * 第 1 位客户的资产总量 = 1 + 2 + 3 = 6
     * 第 2 位客户的资产总量 = 3 + 2 + 1 = 6
     * 两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
     * 2020/12/22
     *
     * @param accounts
     * @return
     */
    public int maximumWealth(int[][] accounts) {
        int maxSum = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    // Stream方法解决问题
    public int maximumWealthStream(int[][] accounts) {
        return Arrays.stream(accounts).map(sum -> Arrays.stream(sum).sum()).max(Integer::compareTo).get();
    }

    /**
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i])
     * 请返回 nums 的动态和。
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,6,10]
     * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4]
     *
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                sum += nums[j];
            }
            result[i] = sum;
            sum = 0;
        }
        return result;
    }

    /**
     * 不需要新开一个数组来做
     */
    public int[] runningSumGood(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    /**
     * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
     * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
     * 输入：nums = [2,5,1,3,4,7], n = 3
     * 输出：[2,3,5,4,1,7]
     * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
     *
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        //0,1,2,n,n+1,2n-1
        // 0,n,1,n+1,2,2n-1(n+2)
        // 0,n,1,n+1,2,n+2,3,2n-1
        int[] result = new int[n << 1];
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) != 0) {// 为奇数
                result[i] = nums[n + tmp++];
            } else {
                result[i] = nums[i / 2];
            }
        }
        return result;
    }
}
