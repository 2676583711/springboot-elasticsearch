package cn.zhou.test;

public class Demo {

    public static void main(String[] args) {
//        test1();
        int[] num = {5, 9, 7, 8, 6, 4, 1, 2, 3, 0};
        //排序之前，打印数据　以便于与排序结果数据对比
        System.out.println("排序前：");
        printArray(num);
        int[] qs = quickSort(num, 0, num.length - 1);
        //排序完毕，打印排序结果数据
        System.out.println("排序后:");
        printArray(qs);

    }

    public static void test1() {
        String s = "()";
        String[] split = s.split("");

        for (int i = 0; i < split.length; i++)
            System.out.println(split[i]);

    }

    //快速排序,递归快速排序
    public static int[] quickSort(int[] num, int left, int right) {
        //left:数组第一个下标，right:数组的最后一个下标:
        //若相等，则数组只有一个元素，无需排序直接返回
        //若left大于right，则数组异常无法进行排序
        //若left<right,则为正常情况，进行后续排序操作
        if (left >= right) return num;

        //左哨兵
        int i = left;
        //右哨兵
        int k = right;
        //基准值
        int key = num[left];

        //只要 i<k,左右哨兵没有相遇，表示本轮排序没有进行完毕
        while (i < k) {
            //先从右边寻找小于基准值的数,直到找一个小于数结束查找
            while (i < k & num[k] >= key) k--;
            //接着从左边寻找大于基准值的数,直到找到一个大于数为止
            while (i < k & num[i] <= key) i++;

            //把右边小于基准值的数与左边大于基准值的数交换位置
            //从而实现小于数左移，大于数右移
            if (i < k) {
                int tem = num[k];
                num[k] = num[i];
                num[i] = tem;
            }
        }

        //基准值（中间值）归位
        num[left] = num[i]; //num[k]
        num[k] = key;

        //继续把分割完成的左边数据排序
        quickSort(num, left, i - 1);

        //继续把分割完成的右边数据排序
        quickSort(num, k + 1, right);

        return num;
    }

    //打印器
    public static void printArray(int[] num) {
        for (int i : num) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
