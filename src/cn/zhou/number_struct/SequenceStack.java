package cn.zhou.number_struct;

/*
 * 栈按照存储结构分为
 * 顺序栈：使用数组实现的
 * 链式栈：链式存储
 */
//本案例使用数组实现
public class SequenceStack {

	// 栈有两种状态：栈满full，栈空null或者小于等于-1
	// 栈有两种操作：进栈psuh，出栈pop

	private Object[] data;// 数据存储
	private Integer size; // 栈的大小
	private Integer top;// 栈顶指针

	SequenceStack() {

	}

	// 初始化
	SequenceStack(Integer size) {
		// 传入栈的尺寸
		this.size = size;
		// 根据传入尺寸，初始化栈的存储空间
		data = new Object[size];
		// 初始化时，栈顶指针位于栈底
		top = -1;
	}

	// 是否为空
	public boolean isNull() {
		// 如果栈顶指针小于等于－１，则表示栈为空
		if (top.compareTo(-1) == 0 || top.compareTo(-1) == -1)
			return true;
		// 否则栈不为空
		return false;
	}

	// 是否栈满
	public boolean isFull() {
		// 如果栈顶指针等于栈空间尺寸;表示栈满
		if (top.equals(size - 1)) {
			return true;
		}
		// 不是栈满
		return false;
	}

	// 入栈 push
	public boolean push(Object o) {
		// 入栈之前先判断栈满，栈满则无法入栈
		if (isFull())
			return false;

		// 否则,入栈一个元素,同时栈顶指针加一
		// 把元素入栈
		data[++top] = o;
		// 入栈成功
		return true;
	}

	// 出栈 pop
	public Object pop() {
		// 如果栈空，直接返回null
		// Integer.compareTo(x); // -1:小于ｘ 0:等于； １：大于ｘ
		if (isNull())
			return null;

		// 否则，正常出栈一个元素，同时栈顶指针减一
		// 返回出栈元素
		return data[top--];
	}

	// 如果栈顶指针小于等于－１，则可以清空栈空间
	public boolean setNull() {
//		data = null;

		data = new Object[size];
		top = -1;
		
		System.out.println("length=" + data.toString());
		System.out.println("length=" + data.length);

		return true;
	}

	public static void main(String[] args) {

		SequenceStack ss = new SequenceStack(3);

		System.out.println("是否为空" + ss.isNull());
		System.out.println("是否栈满" + ss.isFull());

		ss.push("one");
		System.out.println(ss.pop());

		ss.push("two");
		ss.push("three");

		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());

		System.out.println("是否为空" + ss.isNull());
		System.out.println("是否栈满" + ss.isNull());

		System.out.println(ss.push("three"));
		System.out.println(ss.push("three"));

		System.out.println(ss.push("three"));

		ss.setNull();

		System.out.println("置空然后入栈??" + ss.push("three"));
		System.out.println(ss.push("three"));
		System.out.println(ss.push("three"));
		System.out.println(ss.push("three"));
		System.out.println(ss.push("three"));

	}
}
