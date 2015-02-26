package com.spedia.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users", catalog = "sp_new", uniqueConstraints = {
		@UniqueConstraint(columnNames = "uid"),
		@UniqueConstraint(columnNames = "mail") })
public class User extends GenericObject {

	// Fields

	private String username;
	private Integer uid;
	private String password;
	private String mail;
	private static Long time=(new Date()).getTime();
	private Integer created=time.intValue();
	private Integer updated=time.intValue();;
	private Integer login;
	private boolean enabled=true;
	private String socialLoginId;
	private String socialType;
	private Set<UserRole> userRoleses = new HashSet<UserRole>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, Integer uid, String password,
			Integer created, Integer updated, Integer login, boolean enabled) {
		this.username = username;
		this.uid = uid;
		this.password = password;
		this.created = created;
		this.updated = updated;
		this.login = login;
		this.enabled = enabled;
	}

	/** full constructor */
	public User(String username, Integer uid, String password, String mail,
			Integer created, Integer updated, Integer login, boolean enabled,
			String socialLoginId, String socialType, Set<UserRole> userRoleses) {
		this.username = username;
		this.uid = uid;
		this.password = password;
		this.mail = mail;
		this.created = created;
		this.updated = updated;
		this.login = login;
		this.enabled = enabled;
		this.socialLoginId = socialLoginId;
		this.socialType = socialType;
		this.userRoleses = userRoleses;
	}

	// Property accessors
	
	@Column(name = "username", unique = true, nullable = false, length = 60)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uid", unique = true, nullable = false )
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "password", nullable = false, length = 128)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "mail", unique = true, length = 254)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "created", nullable = false)
	public Integer getCreated() {
		return this.created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

	@Column(name = "updated", nullable = false)
	public Integer getUpdated() {
		return this.updated;
	}

	public void setUpdated(Integer updated) {
		this.updated = updated;
	}

	@Column(name = "login", nullable = true)
	public Integer getLogin() {
		return this.login;
	}

	public void setLogin(Integer login) {
		this.login = login;
	}

	@Column(name = "enabled", nullable = false)
	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "social_login_id", length = 50)
	public String getSocialLoginId() {
		return this.socialLoginId;
	}

	public void setSocialLoginId(String socialLoginId) {
		this.socialLoginId = socialLoginId;
	}

	@Column(name = "social_type", length = 10)
	public String getSocialType() {
		return this.socialType;
	}

	public void setSocialType(String socialType) {
		this.socialType = socialType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<UserRole> getUserRoleses() {
		return this.userRoleses;
	}

	public void setUserRoleses(Set<UserRole> userRoleses) {
		this.userRoleses = userRoleses;
	}

}