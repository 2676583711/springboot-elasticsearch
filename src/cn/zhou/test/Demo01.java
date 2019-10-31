package cn.zhou.test;

public class Demo01 {

	public static void main(String[] args) {
//		System.out.println(abc());

		Integer num = 0;
		as(110, num);
		num += 5;// Integer.valueOf(10);
		System.out.println(num + 1);

	}

	public static String abc() {
		try {

			System.out.println("try......");
			return "try.....return.......";
		} catch (Exception e) {
			System.out.println("catch......");
			return "catch.....return.......";

		} finally {
			System.out.println("finally......");
			return "finally.....return.......";

		}
//		return "return";
	}

	public static int setNumber(Integer i, Integer num) {
		num = i;
		return num - 5;
	}

	public static void as(Integer i, Integer num) {
		num = i;
	}
}
