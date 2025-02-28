package com.rent.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.rent.util.PasswordEncryptor;

@Entity
@Table(name = "register_details")
public class Register {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "uuid-char") // Use Hibernate's type for UUIDs
	@Column(name = "id", length = 36)
	private UUID id;

	@Column(name="full_name")
	private String fullname;

	@Column(name="date_of_birth")
	private Date dob;

	@Column(name="email")
	private String email;

	@Column(name = "mobile_number", length = 10)
	private long mobileno;

	@Column(name="gender")
	private String gender;

	@Column(name="occupation")
	private String occupation;

	@Column(name="id_type")
	private String idType;

	@Column(name="id_no", length = 40)
	private Integer idNo;
	
	@Column(name="issued_authority")
	private String IssuedAuthority;

	@Column(name="address_type")
	private String addressType;

	@Column(name="city")
	private String city;

	@Column(name="province")
	private String province;

	@Column(name="district")
	private String district;

	@Column(name="password")
	//@Convert(converter = PasswordEncryptor.class)
	private String password;

	@Column(name = "created_at")
	private Timestamp createdAt;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public Integer getIdNo() {
		return idNo;
	}

	public void setIdNo(Integer idNo) {
		this.idNo = idNo;
	}

	public String getIssuedAuthority() {
		return IssuedAuthority;
	}

	public void setIssuedAuthority(String issuedAuthority) {
		IssuedAuthority = issuedAuthority;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", fullname=" + fullname + ", dob=" + dob + ", email=" + email + ", mobileno="
				+ mobileno + ", gender=" + gender + ", occupation=" + occupation + ", idType=" + idType + ", idNo="
				+ idNo + ", IssuedAuthority=" + IssuedAuthority + ", addressType=" + addressType + ", city=" + city
				+ ", province=" + province + ", district=" + district + ", password=" + password + ", createdAt="
				+ createdAt + "]";
	}

	
}
