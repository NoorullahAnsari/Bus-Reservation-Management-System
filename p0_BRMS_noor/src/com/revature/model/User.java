package com.revature.model;
import java.util.Objects;

public class User {
	private String userId;
	private String username;
	private String email;
	private String phoneNo;
	private String address;
	private String dateOfBirth;
	private String physicalDisability;
	private String identityProof;
	private String loginId;
	private String password;
	private int age;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public String getPhysicalDisability() {
		return physicalDisability;
	}
	public void setPhysicalDisability(String physicalDisability) {
		this.physicalDisability = physicalDisability;
	}
	
	
	public String getIdentityProof() {
		return identityProof;
	}
	public void setIdentityProof(String identityProof) {
		this.identityProof = identityProof;
	}
	
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", phoneNo=" + phoneNo
//				+ ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", physicalDisability=" + physicalDisability
//				+ ", identityProof=" + identityProof + ", loginId=" + loginId + ", password=" + password + ", age="
//				+ age + "]";
//	}
	
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(address, age, dateOfBirth, email, identityProof, loginId, password, phoneNo,
//				physicalDisability, userId, username);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		return Objects.equals(address, other.address) && age == other.age
//				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(email, other.email)
//				&& Objects.equals(identityProof, other.identityProof) && Objects.equals(loginId, other.loginId)
//				&& Objects.equals(password, other.password) && Objects.equals(phoneNo, other.phoneNo)
//				&& Objects.equals(physicalDisability, other.physicalDisability) && Objects.equals(userId, other.userId)
//				&& Objects.equals(username, other.username);
//	}
//	
//	
//	
	
}
