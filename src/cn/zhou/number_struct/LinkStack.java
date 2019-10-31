package cn.zhou.number_struct;

import org.junit.Test;

public class LinkStack<T> {

	// 栈顶节点
	private LinkNode<T> top = null;
	// 栈的长度
	public static volatile int length = 0;

	// 创建栈,最少有一个节点
	public LinkStack() {
		super();
		// 创建栈底第一个节点
		this.top = new LinkNode<T>();
	}

	// 栈的两种状态，两种操作,但是链式结构，理论上是没有上限的
	// 是否为空
	public boolean isEmpty() {
		return this.top == null;
	}

	// 入栈
	public boolean push(LinkNode node) {
		// 如果栈底第一个节点为空，直接入栈即可
		if (isEmpty()) {
			this.top.setNext(node);
			return true;
		} else {
			// 否则，表示最少已经有一个节点了
			// 取出现在的栈顶节点,存入新节点中
			node.setNext(this.top.getNext());
			// 把新节点存入栈顶节点中，保证每次新入栈的节点处于栈顶
			this.top.setNext(node);
			this.length++;
			return true;
		}
	}

	// 出栈
	public LinkNode<T> pop() {
		// 如果是空栈，直接返回null
		if (isEmpty()) {
			return null;
		}
		// 取出现有的栈顶节点
		LinkNode<T> pop = this.top.getNext();
		// 把当前栈顶节点里面的节点（子节点），取出并覆盖当前的栈顶节点
		// 以达到删除的效果
		this.top.setNext(this.top.getNext().getNext());

		// 每次出栈一个节点，长度减一
		if (this.length >= 1)
			this.length--;
		else
			this.length = 1;
		// 直接返回栈顶节点
		return pop;
	}

	// 出栈
	public T popWithValue() {
		// 如果是空栈，直接返回null
		if (isEmpty() || this.length == 1 || this.length <= 0)
			return null;
		// 取出现有的栈顶节点
		LinkNode<T> pop = this.top.getNext();
		// 把当前栈顶节点里面的节点（子节点），取出并覆盖当前的栈顶节点
		// 以达到删除的效果
		this.top.setNext(pop.getNext());

		// 每次出栈一个节点，长度减一
		if (this.length >= 1)
			this.length--;
		else
			this.length = 1;
		// 直接返回栈顶节点
		if (pop != null)
			return pop.getData();
		return null;
	}

	public static void main(String[] args) {
		LinkStack<String> ls = new LinkStack<String>();
		System.out.println("是否为空：" + ls.isEmpty());
		System.out.println("长度:" + ls.length);

		ls.push(new LinkNode("one"));
		ls.push(new LinkNode("one2"));
		ls.push(new LinkNode<String>("one3"));
		ls.push(new LinkNode<String>("one4"));
		ls.push(new LinkNode("one5"));
		ls.push(new LinkNode("one6"));

		System.out.println(ls.pop().getData());
		System.out.println(ls.pop().getData());
		System.out.println(ls.pop().getData());
		System.out.println(ls.pop().getData());
		System.out.println(ls.pop().getData());
		System.out.println(ls.pop().getData());

		System.out.println(ls.pop().getData());
		System.out.println(ls.pop().getData());
		System.out.println(ls.pop().getData());

		System.out.println("是否为空：" + ls.isEmpty());
//		System.out.println("长度:" + ls.length);
		System.out.println(ls.popWithValue());
		System.out.println(ls.popWithValue());

		System.out.println("是否为空：" + ls.isEmpty());
//		System.out.println("长度:" + ls.length);
	}
}

// 节点
class LinkNode<T> {
	// 数据域
	private T data = null;
	// 下一个指针节点
	private LinkNode next = null;

	public LinkNode() {
	}

	public LinkNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LinkNode getNext() {
		return next;
	}

	public void setNext(LinkNode next) {
		this.next = next;
	}

}
