package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DaoBase;

public class Registration extends DaoBase<Registration> {
	private Integer id;
	private String last;
	private String first;
	private String email;
	private String phoneNumber;
	private Integer age;
	@Override
	public void decodeResultSet(ResultSet rset) throws SQLException {
		id = rset.getInt(1);
		last = rset.getString(2);
		first = rset.getString(3);
		email = rset.getString(4);
		phoneNumber = rset.getString(5);
		age = rset.getInt(6);
	}
	@Override
	public String getTable() {
		return "Registration";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
	@Override
	public Registration makeNewT() {
		return new Registration();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
