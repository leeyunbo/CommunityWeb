package com.yjy.idw;


public class UserVO {
	int id; 
	String name; 
	String passwd;
	
	public UserVO() {}
	public UserVO(int _id, String _name, String _passwd) {
		id = _id;
		name = _name;
		passwd = _passwd; 
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	} 
}
