package bean;

public class Person {
	public String name;
	private int age;

	public void show() {
		System.out.println(name + "," + age);
	}

	private void eat(String food) {
		System.out.println(name + " eat " + food);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
