package beans;

import java.io.Serializable;
import java.util.Date;

public class CCSS_AddCureCycleBean implements Serializable{
	
	private int SRNO;
	private int PLT;
	private String SEC;
	private int REV_NO;
	private String PATT_NAM;
	private String TYRE_SIZE;
	private String CONS;
	private String THR_CAP;
	private String THR_BASE;
	private String THR_WINGTIP;
	private String TYRE_CODE;
	private String GAUGES_CENTRAL;
	private String GAUGES_SHOULDER;
	private double THREAD_CENTRAL;
	private double TOTAL_CENTRAL;
	private double THREAD_SHOULDER;
	private double TOTAL_SHOULDER;
	private String CURE_CODE;
	private String FLG;
	private Date UPD_ON;
	private int UPD_BY;
	
	public int getREV_NO() {
		return REV_NO;
	}
	public void setREV_NO(int rEV_NO) {
		REV_NO = rEV_NO;
	}
	public int getSRNO() {
		return SRNO;
	}
	public void setSRNO(int sRNO) {
		SRNO = sRNO;
	}
	public int getPLT() {
		return PLT;
	}
	public void setPLT(int pLT) {
		PLT = pLT;
	}
	public String getSEC() {
		return SEC;
	}
	public void setSEC(String sEC) {
		SEC = sEC;
	}
	public String getPATT_NAM() {
		return PATT_NAM;
	}
	public void setPATT_NAM(String pATT_NAM) {
		PATT_NAM = pATT_NAM;
	}
	public String getTYRE_SIZE() {
		return TYRE_SIZE;
	}
	public void setTYRE_SIZE(String tYRE_SIZE) {
		TYRE_SIZE = tYRE_SIZE;
	}
	public String getCONS() {
		return CONS;
	}
	public void setCONS(String cONS) {
		CONS = cONS;
	}
	public String getTHR_CAP() {
		return THR_CAP;
	}
	public void setTHR_CAP(String tHR_CAP) {
		THR_CAP = tHR_CAP;
	}
	public String getTHR_BASE() {
		return THR_BASE;
	}
	public void setTHR_BASE(String tHR_BASE) {
		THR_BASE = tHR_BASE;
	}
	public String getTHR_WINGTIP() {
		return THR_WINGTIP;
	}
	public void setTHR_WINGTIP(String tHR_WINGTIP) {
		THR_WINGTIP = tHR_WINGTIP;
	}
	public String getTYRE_CODE() {
		return TYRE_CODE;
	}
	public void setTYRE_CODE(String tYRE_CODE) {
		TYRE_CODE = tYRE_CODE;
	}
	public String getGAUGES_CENTRAL() {
		return GAUGES_CENTRAL;
	}
	public void setGAUGES_CENTRAL(String gAUGES_CENTRAL) {
		GAUGES_CENTRAL = gAUGES_CENTRAL;
	}
	public String getGAUGES_SHOULDER() {
		return GAUGES_SHOULDER;
	}
	public void setGAUGES_SHOULDER(String gAUGES_SHOULDER) {
		GAUGES_SHOULDER = gAUGES_SHOULDER;
	}
	public double getTHREAD_CENTRAL() {
		return THREAD_CENTRAL;
	}
	public void setTHREAD_CENTRAL(double tHREAD_CENTRAL) {
		THREAD_CENTRAL = tHREAD_CENTRAL;
	}
	public double getTOTAL_CENTRAL() {
		return TOTAL_CENTRAL;
	}
	public void setTOTAL_CENTRAL(double tOTAL_CENTRAL) {
		TOTAL_CENTRAL = tOTAL_CENTRAL;
	}
	public double getTHREAD_SHOULDER() {
		return THREAD_SHOULDER;
	}
	public void setTHREAD_SHOULDER(double tHREAD_SHOULDER) {
		THREAD_SHOULDER = tHREAD_SHOULDER;
	}
	public double getTOTAL_SHOULDER() {
		return TOTAL_SHOULDER;
	}
	public void setTOTAL_SHOULDER(double tOTAL_SHOULDER) {
		TOTAL_SHOULDER = tOTAL_SHOULDER;
	}
	public String getCURE_CODE() {
		return CURE_CODE;
	}
	public void setCURE_CODE(String cURE_CODE) {
		CURE_CODE = cURE_CODE;
	}
	public String getFLG() {
		return FLG;
	}
	public void setFLG(String fLG) {
		FLG = fLG;
	}
	public Date getUPD_ON() {
		return UPD_ON;
	}
	public void setUPD_ON(Date uPD_ON) {
		UPD_ON = uPD_ON;
	}
	public int getUPD_BY() {
		return UPD_BY;
	}
	public void setUPD_BY(int uPD_BY) {
		UPD_BY = uPD_BY;
	}
}
