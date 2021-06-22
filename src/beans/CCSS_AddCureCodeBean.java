package beans;

import java.io.Serializable;
import java.util.Date;

public class CCSS_AddCureCodeBean implements Serializable{
	
	private int SRNO;
	private int PLT;
	private String SEC;
	private String CURE_CODE;
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
