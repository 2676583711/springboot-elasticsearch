package cn.zhou.number_struct;

public class MyQueue {

	public static void main(String[] args) {
		test2();
	}

	public static void test1() {
		String s = "my name is abc";

		System.out.println("s=" + s);

		System.out.println("s=" + s.replace(" ", ","));
		System.out.println("s=" + s.replaceAll("", ",") + "\n\n ");

		// 逆序输出
		String[] split = s.replaceAll(" ", ",").split(",");
		StringBuffer sb = new StringBuffer();
		for (int i = split.length - 1; i >= 0; i--) {
			sb.append(split[i] + " ");// .append(" ");
			System.out.println("split=" + split[i]);
		}

		System.out.println("sb=" + sb);
		System.out.println("*//*/*/**/*/*/*/*");

		for (String s2 : s.split(" "))
			System.out.println("split::=" + s2);

	}

	public static void test2() {
		String s = "dasd";

		for (int i = 0; i < s.split("").length; i++)
			System.out.println("----%d-----" + i + s.substring(0, i+1));
	}
}
