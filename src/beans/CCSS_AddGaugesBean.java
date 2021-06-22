package beans;

import java.io.Serializable;
import java.util.Date;

public class CCSS_AddGaugesBean implements Serializable{
	
	private int SRNO;
	private int PLT;
	private String SEC;
	private String TYRE_CODE;
	private String GAUGE_TYPE;
	private double THREAD;
	private double TOTAL;
	private String FLG;
	private Date UPD_ON;
	private int UPD_BY;
	
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
	public String getTYRE_CODE() {
		return TYRE_CODE;
	}
	public void setTYRE_CODE(String tYRE_CODE) {
		TYRE_CODE = tYRE_CODE;
	}
	public String getGAUGE_TYPE() {
		return GAUGE_TYPE;
	}
	public void setGAUGE_TYPE(String gAUGE_TYPE) {
		GAUGE_TYPE = gAUGE_TYPE;
	}
	public double getTHREAD() {
		return THREAD;
	}
	public void setTHREAD(double tHREAD) {
		THREAD = tHREAD;
	}
	public double getTOTAL() {
		return TOTAL;
	}
	public void setTOTAL(double tOTAL) {
		TOTAL = tOTAL;
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
