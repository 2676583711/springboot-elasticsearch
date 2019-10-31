package cn.zhou.sorts;


import cn.zhou.tools.ForEach;

/*
 ****快速排序****．
 * 最好时间复杂度： O(n)
 *最差时间复杂度： O(n^2)
 *平均时间复杂度： O(n^2)
 * 空间复杂度： O(1)
 * 是否稳定：　是
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {5, 8, 2, 1, 4, 7, 9, 6, 3};
        ForEach.output(sort(a, 0, a.length - 1));
    }


    public static int[] sort(int[] a, int left, int right) {

        if (left > right) return a;

        //左哨兵
        int i = left;
        //右哨兵
        int j = right;
        //标准值
        int center = a[left];

        while (i < j) {
            while (i < j && a[j] >= center) j--;
            while (i < j && a[i] <= center) i++;

            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }


        //基准值归位
        a[left] = a[i];//a[j]
        a[j] = center;

        //继续递归左边
        sort(a, left, i - 1);

        //继续地柜右边
        sort(a, j + 1, right);

        return a;
    }
}
