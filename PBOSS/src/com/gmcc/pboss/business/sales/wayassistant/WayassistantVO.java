package com.gmcc.pboss.business.sales.wayassistant;
 
import com.gmcc.pboss.business.sales.wayassistantlog.WayassistantlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog; 
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WayassistantVO extends BaseVO implements BusinessLog,Serializable {

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Short canorder;

    /** nullable persistent field */
    private Short printinvoice;

    /** nullable persistent field */
    private String paytype;

    /** nullable persistent field */
    private String delitype;

    /** nullable persistent field */
    private Short orderbetterno;
    
    private String svccode;
    
    private String mareacode;
    
    private String countyid;
    
    private Short waystate;
    
    private String wayname;
    
    public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	/** full constructor */
    public WayassistantVO(java.lang.String wayid, java.lang.Short canorder, java.lang.Short printinvoice, java.lang.String paytype, java.lang.String delitype, java.lang.Short orderbetterno) {
        this.wayid = wayid;
        this.canorder = canorder;
        this.printinvoice = printinvoice;
        this.paytype = paytype;
        this.delitype = delitype;
        this.orderbetterno = orderbetterno;
    }

    /** default constructor */
    public WayassistantVO() {
    }

    /** minimal constructor */
    public WayassistantVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getCanorder() {
        return this.canorder;
    }

    public void setCanorder(java.lang.Short canorder) {
        this.canorder = canorder;
    }

    public java.lang.Short getPrintinvoice() {
        return this.printinvoice;
    }

    public void setPrintinvoice(java.lang.Short printinvoice) {
        this.printinvoice = printinvoice;
    }

    public java.lang.String getPaytype() {
        return this.paytype;
    }

    public void setPaytype(java.lang.String paytype) {
        this.paytype = paytype;
    }

    public java.lang.String getDelitype() {
        return this.delitype;
    }

    public void setDelitype(java.lang.String delitype) {
        this.delitype = delitype;
    }

    public java.lang.Short getOrderbetterno() {
        return this.orderbetterno;
    }

    public void setOrderbetterno(java.lang.Short orderbetterno) {
        this.orderbetterno = orderbetterno;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WayassistantVO) ) return false;
        WayassistantVO castOther = (WayassistantVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .toHashCode();
    }

	public String getSvccode() {
		return svccode;
	}

	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}

	public String getMareacode() {
		return mareacode;
	}

	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public Short getWaystate() {
		return waystate;
	}

	public void setWaystate(Short waystate) {
		this.waystate = waystate;
	}
	
	public Class logVOClass(){
    	return WayassistantlogVO.class;
    }
}
