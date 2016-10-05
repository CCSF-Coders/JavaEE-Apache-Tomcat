package model;

public class Registration {
	private Integer id;
	private String first;
	private String last;
	private Integer age;
	public Registration(Integer id, String first, String last, Integer age) {
		super();
		this.id = id;
		this.first = first;
		this.last = last;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
