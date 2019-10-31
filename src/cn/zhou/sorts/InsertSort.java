package cn.zhou.sorts;


import cn.zhou.tools.ForEach;

/*
 ****插入 排序****．
 * 最好时间复杂度： O(n)
 *最差时间复杂度： O(n^2)
 *平均时间复杂度： O(n^2)
 * 空间复杂度： O(1)
 * 是否稳定：　是
 */
public class InsertSort {
    public static void main(String[] args) {
        ForEach.output(sort(Arrays.int_number));
    }

    public static int[] sort(int[] a) {
        if (a.length < 1) return a;

        //

        int temp = 0; //等待插入的数,从数组第二个开始
        for (int i = 1; i < a.length; i++) {
            temp = a[i]; //待处入数，从数组第二个开始

            int currentIndex = i;
            for (int j = 0; j < i; j++) {
                if (temp < a[j]) {
                    //如果插入数小于，其之前的数
                    //就把前面的数往后移一位
                    a[currentIndex] = a[currentIndex - 1];
                    currentIndex--;
                }
            }
            a[currentIndex] = temp;
        }

        return a;
    }


}
