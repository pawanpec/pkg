package com.spedia.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Connection implements Serializable{
	private static final long serialVersionUID = -2603376048437503954L;
	
	/**parent profile id**/
	private Set<String> ppid=new HashSet<String>();
	
	/**parent login id**/
	private Set<String> plid=new HashSet<String>();
	
	/**profile id of connection**/
	private String pid;
	
	/**json data**/
	private String d;
	
	/**times-stamp**/
	private Date ts;
	
	/**old-times-stamp**/
	private Date ot;
	
	/**status**/
	private Long st;
	
	/**network id**/
	private String nid;
	
	/**call source**/
	private String cs;

	/**App Code**/
	private Set<String> apc=new HashSet<String>();
	
	public Connection() {}

	public Connection(Set<String> ppid, Set<String> plid, String pid, String d, Date ts,Date ot,
			Long st, String nid, String cs, Set<String> apc) {
		super();
		this.ppid = ppid;
		this.plid = plid;
		this.pid = pid;
		this.d = d;
		this.ts = ts;
		this.ot = ot;
		this.st = st;
		this.nid = nid;
		this.cs = cs;
		this.setApc(apc);
	}

	public Set<String> getPpid() {
		return ppid;
	}

	public void setPpid(Set<String> ppid) {
		this.ppid = ppid;
	}

	public Set<String> getPlid() {
		return plid;
	}

	public void setPlid(Set<String> plid) {
		this.plid = plid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}

	public Long getSt() {
		return st;
	}

	public void setSt(Long st) {
		this.st = st;
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

	public Set<String> getApc() {
		return apc;
	}

	public void setApc(Set<String> apc) {
		this.apc = apc;
	}

	public Date getOt() {
		return ot;
	}

	public void setOt(Date ot) {
		this.ot = ot;
	}
	
	
}
