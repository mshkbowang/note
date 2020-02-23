package com.note.Model;


public class User {
	private Integer userId;//用户id
	private String username;//用户名
    private String password;
    private String wName;
    private String address;
	private String tel;
	private Integer level;
	private User user;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User(Integer userId, String username, String password, String wName, String address, String tel, Integer level, User user) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.wName = wName;
		this.address = address;
		this.tel = tel;
		this.level = level;
		this.user = user;
	}

	public User(String username, String password, String wName, String address, String tel) {
		this.username = username;
		this.password = password;
		this.wName = wName;
		this.address = address;
		this.tel = tel;

	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(Integer userId) {
		this.userId = userId;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", wName='" + wName + '\'' +
				", address='" + address + '\'' +
				", tel='" + tel + '\'' +
				", level=" + level +
				", user=" + user +
				'}';
	}
}
