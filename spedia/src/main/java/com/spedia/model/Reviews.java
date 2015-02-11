package com.spedia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Reviews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reviews", catalog = "sp_new")
public class Reviews extends GenericObject {

	// Fields

	private Integer rid;
	private Integer nid;
	private Integer uid;
	private String city;
	//location Id
	private Integer lid;
	private String review;
	private Integer a;
	private Integer b;
	private Integer c;
	private Integer d;
	private Integer e;
	private Integer status;
	private Integer created;

	// Constructors

	/** default constructor */
	public Reviews() {
	}

	/** minimal constructor */
	public Reviews(Integer nid, Integer uid, Integer lid, String review,
			Integer a, Integer b, Integer c, Integer d, Integer e,
			Integer status, Integer created) {
		this.nid = nid;
		this.uid = uid;
		this.lid = lid;
		this.review = review;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.status = status;
		this.created = created;
	}

	/** full constructor */
	public Reviews(Integer nid, Integer uid, String city, Integer lid,
			String review, Integer a, Integer b, Integer c, Integer d,
			Integer e, Integer status, Integer created) {
		this.nid = nid;
		this.uid = uid;
		this.city = city;
		this.lid = lid;
		this.review = review;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.status = status;
		this.created = created;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rid", unique = true, nullable = false)
	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	@Column(name = "nid", nullable = false)
	public Integer getNid() {
		return this.nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	@Column(name = "uid", nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "city")
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "lid", nullable = false)
	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	@Column(name = "review", nullable = false)
	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Column(name = "A", nullable = false)
	public Integer getA() {
		return this.a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	@Column(name = "B", nullable = false)
	public Integer getB() {
		return this.b;
	}

	public void setB(Integer b) {
		this.b = b;
	}

	@Column(name = "C", nullable = false)
	public Integer getC() {
		return this.c;
	}

	public void setC(Integer c) {
		this.c = c;
	}

	@Column(name = "D", nullable = false)
	public Integer getD() {
		return this.d;
	}

	public void setD(Integer d) {
		this.d = d;
	}

	@Column(name = "E", nullable = false)
	public Integer getE() {
		return this.e;
	}

	public void setE(Integer e) {
		this.e = e;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "created", nullable = false)
	public Integer getCreated() {
		return this.created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

}