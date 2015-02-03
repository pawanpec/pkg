package com.spedia.model;

import java.util.Date;

public class ProfileBuilder {
	private Profile profile;
	
	public ProfileBuilder() {
		this.profile = new Profile();
	}
	
	public ProfileBuilder(Profile profile) {
		this.profile = profile;
	}
	
	public Profile build(){
		return profile;
	}
	
	public ProfileBuilder buildWithProfileId(String profileId){
		this.profile.setPid(profileId);
		return this;
	}
	
	public ProfileBuilder buildWithLoginId(String loginId){
		this.profile.setLid(loginId);
		return this;
	
	}
	
	public ProfileBuilder buildWithAccessToken(String acsToken){
		this.profile.setAtk(acsToken);
		return this;
	}
	
	public ProfileBuilder buildWithData(String data){
		this.profile.setD(data);
		return this;
	}
	
	public ProfileBuilder buildWithTimesStamp(Date timesStamp){
		this.profile.setTs(timesStamp);
		return this;
	}
	
	public ProfileBuilder buildWithOldTimesStamp(Date oldTimesStamp){
		this.profile.setOt(oldTimesStamp);
		return this;
	}
	
	public ProfileBuilder buildWithStatus(int status){
		this.profile.setSt(status);
		return this;
	}
	
	public ProfileBuilder buildWithAcsTokenSecret(String acsTokenSecret){
		this.profile.setAtks(acsTokenSecret);
		return this;
	}
	
	public ProfileBuilder buildWithReqToken(String reqToken){
		this.profile.setRtk(reqToken);
		return this;
	}
	
	public ProfileBuilder buildWithReqTokenSecret(String reqTokenSecret){
		this.profile.setRtks(reqTokenSecret);
		return this;
	}
	
	public ProfileBuilder buildWithExpires(Long expires){
		this.profile.setExp(expires);
		return this;
	}
	
	public ProfileBuilder buildWithProvider(String provider){
		this.profile.setNid(provider);
		return this;
	}
	
	public ProfileBuilder buildWithConnections(String[] connectionIds){
		this.profile.setNt(connectionIds);
		return this;
	}
	public ProfileBuilder buildWithCallSource(String callSource){
		this.profile.setCs(callSource);
		return this;
	}
	public ProfileBuilder buildWithAppCode(String appCode){
		this.profile.setApc(appCode);
		return this;
	}
}
