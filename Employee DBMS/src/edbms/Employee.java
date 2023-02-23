package edbms;

public class Employee {
	private String id;	
	private String name;
	private int age;
	private Double sal;
	static int count=1;
	public Employee(String name,int age,double sal)
	{
		this.id="SSS"+count;
		this.name=name;
		this.age=age;
		this.sal=sal;
		count++;
		
	}
	public String getId()
	{
		return id;
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
	public Double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee || id : " + id + " | name : " + name + " | age : " + age + " | sal : " + sal +  "||";
	}
	
	
	
	
	

}
