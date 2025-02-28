package com.rent.sprite;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class RegisterTable {

	@Pattern(regexp = "^[a-zA-Z ]{0,60}$", message = "The character should be alphabets and length should be less than 60.")
	@NotEmpty(message = "English Full Name is required.")
	private String fullname;

	@Pattern(regexp = "^(\\d{4}-\\d{2}-\\d{2})|({0})$", message = "Enter Valid Date (YYYY-mm-dd)")
	@NotEmpty(message = "Date of Birth is required.")
	private String dob;

	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format.")
	@NotEmpty(message = "Email is required.")
	private String email;

	@Pattern(regexp = "^\\d{10}$", message = "Mobile number should be 10 digits.")
	private long mobileno;

	@Pattern(regexp = "^((?i)Male|Female|Other)$", message = "Invalid gender value.")
	private String gender;

	@Pattern(regexp = "^(?i)(Student|Teacher|Engineer|Doctor|Other)$", message = "Invalid occupation value.")
	@NotEmpty(message = "Occupation is required.")
	private String occupation;

	@Pattern(regexp = "^(?i)(NationalId|License|Pan|Other)$", message = "Invalid idType value.")
	@NotEmpty(message = "Occupation is required.")
	private String idType;

	@NotEmpty(message = "Id number is required.")
	private Integer idNo;

	@NotEmpty(message = "IssuedAuthority is required.")
	private String IssuedAuthority;

	@Pattern(regexp = "^(?i)(Permanent|Temporory)$", message = "Invalid addressType value.")
	@NotEmpty(message = "Occupation is required.")
	private String addressType;

	@Pattern(regexp = "^(?i)(Nepali|Nepalese|Indian|Chinese|Other)$", message = "Invalid city value.")
	@NotEmpty(message = "Occupation is required.")
	private String city;

	@Pattern(regexp = "(?i)^(province 1|province 2|Bagmati|Gandaki |Lumbini|Karnali|Sudurpashchim)$", message = "Invalid province value.")
	@NotEmpty(message = "Occupation is required.")
	private String province;

	@Pattern(regexp = "^(?i)(Kathmandu|Pokhara|Biratnagar|Birgunj|Nepalgunj|Dharan|Butwal|Dhangadhi|Bharatpur|Hetauda|Janakpur|Itahari|Birendranagar|Tansen|Birgunj|Damak|Ghorahi|Lamjung|Baglung|Myagdi|Kaski|Mustang|Syangja|Parbat|Gulmi|Arghakhanchi|Palpa|Pyuthan|Rukum|Rolpa|Dang|Banke|Bardiya|Surkhet|Dailekh|Jajarkot|Dolpa|Jumla|Kalikot|Mugu|Humla|Bajura|Bajhang|Achham|Doti|Kailali|Kanchanpur)$", message = "Invalid district value.")
	@NotEmpty(message = "District is required.")
	private String district;

	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,20}$", message = "Password must contain at least one digit, one lowercase, one uppercase, one special character, and have a length between 6 and 20 characters.")
	@NotEmpty(message = "Password is required.")
	private String password;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
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

	@Override
	public String toString() {
		return "RegisterTable [fullname=" + fullname + ", dob=" + dob + ", email=" + email + ", mobileno=" + mobileno
				+ ", gender=" + gender + ", occupation=" + occupation + ", idType=" + idType + ", idNo=" + idNo
				+ ", IssuedAuthority=" + IssuedAuthority + ", addressType=" + addressType + ", city=" + city
				+ ", province=" + province + ", district=" + district + ", password=" + password + "]";
	}

	
}
