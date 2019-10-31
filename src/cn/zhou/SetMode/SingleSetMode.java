package cn.zhou.SetMode;

public class SingleSetMode {
	public static void main(String[] args) {
		A a = cn.zhou.SetMode.A.getA();
		B b = B.getB();
	}
}

//饿汉模式，加载类时创建对象
class A {
	private A() {
		super();
		System.out.println("单例a ");
	}

	final static A a = new A();

	public static A getA() {
		return a;
	}
}

//懒汉模式，调用方法时创建对象
class B {
	private B() {
		super();
		System.out.println("单例b");
	}

	// 禁止改变
	static volatile B b = null;

	public static B getB() {
		synchronized (B.class) {
			if (b == null) {
				b = new B();
			}
		}

		return b;
	}
}