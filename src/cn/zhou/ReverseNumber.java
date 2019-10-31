package cn.zhou;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        int[] exchange = exchange();
        for (int i = 0; i < exchange.length; i++) {
            System.out.println(exchange[i]);
        }


    }

    public static int[] exchange() {
//        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//
//        for (int i = 0; i < a.length; i++) {
//            b[i] = a[a.length - 1 - i];
//            System.out.println("b[i]=" + b[i]);
//        }

        int[] a = new int[10];
        int[] b = new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.println("接下来输入十个数字:");
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println("接下来输入十个数字完毕，进行顺序交换，结果如下:");
        for (int i = 0; i < a.length; i++) {
            b[i] = a[a.length - 1 - i];
        }
        return b;
    }
}
