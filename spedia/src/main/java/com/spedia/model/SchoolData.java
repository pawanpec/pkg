package com.spedia.model;
import java.util.Date;

import com.mongodb.ReflectionDBObject;

/**
 * 
 */

/**
 * @author pawan
 *
 */
public class SchoolData extends ReflectionDBObject{
	int id;
	String SN="";
	String AFF_NO="";
	String STATE="";
	String DISTRICT="";
	String PA="";
	String PIN="";
	String PHONE_NO="";
	//email
	String E="";
	//website
	String W="";
	String SC="";
	String SURL="";
	String CITY="";
	String TAGS="";
	String STATUS="n";
	String YOF;
	String PN;
	String SOS;
	String TN;
	String COS;
	public SchoolData(int id, String sN, String aFF_NO, String sTATE,
			String dISTRICT, String pA, String pIN, String pHONE_NO, String e,
			String w, String sC, String sURL, String cITY, String tAGS,
			String sTATUS, String yOF, String pN, String sOS, String tN,
			String cOS, String mOI, String tOS, Long cREATEDON, int nID) {
		super();
		this.id = id;
		SN = sN;
		AFF_NO = aFF_NO;
		STATE = sTATE;
		DISTRICT = dISTRICT;
		PA = pA;
		PIN = pIN;
		PHONE_NO = pHONE_NO;
		E = e;
		W = w;
		SC = sC;
		SURL = sURL;
		CITY = cITY;
		TAGS = tAGS;
		STATUS = sTATUS;
		YOF = yOF;
		PN = pN;
		SOS = sOS;
		TN = tN;
		COS = cOS;
		MOI = mOI;
		TOS = tOS;
		CREATEDON = cREATEDON;
		NID = nID;
	}
	public SchoolData() {
		// TODO Auto-generated constructor stub
	}
	String MOI;
	String TOS;
	Long CREATEDON;
	int NID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSN() {
		return SN;
	}
	public void setSN(String sN) {
		SN = sN;
	}
	public String getAFF_NO() {
		return AFF_NO;
	}
	public void setAFF_NO(String aFF_NO) {
		AFF_NO = aFF_NO;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public String getDISTRICT() {
		return DISTRICT;
	}
	public void setDISTRICT(String dISTRICT) {
		DISTRICT = dISTRICT;
	}
	public String getPA() {
		return PA;
	}
	public void setPA(String pA) {
		PA = pA;
	}
	public String getPIN() {
		return PIN;
	}
	public void setPIN(String pIN) {
		PIN = pIN;
	}
	public String getPHONE_NO() {
		return PHONE_NO;
	}
	public void setPHONE_NO(String pHONE_NO) {
		PHONE_NO = pHONE_NO;
	}
	public String getE() {
		return E;
	}
	public void setE(String e) {
		E = e;
	}
	public String getW() {
		return W;
	}
	public void setW(String w) {
		W = w;
	}
	public String getSC() {
		return SC;
	}
	public void setSC(String sC) {
		SC = sC;
	}
	public String getSURL() {
		return SURL;
	}
	public void setSURL(String sURL) {
		SURL = sURL;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	public String getTAGS() {
		return TAGS;
	}
	public void setTAGS(String tAGS) {
		TAGS = tAGS;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getYOF() {
		return YOF;
	}
	public void setYOF(String yOF) {
		YOF = yOF;
	}
	public String getPN() {
		return PN;
	}
	public void setPN(String pN) {
		PN = pN;
	}
	public String getSOS() {
		return SOS;
	}
	public void setSOS(String sOS) {
		SOS = sOS;
	}
	public String getTN() {
		return TN;
	}
	public void setTN(String tN) {
		TN = tN;
	}
	public String getCOS() {
		return COS;
	}
	public void setCOS(String cOS) {
		COS = cOS;
	}
	public String getMOI() {
		return MOI;
	}
	public void setMOI(String mOI) {
		MOI = mOI;
	}
	public String getTOS() {
		return TOS;
	}
	public void setTOS(String tOS) {
		TOS = tOS;
	}
	public Long getCREATEDON() {
		return CREATEDON;
	}
	public void setCREATEDON(Long cREATEDON) {
		CREATEDON = cREATEDON;
	}
	public int getNID() {
		return NID;
	}
	public void setNID(int nID) {
		NID = nID;
	}
	@Override
	public String toString() {
		return "SchoolData [id=" + id + ", SN=" + SN + ", AFF_NO=" + AFF_NO
				+ ", STATE=" + STATE + ", DISTRICT=" + DISTRICT + ", PA=" + PA
				+ ", PIN=" + PIN + ", PHONE_NO=" + PHONE_NO + ", E=" + E
				+ ", W=" + W + ", SC=" + SC + ", SURL=" + SURL + ", CITY="
				+ CITY + ", TAGS=" + TAGS + ", STATUS=" + STATUS + ", YOF="
				+ YOF + ", PN=" + PN + ", SOS=" + SOS + ", TN=" + TN + ", COS="
				+ COS + ", MOI=" + MOI + ", TOS=" + TOS + ", CREATEDON="
				+ CREATEDON + ", NID=" + NID + "]";
	}
	
	
	
}
