package cn.zhou.sorts;


/*
选择排序
时间复杂度：
空间复杂度：
是否稳定：
最坏时间复杂度：
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = {5, 6, 4, 8, 7, 9, 2, 3, 1};
        sort(a);
    }


    /*
    选择排序
    每次循环，选出最小的数放到,第一个，第二个。。。。
     */
    public static void sort(int[] a) {
        if (a.length == 0) return;

        for (int i = 0; i < a.length; i++) {

            //最小数的索引,假设第一个是最小的
            int minIndex = i;

            for (int j = i; j < a.length; j++) {
                //  minIndex从第一个开始
                //
                if (a[j] < a[minIndex]) {  //为真 j 是当前最小的
                    minIndex = j;  //保存最小数
                }
            }
            //i 变化
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }

        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }
}
