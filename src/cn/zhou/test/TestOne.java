package cn.zhou.test;

import java.io.UnsupportedEncodingException;

public class TestOne {

	public static void main(String[] args) throws Exception {

//		new TestOne().judgeCode();
		// ***********************
		String str = "我ABC汉DEF";
		byte b = 6;

//		new TestOne().catString(str, b);
		new TestOne().cutString(str, b);

//		System.out.println(bSubstring(str, 3));

	}

	public void judgeCode() throws UnsupportedEncodingException {
		String s = "s";
		String c = "好";
		System.out.println(s.getBytes("gbk").length); // 1
		System.out.println(s.getBytes("utf8").length); // 1
		System.out.println(s.getBytes("utf16").length); // 4
		System.out.println("******************************");
		System.out.println(c.getBytes("gbk").length); // 2
		System.out.println(c.getBytes("utf8").length); // 3
		System.out.println(c.getBytes("utf16").length); // 4

	}

	public void catString(String s, byte b) {
		// 如果原始字符串的长度小于字节数，直接返回
		if (s.length() < b | s.equals(""))
			return;

		// 转换成gbk编码
//		Charset charset = Charset.forName("gbk");
//		charset.encode(s);

		try {
			s = new String(s.getBytes("gbk"), "gbk");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		StringBuffer sb = new StringBuffer();
		char c;

		// 如果字符长度大于一，则是汉字
		if (String.valueOf(s.charAt(b)).getBytes().length > 1)
			--b;

		for (int i = 0; i < b; i++) {
//			c = s.charAt(i);
			c = (char) s.getBytes()[i];
			sb.append(c);

//			System.out.println("截取结果final：" + (char) s.getBytes()[i]);

			try {
				byte[] bytes = s.getBytes();
				String string = new String(bytes, "gbk");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		System.out.println("b=" + b);

		System.out.println("截取结果：" + sb);

	}

	public void cutString(String s, byte b) throws UnsupportedEncodingException {
		// 字符串不能为空
		if (s.isEmpty() || s.equals("") || s.length() <= 0)
			return;

		// 转换成gbk
		byte[] bytes = s.getBytes("gbk");

		// 字符数
		int i = 0;
		int k = 0;

		// 便利字节数组，但是被截取长度不能超过规定的大小
		for (; k < bytes.length & i < b; k++) {

			// 如果第一个字节小于０，表示是中文，在gbk中中文是２个字节
			// 所以下一个字符从第三个开始
			if (bytes[k] < 0) {
				k++;
				i++;
			} else {
				i++;
			}
//			System.out.println(bytes[k]);
		}

		System.out.println("i=" + i);
		System.out.println("bytes[i]=" + bytes[i]); // i-1 -70 i

		// 如果最后一个字节小于零
		// 是汉字，去掉这个半截的汉字
		if (bytes[i] < 0) {
			i--;
		}
		System.out.println(new String(bytes, 0, i, "gbk"));
		System.out.println("i=" + i);

	}

	/// 借鉴
	public static String bSubstring(String s, int length) throws Exception {

		byte[] bytes = s.getBytes("Unicode");
		int n = 0; // 表示当前的字节数
		int i = 2; // 要截取的字节数，从第3个字节开始
		for (; i < bytes.length && n < length; i++) {
			// 奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节
			if (i % 2 == 1) {
				n++; // 在UCS2第二个字节时n加1
			} else {
				// 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
				if (bytes[i] != 0) {
					n++;
				}
			}
		}
		// 如果i为奇数时，处理成偶数
		if (i % 2 == 1)

		{
			// 该UCS2字符是汉字时，去掉这个截一半的汉字
			if (bytes[i - 1] != 0)
				i = i - 1;
			// 该UCS2字符是字母或数字，则保留该字符
			else
				i = i + 1;
		}

		return new String(bytes, 0, i, "Unicode");
	}
}
