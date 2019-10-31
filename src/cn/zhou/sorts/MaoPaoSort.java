package cn.zhou.sorts;

import cn.zhou.tools.ForEach;

/*
 ***冒泡排序**********
 * 最好时间复杂度： O(n)
 *最差时间复杂度： O(n^2)
 *平均时间复杂度： O(n^2)
 * 空间复杂度： O(1)
 * 是否稳定：　是
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        int[] a = {7, 8, 9, 1, 2, 3, 4, 5, 6};
//        ForEach.output(sort(a, true));
        ForEach.output(sort(Arrays.int_number, false));

    }

    public static int[] sort(int[] a) {
        if (a.length < 1) return a;

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
        return a;
    }

    public static int[] sort(int[] a, boolean isDesc) {
        if (a.length < 1) return a;

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (isDesc) {
                    if (a[j] < a[j + 1]) {
                        int t = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = t;
                    }
                } else {
                    if (a[j] > a[j + 1]) {
                        int t = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = t;
                    }
                }
            }
        }
        return a;
    }
}
