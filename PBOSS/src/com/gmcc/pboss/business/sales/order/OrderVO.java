package com.gmcc.pboss.business.sales.order;

import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.business.sales.orderlog.OrderlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrderVO extends BaseVO implements Serializable ,BusinessLog{

    /** identifier field */
    private String orderid;

    /** persistent field */
    private Long flowid;

    /** persistent field */
    private String wayid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String cooptype;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String orderave;

    /** nullable persistent field */
    private String storarea;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private String orderstate;

    /** nullable persistent field */
    private java.util.Date statechgtime;

    /** nullable persistent field */
    private String paytype;

    /** nullable persistent field */
    private String delitype;

    /** nullable persistent field */
    private Double recamt;

    /** nullable persistent field */
    private Double actamt;

    /** nullable persistent field */
    private String posstream;

    /** nullable persistent field */
    private String bossworkfid;

    /** nullable persistent field */
    private String memo;
    
    private String discomcode;
    
    private java.util.Date paytime;
    
    private String deductstate;
    
    private String signstate;
    
    private String alarmlevel;//预警级别
    
    private Integer confirmflag;//是否确认
    
    private String mareacode;//微区域
    
    private String orderInfo;//附加属性
    
    private String brandInfo;//品牌信息
    
    private java.util.Date signtime;
    
    private java.util.Date recordtime;
    
    private java.util.Date disovertime;
    
    private String signtype;

	private String smssignno;
    
    private String svccode;//服务销售中心

    private String crmstate;
    
    private Integer reviewstate; //复核状态
    
    /**受理单打印次数*/
    private Integer accepprintamt;

    public OrderVO(String orderid, Long flowid, String wayid, String countyid,
			String cooptype, Short starlevel, String orderave, String storarea,
			Date createtime, String orderstate, Date statechgtime,
			String paytype, String delitype, Double recamt, Double actamt,
			String posstream, String bossworkfid, String memo,
			String discomcode, Date paytime, String deductstate,
			String signstate, String alarmlevel, Integer confirmflag,
			String mareacode, String orderInfo, String brandInfo,String custwaytypename,Date signtime,Date recordtime,Date disovertime,String svccode,
			String signtype, String smssignno,Integer reviewstate,java.lang.Integer accepprintamt) {
		super();
		this.orderid = orderid;
		this.flowid = flowid;
		this.wayid = wayid;
		this.countyid = countyid;
		this.cooptype = cooptype;
		this.starlevel = starlevel;
		this.orderave = orderave;
		this.storarea = storarea;
		this.createtime = createtime;
		this.orderstate = orderstate;
		this.statechgtime = statechgtime;
		this.paytype = paytype;
		this.delitype = delitype;
		this.recamt = recamt;
		this.actamt = actamt;
		this.posstream = posstream;
		this.bossworkfid = bossworkfid;
		this.memo = memo;
		this.discomcode = discomcode;
		this.paytime = paytime;
		this.deductstate = deductstate;
		this.signstate = signstate;
		this.alarmlevel = alarmlevel;
		this.confirmflag = confirmflag;
		this.mareacode = mareacode;
		this.orderInfo = orderInfo;
		this.brandInfo = brandInfo;
		this.custwaytypename = custwaytypename;
		this.signtime = signtime;
		this.recordtime = recordtime;
		this.disovertime = disovertime;
		this.svccode = svccode;
		this.signtype = signtype;
		this.smssignno = smssignno;
		this.reviewstate = reviewstate;
        this.accepprintamt = accepprintamt;
	}

	/** default constructor */
    public OrderVO() {
    }

    /** minimal constructor */
    public OrderVO(java.lang.String orderid, java.lang.Long flowid, java.lang.String wayid) {
        this.orderid = orderid;
        this.flowid = flowid;
        this.wayid = wayid;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.Long getFlowid() {
        return this.flowid;
    }

    public void setFlowid(java.lang.Long flowid) {
        this.flowid = flowid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public java.lang.String getCooptype() {
        return this.cooptype;
    }

    public void setCooptype(java.lang.String cooptype) {
        this.cooptype = cooptype;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getOrderave() {
        return this.orderave;
    }

    public void setOrderave(java.lang.String orderave) {
        this.orderave = orderave;
    }

    public java.lang.String getStorarea() {
        return this.storarea;
    }

    public void setStorarea(java.lang.String storarea) {
        this.storarea = storarea;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.String getOrderstate() {
        return this.orderstate;
    }

    public void setOrderstate(java.lang.String orderstate) {
        this.orderstate = orderstate;
    }

    public java.util.Date getStatechgtime() {
        return this.statechgtime;
    }

    public void setStatechgtime(java.util.Date statechgtime) {
        this.statechgtime = statechgtime;
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

    public java.lang.Double getRecamt() {
        return this.recamt;
    }

    public void setRecamt(java.lang.Double recamt) {
        this.recamt = recamt;
    }

    public java.lang.Double getActamt() {
        return this.actamt;
    }

    public void setActamt(java.lang.Double actamt) {
        this.actamt = actamt;
    }

    public java.lang.String getPosstream() {
        return this.posstream;
    }

    public void setPosstream(java.lang.String posstream) {
        this.posstream = posstream;
    }

    public java.lang.String getBossworkfid() {
        return this.bossworkfid;
    }

    public void setBossworkfid(java.lang.String bossworkfid) {
        this.bossworkfid = bossworkfid;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String getDiscomcode() {
		return discomcode;
	}

	public void setDiscomcode(String discomcode) {
		this.discomcode = discomcode;
	}

	public java.util.Date getPaytime() {
		return paytime;
	}

	public void setPaytime(java.util.Date paytime) {
		this.paytime = paytime;
	}

	public String getDeductstate() {
		return deductstate;
	}

	public void setDeductstate(String deductstate) {
		this.deductstate = deductstate;
	}

	public String getSignstate() {
		return signstate;
	}

	public void setSignstate(String signstate) {
		this.signstate = signstate;
	}

	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}
	

	public String getBrandInfo() {
		return brandInfo;
	}

	public void setBrandInfo(String brandInfo) {
		this.brandInfo = brandInfo;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("orderid", getOrderid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrderVO) ) return false;
        OrderVO castOther = (OrderVO) other;
        return new EqualsBuilder()
            .append(this.getOrderid(), castOther.getOrderid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOrderid())
            .toHashCode();
    }

    
    private static Map<Thread,List<CustwaytypeVO>> custwaytypeMap;   
    private String custwaytypename;

	

	public static Map<Thread,List<CustwaytypeVO>> getCustwaytypeMap() {
		return custwaytypeMap;
	}

	public static void setCustwaytypeMap(Map<Thread,List<CustwaytypeVO>> custwaytypeMap) {
		OrderVO.custwaytypeMap = custwaytypeMap;
	}

	public String getCustwaytypename() {
		if(this.cooptype == null)
			return null;
		if(this.custwaytypename != null)
			return this.custwaytypename;
		if(this.custwaytypename == null){
			if(custwaytypeMap == null)
				return this.cooptype;
			List<CustwaytypeVO> list = custwaytypeMap.get(Thread.currentThread());
			if(list == null)
				return this.cooptype;
			for(CustwaytypeVO vo: list){
				if(this.cooptype.equals(vo.getCustwaytypecode()))
					return vo.getCustwaytypename();
			}
		}
		return this.cooptype;
	}

	public void setCustwaytypename(String custwaytypename) {
		this.custwaytypename = custwaytypename;
		Thread thread = Thread.currentThread();
		
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return OrderlogVO.class;
	}

	public String getAlarmlevel() {
		return alarmlevel;
	}

	public void setAlarmlevel(String alarmlevel) {
		this.alarmlevel = alarmlevel;
	}

	public Integer getConfirmflag() {
		return confirmflag;
	}

	public void setConfirmflag(Integer confirmflag) {
		this.confirmflag = confirmflag;
	}

	public String getMareacode() {
		return mareacode;
	}

	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}

	public java.util.Date getSigntime() {
		return signtime;
	}

	public void setSigntime(java.util.Date signtime) {
		this.signtime = signtime;
	}

	public java.util.Date getRecordtime() {
		return recordtime;
	}

	public void setRecordtime(java.util.Date recordtime) {
		this.recordtime = recordtime;
	}

	public java.util.Date getDisovertime() {
		return disovertime;
	}

	public void setDisovertime(java.util.Date disovertime) {
		this.disovertime = disovertime;
	}

	public String getSvccode() {
		return svccode;
	}

	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}
	
	public String getSigntype() {
		return signtype;
	}

	public void setSigntype(String signtype) {
		this.signtype = signtype;
	}

	public String getSmssignno() {
		return smssignno;
	}

	public void setSmssignno(String smssignno) {
		this.smssignno = smssignno;
	}

	public String getCrmstate() {
		return crmstate;
	}

	public void setCrmstate(String crmstate) {
		this.crmstate = crmstate;
	}

	public Integer getReviewstate() {
		return reviewstate;
	}

	public void setReviewstate(Integer reviewstate) {
		this.reviewstate = reviewstate;
	}
 
    public Integer getAccepprintamt() {
		return accepprintamt;
	}

	public void setAccepprintamt(Integer accepprintamt) {
		this.accepprintamt = accepprintamt;
	}
}
