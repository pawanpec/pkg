package com.spedia.model;
import java.util.Date;

/**
 * 
 */

/**
 * @author pawan
 *
 */
public class SchoolData {
	int id;
	String school_name="";
	String aff_no="";
	String state="";
	String district="";
	String postal_address="";
	String pin_code="";
	String phone_no="";
	String email="";
	String website="";
	String content="";
	String school_info;
	String school_code="";
	String school_url="";
	String city="";
	String tags="";
	String status="n";
	Date createdOn;
	int nid;
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public SchoolData(String school_name, String aff_no, String state,
			String district, String postal_address, String pin_code,
			String phone_no, String email, String website) {
		super();
		this.school_name = school_name;
		this.aff_no = aff_no;
		this.state = state;
		this.district = district;
		this.postal_address = postal_address;
		this.pin_code = pin_code;
		this.phone_no = phone_no;
		this.email = email;
		this.website = website;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getAff_no() {
		return aff_no;
	}
	public void setAff_no(String aff_no) {
		this.aff_no = aff_no;
	}
	public SchoolData() {
		super();
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPostal_address() {
		return postal_address;
	}
	public void setPostal_address(String postal_address) {
		this.postal_address = postal_address;
	}
	public String getPin_code() {
		return pin_code;
	}
	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSchool_info() {
		return school_info;
	}
	public void setSchool_info(String school_info) {
		this.school_info = school_info;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchool_code() {
		return school_code;
	}
	public void setSchool_code(String school_code) {
		this.school_code = school_code;
	}
	public String getSchool_url() {
		return school_url;
	}
	public void setSchool_url(String school_url) {
		this.school_url = school_url;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SchoolData [id=" + id + ", school_name=" + school_name
				+ ", aff_no=" + aff_no + ", state=" + state + ", district="
				+ district + ", postal_address=" + postal_address
				+ ", pin_code=" + pin_code + ", phone_no=" + phone_no
				+ ", email=" + email + ", website=" + website + ", content="
				+ content + ", school_info=" + school_info + ", school_code="
				+ school_code + ", school_url=" + school_url + ", city=" + city
				+ ", tags=" + tags + ", status=" + status + ", createdOn="
				+ createdOn + ", nid=" + nid + "]";
	}
}
