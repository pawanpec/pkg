package com.spedia.model;

import java.util.Date;

public class ConnectionBuilder {
	private Connection connection;
	public ConnectionBuilder() {
		this.connection = new Connection();
	}
	public ConnectionBuilder(Connection connection) {
		this.connection = connection;
	}
	public Connection build(){
		return connection;
	}
	public ConnectionBuilder buildWithParentProfileId(String parentProfileId){
		this.connection.getPpid().add(parentProfileId);
		return this;
	}
	public ConnectionBuilder buildWithParentLoginId(String parentloginId){
		this.connection.getPpid().add(parentloginId);
		return this;
	}
	
	public ConnectionBuilder buildWithProfileId(String profileId){
		this.connection.setPid(profileId);
		return this;
	}
	
	public ConnectionBuilder buildWithData(String data){
		this.connection.setD(data);
		return this;
	}
	public ConnectionBuilder buildWithTimesStamp(Date timesStamp){
		this.connection.setTs(timesStamp);
		return this;
	}
	public ConnectionBuilder buildWithOldTimesStamp(Date oldTimesStamp){
		this.connection.setOt(oldTimesStamp);
		return this;
	}
	public ConnectionBuilder buildWithStatus(Long status){
		this.connection.setSt(status);
		return this;
	}
	public ConnectionBuilder buildWithProvider(String provider){
		this.connection.setNid(provider);
		return this;
	}
	public ConnectionBuilder buildWithCallSource(String callSource){
		this.connection.setCs(callSource);
		return this;
	}
	public ConnectionBuilder buildWithAppCode(String appCode){
		this.connection.getApc().add(appCode);
		return this;
	}	
}
