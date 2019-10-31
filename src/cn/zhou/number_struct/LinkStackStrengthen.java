package cn.zhou.number_struct;

public class LinkStackStrengthen {

	class StackNode {
		Object value = null;
		StackNode next = null;

		public StackNode(Object value) {
			this.value = value;
		}
	}

	private StackNode top = null;
	private int length = 0;

	// 是否为空
	public boolean isEmpty() {
		return top == null;
	}

	// 入栈
	public void push(Object value) {
		StackNode newNode = new StackNode(value);
		newNode.next = top;
		top = newNode;
		length++;
	}

	// 出栈
	public Object pop() {
		if (isEmpty())
			return null;
		StackNode current = top;
		top = current.next;
		length--;
		return current.value;
	}

	// 查询栈的长度
	public int getSize() {
		return length;
	}

	public static void main(String[] args) {
		LinkStackStrengthen lss = new LinkStackStrengthen();
		System.out.println("是否为空：" + lss.isEmpty());
		System.out.println("长度：" + lss.getSize());

		lss.push("one");
		lss.push("two");
		System.out.println("push--是否为空：" + lss.isEmpty());
		System.out.println("长度：" + lss.getSize());

		System.out.println("popint：" + lss.pop());
		System.out.println("popint：" + lss.pop());
		System.out.println("popint：" + lss.pop());
		System.out.println("popint：" + lss.pop());

		System.out.println("pop--是否为空：" + lss.isEmpty());
		System.out.println("长度：" + lss.getSize());
	}
}
