package cn.zhou.miscellaneous;

import java.util.Scanner;

public class HuiWenNumber {
    public static void main(String[] args) {
        System.out.println("please input a number:");

        Scanner s = new Scanner(System.in);

        String i = s.next();

        StringBuffer r = new StringBuffer(i).reverse();


        if (i.equals(r.toString()))
            System.out.println("it is a 回文数>>>>>");
        else
            System.out.println("it is not a 回文数>>>>>");


    }
}
