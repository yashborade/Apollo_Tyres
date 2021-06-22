package beans;

import java.io.Serializable;
import java.util.Date;

public class TPRC_TyreMstBean implements Serializable{
	
	private int SRNO;
	private int PLT;
	private String SEC;
	private String SIZE;
	private String FGCODE;
	private String GTCODE;
	private Date DT_ENT;
	private Date DT_ACT;
	private int EMPID;
	
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
	public String getSIZE() {
		return SIZE;
	}
	public void setSIZE(String sIZE) {
		SIZE = sIZE;
	}
	public String getFGCODE() {
		return FGCODE;
	}
	public void setFGCODE(String fGCODE) {
		FGCODE = fGCODE;
	}
	public String getGTCODE() {
		return GTCODE;
	}
	public void setGTCODE(String gTCODE) {
		GTCODE = gTCODE;
	}
	public Date getDT_ENT() {
		return DT_ENT;
	}
	public void setDT_ENT(Date dT_ENT) {
		DT_ENT = dT_ENT;
	}
	public Date getDT_ACT() {
		return DT_ACT;
	}
	public void setDT_ACT(Date dT_ACT) {
		DT_ACT = dT_ACT;
	}
	public int getEMPID() {
		return EMPID;
	}
	public void setEMPID(int eMPID) {
		EMPID = eMPID;
	}
}
