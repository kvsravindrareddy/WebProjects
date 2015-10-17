package com.ravindra.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_registration_tb")
public class UserRegistrationTable {
	private Integer userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String userName;
	private String password;
	private String gender;
	private String profession;
	private String mobileNumber;
	
	public UserRegistrationTable() {
		
	}
	
	public UserRegistrationTable(Integer userId, String firstName, String middleName, String lastName,
			String userName, String password, String gender, String profession, String mobileNumber) {
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.profession = profession;
		this.mobileNumber = mobileNumber;
	}
	@Id
	@Column(name="user_id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name="first_name", nullable=false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="middle_name", nullable=true)
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name="last_name", nullable=false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="user_name", nullable=false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="password", nullable=false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="gender", nullable=false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name="profession", nullable=false)
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Column(name="mobile_number", nullable=false)
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
