package cn.zhou.miscellaneous;

public class NineMultipleNine {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int k = 1; k <= i; k++) {
                System.out.print(i + "x" + k + "=" + i * k+"\t");
            }
            System.out.println();
        }
    }
}
