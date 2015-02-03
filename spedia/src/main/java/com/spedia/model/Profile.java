package com.spedia.model;

import java.io.Serializable;
import java.util.Date;

public class Profile implements Serializable{
	private static final long serialVersionUID = 3528605457463385406L;
	
	
	/**profile id **/
	private String pid;
	
	/**login id**/
	private String lid;
	
	/**json data**/
	private String d;
	
	/**times-stamp**/
	private Date ts;

	/**times-stamp**/
	private Date ot;
	
	/**access-token**/
	private String atk;

	/**access token**/
	private int st;
	
	/**access token secret**/
	private String atks;
	
	/**request token**/
	private String rtk;
	
	/**request token secret**/
	private String rtks;
	
	/**expires on**/
	private Long exp;
	
	/**network name **/
	private String nid;
	
	/**call source**/
	private String cs;
	
	/**App Code**/
	private String apc;
	
	/**array of connection id's**/
	private String[] nt;
	
	public Profile() {}

	public Profile(String pid, String lid, String d, String atk, Date ts, Date ot,
			int st, String atks, String rtk, String rtks, Long exp, String nid,
			String cs, String apc, String[] nt) {
		super();
		this.pid = pid;
		this.lid = lid;
		this.d = d;
		this.atk = atk;
		this.ts = ts;
		this.setOt(ot);
		this.st = st;
		this.atks = atks;
		this.rtk = rtk;
		this.rtks = rtks;
		this.exp = exp;
		this.nid = nid;
		this.cs = cs;
		this.apc = apc;
		this.nt = nt;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getAtk() {
		return atk;
	}

	public void setAtk(String atk) {
		this.atk = atk;
	}

	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}

	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

	public String getAtks() {
		return atks;
	}

	public void setAtks(String atks) {
		this.atks = atks;
	}

	public String getRtk() {
		return rtk;
	}

	public void setRtk(String rtk) {
		this.rtk = rtk;
	}

	public String getRtks() {
		return rtks;
	}

	public void setRtks(String rtks) {
		this.rtks = rtks;
	}

	public Long getExp() {
		return exp;
	}

	public void setExp(Long exp) {
		this.exp = exp;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getCs() {
		return cs;
	}

	public void setCs(String cs) {
		this.cs = cs;
	}

	public String getApc() {
		return apc;
	}

	public void setApc(String apc) {
		this.apc = apc;
	}

	public String[] getNt() {
		return nt;
	}

	public void setNt(String[] nt) {
		this.nt = nt;
	}

	public Date getOt() {
		return ot;
	}

	public void setOt(Date ot) {
		this.ot = ot;
	}
}
