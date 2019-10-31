package cn.zhou.number_struct;

public class LinkStackTest {
	/* 长度和头指针 */
	private int size = 0;
	private StackNode top = null;// top

	/* 节点类 */
	class StackNode {
		Object value;
		StackNode next = null;

		StackNode(Object obj) {
			this.value = obj;
		}
	}

	public void push(Object obj) {
		StackNode snode = new StackNode(obj);
		snode.next = top;
		top = snode;
		size++;
	}

	public Object pop() throws Exception {
		if (top == null)
//			throw new Exception("空栈！");
			return null;

		Object obj = top.value;
		top = top.next;
		size--;
		return obj;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void display() throws Exception {
		if (top == null)
			throw new Exception("空栈！");
		StackNode cur = top;
		while (cur != null) {
			System.out.print(cur.value.toString() + "->");
			cur = cur.next;
		}
	}

	public static void main(String[] args) throws Exception {
		LinkStackTest lk = new LinkStackTest();
		// lk.pop();
		// lk.display();
		lk.push("你好");
		lk.push("qeqwe");
		lk.push("rrr");
		lk.push("htht");
		lk.push("5655");
		lk.push("你");
		lk.push("好");

		// 遍历
		lk.display();
		System.out.println("\n" + lk.getSize());
		lk.pop();
		lk.pop();
		lk.pop();
		lk.display();
		System.out.println("\n" + lk.getSize());

		System.out.println("\n*********************///**//*/*/*");

		System.out.println("pop=" + lk.pop());
		System.out.println("pop=" + lk.pop());
		System.out.println("pop=" + lk.pop());
		System.out.println("pop=" + lk.pop());
		System.out.println("pop=" + lk.pop());
		System.out.println("pop=" + lk.pop());
		System.out.println("pop=" + lk.pop());
		System.out.println("pop=" + lk.pop());
		System.out.println("pop=" + lk.pop());
		System.out.println("pop=" + lk.pop());
		System.out.println("pop=" + lk.pop());
		System.out.println("pop=" + lk.pop());
		System.out.println("pop=" + lk.pop());
		System.out.println("pop=" + lk.pop());

	}

}
