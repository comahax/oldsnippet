package com.sunrise.boss.business.bcss.syncdata.wydata.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WydataVO implements Serializable {

    /** identifier field */
    private Long dataid;

    /** identifier field */
    private String field1;

    /** identifier field */
    private String filecode;

    /** identifier field */
    private Long serialno;

    /** nullable persistent field */
    private Date indate;

    /** nullable persistent field */
    private String field2;

    /** nullable persistent field */
    private String field3;

    /** nullable persistent field */
    private String field4;

    /** nullable persistent field */
    private String field5;

    /** nullable persistent field */
    private String field6;

    /** nullable persistent field */
    private String field7;

    /** nullable persistent field */
    private String field8;

    /** nullable persistent field */
    private String field9;

    /** nullable persistent field */
    private String field10;

    /** nullable persistent field */
    private String field11;

    /** nullable persistent field */
    private String field12;

    /** nullable persistent field */
    private String field13;

    /** nullable persistent field */
    private String field14;

    /** nullable persistent field */
    private String field15;

    /** nullable persistent field */
    private String field16;

    /** nullable persistent field */
    private String field17;

    /** nullable persistent field */
    private String field18;

    /** nullable persistent field */
    private String field19;

    /** nullable persistent field */
    private String field20;

    /** nullable persistent field */
    private String field21;

    /** nullable persistent field */
    private String field22;

    /** nullable persistent field */
    private String field23;

    /** nullable persistent field */
    private String field24;

    /** nullable persistent field */
    private String field25;

    /** nullable persistent field */
    private String field26;

    /** nullable persistent field */
    private String field27;

    /** nullable persistent field */
    private String field28;

    /** nullable persistent field */
    private String field29;

    /** nullable persistent field */
    private String field30;

    /** full constructor */
    public WydataVO(java.lang.Long dataid,java.lang.String field1, java.lang.String filecode, java.lang.Long serialno, java.util.Date indate, java.lang.String field2, java.lang.String field3, java.lang.String field4, java.lang.String field5, java.lang.String field6, java.lang.String field7, java.lang.String field8, java.lang.String field9, java.lang.String field10, java.lang.String field11, java.lang.String field12, java.lang.String field13, java.lang.String field14, java.lang.String field15, java.lang.String field16, java.lang.String field17, java.lang.String field18, java.lang.String field19, java.lang.String field20, java.lang.String field21, java.lang.String field22, java.lang.String field23, java.lang.String field24, java.lang.String field25, java.lang.String field26, java.lang.String field27, java.lang.String field28, java.lang.String field29, java.lang.String field30) {
        this.dataid = dataid;
        this.field1 = field1;
        this.filecode = filecode;
        this.serialno = serialno;
        this.indate = indate;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
        this.field6 = field6;
        this.field7 = field7;
        this.field8 = field8;
        this.field9 = field9;
        this.field10 = field10;
        this.field11 = field11;
        this.field12 = field12;
        this.field13 = field13;
        this.field14 = field14;
        this.field15 = field15;
        this.field16 = field16;
        this.field17 = field17;
        this.field18 = field18;
        this.field19 = field19;
        this.field20 = field20;
        this.field21 = field21;
        this.field22 = field22;
        this.field23 = field23;
        this.field24 = field24;
        this.field25 = field25;
        this.field26 = field26;
        this.field27 = field27;
        this.field28 = field28;
        this.field29 = field29;
        this.field30 = field30;
    }

    /** default constructor */
    public WydataVO() {
    }

    /** minimal constructor */
    public WydataVO(java.lang.String field1, java.lang.String filecode) {
        this.field1 = field1;
        this.filecode = filecode;
    }

 

    public String toString() {
        return new ToStringBuilder(this)
            .append("field1", getField1())
            .append("filecode", getFilecode())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WydataVO) ) return false;
        WydataVO castOther = (WydataVO) other;
        return new EqualsBuilder()
            .append(this.getField1(), castOther.getField1())
            .append(this.getFilecode(), castOther.getFilecode())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getField1())
            .append(getFilecode())
            .toHashCode();
    }

	public Long getDataid() {
		return dataid;
	}

	public void setDataid(Long dataid) {
		this.dataid = dataid;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getFilecode() {
		return filecode;
	}

	public void setFilecode(String filecode) {
		this.filecode = filecode;
	}

	public Long getSerialno() {
		return serialno;
	}

	public void setSerialno(Long serialno) {
		this.serialno = serialno;
	}

	

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

	public String getField5() {
		return field5;
	}

	public void setField5(String field5) {
		this.field5 = field5;
	}

	public String getField6() {
		return field6;
	}

	public void setField6(String field6) {
		this.field6 = field6;
	}

	public String getField7() {
		return field7;
	}

	public void setField7(String field7) {
		this.field7 = field7;
	}

	public String getField8() {
		return field8;
	}

	public void setField8(String field8) {
		this.field8 = field8;
	}

	public String getField9() {
		return field9;
	}

	public void setField9(String field9) {
		this.field9 = field9;
	}

	public String getField10() {
		return field10;
	}

	public void setField10(String field10) {
		this.field10 = field10;
	}

	public String getField11() {
		return field11;
	}

	public void setField11(String field11) {
		this.field11 = field11;
	}

	public String getField12() {
		return field12;
	}

	public void setField12(String field12) {
		this.field12 = field12;
	}

	public String getField13() {
		return field13;
	}

	public void setField13(String field13) {
		this.field13 = field13;
	}

	public String getField14() {
		return field14;
	}

	public void setField14(String field14) {
		this.field14 = field14;
	}

	public String getField15() {
		return field15;
	}

	public void setField15(String field15) {
		this.field15 = field15;
	}

	public String getField16() {
		return field16;
	}

	public void setField16(String field16) {
		this.field16 = field16;
	}

	public String getField17() {
		return field17;
	}

	public void setField17(String field17) {
		this.field17 = field17;
	}

	public String getField18() {
		return field18;
	}

	public void setField18(String field18) {
		this.field18 = field18;
	}

	public String getField19() {
		return field19;
	}

	public void setField19(String field19) {
		this.field19 = field19;
	}

	public String getField20() {
		return field20;
	}

	public void setField20(String field20) {
		this.field20 = field20;
	}

	public String getField21() {
		return field21;
	}

	public void setField21(String field21) {
		this.field21 = field21;
	}

	public String getField22() {
		return field22;
	}

	public void setField22(String field22) {
		this.field22 = field22;
	}

	public String getField23() {
		return field23;
	}

	public void setField23(String field23) {
		this.field23 = field23;
	}

	public String getField24() {
		return field24;
	}

	public void setField24(String field24) {
		this.field24 = field24;
	}

	public String getField25() {
		return field25;
	}

	public void setField25(String field25) {
		this.field25 = field25;
	}

	public String getField26() {
		return field26;
	}

	public void setField26(String field26) {
		this.field26 = field26;
	}

	public String getField27() {
		return field27;
	}

	public void setField27(String field27) {
		this.field27 = field27;
	}

	public String getField28() {
		return field28;
	}

	public void setField28(String field28) {
		this.field28 = field28;
	}

	public String getField29() {
		return field29;
	}

	public void setField29(String field29) {
		this.field29 = field29;
	}

	public String getField30() {
		return field30;
	}

	public void setField30(String field30) {
		this.field30 = field30;
	}

}
