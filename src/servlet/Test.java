package servlet;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.function.Consumer;

import bean.Person;

/**
 * 
 * @author lloydfinch 测试反射
 */
public class Test {
	public static void main(String[] args) throws Exception {
		// 1 通过实例来得到class，然后通过class来创建新实例

		// step1: create a Person instance
		Person person = new Person();

		// step2: get class by person
		Class personClass = person.getClass();
		Person person2 = (Person) personClass.newInstance();
		person2.setName("by instance");
		person2.show();
		// 2 通类名来创建对象

		Class personClass2 = Class.forName("bean.Person");
		Person person3 = (Person) personClass2.newInstance();
		person3.setName("by full name");
		person3.show();

		// 拿到class后通过构造器
		Constructor constructor = personClass2.getConstructor();
		Person person4 = (Person) constructor.newInstance();
		person4.setName("by constructor");
		person4.show();

		// 获取字段

		// 获取name字段
		Field fieldName = personClass2.getField("name"); // 这个只能获取public级别的
		fieldName.set(person4, "android");
		person4.show();

		// age字段是private的，这里不能直接获取，而是应该获取DeclaredFiled，
		// 但是仍然不能修改，需要设置accessible权限才行
		Field fieldAge = personClass2.getDeclaredField("age"); // 这个可以获取私有private级别的Filed
		fieldAge.setAccessible(true); // 去除private权限
		fieldAge.set(person4, 24);
		person4.show();

		// 获取方法
		Method method = personClass2.getMethod("show"); // 这个也是只能获取public级别的方法
		System.out.println(method.getName());
		method.invoke(person4);

		Method eatMethod = personClass2.getDeclaredMethod("eat", String.class);// 这个可以获取private级别的方法
		eatMethod.setAccessible(true); // 去除private权限
		eatMethod.invoke(person4, "apple");

		// 使用反射绕过集合范型检测

		// 这是一个Integer的list，是不能放入String的，但是通过反射就可以
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100);
		// list.add("hello"); // 这个不可以，编译不通过
		Class<?> clazz = Class.forName("java.util.ArrayList");
		Method addMethod = clazz.getMethod("add", Object.class);
		addMethod.invoke(list, "hello");

		// 这里如果传递Integer的话，accept()就会报错
		list.forEach(new Consumer<Object>() {
			@Override
			public void accept(Object t) {
				System.out.println(t);
			}
		});
	}

	public static void testReflect() {
		// 加载web.xml
	}
}
