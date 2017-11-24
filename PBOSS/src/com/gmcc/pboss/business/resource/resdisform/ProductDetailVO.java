package com.gmcc.pboss.business.resource.resdisform;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ProductDetailVO extends BaseVO implements Serializable {

    /** identifier field */
    private String discomcode;

    /** identifier field */
    private String disid;
    private String batchno;
    private String comresid;
    private String comcategory;
    private String boxnum;
    
    
	public ProductDetailVO() {
		
	}
	
	
	public ProductDetailVO(String discomcode, String disid, String batchno,
			String comresid, String comcategory, String boxnum) {
		super();
		this.discomcode = discomcode;
		this.disid = disid;
		this.batchno = batchno;
		this.comresid = comresid;
		this.comcategory = comcategory;
		this.boxnum = boxnum;
	}


	public String getDiscomcode() {
		return discomcode;
	}
	public void setDiscomcode(String discomcode) {
		this.discomcode = discomcode;
	}
	public String getDisid() {
		return disid;
	}
	public void setDisid(String disid) {
		this.disid = disid;
	}
	public String getBatchno() {
		return batchno;
	}
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
	
	public String getComcategory() {
		return comcategory;
	}
	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}
	public String getBoxnum() {
		return boxnum;
	}
	public void setBoxnum(String boxnum) {
		this.boxnum = boxnum;
	}
    
	 public String getComresid() {
		return comresid;
	}


	public void setComresid(String comresid) {
		this.comresid = comresid;
	}


	public boolean equals(Object other) {
	        if ( !(other instanceof ResdisformVO) ) return false;
	        ResdisformVO castOther = (ResdisformVO) other;
	        return new EqualsBuilder()
	            .append(this.getDiscomcode(), castOther.getDiscomcode())
	            .append(this.getDisid(), castOther.getDisid())
	            .isEquals();
	    }

	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getDiscomcode())
	            .append(getDisid())
	            .toHashCode();
	    }
    
}
