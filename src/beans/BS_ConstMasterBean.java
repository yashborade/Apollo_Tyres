package beans;

import java.io.Serializable;
import java.util.Date;

public class BS_ConstMasterBean implements Serializable{
	
	private int SRNO;
	private int PLT;
	private String SECTION;
	private String CONST;
	private String USER_DISP;
	private Date UPD_ON;
	private int UPD_BY;
	private String FIN_YEAR;
	
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
	public String getSECTION() {
		return SECTION;
	}
	public void setSECTION(String sECTION) {
		SECTION = sECTION;
	}
	public String getCONST() {
		return CONST;
	}
	public void setCONST(String cONST) {
		CONST = cONST;
	}
	public String getUSER_DISP() {
		return USER_DISP;
	}
	public void setUSER_DISP(String uSER_DISP) {
		USER_DISP = uSER_DISP;
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
	public String getFIN_YEAR() {
		return FIN_YEAR;
	}
	public void setFIN_YEAR(String fIN_YEAR) {
		FIN_YEAR = fIN_YEAR;
	}
}
